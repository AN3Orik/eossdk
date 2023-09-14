package host.anzo.eossdk.eos.sdk.anticheat.client.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo;

/**
 * Optional callback issued when a connected peer's authentication status has changed.
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public interface EOS_AntiCheatClient_OnPeerAuthStatusChangedCallback extends Callback {
	void apply(EOS_AntiCheatCommon_OnClientAuthStatusChangedCallbackInfo Data);
}