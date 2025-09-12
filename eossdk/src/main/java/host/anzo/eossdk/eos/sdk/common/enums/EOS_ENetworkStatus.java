package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * All possible states of the network
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_ENetworkStatus implements NativeMapped {
	/**
	 * Networking unavailable.
	 */
	EOS_NS_Disabled(1),
	/**
	 * Not connected to the internet. Only local area networking (LAN) may be available.
	 */
	EOS_NS_Offline(2),
	/**
	 * Connected to the internet.
	 */
	EOS_NS_Online(3);

	private final int id;

	private static final Map<Integer, EOS_ENetworkStatus> values = new HashMap<>();

	static {
		for (EOS_ENetworkStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ENetworkStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_NS_Disabled);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}

	/**
	 * Gets the string representation of an EOS_ENetworkStatus value.
	 * <p>
	 * Example: EOS_ENetworkStatus_ToString(EOS_ENetworkStatus::EOS_NS_Online) returns "EOS_NS_Online".
	 *
	 * @return Pointer to a static string representing the input enum value.
	 *         The returned string is guaranteed to be non-null, and must not be freed by the application.
	 */
	@Override
	public String toString() {
		return EOSLibrary.instance.EOS_ENetworkStatus_ToString(this);
	}
}