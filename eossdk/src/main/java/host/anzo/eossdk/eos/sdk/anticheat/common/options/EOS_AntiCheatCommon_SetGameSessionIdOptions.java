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
@FieldOrder({"ApiVersion", "GameSessionId"})
public class EOS_AntiCheatCommon_SetGameSessionIdOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_SETGAMESESSIONID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_SETGAMESESSIONID_API_LATEST}. */
	public int ApiVersion;
	/** Game session identifier */
	public String GameSessionId;

	public EOS_AntiCheatCommon_SetGameSessionIdOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_SETGAMESESSIONID_API_LATEST;
	}

	public EOS_AntiCheatCommon_SetGameSessionIdOptions(String gameSessionId) {
		this();
		GameSessionId = gameSessionId;
	}

	public EOS_AntiCheatCommon_SetGameSessionIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_SetGameSessionIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_SetGameSessionIdOptions implements Structure.ByValue {
	}
}