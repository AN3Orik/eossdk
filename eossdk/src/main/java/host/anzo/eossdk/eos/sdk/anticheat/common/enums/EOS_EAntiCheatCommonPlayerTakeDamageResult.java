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
	/** Deprecated - use more specific values below instead */
	EOS_ACCPTDR_Downed_DEPRECATED(1),
	/** Deprecated - use more specific values below instead */
	EOS_ACCPTDR_Eliminated_DEPRECATED(2),
	/** Player character transitioned from a normal state to temporarily incapacitated and requires assistance to recover. */
	EOS_ACCPTDR_NormalToDowned(3),
	/** Player character transitioned from a normal state to permanently incapacitated and cannot recover (e.g. dead). */
	EOS_ACCPTDR_NormalToEliminated(4),
	/** Player character transitioned from a temporarily incapacitated state to permanently incapacitated and cannot recover (e.g. dead). */
	EOS_ACCPTDR_DownedToEliminated(5);

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
		return values.getOrDefault((int) nativeValue, EOS_ACCPTDR_None);
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