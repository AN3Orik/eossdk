/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Type of damage applied in a damage event
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonPlayerTakeDamageType implements NativeMapped {
	/** No particular type relevant */
	EOS_ACCPTDT_None(0),
	/** Damage caused by a point source such as a bullet or melee attack */
	EOS_ACCPTDT_PointDamage(1),
	/** Damage caused by a radial source such as an explosion */
	EOS_ACCPTDT_RadialDamage(2),
	/** Damage over time such as bleeding, poison, etc */
	EOS_ACCPTDT_DamageOverTime(3);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonPlayerTakeDamageType> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonPlayerTakeDamageType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonPlayerTakeDamageType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCPTDT_None);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}