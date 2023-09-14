package host.anzo.eossdk.eos.sdk.lobby.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Advertisement properties for a single attribute associated with a lobby
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public @Getter enum EOS_ELobbyAttributeVisibility implements NativeMapped {
	/** Data is visible to lobby members, searchable and visible in search results. */
	EOS_LAT_PUBLIC(0),
	/** Data is only visible to the user setting the data. Data is not visible to lobby members, not searchable, and not visible in search results. */
	EOS_LAT_PRIVATE(1);

	private final int id;

	private static final Map<Integer, EOS_ELobbyAttributeVisibility> values = new HashMap<>();

	static {
		for (EOS_ELobbyAttributeVisibility result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELobbyAttributeVisibility(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_LAT_PUBLIC);
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