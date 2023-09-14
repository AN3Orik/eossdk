package host.anzo.eossdk.eos.sdk.titlestorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing the result of a read file request
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "Filename"})
public class EOS_TitleStorage_ReadFileCallbackInfo extends Structure {
	/**
	 * Result code for the operation. EOS_Success is returned for a successful request, other codes indicate an error<br>
	 * {@link EOS_EResult#EOS_Success} if the file is exists and the read operation completes successfully<br>
	 * {@link EOS_EResult#EOS_NotFound} if no file is found
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the file read request */
	public Pointer ClientData;
	/** Product User ID of the local user who initiated this request (optional, will only be present in case it was provided during operation start) */
	public EOS_ProductUserId LocalUserId;
	/** The filename of the file that has been finished reading */
	public String Filename;

	public EOS_TitleStorage_ReadFileCallbackInfo() {
		super();
	}

	public EOS_TitleStorage_ReadFileCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_ReadFileCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_ReadFileCallbackInfo implements Structure.ByValue {
	}
}