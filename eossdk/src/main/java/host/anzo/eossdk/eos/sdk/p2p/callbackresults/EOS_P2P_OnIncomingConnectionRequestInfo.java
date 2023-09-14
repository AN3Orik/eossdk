package host.anzo.eossdk.eos.sdk.p2p.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about an incoming connection request.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RemoteUserId", "SocketId"})
public class EOS_P2P_OnIncomingConnectionRequestInfo extends Structure {
	/** Client-specified data passed into EOS_Presence_AddNotifyOnPresenceChanged */
	public Pointer ClientData;
	/** The Product User ID of the local user who is being requested to open a P2P session with RemoteUserId */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the remote user who requested a peer connection with the local user */
	public EOS_ProductUserId RemoteUserId;
	/** The ID of the socket the Remote User wishes to communicate on */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_OnIncomingConnectionRequestInfo() {
		super();
	}

	public EOS_P2P_OnIncomingConnectionRequestInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_OnIncomingConnectionRequestInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_OnIncomingConnectionRequestInfo implements Structure.ByValue {
	}
}