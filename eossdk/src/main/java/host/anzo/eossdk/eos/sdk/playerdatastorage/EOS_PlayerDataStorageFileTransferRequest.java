package host.anzo.eossdk.eos.sdk.playerdatastorage;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_PlayerDataStorage_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Handle type to a File Request
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public class EOS_PlayerDataStorageFileTransferRequest extends PointerType implements AutoCloseable {
	public EOS_PlayerDataStorageFileTransferRequest(Pointer address) {
		super(address);
	}

	public EOS_PlayerDataStorageFileTransferRequest() {
		super();
	}

	/**
	 * Get the current state of a file request.
	 *
	 * @return EOS_Success if complete and successful, EOS_PlayerDataStorage_RequestInProgress if the request is still in progress, or another state for failure.
	 */
	public EOS_EResult getFileRequestState() {
		return EOSLibrary.instance.EOS_PlayerDataStorageFileTransferRequest_GetFileRequestState(this);
	}

	/**
	 * Get the file name of the file this request is for. OutStringLength will always be set to the string length of the file name if it is not NULL.
	 * @return NULL-terminated utf8 file name
	 *
	 * @throws EOSException if exception occurred
	 *
	 * @see EOS_PlayerDataStorage_Interface#EOS_PLAYERDATASTORAGE_FILENAME_MAX_LENGTH_BYTES
	 */
	public String getFilename() throws EOSException {
		final IntByReference outStringLength = new IntByReference(EOS_PlayerDataStorage_Interface.EOS_PLAYERDATASTORAGE_FILENAME_MAX_LENGTH_BYTES);
		final byte[] outStringBuffer = new byte[EOS_PlayerDataStorage_Interface.EOS_PLAYERDATASTORAGE_FILENAME_MAX_LENGTH_BYTES];
		final EOS_EResult result = EOSLibrary.instance.EOS_PlayerDataStorageFileTransferRequest_GetFilename(this,
				EOS_PlayerDataStorage_Interface.EOS_PLAYERDATASTORAGE_FILENAME_MAX_LENGTH_BYTES,
				outStringBuffer,
				outStringLength);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return new String(outStringBuffer, 0, outStringLength.getValue());
	}

	/**
	 * Attempt to cancel this file request in progress. This is a best-effort command and is not guaranteed to be successful if the request has completed before this function is called.
	 *
	 * @return EOS_Success if cancel is successful, EOS_NoChange if request had already completed (can't be canceled), EOS_AlreadyPending if it's already been canceled before (this is a final state for canceled request and won't change over time).
	 */
	public EOS_EResult cancelRequest() {
		return EOSLibrary.instance.EOS_PlayerDataStorageFileTransferRequest_CancelRequest(this);
	}

	/**
	 * Free the memory used by a cloud-storage file request handle. This will not cancel a request in progress.
	 */
	public void release() {
		EOSLibrary.instance.EOS_PlayerDataStorageFileTransferRequest_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}