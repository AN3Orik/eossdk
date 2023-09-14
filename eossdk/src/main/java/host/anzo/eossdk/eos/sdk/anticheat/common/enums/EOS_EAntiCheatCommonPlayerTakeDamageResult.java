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
 * The result of a damage event, if any
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonPlayerTakeDamageResult implements NativeMapped {
	/** No direct state change consequence for the victim */
	EOS_ACCPTDR_None(0),
	/** Player character is temporarily incapacitated and requires assistance to recover */
	EOS_ACCPTDR_Downed(1),
	/** Player character is permanently incapacitated and cannot recover (e.g. dead) */
	EOS_ACCPTDR_Eliminated(2);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonPlayerTakeDamageResult> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonPlayerTakeDamageResult result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonPlayerTakeDamageResult(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_ACCPTDR_None);
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