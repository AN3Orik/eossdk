package host.anzo.eossdk.eos.sdk.p2p;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * P2P Socket ID
 * <p>
 * The Socket ID contains an application-defined name for the connection between a local person and another peer.
 * <p>
 * When a remote user receives a connection request from you, they will receive this information.  It can be important
 * to only accept connections with a known socket-name and/or from a known user, to prevent leaking of private
 * information, such as a user's IP address. Using the socket name as a secret key can help prevent such leaks. Shared
 * private data, like a private match's Session ID are good candidates for a socket name.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "SocketName"})
public class EOS_P2P_SocketId extends Structure {
	public static final int EOS_P2P_SOCKETID_API_LATEST = 1;

	/** The total buffer size of a EOS_P2P_SocketId SocketName, including space for the null-terminator */
	public static final int EOS_P2P_SOCKETID_SOCKETNAME_SIZE = 33;

	/** API Version: Set this to EOS_P2P_SOCKETID_API_LATEST. */
	public int ApiVersion;
	/** A name for the connection. Must be a NULL-terminated string of between 1-32 alpha-numeric characters (A-Z, a-z, 0-9, '-', '_', ' ', '+', '=', '.') */
	public char[] SocketName = new char[EOS_P2P_SOCKETID_SOCKETNAME_SIZE];

	public EOS_P2P_SocketId() {
		super();
		ApiVersion = EOS_P2P_SOCKETID_API_LATEST;
	}

	public EOS_P2P_SocketId(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_SocketId implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_SocketId implements Structure.ByValue {
	}
}