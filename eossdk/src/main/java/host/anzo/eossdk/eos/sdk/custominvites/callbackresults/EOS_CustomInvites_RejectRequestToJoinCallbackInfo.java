package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_RejectRequestToJoin Function. These parameters are received through the callback provided to EOS_CustomInvites_RejectRequestToJoin
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_CustomInvites_RejectRequestToJoinCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the query completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options values are incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_CustomInvites_RejectRequestToJoin */
	public Pointer ClientData;
	/** Local user declining a request to join */
	public EOS_ProductUserId LocalUserId;
	/** Target user that sent original request to join */
	public EOS_ProductUserId TargetUserId;

	public EOS_CustomInvites_RejectRequestToJoinCallbackInfo() {
		super();
	}
	public EOS_CustomInvites_RejectRequestToJoinCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_RejectRequestToJoinCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_RejectRequestToJoinCallbackInfo implements Structure.ByValue {
	}
}