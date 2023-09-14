/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_Token;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_CopyUserAuthTokenOptions;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Types of auth tokens
 * @see EOS_Auth_Interface#copyUserAuthToken(EOS_Auth_CopyUserAuthTokenOptions, EOS_EpicAccountId, EOS_Auth_Token[])
 * @see EOS_Auth_Token
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAuthTokenType implements NativeMapped {
	/** Auth token is for a validated client */
	EOS_ATT_Client(0),
	/** Auth token is for a validated user */
	EOS_ATT_User(1);

	private final int id;

	private static final Map<Integer, EOS_EAuthTokenType> values = new HashMap<>();

	static {
		for (EOS_EAuthTokenType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAuthTokenType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_ATT_Client);
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