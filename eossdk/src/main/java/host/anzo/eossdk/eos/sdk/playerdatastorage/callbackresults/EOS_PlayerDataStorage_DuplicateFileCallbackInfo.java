package host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for a duplicate file request
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_PlayerDataStorage_DuplicateFileCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned for a successful request, other codes indicate an error */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the file duplicate request */
	public Pointer ClientData;
	/** The Product User ID of the local user who initiated this request */
	public EOS_ProductUserId LocalUserId;

	public EOS_PlayerDataStorage_DuplicateFileCallbackInfo() {
		super();
	}

	public EOS_PlayerDataStorage_DuplicateFileCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_DuplicateFileCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_DuplicateFileCallbackInfo implements Structure.ByValue {
	}
}