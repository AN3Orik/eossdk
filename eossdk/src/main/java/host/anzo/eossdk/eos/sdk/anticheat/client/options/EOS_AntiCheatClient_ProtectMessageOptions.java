package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatClient_ProtectMessage} function.
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "DataLengthBytes", "Data", "OutBufferSizeBytes"})
public class EOS_AntiCheatClient_ProtectMessageOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatClient_ProtectMessage API. */
	public static final int EOS_ANTICHEATCLIENT_PROTECTMESSAGE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCLIENT_PROTECTMESSAGE_API_LATEST}. */
	public int ApiVersion;
	/** Length in bytes of input */
	public int DataLengthBytes;
	/** The data to encrypt */
	public Pointer Data;
	/** The size in bytes of OutBuffer */
	public int OutBufferSizeBytes;

	public EOS_AntiCheatClient_ProtectMessageOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_PROTECTMESSAGE_API_LATEST;
	}

	public EOS_AntiCheatClient_ProtectMessageOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_ProtectMessageOptions implements Structure.ByReference {
		/**
		 * @param data The data to encrypt
		 * @param outBufferSizeBytes The size in bytes of OutBuffer
		 */
		public ByReference(byte @NotNull [] data, int outBufferSizeBytes) {
			super();
			Data = new Memory(data.length);
			Data.write(0, data, 0, data.length);
			DataLengthBytes = data.length;
			OutBufferSizeBytes = outBufferSizeBytes;
		}
	}

	public static class ByValue extends EOS_AntiCheatClient_ProtectMessageOptions implements Structure.ByValue {
	}
}