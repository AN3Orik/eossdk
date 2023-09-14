package host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing information about a query file list request
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "FileCount"})
public class EOS_PlayerDataStorage_QueryFileListCallbackInfo extends Structure {
	/**
	 * Result code for the operation. EOS_Success is returned for a successful request, other codes indicate an error
	 * {@link EOS_EResult#EOS_Success} if the query completes successfully (whether any files are found or not)
	 */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into the file query request */
	public Pointer ClientData;
	/** The Product User ID of the local user who initiated this request */
	public EOS_ProductUserId LocalUserId;
	/** A count of files that were found, if successful */
	public int FileCount;

	public EOS_PlayerDataStorage_QueryFileListCallbackInfo() {
		super();
	}

	public EOS_PlayerDataStorage_QueryFileListCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_QueryFileListCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_QueryFileListCallbackInfo implements Structure.ByValue {
	}
}