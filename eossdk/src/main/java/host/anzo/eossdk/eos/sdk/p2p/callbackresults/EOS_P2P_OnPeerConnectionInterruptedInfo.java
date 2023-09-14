package host.anzo.eossdk.eos.sdk.p2p.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about an connection request that is that was interrupted.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RemoteUserId", "SocketId"})
public class EOS_P2P_OnPeerConnectionInterruptedInfo extends Structure {
	/** Client-specified data passed into EOS_Presence_AddNotifyOnPresenceChanged */
	public Pointer ClientData;
	/** The local user who is being notified of a connection that was interrupted */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the remote user who this connection was with */
	public EOS_ProductUserId RemoteUserId;
	/** The socket ID of the connection that was interrupted */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_OnPeerConnectionInterruptedInfo() {
		super();
	}

	public EOS_P2P_OnPeerConnectionInterruptedInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_OnPeerConnectionInterruptedInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_OnPeerConnectionInterruptedInfo implements Structure.ByValue {
	}
}