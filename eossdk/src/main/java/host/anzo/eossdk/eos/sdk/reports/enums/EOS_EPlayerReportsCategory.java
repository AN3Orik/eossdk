package host.anzo.eossdk.eos.sdk.reports.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different player behavior categories that can be reported.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public @Getter enum EOS_EPlayerReportsCategory implements NativeMapped {
	/** Not used */
	EOS_PRC_Invalid(0),
	/** The reported player is cheating */
	EOS_PRC_Cheating(1),
	/** The reported player is exploiting the game */
	EOS_PRC_Exploiting(2),
	/** The reported player has an offensive profile, name, etc */
	EOS_PRC_OffensiveProfile(3),
	/** The reported player is being abusive in chat */
	EOS_PRC_VerbalAbuse(4),
	/** The reported player is scamming other players */
	EOS_PRC_Scamming(5),
	/** The reported player is spamming chat */
	EOS_PRC_Spamming(6),
	/** The player is being reported for something else */
	EOS_PRC_Other(7);

	private final int id;

	private static final Map<Integer, EOS_EPlayerReportsCategory> values = new HashMap<>();

	static {
		for (EOS_EPlayerReportsCategory result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EPlayerReportsCategory(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_PRC_Invalid);
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