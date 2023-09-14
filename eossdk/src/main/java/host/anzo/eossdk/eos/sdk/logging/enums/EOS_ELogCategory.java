/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.logging.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Logging Categories
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_ELogCategory implements NativeMapped {
	EOS_LC_Core(0),
	EOS_LC_Auth(1),
	EOS_LC_Friends(2),
	EOS_LC_Presence(3),
	EOS_LC_UserInfo(4),
	EOS_LC_HttpSerialization(5),
	EOS_LC_Ecom(6),
	EOS_LC_P2P(7),
	EOS_LC_Sessions(8),
	EOS_LC_RateLimiter(9),
	EOS_LC_PlayerDataStorage(10),
	EOS_LC_Analytics(11),
	EOS_LC_Messaging(12),
	EOS_LC_Connect(13),
	EOS_LC_Overlay(14),
	EOS_LC_Achievements(15),
	EOS_LC_Stats(16),
	EOS_LC_UI(17),
	EOS_LC_Lobby(18),
	EOS_LC_Leaderboards(19),
	EOS_LC_Keychain(20),
	EOS_LC_IntegratedPlatform(21),
	EOS_LC_TitleStorage(22),
	EOS_LC_Mods(23),
	EOS_LC_AntiCheat(24),
	EOS_LC_Reports(25),
	EOS_LC_Sanctions(26),
	EOS_LC_ProgressionSnapshots(27),
	EOS_LC_KWS(28),
	EOS_LC_RTC(29),
	EOS_LC_RTCAdmin(30),
	EOS_LC_CustomInvites(31),
	EOS_LC_ALL_CATEGORIES(0x7fffffff);

	private final int id;

	private static final Map<Integer, EOS_ELogCategory> values = new HashMap<>();

	static {
		for (EOS_ELogCategory result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELogCategory(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_LC_Core);
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