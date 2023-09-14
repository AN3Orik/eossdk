/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.server.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnMessageToClientCallbackInfo;

/**
 * Callback issued when a new message must be dispatched to a connected client.
 *
 * Messages contain opaque binary data of up to 256 bytes and must be transmitted
 * to the correct client using the game's own networking layer, then delivered
 * to the client anti-cheat instance using the EOS_AntiCheatClient_ReceiveMessageFromServer function.
 *
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_AntiCheatServer_OnMessageToClientCallback extends Callback {
	void run(EOS_AntiCheatCommon_OnMessageToClientCallbackInfo data);
}