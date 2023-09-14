package host.anzo.eossdk.eos.sdk.anticheat.client.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.anticheat.client.callbackresults.EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo;

/**
 * Callback issued when the local client triggers an integrity violation.
 * <p>
 * The message contains descriptive string of up to 256 characters and must be displayed to the player.
 * <p>
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public interface EOS_AntiCheatClient_OnClientIntegrityViolatedCallback extends Callback {
	void apply(EOS_AntiCheatClient_OnClientIntegrityViolatedCallbackInfo data);
}