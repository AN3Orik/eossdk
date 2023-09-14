package host.anzo.eossdk.eos.sdk.titlestorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about a query file request
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_TitleStorage_QueryFileCallbackInfo extends Structure {
	/**
	 * Result code for the operation. EOS_Success is returned for a successful request, other codes indicate an error<br>
	 * {@link EOS_EResult#EOS_Success} if the query completes successfully and a file is found<br>
	 * {@link EOS_EResult#EOS_NotFound} if no file is found
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the file query request */
	public Pointer ClientData;
	/** Product User ID of the local user who initiated this request (optional, will only be present in case it was provided during operation start) */
	public EOS_ProductUserId LocalUserId;

	public EOS_TitleStorage_QueryFileCallbackInfo() {
		super();
	}

	public EOS_TitleStorage_QueryFileCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_QueryFileCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_QueryFileCallbackInfo implements Structure.ByValue {
	}
}
