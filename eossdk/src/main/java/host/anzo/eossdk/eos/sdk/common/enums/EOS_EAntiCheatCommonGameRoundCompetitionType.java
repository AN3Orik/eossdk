package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * Flags describing the type of competition taking place<br>
 * @author Anton Lasevich
 * @since 10/16/2024
 */
public enum EOS_EAntiCheatCommonGameRoundCompetitionType implements NativeMapped {
	/** No particular competition type applies */
	EOS_ACCGRCT_None(0),
	/** Casual unranked play */
	EOS_ACCGRCT_Casual(1),
	/** Ranked play, usually with skill-based matchmaking */
	EOS_ACCGRCT_Ranked(2),
	/** Organized competitive play like a tournament */
	EOS_ACCGRCT_Competitive(3);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatCommonGameRoundCompetitionType> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatCommonGameRoundCompetitionType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatCommonGameRoundCompetitionType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_ACCGRCT_None);
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