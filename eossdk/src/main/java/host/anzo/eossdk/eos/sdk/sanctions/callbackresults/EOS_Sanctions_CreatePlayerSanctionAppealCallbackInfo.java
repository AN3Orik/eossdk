package host.anzo.eossdk.eos.sdk.sanctions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.*;

/**
 * Output parameters for the EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo function.
 *
 * @author Anton Lasevich
 * @since 3/24/2024
 */
@FieldOrder({"ResultCode", "ClientData", "ReferenceId"})
public class EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Sanctions_CreatePlayerSanctionAppeal. */
	public Pointer ClientData;
	/** A unique identifier for the specific sanction that was appealed */
	public String ReferenceId;

	public EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo() {
		super();
	}

	public EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sanctions_CreatePlayerSanctionAppealCallbackInfo implements Structure.ByValue {
	}
}