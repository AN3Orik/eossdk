package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatClientMode;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Mode"})
public class EOS_AntiCheatClient_BeginSessionOptions extends Structure {
	public static final int EOS_ANTICHEATCLIENT_BEGINSESSION_API_LATEST = 3;

	/** API Version: Set this to EOS_ANTICHEATCLIENT_BEGINSESSION_API_LATEST. */
	public int ApiVersion;
	/** Logged in user identifier from earlier call to EOS_Connect_Login family of functions */
	public EOS_ProductUserId LocalUserId;
	/** Operating mode */
	public EOS_EAntiCheatClientMode Mode;

	public EOS_AntiCheatClient_BeginSessionOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_BEGINSESSION_API_LATEST;
	}

	public EOS_AntiCheatClient_BeginSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_BeginSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_BeginSessionOptions implements Structure.ByValue {
	}
}
