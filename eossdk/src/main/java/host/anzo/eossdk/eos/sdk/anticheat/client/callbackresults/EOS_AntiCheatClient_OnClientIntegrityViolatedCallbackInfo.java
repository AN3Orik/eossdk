package host.anzo.eossdk.eos.sdk.anticheat.client.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatClientViolationType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing details about integrity violation related to the local client
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ClientData", "ViolationType", "ViolationMessage"})
public class EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo extends Structure {
	/** Caller-specified context data */
	public Pointer ClientData;
	/** Code describing the violation that occurred */
	public EOS_EAntiCheatClientViolationType ViolationType;
	/** String describing the violation which should be displayed to the user */
	public String ViolationMessage;
	public EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo() {
		super();
	}

	public EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo implements Structure.ByValue {
	}
}