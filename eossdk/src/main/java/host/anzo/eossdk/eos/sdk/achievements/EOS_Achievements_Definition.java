package host.anzo.eossdk.eos.sdk.achievements;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Achievements_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "AchievementId", "DisplayName", "Description", "LockedDisplayName", "LockedDescription", "HiddenDescription", "CompletionDescription", "UnlockedIconId", "LockedIconId", "bIsHidden", "StatThresholdsCount", "StatThresholds"})
public class EOS_Achievements_Definition extends Structure implements AutoCloseable {
	public static final int EOS_ACHIEVEMENTS_DEFINITION_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_DEFINITION_API_LATEST. */
	public int ApiVersion;
	/** Achievement ID that can be used to uniquely identify the achievement. */
	public String AchievementId;
	/** Text representing the Name to display in-game when achievement has been unlocked. */
	public String DisplayName;
	/** Text representing the description to display in-game when achievement has been unlocked. */
	public String Description;
	/** Text representing the name to display in-game when achievement is locked. */
	public String LockedDisplayName;
	/** Text representing the description of what needs to be done to trigger the unlock of this achievement. */
	public String LockedDescription;
	/** Text representing the description to display in-game when achievement is hidden. */
	public String HiddenDescription;
	/** Text representing the description of what happens when the achievement is unlocked. */
	public String CompletionDescription;
	/** Text representing the icon to display in-game when achievement is unlocked. */
	public String UnlockedIconId;
	/** Text representing the icon to display in-game when achievement is locked. */
	public String LockedIconId;
	/** {@link EOS_Bool#EOS_TRUE} if achievement is hidden, {@link EOS_Bool#EOS_FALSE} otherwise. */
	public EOS_Bool bIsHidden;
	/** The number of stat thresholds. */
	public int StatThresholdsCount;
	/** Array of stat thresholds that need to be satisfied to unlock the achievement. */
	public EOS_Achievements_StatThresholds.ByReference[] StatThresholds;

	public EOS_Achievements_Definition() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_DEFINITION_API_LATEST;
	}

	public EOS_Achievements_Definition(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOS_Achievements_Interface.releaseDefinition(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Achievements_Definition implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_Definition implements Structure.ByValue {
	}
}