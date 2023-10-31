package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about who would like to close connections, and by what socket ID
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "SocketId"})
public class EOS_P2P_CloseConnectionsOptions extends Structure {
	/** The most recent version of the EOS_P2P_CloseConnections API. */
	public static final int EOS_P2P_CLOSECONNECTIONS_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_CLOSECONNECTIONS_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who would like to close all connections that use a particular socket ID */
	public EOS_ProductUserId LocalUserId;
	/** The socket ID of the connections to close */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_CloseConnectionsOptions() {
		super();
		ApiVersion = EOS_P2P_CLOSECONNECTIONS_API_LATEST;
	}

	public EOS_P2P_CloseConnectionsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_CloseConnectionsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_CloseConnectionsOptions implements Structure.ByValue {
	}
}