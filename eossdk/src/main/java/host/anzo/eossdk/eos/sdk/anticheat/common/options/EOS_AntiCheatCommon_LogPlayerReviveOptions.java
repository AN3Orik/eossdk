package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatServer_LogPlayerRevive} function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "RevivedPlayerHandle", "ReviverPlayerHandle"})
public class EOS_AntiCheatCommon_LogPlayerReviveOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatCommon_LogPlayerReviveOptions struct. */
	public static int EOS_ANTICHEATCOMMON_LOGPLAYERREVIVE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGPLAYERREVIVE_API_LATEST}. */
	public int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle RevivedPlayerHandle;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle ReviverPlayerHandle;

	public EOS_AntiCheatCommon_LogPlayerReviveOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGPLAYERREVIVE_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogPlayerReviveOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogPlayerReviveOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogPlayerReviveOptions implements Structure.ByValue {
	}
}