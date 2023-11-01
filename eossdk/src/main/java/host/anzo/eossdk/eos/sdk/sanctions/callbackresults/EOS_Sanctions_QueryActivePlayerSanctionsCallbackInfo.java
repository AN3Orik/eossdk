package host.anzo.eossdk.eos.sdk.sanctions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Sanctions_QueryActivePlayerSanctions function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ResultCode", "ClientData", "TargetUserId", "LocalUserId"})
public class EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Sanctions_QueryActivePlayerSanctions. */
	public Pointer ClientData;
	/** Target Product User ID that was passed to EOS_Sanctions_QueryActivePlayerSanctions. */
	public EOS_ProductUserId TargetUserId;
	/** The Product User ID of the local user who initiated this request, if applicable. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo() {
		super();
	}

	public EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sanctions_QueryActivePlayerSanctionsCallbackInfo implements Structure.ByValue {
	}
}