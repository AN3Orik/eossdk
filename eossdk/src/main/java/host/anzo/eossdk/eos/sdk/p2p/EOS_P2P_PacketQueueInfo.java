package host.anzo.eossdk.eos.sdk.p2p;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Information related to the current state of the packet queues. It is possible for the current size
 * to be larger than the maximum size if the maximum size changes or if the maximum queue size is
 * set to EOS_P2P_MAX_QUEUE_SIZE_UNLIMITED.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"IncomingPacketQueueMaxSizeBytes", "IncomingPacketQueueCurrentSizeBytes", "IncomingPacketQueueCurrentPacketCount", "OutgoingPacketQueueMaxSizeBytes", "OutgoingPacketQueueCurrentSizeBytes", "OutgoingPacketQueueCurrentPacketCount"})
public class EOS_P2P_PacketQueueInfo extends Structure {
	/** The maximum size in bytes of the incoming packet queue */
	public long IncomingPacketQueueMaxSizeBytes;
	/** The current size in bytes of the incoming packet queue */
	public long IncomingPacketQueueCurrentSizeBytes;
	/** The current number of queued packets in the incoming packet queue */
	public long IncomingPacketQueueCurrentPacketCount;
	/** The maximum size in bytes of the outgoing packet queue */
	public long OutgoingPacketQueueMaxSizeBytes;
	/** The current size in bytes of the outgoing packet queue */
	public long OutgoingPacketQueueCurrentSizeBytes;
	/** The current amount of queued packets in the outgoing packet queue */
	public long OutgoingPacketQueueCurrentPacketCount;

	public EOS_P2P_PacketQueueInfo() {
		super();
	}

	public EOS_P2P_PacketQueueInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_PacketQueueInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_PacketQueueInfo implements Structure.ByValue {
	}
}