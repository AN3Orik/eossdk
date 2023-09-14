package host.anzo.eossdk.eos.sdk.playerdatastorage.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults.EOS_PlayerDataStorage_WriteFileDataCallbackInfo;
import host.anzo.eossdk.eos.sdk.playerdatastorage.enums.EOS_PlayerDataStorage_EWriteResult;

/**
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_PlayerDataStorage_OnWriteFileDataCallback extends Callback {
	/**
	 * Callback for when we are ready to get more data to be written into the requested file. It is undefined how often this will be called during a single tick.
	 *
	 * @param data Struct containing metadata for the file being written to, as well as the max length in bytes that can be safely written to DataBuffer
	 * @param outDataBuffer A buffer to write data into, to be appended to the end of the file that is being written to. The maximum length of this value is provided in the Info parameter. The number of bytes written to this buffer should be set in OutDataWritten.
	 * @param outDataWritten The length of the data written to OutDataBuffer. This must be less than or equal than the DataBufferLengthBytes provided in the Info parameter
	 * @return The result of the write operation. If this value is not {@link EOS_PlayerDataStorage_EWriteResult#EOS_WR_ContinueWriting}, this callback will not be called again for the same request. If this is set to {@link EOS_PlayerDataStorage_EWriteResult#EOS_WR_FailRequest} or {@link EOS_PlayerDataStorage_EWriteResult#EOS_WR_CancelRequest}, all data written during the request will not be saved
	 */
	EOS_PlayerDataStorage_EWriteResult apply(EOS_PlayerDataStorage_WriteFileDataCallbackInfo data, Pointer outDataBuffer, IntByReference outDataWritten);
}