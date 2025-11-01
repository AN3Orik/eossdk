package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.titlestorage.EOS_TitleStorageFileTransferRequest;
import host.anzo.eossdk.eos.sdk.titlestorage.EOS_TitleStorage_FileMetadata;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnDeleteCacheCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnQueryFileCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnQueryFileListCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.callbacks.EOS_TitleStorage_OnReadFileCompleteCallback;
import host.anzo.eossdk.eos.sdk.titlestorage.options.*;

/**
 * The following EOS_TitleStorage_* functions allow you to query metadata for available files from title storage as well as download and read their contents.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
public class EOS_TitleStorage_Interface extends PointerType {
	public EOS_TitleStorage_Interface(Pointer address) {
		super(address);
	}

	public EOS_TitleStorage_Interface() {
		super();
	}

	/**
	 * Query a specific file's metadata, such as file names, size, and a MD5 hash of the data. This is not required before a file may be opened. Once a file has
	 * been queried, its metadata will be available by the EOS_TitleStorage_CopyFileMetadataAtIndex and EOS_TitleStorage_CopyFileMetadataByFilename functions.
	 *
	 * @param options Object containing properties related to which user is querying files, and what file is being queried
	 * @param clientData Optional pointer to help clients track this request, that is returned in the completion callback
	 * @param completionCallback This function is called when the query operation completes
	 *
	 * @see #getFileMetadataCount(EOS_TitleStorage_GetFileMetadataCountOptions)
	 * @see #copyFileMetadataAtIndex(EOS_TitleStorage_CopyFileMetadataAtIndexOptions)
	 * @see #copyFileMetadataByFilename(EOS_TitleStorage_CopyFileMetadataByFilenameOptions)
	 */
	public void queryFile(EOS_TitleStorage_QueryFileOptions options, Pointer clientData, EOS_TitleStorage_OnQueryFileCompleteCallback completionCallback) {
		EOSLibrary.instance.EOS_TitleStorage_QueryFile(this, options, clientData, completionCallback);
	}

	/**
	 * Query the file metadata, such as file names, size, and a MD5 hash of the data, for all files available for current user based on their settings (such as game role) and tags provided.
	 * This is not required before a file can be downloaded by name.
	 *
	 * @param options Object containing properties related to which user is querying files and the list of tags
	 * @param clientData Optional pointer to help clients track this request, that is returned in the completion callback
	 * @param completionCallback This function is called when the query operation completes
	 *
	 * @see #getFileMetadataCount(EOS_TitleStorage_GetFileMetadataCountOptions)
	 * @see #copyFileMetadataAtIndex(EOS_TitleStorage_CopyFileMetadataAtIndexOptions)
	 * @see #copyFileMetadataByFilename(EOS_TitleStorage_CopyFileMetadataByFilenameOptions)
	 */
	public void queryFileList(EOS_TitleStorage_QueryFileListOptions options,
	                          Pointer clientData,
	                          EOS_TitleStorage_OnQueryFileListCompleteCallback completionCallback) {
		EOSLibrary.instance.EOS_TitleStorage_QueryFileList(this, options, clientData, completionCallback);
	}

	/**
	 * Create a cached copy of a file's metadata by filename. The metadata will be for the last retrieved or successfully saved version, and will not include any changes that have not
	 * completed writing. The returned pointer must be released by the user when no longer needed.
	 *
	 * @param options Object containing properties related to which user is requesting metadata, and for which filename
	 * @return A copy of the FileMetadata structure will be set if successful. This data must be released by calling EOS_TitleStorage_FileMetadata_Release.
	 */
	public EOS_TitleStorage_FileMetadata copyFileMetadataByFilename(EOS_TitleStorage_CopyFileMetadataByFilenameOptions options) throws EOSException {
		final PointerByReference outMetadata = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_TitleStorage_CopyFileMetadataByFilename(this, options, outMetadata);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_TitleStorage_FileMetadata metadata = new EOS_TitleStorage_FileMetadata(outMetadata.getValue());
		metadata.read();
		return metadata;
	}

	/**
	 * Get the count of files we have previously queried information for and files we have previously read from / written to.
	 *
	 * @param options Object containing properties related to which user is requesting the metadata count
	 * @return If successful, the count of metadata currently cached. Returns 0 on failure.
	 *
	 * @see #copyFileMetadataAtIndex(EOS_TitleStorage_CopyFileMetadataAtIndexOptions)
	 */
	public int getFileMetadataCount(EOS_TitleStorage_GetFileMetadataCountOptions options) {
		return EOSLibrary.instance.EOS_TitleStorage_GetFileMetadataCount(this, options);
	}

	/**
	 * Get the cached copy of a file's metadata by index. The metadata will be for the last retrieved version. The returned pointer must be released by the user when no longer needed.
	 *
	 * @param options Object containing properties related to which user is requesting metadata, and at what index
	 * @return A copy of the FileMetadata structure will be set if successful.  This data must be released by calling EOS_TitleStorage_FileMetadata_Release.
	 *
	 * @see #getFileMetadataCount(EOS_TitleStorage_GetFileMetadataCountOptions)
	 * @see EOS_TitleStorage_FileMetadata#release()
	 */
	public EOS_TitleStorage_FileMetadata copyFileMetadataAtIndex(EOS_TitleStorage_CopyFileMetadataAtIndexOptions options) throws EOSException {
		final PointerByReference outMetadata = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_TitleStorage_CopyFileMetadataAtIndex(this, options, outMetadata);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_TitleStorage_FileMetadata metadata = new EOS_TitleStorage_FileMetadata(outMetadata.getValue());
		metadata.read();
		return metadata;
	}

	/**
	 * Retrieve the contents of a specific file, potentially downloading the contents if we do not have a local copy, from the cloud. This request will occur asynchronously, potentially over
	 * multiple frames. All callbacks for this function will come from the same thread that the SDK is ticked from. If specified, the FileTransferProgressCallback will always be called at
	 * least once if the request is started successfully.
	 *
	 * @param options Object containing properties related to which user is opening the file, what the file's name is, and related mechanisms for copying the data
	 * @param clientData Optional pointer to help clients track this request, that is returned in associated callbacks
	 * @param completionCallback This function is called when the read operation completes
	 * @return A valid Title Storage File Request handle if successful, or NULL otherwise. Data contained in the completion callback will have more detailed information about issues with the request in failure cases. This handle must be released when it is no longer needed
	 *
	 * @see EOS_TitleStorageFileTransferRequest#release()
	 */
	public EOS_TitleStorageFileTransferRequest readFile(EOS_TitleStorage_ReadFileOptions options, Pointer clientData, EOS_TitleStorage_OnReadFileCompleteCallback completionCallback) {
		return EOSLibrary.instance.EOS_TitleStorage_ReadFile(this, options, clientData, completionCallback);
	}

	/**
	 * Clear previously cached file data. This operation will be done asynchronously. All cached files except those corresponding to the transfers in progress will be removed.<br>
	 * <b>Warning: Use this with care. Cache system generally tries to clear old and unused cached files from time to time. Unnecessarily clearing cache can degrade performance as SDK will have to re-download data.</b>
	 *
	 * @param options Object containing properties related to which user is deleting cache
	 * @param clientData Optional pointer to help clients track this request, that is returned in associated callbacks
	 * @param completionCallback This function is called when the delete cache operation completes
	 * @return {@link EOS_EResult#EOS_Success} if the operation was started correctly, otherwise an error result explaining what went wrong
	 */
	public EOS_EResult deleteCache(EOS_TitleStorage_DeleteCacheOptions options, Pointer clientData, EOS_TitleStorage_OnDeleteCacheCompleteCallback completionCallback) {
		return EOSLibrary.instance.EOS_TitleStorage_DeleteCache(this, options, clientData, completionCallback);
	}
}