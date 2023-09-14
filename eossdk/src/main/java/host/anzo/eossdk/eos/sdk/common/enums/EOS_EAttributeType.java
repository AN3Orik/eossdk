/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.lobby.EOS_LobbySearch;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_LobbySearch_SetParameterOptions;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionSearch;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_SessionSearch_SetParameterOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Supported types of data that can be stored with inside an attribute (used by sessions/lobbies/etc)
 * @see EOS_LobbySearch#setParameter(EOS_LobbySearch_SetParameterOptions)
 * @see EOS_SessionSearch#setParameter(EOS_SessionSearch_SetParameterOptions)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAttributeType implements NativeMapped {
	/** Boolean value (true/false) */
	EOS_AT_BOOLEAN(0),
	/** 64 bit integers */
	EOS_AT_INT64(1),
	/** Double/floating point precision */
	EOS_AT_DOUBLE(2),
	/** UTF8 Strings */
	EOS_AT_STRING(3);

	private final int id;

	private static final Map<Integer, EOS_EAttributeType> values = new HashMap<>();

	static {
		for (EOS_EAttributeType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAttributeType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_AT_BOOLEAN);
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