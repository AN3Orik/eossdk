package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatClient_GetProtectMessageOutputLength} function.
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "DataLengthBytes"})
public class EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatClient_GetProtectMessageOutputLength API. */
	public static final int EOS_ANTICHEATCLIENT_GETPROTECTMESSAGEOUTPUTLENGTH_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCLIENT_GETPROTECTMESSAGEOUTPUTLENGTH_API_LATEST}. */
	public int ApiVersion;
	/** Length in bytes of input */
	public int DataLengthBytes;

	public EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_GETPROTECTMESSAGEOUTPUTLENGTH_API_LATEST;
	}

	public EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions(int dataLengthBytes) {
		this();
		this.DataLengthBytes = dataLengthBytes;
	}

	public EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions implements Structure.ByValue {
	}
}