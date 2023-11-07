package host.anzo.eossdk.eos.sdk.achievements.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Achievements_QueryDefinitions function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "EpicUserId_DEPRECATED", "HiddenAchievementIds_DEPRECATED", "HiddenAchievementsCount_DEPRECATED"})
public class EOS_Achievements_QueryDefinitionsOptions extends Structure {
	/** The most recent version of the EOS_Achievements_QueryDefinitions struct. */
	public static final int EOS_ACHIEVEMENTS_QUERYDEFINITIONS_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_ACHIEVEMENTS_QUERYDEFINITIONS_API_LATEST}. */
	public int ApiVersion;
	/**
	 * Product User ID for user who is querying definitions.
	 * The localized text returned will be based on the locale code of the given user if they have a linked Epic Account ID.
	 * The localized text returned can also be overridden using EOS_Platform_SetOverrideLocaleCode to override the locale.
	 * If the locale code is not overridden and LocalUserId is not valid, default text will be returned.
	 */
	public EOS_ProductUserId LocalUserId;
	/** Deprecated */
	public EOS_EpicAccountId EpicUserId_DEPRECATED;
	/** Deprecated */
	public PointerByReference HiddenAchievementIds_DEPRECATED;
	/** Deprecated */
	public int HiddenAchievementsCount_DEPRECATED;

	public EOS_Achievements_QueryDefinitionsOptions() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_QUERYDEFINITIONS_API_LATEST;
	}

	public EOS_Achievements_QueryDefinitionsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_QueryDefinitionsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_QueryDefinitionsOptions implements Structure.ByValue {
	}
}