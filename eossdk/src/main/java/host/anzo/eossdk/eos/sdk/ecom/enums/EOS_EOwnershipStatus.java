package host.anzo.eossdk.eos.sdk.ecom.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different ownership statuses.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public @Getter enum EOS_EOwnershipStatus implements NativeMapped {
	/** The catalog item is not owned by the local user */
	EOS_OS_NotOwned(0),
	/** The catalog item is owned by the local user */
	EOS_OS_Owned(1);

	private final int id;

	private static final Map<Integer, EOS_EOwnershipStatus> values = new HashMap<>();

	static {
		for (EOS_EOwnershipStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EOwnershipStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_OS_NotOwned);
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