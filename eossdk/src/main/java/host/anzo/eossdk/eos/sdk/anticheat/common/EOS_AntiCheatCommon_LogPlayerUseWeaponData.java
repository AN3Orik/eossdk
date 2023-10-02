/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"PlayerHandle", "PlayerPosition", "PlayerViewRotation", "IsPlayerViewZoomed", "IsMeleeAttack", "WeaponName"})
public class EOS_AntiCheatCommon_LogPlayerUseWeaponData extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERUSEWEAPON_WEAPONNAME_MAX_LENGTH = 16;

	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle PlayerHandle;
	/** Attack origin world position as a 3D vector */
	public EOS_AntiCheatCommon_Vec3f.ByReference PlayerPosition;
	/** Attack direction as a quaternion */
	public EOS_AntiCheatCommon_Quat.ByReference PlayerViewRotation;
	/** {@link EOS_Bool#EOS_TRUE} if the player's view is zoomed (e.g. using a sniper rifle), otherwise {@link EOS_Bool#EOS_FALSE} */
	public EOS_Bool IsPlayerViewZoomed;
	/** Set to {@link EOS_Bool#EOS_TRUE} if the player is using a melee attack, otherwise {@link EOS_Bool#EOS_FALSE} */
	public EOS_Bool IsMeleeAttack;
	/** Name of the weapon used. Will be truncated to {@link #EOS_ANTICHEATCOMMON_LOGPLAYERUSEWEAPON_WEAPONNAME_MAX_LENGTH} bytes if longer. */
	public String WeaponName;

	public EOS_AntiCheatCommon_LogPlayerUseWeaponData() {
		super();
	}

	public EOS_AntiCheatCommon_LogPlayerUseWeaponData(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerUseWeaponData implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerUseWeaponData implements Structure.ByValue {
	}
}
