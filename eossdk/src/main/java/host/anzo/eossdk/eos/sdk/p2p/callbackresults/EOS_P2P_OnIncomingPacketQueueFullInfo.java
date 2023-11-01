package host.anzo.eossdk.eos.sdk.p2p.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about the packet queue's state and the incoming packet that would overflow the queue
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "PacketQueueMaxSizeBytes", "PacketQueueCurrentSizeBytes", "OverflowPacketLocalUserId", "OverflowPacketChannel", "OverflowPacketSizeBytes"})
public class EOS_P2P_OnIncomingPacketQueueFullInfo extends Structure {
	/** Client-specified data passed into AddNotifyIncomingPacketQueueFull */
	public Pointer ClientData;
	/** The maximum size in bytes the incoming packet queue is allowed to use */
	public long PacketQueueMaxSizeBytes;
	/** The current size in bytes the incoming packet queue is currently using */
	public long PacketQueueCurrentSizeBytes;
	/** The Product User ID of the local user who is receiving the packet that would overflow the queue */
	public EOS_ProductUserId OverflowPacketLocalUserId;
	/** The channel the incoming packet is for */
	public byte OverflowPacketChannel;
	/** The size in bytes of the incoming packet (and related metadata) that would overflow the queue */
	public int OverflowPacketSizeBytes;

	public EOS_P2P_OnIncomingPacketQueueFullInfo() {
		super();
	}

	public EOS_P2P_OnIncomingPacketQueueFullInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_OnIncomingPacketQueueFullInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_OnIncomingPacketQueueFullInfo implements Structure.ByValue {
	}
}