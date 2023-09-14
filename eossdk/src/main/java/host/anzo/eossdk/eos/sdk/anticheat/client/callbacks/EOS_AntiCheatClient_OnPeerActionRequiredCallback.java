package host.anzo.eossdk.eos.sdk.anticheat.client.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo;

/**
 * Callback issued when an action must be applied to a connected peer.
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public interface EOS_AntiCheatClient_OnPeerActionRequiredCallback extends Callback {
	void apply(EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo data);
}