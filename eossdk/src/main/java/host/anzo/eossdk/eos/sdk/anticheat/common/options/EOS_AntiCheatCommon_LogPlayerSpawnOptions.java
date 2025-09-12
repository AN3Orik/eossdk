package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "SpawnedPlayerHandle", "TeamId", "CharacterId"})
public class EOS_AntiCheatCommon_LogPlayerSpawnOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERSPAWN_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGPLAYERSPAWN_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle SpawnedPlayerHandle;
	/** Optional identifier for the player's team. If none, use 0. */
	public int TeamId;
	/** Optional identifier for the player's character. If none, use 0. */
	public int CharacterId;

	public EOS_AntiCheatCommon_LogPlayerSpawnOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERSPAWN_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerSpawnOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerSpawnOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerSpawnOptions implements Structure.ByValue {
	}
}