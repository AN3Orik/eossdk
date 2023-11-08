package host.anzo.eossdk.eos.sdk.titlestorage;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author Anton Lasevich
 * @since 8/31/2023
 */
public class EOS_TitleStorageFileTransferRequest extends PointerType implements AutoCloseable {
	/** Maximum File Name Length in bytes */
	public static final int EOS_TITLESTORAGE_FILENAME_MAX_LENGTH_BYTES = 64;

	public EOS_TitleStorageFileTransferRequest(Pointer address) {
		super(address);
	}

	public EOS_TitleStorageFileTransferRequest() {
		super();
	}

	/**
	 * Get the current state of a file request.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if complete and successful, EOS_RequestInProgress if the request is still in progress, or another state for failure.
	 */
	public EOS_EResult getFileRequestState() {
		return EOSLibrary.instance.EOS_TitleStorageFileTransferRequest_GetFileRequestState(this);
	}

	/**
	 * Get the file name of the file this request is for. OutStringLength will always be set to the string length of the file name if it is not NULL.
	 *
	 * @param filenameStringBufferSizeBytes The maximum number of bytes that can be written to OutStringBuffer
	 * @param outStringBuffer The buffer to write the NULL-terminated utf8 file name into, if successful
	 * @param outStringLength How long the file name is (not including null terminator)
	 * @return {@link EOS_EResult#EOS_Success} if the file name was successfully written to OutFilenameBuffer, a failure result otherwise
	 *
	 * @see #EOS_TITLESTORAGE_FILENAME_MAX_LENGTH_BYTES
	 */
	public EOS_EResult getFilename(int filenameStringBufferSizeBytes, ByteBuffer outStringBuffer, IntBuffer outStringLength) {
		return EOSLibrary.instance.EOS_TitleStorageFileTransferRequest_GetFilename(this, filenameStringBufferSizeBytes, outStringBuffer, outStringLength);
	}

	/**
	 * Attempt to cancel this file request in progress. This is a best-effort command and is not guaranteed to be successful if the request has completed before this function is called.
	 *
	 * @return EOS_Success if cancel is successful, EOS_NoChange if request had already completed (can't be canceled), EOS_AlreadyPending if it's already been canceled before (this is a final state for canceled request and won't change over time).
	 */
	public EOS_EResult cancelRequest() {
		return EOSLibrary.instance.EOS_TitleStorageFileTransferRequest_CancelRequest(this);
	}

	public void release() {
		EOSLibrary.instance.EOS_TitleStorageFileTransferRequest_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}
