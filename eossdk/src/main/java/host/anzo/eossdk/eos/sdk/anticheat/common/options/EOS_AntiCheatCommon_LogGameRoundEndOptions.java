package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatServer_LogGameRoundEnd} function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "WinningTeamId"})
public class EOS_AntiCheatCommon_LogGameRoundEndOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatCommon_LogGameRoundEndOptions struct. */
	public static int EOS_ANTICHEATCOMMON_LOGGAMEROUNDEND_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGGAMEROUNDEND_API_LATEST}. */
	public int ApiVersion;
	/** Optional identifier for the winning team */
	public int WinningTeamId;

	public EOS_AntiCheatCommon_LogGameRoundEndOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGGAMEROUNDEND_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogGameRoundEndOptions(int winningTeamId) {
		this();
		WinningTeamId = winningTeamId;
	}

	public EOS_AntiCheatCommon_LogGameRoundEndOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogGameRoundEndOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogGameRoundEndOptions implements Structure.ByValue {
	}
}