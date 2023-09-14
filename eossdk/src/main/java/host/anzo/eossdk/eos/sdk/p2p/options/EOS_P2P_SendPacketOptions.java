package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_EPacketReliability;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about the data being sent and to which player
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RemoteUserId", "SocketId", "Channel", "DataLengthBytes", "Data", "bAllowDelayedDelivery", "Reliability", "bDisableAutoAcceptConnection"})
public class EOS_P2P_SendPacketOptions extends Structure {
	public static final int EOS_P2P_SENDPACKET_API_LATEST = 3;

	/** API Version: Set this to EOS_P2P_SENDPACKET_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who is sending this packet */
	public EOS_ProductUserId LocalUserId;
	/** The Product User ID of the Peer you would like to send a packet to */
	public EOS_ProductUserId RemoteUserId;
	/** The socket ID for data you are sending in this packet */
	public EOS_P2P_SocketId.ByReference SocketId;
	/** Channel associated with this data */
	public byte Channel;
	/** The size of the data to be sent to the RemoteUser */
	public int DataLengthBytes;
	/** The data to be sent to the RemoteUser */
	public Pointer Data;
	/** If false and we do not already have an established connection to the peer, this data will be dropped */
	public int bAllowDelayedDelivery;
	/**
	 * Setting to control the delivery reliability of this packet
	 */
	public EOS_EPacketReliability Reliability;
	/**
	 * If set to EOS_TRUE, EOS_P2P_SendPacket will not automatically establish a connection with the RemoteUserId and will require explicit calls to
	 * EOS_P2P_AcceptConnection first whenever the connection is closed. If set to EOS_FALSE, EOS_P2P_SendPacket will automatically accept and start
	 * the connection any time it is called and the connection is not already open.
	 */
	public int bDisableAutoAcceptConnection;

	public EOS_P2P_SendPacketOptions() {
		super();
		ApiVersion = EOS_P2P_SENDPACKET_API_LATEST;
	}

	public EOS_P2P_SendPacketOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_SendPacketOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_SendPacketOptions implements Structure.ByValue {
	}
}