package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "PeerHandle", "DataLengthBytes", "Data"})
public class EOS_AntiCheatClient_ReceiveMessageFromPeerOptions extends Structure {
	public static int EOS_ANTICHEATCLIENT_RECEIVEMESSAGEFROMPEER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCLIENT_RECEIVEMESSAGEFROMPEER_API_LATEST}. */
	public int ApiVersion;
	/** The handle describing the sender of this message */
	public EOS_AntiCheatCommon_ClientHandle PeerHandle;
	/** The size of the data received */
	public int DataLengthBytes;
	/** The data received */
	public Pointer Data;

	public EOS_AntiCheatClient_ReceiveMessageFromPeerOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_RECEIVEMESSAGEFROMPEER_API_LATEST;
	}

	public EOS_AntiCheatClient_ReceiveMessageFromPeerOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_ReceiveMessageFromPeerOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_ReceiveMessageFromPeerOptions implements Structure.ByValue {
	}
}