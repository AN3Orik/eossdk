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
 * Flags describing a remote client. These can be updated during a play session
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonClientFlags implements NativeMapped {
	/** No particular flags relevant for this client */
	EOS_ACCCF_None(0),
	/** The client has admin privileges on the game server */
	EOS_ACCCF_Admin(1);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonClientFlags> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonClientFlags result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonClientFlags(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCCF_None);
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