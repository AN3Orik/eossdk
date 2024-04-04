package host.anzo.eossdk.eos.sdk.sanctions.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton Lasevich
 * @since 3/24/2024
 */
public enum EOS_ESanctionAppealReason implements NativeMapped {
	/** Not used */
	EOS_SAR_Invalid(0),
	/** Incorrectly placed sanction */
	EOS_SAR_IncorrectSanction(1),
	/** The account was compromised, typically this means stolen */
	EOS_SAR_CompromisedAccount(2),
	/** The punishment is considered too severe by the user */
	EOS_SAR_UnfairPunishment(3),
	/** The user admits to rulebreaking, but still appeals for forgiveness */
	EOS_SAR_AppealForForgiveness(4);

	private final int id;

	private static final Map<Integer, EOS_ESanctionAppealReason> values = new HashMap<>();

	static {
		for (EOS_ESanctionAppealReason result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ESanctionAppealReason(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_SAR_Invalid);
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