package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_GetUnlockedAchievementCount function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "UserId"})
public class EOS_Achievements_GetUnlockedAchievementCountOptions extends Structure {
	public static final int EOS_ACHIEVEMENTS_GETUNLOCKEDACHIEVEMENTCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_GETUNLOCKEDACHIEVEMENTCOUNT_API_LATEST. */
	public int ApiVersion;
	/** Product User ID for which to retrieve the unlocked achievement count */
	public EOS_ProductUserId UserId;

	public EOS_Achievements_GetUnlockedAchievementCountOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_GETUNLOCKEDACHIEVEMENTCOUNT_API_LATEST;
	}

	public EOS_Achievements_GetUnlockedAchievementCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_GetUnlockedAchievementCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_GetUnlockedAchievementCountOptions implements Structure.ByValue {
	}
}
