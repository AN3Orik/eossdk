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
 * The source of a damage event
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonPlayerTakeDamageSource implements NativeMapped {
	/** No particular source relevant */
	EOS_ACCPTDS_None(0),
	/** Damage caused by a player controlled character */
	EOS_ACCPTDS_Player(1),
	/** Damage caused by a non-player character such as an AI enemy */
	EOS_ACCPTDS_NonPlayerCharacter(2),
	/** Damage caused by the world (falling off level, into lava, etc) */
	EOS_ACCPTDS_World(3);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonPlayerTakeDamageSource> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonPlayerTakeDamageSource result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonPlayerTakeDamageSource(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCPTDS_None);
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