package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about who would like connection notifications, and about which socket.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "SocketId"})
public class EOS_P2P_AddNotifyPeerConnectionRequestOptions extends Structure {
	/** The most recent version of the EOS_P2P_AddNotifyPeerConnectionRequest API. */
	public static final int EOS_P2P_ADDNOTIFYPEERCONNECTIONREQUEST_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_P2P_ADDNOTIFYPEERCONNECTIONREQUEST_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user who is listening for incoming connection requests */
	public EOS_ProductUserId LocalUserId;
	/** The optional socket ID to listen for, used as a filter for incoming connection requests; If NULL, incoming connection requests will not be filtered */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_AddNotifyPeerConnectionRequestOptions() {
		super();
		ApiVersion = EOS_P2P_ADDNOTIFYPEERCONNECTIONREQUEST_API_LATEST;
	}

	public EOS_P2P_AddNotifyPeerConnectionRequestOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_AddNotifyPeerConnectionRequestOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_AddNotifyPeerConnectionRequestOptions implements Structure.ByValue {
	}
}