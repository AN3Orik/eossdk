package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.playerdatastorage.EOS_PlayerDataStorageFileTransferRequest;
import host.anzo.eossdk.eos.sdk.playerdatastorage.EOS_PlayerDataStorage_FileMetadata;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks.*;
import host.anzo.eossdk.eos.sdk.playerdatastorage.options.*;

/**
 * The following EOS_PlayerDataStorage_* functions allow you to query file metadata; create/upload files; and duplicate, read, and delete existing files
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public class EOS_PlayerDataStorage_Interface extends PointerType {
	public EOS_PlayerDataStorage_Interface(Pointer address) {
		super(address);
	}

	public EOS_PlayerDataStorage_Interface() {
		super();
	}

	public static final int EOS_PLAYERDATASTORAGE_FILENAME_MAX_LENGTH_BYTES = 64;

	/**
	 * Query a specific file's metadata, such as file names, size, and a MD5 hash of the data. This is not required before a file may be opened, saved, copied, or deleted. Once a file has
	 * been queried, its metadata will be available by the EOS_PlayerDataStorage_CopyFileMetadataAtIndex and EOS_PlayerDataStorage_CopyFileMetadataByFilename functions.
	 *
	 * @param queryFileOptions Object containing properties related to which user is querying files, and what file is being queried
	 * @param clientData Optional pointer to help clients track this request, that is returned in the completion callback
	 * @param completionCallback This function is called when the query operation completes
	 *
	 * @see #getFileMetadataCount(EOS_PlayerDataStorage_GetFileMetadataCountOptions)
	 * @see #copyFileMetadataAtIndex(EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions)
	 * @see #copyFileMetadataByFilename(EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions)
	 */
	public void queryFile(EOS_PlayerDataStorage_QueryFileOptions queryFileOptions,
	                      Pointer clientData,
	                      EOS_PlayerDataStorage_OnQueryFileCompleteCallback completionCallback) {
		EOSLibrary.instance.EOS_PlayerDataStorage_QueryFile(this, queryFileOptions, clientData, completionCallback);
	}

	/**
	 * Query the file metadata, such as file names, size, and a MD5 hash of the data, for all files owned by this user for this application. This is not required before a file may be opened,
	 * saved, copied, or deleted.
	 *
	 * @param queryFileListOptions Object containing properties related to which user is querying files
	 * @param clientData Optional pointer to help clients track this request, that is returned in the completion callback
	 * @param completionCallback This function is called when the query operation completes
	 *
	 * @see #getFileMetadataCount(EOS_PlayerDataStorage_GetFileMetadataCountOptions)
	 * @see #copyFileMetadataAtIndex(EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions)
	 * @see #copyFileMetadataByFilename(EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions)
	 */
	public void queryFileList(EOS_PlayerDataStorage_QueryFileListOptions queryFileListOptions,
	                          Pointer clientData,
	                          EOS_PlayerDataStorage_OnQueryFileListCompleteCallback completionCallback) {
		EOSLibrary.instance.EOS_PlayerDataStorage_QueryFileList(this, queryFileListOptions, clientData, completionCallback);
	}

	/**
	 * Create the cached copy of a file's metadata by filename. The metadata will be for the last retrieved or successfully saved version, and will not include any changes that have not
	 * completed writing. The returned pointer must be released by the user when no longer needed.
	 *
	 * @param copyFileMetadataOptions Object containing properties related to which user is requesting metadata, and for which filename
	 * @return A copy of the FileMetadata structure will be set if successful.  This data must be released by calling EOS_PlayerDataStorage_FileMetadata_Release.
	 *
	 * @throws EOSException error result explaining what went wrong if the metadata isn't cached
	 */
	public EOS_PlayerDataStorage_FileMetadata copyFileMetadataByFilename(EOS_PlayerDataStorage_CopyFileMetadataByFilenameOptions copyFileMetadataOptions) throws EOSException {
		final EOS_PlayerDataStorage_FileMetadata.ByReference outMetadata = new EOS_PlayerDataStorage_FileMetadata.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_PlayerDataStorage_CopyFileMetadataByFilename(this, copyFileMetadataOptions, outMetadata);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outMetadata;
	}

	/**
	 * Get the count of files we have previously queried information for and files we have previously read from / written to.
	 *
	 * @param getFileMetadataCountOptions Object containing properties related to which user is requesting the metadata count
	 * @return the count of metadata currently cached
	 *
	 * @throws EOSException error result explaining what went wrong if the input was invalid
	 *
	 * @see #copyFileMetadataAtIndex(EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions)
	 */
	public int getFileMetadataCount(EOS_PlayerDataStorage_GetFileMetadataCountOptions getFileMetadataCountOptions) throws EOSException {
		final IntByReference outFileMetadataCount = new IntByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_PlayerDataStorage_GetFileMetadataCount(this, getFileMetadataCountOptions, outFileMetadataCount);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outFileMetadataCount.getValue();
	}

	/**
	 * Get the cached copy of a file's metadata by index. The metadata will be for the last retrieved or successfully saved version, and will not include any local changes that have not been
	 * committed by calling SaveFile. The returned pointer must be released by the user when no longer needed.
	 *
	 * @param copyFileMetadataOptions Object containing properties related to which user is requesting metadata, and at what index
	 * @return A copy of the FileMetadata structure will be set if successful. This data must be released by calling EOS_PlayerDataStorage_FileMetadata_Release.
	 *
	 * @throws EOSException error result explaining what went wrong if the requested metadata isn't cached
	 *
	 * @see #getFileMetadataCount(EOS_PlayerDataStorage_GetFileMetadataCountOptions)
	 * @see EOS_PlayerDataStorage_FileMetadata#release()
	 */
	public EOS_PlayerDataStorage_FileMetadata copyFileMetadataAtIndex(EOS_PlayerDataStorage_CopyFileMetadataAtIndexOptions copyFileMetadataOptions) throws EOSException {
		final EOS_PlayerDataStorage_FileMetadata.ByReference outMetadata = new EOS_PlayerDataStorage_FileMetadata.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_PlayerDataStorage_CopyFileMetadataAtIndex(this, copyFileMetadataOptions, outMetadata);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outMetadata;
	}

	/**
	 * Copies the data of an existing file to a new filename. This action happens entirely on the server and will not upload the contents of the source destination file from the host. This
	 * function paired with a subsequent EOS_PlayerDataStorage_DeleteFile can be used to rename a file. If successful, the destination file's metadata will be updated in our local cache.
	 *
	 * @param duplicateOptions Object containing properties related to which user is duplicating the file, and what the source and destination file names are
	 * @param clientData Optional pointer to help clients track this request, that is returned in the completion callback
	 * @param completionCallback This function is called when the duplicate operation completes
	 */
	public void duplicateFile(EOS_PlayerDataStorage_DuplicateFileOptions duplicateOptions,
	                          Pointer clientData,
	                          EOS_PlayerDataStorage_OnDuplicateFileCompleteCallback completionCallback) {
		EOSLibrary.instance.EOS_PlayerDataStorage_DuplicateFile(this, duplicateOptions, clientData, completionCallback);
	}

	/**
	 * Deletes an existing file in the cloud. If successful, the file's data will be removed from our local cache.
	 *
	 * @param deleteOptions Object containing properties related to which user is deleting the file, and what file name is
	 * @param clientData Optional pointer to help clients track this request, that is returned in the completion callback
	 * @param completionCallback This function is called when the delete operation completes
	 */
	public void deleteFile(EOS_PlayerDataStorage_DeleteFileOptions deleteOptions,
	                       Pointer clientData,
	                       EOS_PlayerDataStorage_OnDeleteFileCompleteCallback completionCallback) {
		EOSLibrary.instance.EOS_PlayerDataStorage_DeleteFile(this, deleteOptions, clientData, completionCallback);
	}

	/**
	 * Retrieve the contents of a specific file, potentially downloading the contents if we do not have a local copy, from the cloud. This request will occur asynchronously, potentially over
	 * multiple frames. All callbacks for this function will come from the same thread that the SDK is ticked from. If specified, the FileTransferProgressCallback will always be called at
	 * least once if the request is started successfully.
	 *
	 * @param readOptions Object containing properties related to which user is opening the file, what the file's name is, and related mechanisms for copying the data
	 * @param clientData Optional pointer to help clients track this request, that is returned in associated callbacks
	 * @param completionCallback This function is called when the read operation completes
	 * @return A valid Player Data Storage File Request handle if successful, or NULL otherwise. Data contained in the completion callback will have more detailed information about issues with the request in failure cases. This handle must be released when it is no longer needed
	 *
	 * @see EOS_PlayerDataStorageFileTransferRequest#release()
	 */
	public EOS_PlayerDataStorageFileTransferRequest readFile(EOS_PlayerDataStorage_ReadFileOptions readOptions,
	                                                         Pointer clientData,
	                                                         EOS_PlayerDataStorage_OnReadFileCompleteCallback completionCallback) {
		return EOSLibrary.instance.EOS_PlayerDataStorage_ReadFile(this, readOptions, clientData, completionCallback);
	}

	/**
	 * Write new data to a specific file, potentially overwriting any existing file by the same name, to the cloud. This request will occur asynchronously, potentially over multiple frames.
	 * All callbacks for this function will come from the same thread that the SDK is ticked from. If specified, the FileTransferProgressCallback will always be called at least once if the
	 * request is started successfully.
	 *
	 * @param writeOptions Object containing properties related to which user is writing the file, what the file's name is, and related mechanisms for writing the data
	 * @param clientData Optional pointer to help clients track this request, that is returned in associated callbacks
	 * @param completionCallback This function is called when the write operation completes
	 * @return A valid Player Data Storage File Request handle if successful, or NULL otherwise. Data contained in the completion callback will have more detailed information about issues with the request in failure cases. This handle must be released when it is no longer needed
	 *
	 * @see EOS_PlayerDataStorageFileTransferRequest#release()
	 */
	public EOS_PlayerDataStorageFileTransferRequest writeFile(EOS_PlayerDataStorage_WriteFileOptions writeOptions,
	                                                          Pointer clientData,
	                                                          EOS_PlayerDataStorage_OnWriteFileCompleteCallback completionCallback) {
		return EOSLibrary.instance.EOS_PlayerDataStorage_WriteFile(this, writeOptions, clientData, completionCallback);
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
	public EOS_EResult deleteCache(EOS_PlayerDataStorage_DeleteCacheOptions options,
	                               Pointer clientData,
	                               EOS_PlayerDataStorage_OnDeleteCacheCompleteCallback completionCallback) {
		return EOSLibrary.instance.EOS_PlayerDataStorage_DeleteCache(this, options, clientData, completionCallback);
	}
}