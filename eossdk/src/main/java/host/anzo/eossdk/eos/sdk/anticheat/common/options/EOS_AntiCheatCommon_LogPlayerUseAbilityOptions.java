package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "PlayerHandle", "AbilityId", "AbilityDurationMs", "AbilityCooldownMs"})
public class EOS_AntiCheatCommon_LogPlayerUseAbilityOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERUSEABILITY_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGPLAYERUSEABILITY_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle PlayerHandle;
	/** Game defined unique identifier for the ability being used */
	public int AbilityId;
	/** Duration of the ability effect in milliseconds. If not applicable, use 0. */
	public int AbilityDurationMs;
	/** Cooldown until the ability can be used again in milliseconds. If not applicable, use 0. */
	public int AbilityCooldownMs;

	public EOS_AntiCheatCommon_LogPlayerUseAbilityOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERUSEABILITY_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerUseAbilityOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerUseAbilityOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerUseAbilityOptions implements Structure.ByValue {
	}
}
