package host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientAction;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientActionReason;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing details about a required client/peer action
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ClientData", "ClientHandle", "ClientAction", "ActionReasonCode", "ActionReasonDetailsString"})
public class EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo extends Structure {
	/** Caller-specified context data */
	public Pointer ClientData;
	/** The identifier of the client/peer that this message must be delivered to. See the RegisterClient and RegisterPeer functions. */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** The action that must be applied to the specified client/peer */
	public EOS_EAntiCheatCommonClientAction ClientAction;
	/** Code indicating the reason for the action. This can be displayed to the affected player. */
	public EOS_EAntiCheatCommonClientActionReason ActionReasonCode;
	/** String containing details about the action reason. This can be displayed to the affected player. */
	public String ActionReasonDetailsString;

	public EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo() {
		super();
	}

	public EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo implements Structure.ByValue {
	}
}