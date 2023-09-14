package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Achievements_AddNotifyAchievementsUnlockedV2Options extends Structure {
	/** The most recent version of the EOS_Achievements_AddNotifyAchievementsUnlockedV2 API. */
	public static final int EOS_ACHIEVEMENTS_ADDNOTIFYACHIEVEMENTSUNLOCKEDV2_API_LATEST = 2;

	/** API Version: Set this to EOS_ACHIEVEMENTS_ADDNOTIFYACHIEVEMENTSUNLOCKEDV2_API_LATEST. */
	public int ApiVersion;

	public EOS_Achievements_AddNotifyAchievementsUnlockedV2Options() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_ADDNOTIFYACHIEVEMENTSUNLOCKEDV2_API_LATEST;
	}

	public EOS_Achievements_AddNotifyAchievementsUnlockedV2Options(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_AddNotifyAchievementsUnlockedV2Options implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_AddNotifyAchievementsUnlockedV2Options implements Structure.ByValue {
	}
}