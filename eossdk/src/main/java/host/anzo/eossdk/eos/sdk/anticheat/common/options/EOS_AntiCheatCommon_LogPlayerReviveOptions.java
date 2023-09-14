/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "RevivedPlayerHandle", "ReviverPlayerHandle"})
public class EOS_AntiCheatCommon_LogPlayerReviveOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERREVIVE_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATCOMMON_LOGPLAYERREVIVE_API_LATEST. */
	private int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	private EOS_AntiCheatCommon_ClientHandle RevivedPlayerHandle;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	private EOS_AntiCheatCommon_ClientHandle ReviverPlayerHandle;

	public EOS_AntiCheatCommon_LogPlayerReviveOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERREVIVE_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerReviveOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerReviveOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerReviveOptions implements Structure.ByValue {
	}
}