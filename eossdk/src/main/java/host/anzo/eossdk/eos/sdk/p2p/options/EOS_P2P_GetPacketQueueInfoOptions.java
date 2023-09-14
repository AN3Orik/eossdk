package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information needed to get the current packet queue information.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_P2P_GetPacketQueueInfoOptions extends Structure {
	public static final int EOS_P2P_GETPACKETQUEUEINFO_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_GETPACKETQUEUEINFO_API_LATEST. */
	public int ApiVersion;
	public EOS_P2P_GetPacketQueueInfoOptions() {
		super();
		ApiVersion = EOS_P2P_GETPACKETQUEUEINFO_API_LATEST;
	}

	public EOS_P2P_GetPacketQueueInfoOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_GetPacketQueueInfoOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_GetPacketQueueInfoOptions implements Structure.ByValue {
	}
}