package host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * The result information for a request to write data to a file
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "Filename"})
public class EOS_PlayerDataStorage_WriteFileCallbackInfo extends Structure {
	/** The result code for the operation.<br>
	 * {@link EOS_EResult#EOS_Success}: The request was successful.<br>
	 * {@link EOS_EResult#EOS_Canceled}: The request was canceled.<br>
	 * {@link EOS_EResult#EOS_TooManyRequests}: There are too many requests in progress for the local user at this time.<br>
	 * {@link EOS_EResult#EOS_AlreadyPending}: There is another requests in progress for the specified file by this user.<br>
	 * {@link EOS_EResult#EOS_CacheDirectoryMissing}: The cache directory was not set when calling EOS_Platform_Create.<br>
	 * {@link EOS_EResult#EOS_CacheDirectoryInvalid}: The cache directory provided when calling EOS_Platform_Create was invalid.<br>
	 * {@link EOS_EResult#EOS_PlayerDataStorage_UserThrottled}: There were too many requests to the Data Storage service recently by the local user. The application must wait some time before trying again.<br>
	 * {@link EOS_EResult#EOS_PlayerDataStorage_EncryptionKeyNotSet}: The encryption key value was not set when calling EOS_Platform_Create.<br>
	 * {@link EOS_EResult#EOS_PlayerDataStorage_EncryptionKeyNotSet}x: The read operation is not allowed (e.g. when application is suspended).<br>
	 * {@link EOS_EResult#EOS_UnexpectedError}: An unexpected error occurred either downloading, or reading the downloaded file. This most commonly means there were file IO issues such as: permission issues, disk is full, etc. (potentially retryable)
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the file write request */
	public Pointer ClientData;
	/** The Product User ID of the local user who initiated this request */
	public EOS_ProductUserId LocalUserId;
	/** The file name that is being written to */
	public String Filename;

	public EOS_PlayerDataStorage_WriteFileCallbackInfo() {
		super();
	}

	public EOS_PlayerDataStorage_WriteFileCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_WriteFileCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_WriteFileCallbackInfo implements Structure.ByValue {
	}
}