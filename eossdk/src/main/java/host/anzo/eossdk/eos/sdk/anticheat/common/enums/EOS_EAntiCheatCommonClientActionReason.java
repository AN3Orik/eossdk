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
 * Anti-cheat action reasons. Applicable to both clients and remote peers.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EAntiCheatCommonClientActionReason implements NativeMapped {
	/** Not used */
	EOS_ACCCAR_Invalid(0),
	/** An internal error occurred */
	EOS_ACCCAR_InternalError(1),
	/** An anti-cheat message received from the client/peer was corrupt or invalid */
	EOS_ACCCAR_InvalidMessage(2),
	/** The client/peer's anti-cheat authentication failed */
	EOS_ACCCAR_AuthenticationFailed(3),
	/** The client/peer failed to load the anti-cheat module at startup */
	EOS_ACCCAR_NullClient(4),
	/** The client/peer's anti-cheat heartbeat was not received */
	EOS_ACCCAR_HeartbeatTimeout(5),
	/** The client/peer failed an anti-cheat client runtime check */
	EOS_ACCCAR_ClientViolation(6),
	/** The client/peer failed an anti-cheat backend runtime check */
	EOS_ACCCAR_BackendViolation(7),
	/** The client/peer is temporarily blocked from playing on this game server */
	EOS_ACCCAR_TemporaryCooldown(8),
	/** The client/peer is temporarily banned */
	EOS_ACCCAR_TemporaryBanned(9),
	/** The client/peer is permanently banned */
	EOS_ACCCAR_PermanentBanned(10);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonClientActionReason> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonClientActionReason result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonClientActionReason(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCCAR_Invalid);
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