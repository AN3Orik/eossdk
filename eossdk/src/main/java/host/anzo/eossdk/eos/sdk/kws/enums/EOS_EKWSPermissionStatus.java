package host.anzo.eossdk.eos.sdk.kws.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different permission statuses.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public @Getter enum EOS_EKWSPermissionStatus implements NativeMapped {
	/** Permission has been granted */
	EOS_KPS_GRANTED(0),
	/** Permission has been rejected */
	EOS_KPS_REJECTED(1),
	/** Permission is still pending approval */
	EOS_KPS_PENDING(2);

	private final int id;

	private static final Map<Integer, EOS_EKWSPermissionStatus> values = new HashMap<>();

	static {
		for (EOS_EKWSPermissionStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EKWSPermissionStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_KPS_GRANTED);
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