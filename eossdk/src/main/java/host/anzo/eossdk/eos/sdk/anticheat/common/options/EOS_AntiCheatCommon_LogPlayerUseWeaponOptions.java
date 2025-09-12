package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_LogPlayerUseWeaponData;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "UseWeaponData"})
public class EOS_AntiCheatCommon_LogPlayerUseWeaponOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERUSEWEAPON_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGPLAYERUSEWEAPON_API_LATEST}. */
	public int ApiVersion;
	/** Struct containing detailed information about a weapon use event */
	public EOS_AntiCheatCommon_LogPlayerUseWeaponData.ByReference UseWeaponData;

	public EOS_AntiCheatCommon_LogPlayerUseWeaponOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERUSEWEAPON_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerUseWeaponOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerUseWeaponOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerUseWeaponOptions implements Structure.ByValue {
	}
}