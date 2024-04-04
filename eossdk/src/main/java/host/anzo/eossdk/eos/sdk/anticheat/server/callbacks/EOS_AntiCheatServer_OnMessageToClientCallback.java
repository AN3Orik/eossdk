/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.server.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.EOS_Defines;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnMessageToClientCallbackInfo;

/**
 * Callback issued when a new message must be dispatched to a connected client.
 * <p>
 * Messages contain opaque binary data and must be transmitted to the correct client
 * using the game's own networking layer, then delivered to the client anti-cheat instance
 * using the EOS_AntiCheatClient_ReceiveMessageFromServer function.
 * The upper limit of the message size is {@link EOS_Defines#EOS_ANTICHEATSERVER_ONMESSAGETOCLIENTCALLBACK_MAX_MESSAGE_SIZE}.
 * <p>
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_AntiCheatServer_OnMessageToClientCallback extends Callback {
	void run(EOS_AntiCheatCommon_OnMessageToClientCallbackInfo data) throws EOSException;
}