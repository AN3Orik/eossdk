package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about which connections should be notified
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "SocketId"})
public class EOS_P2P_AddNotifyPeerConnectionEstablishedOptions extends Structure {
	public static final int EOS_P2P_ADDNOTIFYPEERCONNECTIONESTABLISHED_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_ADDNOTIFYPEERCONNECTIONESTABLISHED_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who would like to receive notifications */
	public EOS_ProductUserId LocalUserId;
	/** The optional socket ID, used as a filter for established connections. If NULL, this function handler will be called for all sockets */
	public EOS_P2P_SocketId.ByReference SocketId;

	public EOS_P2P_AddNotifyPeerConnectionEstablishedOptions() {
		super();
		ApiVersion = EOS_P2P_ADDNOTIFYPEERCONNECTIONESTABLISHED_API_LATEST;
	}

	public EOS_P2P_AddNotifyPeerConnectionEstablishedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_AddNotifyPeerConnectionEstablishedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_AddNotifyPeerConnectionEstablishedOptions implements Structure.ByValue {
	}
}