package host.anzo.eossdk.eos.sdk.p2p.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_EConnectionClosedReason;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about an connection request that is being closed.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RemoteUserId", "SocketId", "Reason"})
public class EOS_P2P_OnRemoteConnectionClosedInfo extends Structure {
	/** Client-specified data passed into EOS_Presence_AddNotifyOnPresenceChanged */
	public Pointer ClientData;
	/** The local user who is being notified of a connection being closed */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the remote user who this connection was with */
	public EOS_ProductUserId RemoteUserId;
	/** The socket ID of the connection being closed */
	public EOS_P2P_SocketId.ByReference SocketId;
	/**
	 * The reason the connection was closed (if known)
	 */
	public EOS_EConnectionClosedReason Reason;

	public EOS_P2P_OnRemoteConnectionClosedInfo() {
		super();
	}

	public EOS_P2P_OnRemoteConnectionClosedInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_OnRemoteConnectionClosedInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_OnRemoteConnectionClosedInfo implements Structure.ByValue {
	}
}