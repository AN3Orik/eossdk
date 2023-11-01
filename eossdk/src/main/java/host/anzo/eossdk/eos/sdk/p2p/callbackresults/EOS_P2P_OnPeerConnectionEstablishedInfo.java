package host.anzo.eossdk.eos.sdk.p2p.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_EConnectionEstablishedType;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_ENetworkConnectionType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about a connection being established
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RemoteUserId", "SocketId", "ConnectionType", "NetworkType"})
public class EOS_P2P_OnPeerConnectionEstablishedInfo extends Structure {
	/** Client-specified data passed into EOS_P2P_AddNotifyPeerConnectionEstablished */
	public Pointer ClientData;
	/** The Product User ID of the local user who is being notified of a connection being established */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the remote user who this connection was with */
	public EOS_ProductUserId RemoteUserId;
	/** The socket ID of the connection being established */
	public EOS_P2P_SocketId.ByReference SocketId;
	/**
	 * Information if this is a new connection or reconnection
	 */
	public EOS_EConnectionEstablishedType ConnectionType;
	/**
	 * What type of network connection is being used for this connection
	 */
	public EOS_ENetworkConnectionType NetworkType;

	public EOS_P2P_OnPeerConnectionEstablishedInfo() {
		super();
	}

	public EOS_P2P_OnPeerConnectionEstablishedInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_OnPeerConnectionEstablishedInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_OnPeerConnectionEstablishedInfo implements Structure.ByValue {
	}
}