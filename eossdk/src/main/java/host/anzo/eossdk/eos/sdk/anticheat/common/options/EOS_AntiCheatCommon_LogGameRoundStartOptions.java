/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "SessionIdentifier", "LevelName", "ModeName", "RoundTimeSeconds"})
public class EOS_AntiCheatCommon_LogGameRoundStartOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGGAMEROUNDSTART_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATCOMMON_LOGGAMEROUNDSTART_API_LATEST. */
	public int ApiVersion;
	/** Optional game session or match identifier useful for some backend API integrations */
	public String SessionIdentifier;
	/** Optional name of the map being played */
	public String LevelName;
	/** Optional name of the game mode being played */
	public String ModeName;
	/** Optional length of the game round to be played, in seconds. If none, use 0. */
	public int RoundTimeSeconds;

	public EOS_AntiCheatCommon_LogGameRoundStartOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGGAMEROUNDSTART_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogGameRoundStartOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogGameRoundStartOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogGameRoundStartOptions implements Structure.ByValue {
	}
}