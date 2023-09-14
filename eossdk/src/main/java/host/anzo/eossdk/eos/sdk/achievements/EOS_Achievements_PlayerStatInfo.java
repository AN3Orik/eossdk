package host.anzo.eossdk.eos.sdk.achievements;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a collection of stat info data.
 * @see EOS_Achievements_PlayerAchievement
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "Name", "CurrentValue", "ThresholdValue"})
public class EOS_Achievements_PlayerStatInfo extends Structure {
	/** The most recent version of the EOS_Achievements_PlayerStatInfo struct. */
	public static final int EOS_ACHIEVEMENTS_PLAYERSTATINFO_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_PLAYERSTATINFO_API_LATEST. */
	public int ApiVersion;
	/** The name of the stat. */
	public String Name;
	/** The current value of the stat. */
	public int CurrentValue;
	/** The threshold value of the stat, used in determining when to unlock an achievement. */
	public int ThresholdValue;

	public EOS_Achievements_PlayerStatInfo() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_PLAYERSTATINFO_API_LATEST;
	}

	public EOS_Achievements_PlayerStatInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_PlayerStatInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_PlayerStatInfo implements Structure.ByValue {
	}
}