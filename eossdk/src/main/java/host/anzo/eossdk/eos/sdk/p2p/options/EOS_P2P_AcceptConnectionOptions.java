package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about who would like to accept a connection, and which connection.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RemoteUserId", "SocketId"})
public class EOS_P2P_AcceptConnectionOptions extends Structure {
	/** The most recent version of the EOS_P2P_AcceptConnection API. */
	public static final int EOS_P2P_ACCEPTCONNECTION_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_ACCEPTCONNECTION_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who is accepting any pending or future connections with RemoteUserId */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the remote user who has either sent a connection request or is expected to in the future */
	public EOS_ProductUserId RemoteUserId;
	/** The socket ID of the connection to accept on */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_AcceptConnectionOptions() {
		super();
		ApiVersion = EOS_P2P_ACCEPTCONNECTION_API_LATEST;
	}

	public EOS_P2P_AcceptConnectionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_AcceptConnectionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_AcceptConnectionOptions implements Structure.ByValue {
	}
}