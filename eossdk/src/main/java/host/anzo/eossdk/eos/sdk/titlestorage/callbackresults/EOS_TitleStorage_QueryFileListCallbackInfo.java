package host.anzo.eossdk.eos.sdk.titlestorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about a query file list request
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "FileCount"})
public class EOS_TitleStorage_QueryFileListCallbackInfo extends Structure {
	/**
	 * Result code for the operation. EOS_Success is returned for a successful request, other codes indicate an error
	 * {@link EOS_EResult#EOS_Success} if the query completes successfully (whether any files are found or not)
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the file query request */
	public Pointer ClientData;
	/** Product User ID of the local user who initiated this request (optional, will only be present in case it was provided during operation start) */
	public EOS_ProductUserId LocalUserId;
	/** A count of files that were found, if successful */
	public int FileCount;

	public EOS_TitleStorage_QueryFileListCallbackInfo() {
		super();
	}

	public EOS_TitleStorage_QueryFileListCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_QueryFileListCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_QueryFileListCallbackInfo implements Structure.ByValue {
	}
}