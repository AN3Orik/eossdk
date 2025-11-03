package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EAntiCheatCommonGameRoundCompetitionType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatServer_LogGameRoundStart} function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "SessionIdentifier", "LevelName", "ModeName", "RoundTimeSeconds", "CompetitionType"})
public class EOS_AntiCheatCommon_LogGameRoundStartOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatCommon_LogGameRoundStartOptions struct. */
	public static int EOS_ANTICHEATCOMMON_LOGGAMEROUNDSTART_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGGAMEROUNDSTART_API_LATEST}. */
	public int ApiVersion;
	/** Optional game session or match identifier useful for some backend API integrations */
	public String SessionIdentifier;
	/** Optional name of the map being played */
	public String LevelName;
	/** Optional name of the game mode being played */
	public String ModeName;
	/** Optional length of the game round to be played, in seconds. If none, use 0. */
	public int RoundTimeSeconds;
	/**
	 * Type of competition for this game round
	 */
	public EOS_EAntiCheatCommonGameRoundCompetitionType CompetitionType;

	public EOS_AntiCheatCommon_LogGameRoundStartOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGGAMEROUNDSTART_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogGameRoundStartOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogGameRoundStartOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogGameRoundStartOptions implements Structure.ByValue {
	}
}