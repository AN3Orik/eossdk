package host.anzo.eossdk.eos.sdk.p2p.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Types of packet reliability.
 * <p>
 * Ordered packets will only be ordered relative to other ordered packets. Reliable/unreliable and ordered/unordered communication
 * can be sent on the same Socket ID and Channel.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public @Getter enum EOS_EPacketReliability implements NativeMapped {
	/** Packets will only be sent once and may be received out of order */
	EOS_PR_UnreliableUnordered(0),
	/** Packets may be sent multiple times and may be received out of order */
	EOS_PR_ReliableUnordered(1),
	/** Packets may be sent multiple times and will be received in order */
	EOS_PR_ReliableOrdered(2);

	private final int id;

	private static final Map<Integer, EOS_EPacketReliability> values = new HashMap<>();

	static {
		for (EOS_EPacketReliability result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EPacketReliability(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_PR_UnreliableUnordered);
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