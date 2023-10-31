package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "DataLengthBytes", "Data"})
public class EOS_AntiCheatClient_ReceiveMessageFromServerOptions extends Structure {
	public static final int EOS_ANTICHEATCLIENT_RECEIVEMESSAGEFROMSERVER_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATCLIENT_RECEIVEMESSAGEFROMSERVER_API_LATEST. */
	public int ApiVersion;
	/** The size of the data received */
	public int DataLengthBytes;
	/** The data received */
	public Pointer Data;

	public EOS_AntiCheatClient_ReceiveMessageFromServerOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_RECEIVEMESSAGEFROMSERVER_API_LATEST;
	}

	/**
	 * @param data The data received
	 */
	public EOS_AntiCheatClient_ReceiveMessageFromServerOptions(byte @NotNull [] data) {
		this();
		Data = new Memory(data.length);
		Data.write(0, data, 0, data.length);
		DataLengthBytes = data.length;
	}

	public EOS_AntiCheatClient_ReceiveMessageFromServerOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_ReceiveMessageFromServerOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_ReceiveMessageFromServerOptions implements Structure.ByValue {
	}
}