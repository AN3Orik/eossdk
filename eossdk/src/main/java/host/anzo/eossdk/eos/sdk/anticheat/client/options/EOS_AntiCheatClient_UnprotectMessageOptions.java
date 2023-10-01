package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "DataLengthBytes", "Data", "OutBufferSizeBytes"})
public class EOS_AntiCheatClient_UnprotectMessageOptions extends Structure {
	public static final int EOS_ANTICHEATCLIENT_UNPROTECTMESSAGE_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATCLIENT_UNPROTECTMESSAGE_API_LATEST. */
	public int ApiVersion;
	/** Length in bytes of input */
	public int DataLengthBytes;
	/** The data to decrypt */
	public byte[] Data;
	/** The size in bytes of OutBuffer */
	public int OutBufferSizeBytes;

	public EOS_AntiCheatClient_UnprotectMessageOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_UNPROTECTMESSAGE_API_LATEST;
	}

	public EOS_AntiCheatClient_UnprotectMessageOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_UnprotectMessageOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_UnprotectMessageOptions implements Structure.ByValue {
	}
}

