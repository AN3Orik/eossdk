package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about who would like to receive a packet, and how much data can be stored safely.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "MaxDataSizeBytes", "RequestedChannel"})
public class EOS_P2P_ReceivePacketOptions extends Structure {
	public static final int EOS_P2P_RECEIVEPACKET_API_LATEST = 2;

	/** API Version: Set this to EOS_P2P_RECEIVEPACKET_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the user who is receiving the packet */
	public EOS_ProductUserId LocalUserId;
	/** The maximum amount of data in bytes that can be safely copied to OutData in the function call */
	public int MaxDataSizeBytes;
	/** An optional channel to request the data for. If NULL, we're retrieving the next packet on any channel */
	public Pointer RequestedChannel;

	public EOS_P2P_ReceivePacketOptions() {
		super();
		ApiVersion = EOS_P2P_RECEIVEPACKET_API_LATEST;
	}

	public EOS_P2P_ReceivePacketOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_ReceivePacketOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_ReceivePacketOptions implements Structure.ByValue {
	}
}