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
 * Flags describing the platform of a remote client, if known
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonClientPlatform implements NativeMapped {
	/** Unknown platform */
	EOS_ACCCP_Unknown(0),
	/** The client is playing on Windows */
	EOS_ACCCP_Windows(1),
	/** The client is playing on Mac */
	EOS_ACCCP_Mac(2),
	/** The client is playing on Linux */
	EOS_ACCCP_Linux(3),
	/** The client is playing on an Xbox device */
	EOS_ACCCP_Xbox(4),
	/** The client is playing on a PlayStation device */
	EOS_ACCCP_PlayStation(5),
	/** The client is playing on a Nintendo device */
	EOS_ACCCP_Nintendo(6),
	/** The client is playing on iOS */
	EOS_ACCCP_iOS(7),
	/** The client is playing on Android */
	EOS_ACCCP_Android(8);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonClientPlatform> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonClientPlatform result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonClientPlatform(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCCP_Unknown);
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