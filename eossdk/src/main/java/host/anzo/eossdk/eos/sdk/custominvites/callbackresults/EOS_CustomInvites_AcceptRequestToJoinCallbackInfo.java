package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_AcceptRequestToJoin Function. These parameters are received through the callback provided to EOS_CustomInvites_AcceptRequestToJoin
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_CustomInvites_AcceptRequestToJoinCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the query completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options values are incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_CustomInvites_AcceptRequestToJoin */
	public Pointer ClientData;
	/** Local user accepting an invite request */
	public EOS_ProductUserId LocalUserId;
	/** Target user that sent original invite request */
	public EOS_ProductUserId TargetUserId;

	public EOS_CustomInvites_AcceptRequestToJoinCallbackInfo() {
		super();
	}
	public EOS_CustomInvites_AcceptRequestToJoinCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_AcceptRequestToJoinCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_AcceptRequestToJoinCallbackInfo implements Structure.ByValue {
	}
}