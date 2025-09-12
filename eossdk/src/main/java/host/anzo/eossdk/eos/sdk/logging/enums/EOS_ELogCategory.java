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
	/** Low level logs unrelated to specific services */
	EOS_LC_Core(0),
	/** Logs related to the Auth service */
	EOS_LC_Auth(1),
	/** Logs related to the Friends service */
	EOS_LC_Friends(2),
	/** Logs related to the Presence service */
	EOS_LC_Presence(3),
	/** Logs related to the UserInfo service */
	EOS_LC_UserInfo(4),
	/** Logs related to HTTP serialization */
	EOS_LC_HttpSerialization(5),
	/** Logs related to the Ecommerce service */
	EOS_LC_Ecom(6),
	/** Logs related to the P2P service */
	EOS_LC_P2P(7),
	/** Logs related to the Sessions service */
	EOS_LC_Sessions(8),
	/** Logs related to rate limiting */
	EOS_LC_RateLimiter(9),
	/** Logs related to the PlayerDataStorage service */
	EOS_LC_PlayerDataStorage(10),
	/** Logs related to sdk analytics */
	EOS_LC_Analytics(11),
	/** Logs related to the messaging service */
	EOS_LC_Messaging(12),
	/** Logs related to the Connect service */
	EOS_LC_Connect(13),
	/** Logs related to the Overlay */
	EOS_LC_Overlay(14),
	/** Logs related to the Achievements service */
	EOS_LC_Achievements(15),
	/** Logs related to the Stats service */
	EOS_LC_Stats(16),
	/** Logs related to the UI service */
	EOS_LC_UI(17),
	/** Logs related to the lobby service */
	EOS_LC_Lobby(18),
	/** Logs related to the Leaderboards service */
	EOS_LC_Leaderboards(19),
	/** Logs related to an internal Keychain feature that the authentication interfaces use */
	EOS_LC_Keychain(20),
	/** Logs related to integrated platforms */
	EOS_LC_IntegratedPlatform(21),
	/** Logs related to Title Storage */
	EOS_LC_TitleStorage(22),
	/** Logs related to the Mods service */
	EOS_LC_Mods(23),
	/** Logs related to the Anti-Cheat service */
	EOS_LC_AntiCheat(24),
	/** Logs related to reports client. */
	EOS_LC_Reports(25),
	/** Logs related to the Sanctions service */
	EOS_LC_Sanctions(26),
	/** Logs related to the Progression Snapshot service */
	EOS_LC_ProgressionSnapshots(27),
	/** Logs related to the Kids Web Services integration */
	EOS_LC_KWS(28),
	/** Logs related to the RTC API */
	EOS_LC_RTC(29),
	/** Logs related to the RTC Admin API */
	EOS_LC_RTCAdmin(30),
	/** Logs related to the Custom Invites API */
	EOS_LC_CustomInvites(31),
	/** Logs related to EOS HTTP activity */
	EOS_LC_HTTP(41),
	/** Not a real log category. Used by EOS_Logging_SetLogLevel to set the log level for all categories at the same time */
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