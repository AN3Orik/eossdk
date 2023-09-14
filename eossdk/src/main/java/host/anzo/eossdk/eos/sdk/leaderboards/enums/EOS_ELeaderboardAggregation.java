package host.anzo.eossdk.eos.sdk.leaderboards.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different leaderboard aggregation types.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public @Getter enum EOS_ELeaderboardAggregation implements NativeMapped {
	/** Minimum */
	EOS_LA_Min(0),
	/** Maximum */
	EOS_LA_Max(1),
	/** Sum */
	EOS_LA_Sum(2),
	/** Latest */
	EOS_LA_Latest(3);

	private final int id;

	private static final Map<Integer, EOS_ELeaderboardAggregation> values = new HashMap<>();

	static {
		for (EOS_ELeaderboardAggregation result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELeaderboardAggregation(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_LA_Min);
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