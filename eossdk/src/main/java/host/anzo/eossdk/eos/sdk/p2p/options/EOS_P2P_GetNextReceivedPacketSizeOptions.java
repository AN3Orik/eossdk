package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about who would like to receive a packet.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RequestedChannel"})
public class EOS_P2P_GetNextReceivedPacketSizeOptions extends Structure {
	/** The most recent version of the EOS_P2P_GetNextReceivedPacketSize API. */
	public static final int EOS_P2P_GETNEXTRECEIVEDPACKETSIZE_API_LATEST = 2;

	/** API Version: Set this to EOS_P2P_GETNEXTRECEIVEDPACKETSIZE_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who is receiving the packet */
	public EOS_ProductUserId LocalUserId;
	/** An optional channel to request the data for. If NULL, we're retrieving the size of the next packet on any channel. */
	public ByteByReference RequestedChannel;

	public EOS_P2P_GetNextReceivedPacketSizeOptions() {
		super();
		ApiVersion = EOS_P2P_GETNEXTRECEIVEDPACKETSIZE_API_LATEST;
	}

	public EOS_P2P_GetNextReceivedPacketSizeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_GetNextReceivedPacketSizeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_GetNextReceivedPacketSizeOptions implements Structure.ByValue {
	}
}
