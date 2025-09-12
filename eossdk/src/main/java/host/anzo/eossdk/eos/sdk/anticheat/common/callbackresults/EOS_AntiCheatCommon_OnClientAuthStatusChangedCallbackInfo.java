package host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientAuthStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing details about a client/peer authentication status change
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ClientData", "ClientHandle", "ClientAuthStatus"})
public class EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo extends Structure {
	/** Caller-specified context data */
	public Pointer ClientData;
	/** The identifier of the client/peer that this message must be delivered to. See the RegisterClient and RegisterPeer functions. */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** The client/peer's new authentication status */
	public EOS_EAntiCheatCommonClientAuthStatus ClientAuthStatus;

	public EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo() {
		super();
	}

	public EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo implements Structure.ByValue {
	}
}