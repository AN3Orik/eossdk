package host.anzo.eossdk.eos.sdk.titlestorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing the result of a delete cache operation
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_TitleStorage_DeleteCacheCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned for a successful request, other codes indicate an error */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the delete cache request */
	public Pointer ClientData;
	/** Product User ID of the local user who initiated this request (optional, will only be present in case it was provided during operation start) */
	public EOS_ProductUserId LocalUserId;
	public EOS_TitleStorage_DeleteCacheCallbackInfo() {
		super();
	}

	public EOS_TitleStorage_DeleteCacheCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_DeleteCacheCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_DeleteCacheCallbackInfo implements Structure.ByValue {
	}
}
