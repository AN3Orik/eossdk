package host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result of a read file request
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "Filename"})
public class EOS_PlayerDataStorage_ReadFileCallbackInfo extends Structure {
	/** The result code for the operation.<br>
	 * {@link EOS_EResult#EOS_Success}: The request was successful.<br>
	 * {@link EOS_EResult#EOS_Canceled}: The request was canceled.<br>
	 * {@link EOS_EResult#EOS_TooManyRequests}: There are too many requests in progress for the local user at this time.<br>
	 * {@link EOS_EResult#EOS_AlreadyPending}: There is another requests in progress for the specified file by this user.<br>
	 * {@link EOS_EResult#EOS_CacheDirectoryMissing}: The cache directory was not set when calling EOS_Platform_Create.<br>
	 * {@link EOS_EResult#EOS_CacheDirectoryInvalid}: The cache directory provided when calling EOS_Platform_Create was invalid.<br>
	 * {@link EOS_EResult#EOS_PlayerDataStorage_UserThrottled}: There were too many requests to the Data Storage service recently by the local user. The application must wait some time before trying again.<br>
	 * {@link EOS_EResult#EOS_PlayerDataStorage_EncryptionKeyNotSet}: The encryption key value was not set when calling EOS_Platform_Create.<br>
	 * {@link EOS_EResult#EOS_PlayerDataStorage_FileCorrupted}: The downloaded or cached file was corrupted or invalid in some way. What exactly is wrong with the file is returned in the logs (potentially retryable).<br>
	 * {@link EOS_EResult#EOS_InvalidState}: The read operation is not allowed (e.g. when application is suspended).<br>
	 * {@link EOS_EResult#EOS_UnexpectedError}: An unexpected error occurred either downloading, or reading the downloaded file. This most commonly means there were file IO issues such as: permission issues, disk is full, etc. (potentially retryable)
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the file read request */
	public Pointer ClientData;
	/** The Product User ID of the local user who initiated this request */
	public EOS_ProductUserId LocalUserId;
	/** The filename of the file that has been finished reading */
	public String Filename;

	public EOS_PlayerDataStorage_ReadFileCallbackInfo() {
		super();
	}

	public EOS_PlayerDataStorage_ReadFileCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_ReadFileCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_ReadFileCallbackInfo implements Structure.ByValue {
	}
}