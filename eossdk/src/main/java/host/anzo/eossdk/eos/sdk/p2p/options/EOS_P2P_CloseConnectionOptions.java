package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about who would like to close a connection, and which connection.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RemoteUserId", "SocketId"})
public class EOS_P2P_CloseConnectionOptions extends Structure {
	public static final int EOS_P2P_CLOSECONNECTION_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_CLOSECONNECTION_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who would like to close a previously accepted connection (or decline a pending invite) */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the remote user to disconnect from (or to reject a pending invite from) */
	public EOS_ProductUserId RemoteUserId;
	/** The socket ID of the connection to close (or optionally NULL to not accept any connection requests from the Remote User) */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_CloseConnectionOptions() {
		super();
		ApiVersion = EOS_P2P_CLOSECONNECTION_API_LATEST;
	}

	public EOS_P2P_CloseConnectionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_CloseConnectionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_CloseConnectionOptions implements Structure.ByValue {
	}
}