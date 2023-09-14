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
 * All comparison operators associated with parameters in a search query
 *
 * @see EOS_LobbySearch#setParameter(EOS_LobbySearch_SetParameterOptions)
 * @see EOS_SessionSearch#setParameter(EOS_SessionSearch_SetParameterOptions)
 *
 * typedef EOS_EComparisonOp EOS_EOnlineComparisonOp;
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EComparisonOp implements NativeMapped {
	/** Value must equal the one stored on the lobby/session */
	EOS_CO_EQUAL(0),
	/** Value must not equal the one stored on the lobby/session */
	EOS_CO_NOTEQUA(1),
	/** Value must be strictly greater than the one stored on the lobby/session */
	EOS_CO_GREATERTHAN(2),
	/** Value must be greater than or equal to the one stored on the lobby/session */
	EOS_CO_GREATERTHANOREQUAL(3),
	/** Value must be strictly less than the one stored on the lobby/session */
	EOS_CO_LESSTHAN(4),
	/** Value must be less than or equal to the one stored on the lobby/session */
	EOS_CO_LESSTHANOREQUAL(5),
	/** Prefer values nearest the one specified ie. abs(SearchValue-SessionValue) closest to 0 */
	EOS_CO_DISTANCE(6),
	/** Value stored on the lobby/session may be any from a specified list */
	EOS_CO_ANYOF(7),
	/** Value stored on the lobby/session may NOT be any from a specified list */
	EOS_CO_NOTANYOF(8),
	/** This one value is a part of a collection */
	EOS_CO_ONEOF(9),
	/** This one value is NOT part of a collection */
	EOS_CO_NOTONEOF(10),
	/** This value is a CASE SENSITIVE substring of an attribute stored on the lobby/session */
	EOS_CO_CONTAINS(11);

	private final int id;

	private static final Map<Integer, EOS_EComparisonOp> values = new HashMap<>();

	static {
		for (EOS_EComparisonOp result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EComparisonOp(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_CO_EQUAL);
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