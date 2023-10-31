package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about new packet queue size settings.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "IncomingPacketQueueMaxSizeBytes", "OutgoingPacketQueueMaxSizeBytes"})
public class EOS_P2P_SetPacketQueueSizeOptions extends Structure {
	/** The most recent version of the EOS_P2P_SetPacketQueueSize API. */
	public static final int EOS_P2P_SETPACKETQUEUESIZE_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_SETPACKETQUEUESIZE_API_LATEST. */
	public int ApiVersion;
	/** The ideal maximum amount of bytes the Incoming packet queue can consume */
	public long IncomingPacketQueueMaxSizeBytes;
	/** The ideal maximum amount of bytes the Outgoing packet queue can consume */
	public long OutgoingPacketQueueMaxSizeBytes;

	public EOS_P2P_SetPacketQueueSizeOptions() {
		super();
		ApiVersion = EOS_P2P_SETPACKETQUEUESIZE_API_LATEST;
	}

	public EOS_P2P_SetPacketQueueSizeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_SetPacketQueueSizeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_SetPacketQueueSizeOptions implements Structure.ByValue {
	}
}