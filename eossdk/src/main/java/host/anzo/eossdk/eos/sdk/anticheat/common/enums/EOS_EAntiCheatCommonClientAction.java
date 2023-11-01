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
 * Anti-cheat action values. Applicable to both clients and remote peers.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonClientAction implements NativeMapped {
	/** Not used */
	EOS_ACCCA_Invalid(0),
	/** The client/peer must be removed from the current game session */
	EOS_ACCCA_RemovePlayer(1);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonClientAction> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonClientAction result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonClientAction(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCCA_Invalid);
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