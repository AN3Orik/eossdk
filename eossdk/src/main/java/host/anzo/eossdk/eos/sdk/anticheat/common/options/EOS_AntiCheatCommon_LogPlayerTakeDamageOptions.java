/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_LogPlayerUseWeaponData;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_Quat;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_Vec3f;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonPlayerTakeDamageResult;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonPlayerTakeDamageSource;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonPlayerTakeDamageType;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "VictimPlayerHandle", "VictimPlayerPosition", "VictimPlayerViewRotation", "AttackerPlayerHandle", "AttackerPlayerPosition", "AttackerPlayerViewRotation", "IsHitscanAttack", "HasLineOfSight", "IsCriticalHit", "HitBoneId_DEPRECATED", "DamageTaken", "HealthRemaining", "DamageSource", "DamageType", "DamageResult", "PlayerUseWeaponData", "TimeSincePlayerUseWeaponMs", "DamagePosition"})
public class EOS_AntiCheatCommon_LogPlayerTakeDamageOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERTAKEDAMAGE_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGPLAYERTAKEDAMAGE_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle VictimPlayerHandle;
	/** Victim player's current world position as a 3D vector */
	public EOS_AntiCheatCommon_Vec3f.ByReference VictimPlayerPosition;
	/** Victim player's view rotation as a quaternion */
	public EOS_AntiCheatCommon_Quat.ByReference VictimPlayerViewRotation;
	/** Locally unique value used in RegisterClient/RegisterPeer if applicable, otherwise 0. */
	public EOS_AntiCheatCommon_ClientHandle AttackerPlayerHandle;
	/** Attacker player's current world position as a 3D vector if applicable, otherwise NULL. */
	public EOS_AntiCheatCommon_Vec3f.ByReference AttackerPlayerPosition;
	/** Attacker player's view rotation as a quaternion if applicable, otherwise NULL. */
	public EOS_AntiCheatCommon_Quat.ByReference AttackerPlayerViewRotation;
	/**
	 * {@link EOS_Bool#EOS_TRUE} if the damage was applied instantly at the time of attack from the game
	 * simulation's perspective, otherwise {@link EOS_Bool#EOS_FALSE} (simulated ballistics, arrow, etc).
	 */
	public EOS_Bool IsHitscanAttack;
	/**
	 * True if there is a visible line of sight between the attacker and the victim at the time
	 * that damage is being applied, false if there is an obstacle like a wall or terrain in
	 * the way. For some situations like melee or hitscan weapons this is trivially
	 * true, for others like projectiles with simulated physics it may not be e.g. a player
	 * could fire a slow moving projectile and then move behind cover before it strikes.
	 * <p>
	 * This can be an estimate, or can simply be always set to true if it is not feasible
	 * to compute in your game.
	 */
	public int HasLineOfSight;
	/** {@link EOS_Bool#EOS_TRUE} if this was a critical hit that causes extra damage (e.g. headshot) */
	public EOS_Bool IsCriticalHit;
	/** Deprecated - use DamagePosition instead */
	public int HitBoneId_DEPRECATED;
	/** Number of health points that the victim lost due to this damage event */
	public float DamageTaken;
	/** Number of health points that the victim has remaining after this damage event */
	public float HealthRemaining;
	/** Source of the damage event */
	public EOS_EAntiCheatCommonPlayerTakeDamageSource DamageSource;
	/** Type of the damage being applied */
	public EOS_EAntiCheatCommonPlayerTakeDamageType DamageType;
	/** Result of the damage for the victim, if any */
	public EOS_EAntiCheatCommonPlayerTakeDamageResult DamageResult;
	/** PlayerUseWeaponData associated with this damage event if available, otherwise NULL */
	public EOS_AntiCheatCommon_LogPlayerUseWeaponData.ByReference PlayerUseWeaponData;
	/** Time in milliseconds since the associated PlayerUseWeaponData event occurred if available, otherwise 0 */
	public int TimeSincePlayerUseWeaponMs;
	/** World position where damage hit the victim as a 3D vector if available, otherwise NULL */
	public EOS_AntiCheatCommon_Vec3f.ByReference DamagePosition;

	public EOS_AntiCheatCommon_LogPlayerTakeDamageOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERTAKEDAMAGE_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerTakeDamageOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerTakeDamageOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerTakeDamageOptions implements Structure.ByValue {
	}
}