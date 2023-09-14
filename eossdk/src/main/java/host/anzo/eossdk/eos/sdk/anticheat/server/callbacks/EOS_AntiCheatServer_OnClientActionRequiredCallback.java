/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.server.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults.EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo;

/**
 * Callback issued when an action must be applied to a connected client.
 * This callback is always issued from within EOS_Platform_Tick on its calling thread.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_AntiCheatServer_OnClientActionRequiredCallback extends Callback {
	void run(EOS_AntiCheatCommon_OnClientActionRequiredCallbackInfo data);
}