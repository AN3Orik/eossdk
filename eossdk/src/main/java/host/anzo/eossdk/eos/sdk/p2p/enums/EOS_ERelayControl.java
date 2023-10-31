package host.anzo.eossdk.eos.sdk.p2p.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Setting for controlling whether relay servers are used.
 * <p>
 * Please see the following EOS_ERelayControl value compatibility-chart to better understand how changing this value
 * can affect compatibility between clients with different settings.
 * <pre>
 * <code>
 * +------------------------------+---------------------+-------------------------------+---------------------+
 * |                              |   EOS_RC_NoRelays   |  EOS_RC_AllowRelays (Default) |  EOS_RC_ForceRelays |
 * +------------------------------+---------------------+-------------------------------+---------------------
 * | EOS_RC_NoRelays              |  Compatible         |  Compatible                   |  Connection Failure |
 * | EOS_RC_AllowRelays (Default) |  Compatible         |  Compatible                   |  Compatible         |
 * | EOS_RC_ForceRelays           |  Connection Failure |  Compatible                   |  Compatible         |
 * +------------------------------+---------------------+-------------------------------+---------------------+
 * </code>
 * </pre>
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public @Getter enum EOS_ERelayControl implements NativeMapped {
	/** Peer connections will never attempt to use relay servers. Clients with restrictive NATs may not be able to connect to peers. */
	EOS_RC_NoRelays(0),
	/** Peer connections will attempt to use relay servers, but only after direct connection attempts fail. This is the default value if not changed. */
	EOS_RC_AllowRelays(1),
	/** Peer connections will only ever use relay servers. This will add latency to all connections, but will hide IP Addresses from peers. */
	EOS_RC_ForceRelays(2);

	private final int id;

	private static final Map<Integer, EOS_ERelayControl> values = new HashMap<>();

	static {
		for (EOS_ERelayControl result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ERelayControl(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_RC_NoRelays);
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