package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_Quat;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_Vec3f;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "PlayerHandle", "PlayerPosition", "PlayerViewRotation", "IsPlayerViewZoomed", "PlayerHealth", "PlayerMovementState", "PlayerViewPosition"})
public class EOS_AntiCheatCommon_LogPlayerTickOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERTICK_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGPLAYERTICK_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle PlayerHandle;
	/** Player character's current world position as a 3D vector. This should be the center of the character. */
	public EOS_AntiCheatCommon_Vec3f.ByReference PlayerPosition;
	/** Player camera's current world rotation as a quaternion. */
	public EOS_AntiCheatCommon_Quat.ByReference PlayerViewRotation;
	/** {@link EOS_Bool#EOS_TRUE} if the player's view is zoomed (e.g. using a sniper rifle), otherwise {@link EOS_Bool#EOS_FALSE} */
	public EOS_Bool IsPlayerViewZoomed;
	/** Player's current health value */
	public float PlayerHealth;
	/** Any movement state applicable */
	public int PlayerMovementState;
	/** Player camera's current world position as a 3D vector. */
	public EOS_AntiCheatCommon_Vec3f.ByReference PlayerViewPosition;

	public EOS_AntiCheatCommon_LogPlayerTickOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERTICK_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerTickOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerTickOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerTickOptions implements Structure.ByValue {
	}
}