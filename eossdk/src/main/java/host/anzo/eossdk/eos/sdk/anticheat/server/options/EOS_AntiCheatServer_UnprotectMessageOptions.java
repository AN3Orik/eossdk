package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatServer_UnprotectMessage} function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle", "DataLengthBytes", "Data", "OutBufferSizeBytes"})
public class EOS_AntiCheatServer_UnprotectMessageOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatServer_UnprotectMessage API. */
	public static int EOS_ANTICHEATSERVER_UNPROTECTMESSAGE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATSERVER_UNPROTECTMESSAGE_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value describing the remote user from whom the message was received */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** Length in bytes of input */
	public int DataLengthBytes;
	/** The data to decrypt */
	public Pointer Data;
	/** The size in bytes of OutBuffer */
	public int OutBufferSizeBytes;

	public EOS_AntiCheatServer_UnprotectMessageOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_UNPROTECTMESSAGE_API_LATEST;
	}

	public EOS_AntiCheatServer_UnprotectMessageOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_UnprotectMessageOptions implements Structure.ByReference {
		public ByReference(EOS_AntiCheatCommon_ClientHandle clientHandle, byte @NotNull [] data) {
			super();
			ClientHandle = clientHandle;
			Data = new Memory(data.length);
			Data.write(0, data, 0, data.length);
			DataLengthBytes = data.length;
			OutBufferSizeBytes = data.length;
		}
	}

	public static class ByValue extends EOS_AntiCheatServer_UnprotectMessageOptions implements Structure.ByValue {
	}
}