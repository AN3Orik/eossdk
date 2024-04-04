package host.anzo.eossdk.eos.sdk.anticheat.client.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.EOS_Defines;
import host.anzo.eossdk.eos.sdk.anticheat.client.callbackresults.EOS_AntiCheatClient_OnMessageToServerCallbackInfo;

/**
 * Callback issued when a new message must be dispatched to the game server.
 * <p>
 * Messages contain opaque binary data and must be transmitted
 * to the game server using the game's own networking layer, then delivered
 * to the server anti-cheat instance using the EOS_AntiCheatServer_ReceiveMessageFromClient function.
 * The upper limit of the message size is {@link EOS_Defines#EOS_ANTICHEATCLIENT_ONMESSAGETOSERVERCALLBACK_MAX_MESSAGE_SIZE}.
 * <p>
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public interface EOS_AntiCheatClient_OnMessageToServerCallback extends Callback {
	void apply(EOS_AntiCheatClient_OnMessageToServerCallbackInfo data);
}