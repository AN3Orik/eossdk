package host.anzo.eossdk.eos.sdk.anticheat.client.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOS_Defines;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnMessageToClientCallbackInfo;

/**
 * Callback issued when a new message must be dispatched to a connected peer.
 * <p>
 * Messages contain opaque binary data and must be transmitted
 * to the correct peer using the game's own networking layer, then delivered
 * to the client anti-cheat instance using the EOS_AntiCheatClient_ReceiveMessageFromPeer function.
 * The upper limit of the message size is {@link EOS_Defines#EOS_ANTICHEATCLIENT_ONMESSAGETOPEERCALLBACK_MAX_MESSAGE_SIZE}.
 * <p>
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public interface EOS_AntiCheatClient_OnMessageToPeerCallback extends Callback {
	void apply(EOS_AntiCheatCommon_OnMessageToClientCallbackInfo data);
}