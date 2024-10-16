package host.anzo.eossdk.eos.sdk.p2p.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Reasons why a P2P connection was closed
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public @Getter enum EOS_EConnectionClosedReason implements NativeMapped {
	/** The connection was closed for unknown reasons. This most notably happens during application shutdown. */
	EOS_CCR_Unknown(0),
	/** The connection was at least locally accepted, but was closed by the local user via a call to EOS_P2P_CloseConnection / EOS_P2P_CloseConnections. */
	EOS_CCR_ClosedByLocalUser(1),
	/** The connection was at least locally accepted, but was gracefully closed by the remote user via a call to EOS_P2P_CloseConnection / EOS_P2P_CloseConnections. */
	EOS_CCR_ClosedByPeer(2),
	/** The connection was at least locally accepted, but was not remotely accepted in time. */
	EOS_CCR_TimedOut(3),
	/** The connection was accepted, but the connection could not be created due to too many other existing connections */
	EOS_CCR_TooManyConnections(4),
	/** The connection was accepted, The remote user sent an invalid message */
	EOS_CCR_InvalidMessage(5),
	/** The connection was accepted, but the remote user sent us invalid data */
	EOS_CCR_InvalidData(6),
	/** The connection was accepted, but we failed to ever establish a connection with the remote user due to connectivity issues. */
	EOS_CCR_ConnectionFailed(7),
	/** The connection was accepted and established, but the peer silently went away. */
	EOS_CCR_ConnectionClosed(8),
	/** The connection was locally accepted, but we failed to negotiate a connection with the remote user. This most commonly occurs if the local user goes offline or is logged-out during the connection process. */
	EOS_CCR_NegotiationFailed(9),
	/** The connection was accepted, but there was an internal error occurred and the connection cannot be created or continue. */
	EOS_CCR_UnexpectedError(10),
	/** The connection was ignored because no connection listeners were bound. */
	EOS_CCR_ConnectionIgnored(11);

	private final int id;

	private static final Map<Integer, EOS_EConnectionClosedReason> values = new HashMap<>();

	static {
		for (EOS_EConnectionClosedReason result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EConnectionClosedReason(int id) {
		this.id = id;
	}

	@SuppressWarnings("unused")
	public static EOS_EConnectionClosedReason fromId(Integer id) {
		return values.getOrDefault(id, EOS_CCR_Unknown);
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_CCR_Unknown);
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