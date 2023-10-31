package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about who would like notifications about closed connections, and for which socket.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "SocketId"})
public class EOS_P2P_AddNotifyPeerConnectionClosedOptions extends Structure {
	/** The most recent version of the EOS_P2P_AddNotifyPeerConnectionClosed API. */
	public static final int EOS_P2P_ADDNOTIFYPEERCONNECTIONCLOSED_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_ADDNOTIFYPEERCONNECTIONCLOSED_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who would like notifications */
	public EOS_ProductUserId LocalUserId;
	/** The optional socket ID to listen for to be closed. If NULL, this function handler will be called for all closed connections */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_AddNotifyPeerConnectionClosedOptions() {
		super();
		ApiVersion = EOS_P2P_ADDNOTIFYPEERCONNECTIONCLOSED_API_LATEST;
	}

	public EOS_P2P_AddNotifyPeerConnectionClosedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_AddNotifyPeerConnectionClosedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_AddNotifyPeerConnectionClosedOptions implements Structure.ByValue {
	}
}