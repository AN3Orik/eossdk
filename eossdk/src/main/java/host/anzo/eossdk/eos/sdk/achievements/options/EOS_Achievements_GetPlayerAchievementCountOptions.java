package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_GetPlayerAchievementCount function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "UserId"})
public class EOS_Achievements_GetPlayerAchievementCountOptions extends Structure {
	/** The most recent version of the EOS_Achievements_GetPlayerAchievementCount API. */
	public static final int EOS_ACHIEVEMENTS_GETPLAYERACHIEVEMENTCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ACHIEVEMENTS_GETPLAYERACHIEVEMENTCOUNT_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID for the user whose achievement count is being retrieved. */
	public EOS_ProductUserId UserId;

	public EOS_Achievements_GetPlayerAchievementCountOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_GETPLAYERACHIEVEMENTCOUNT_API_LATEST;
	}

	public EOS_Achievements_GetPlayerAchievementCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_GetPlayerAchievementCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_GetPlayerAchievementCountOptions implements Structure.ByValue {
	}
}