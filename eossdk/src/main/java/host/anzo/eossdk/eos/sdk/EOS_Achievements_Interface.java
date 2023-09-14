package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_Definition;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_DefinitionV2;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_PlayerAchievement;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_UnlockedAchievement;
import host.anzo.eossdk.eos.sdk.achievements.callbacks.*;
import host.anzo.eossdk.eos.sdk.achievements.options.*;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.platform.enums.EOS_Platform_Create_Flag;

/**
 * The following EOS_Achievements_* functions allow you to query existing achievement definitions that have been defined for your application.
 * You can also query achievement progress data for users.
 * In addition, you can also unlock one or more achievements directly.
 * You can also receive notifications when achievements are unlocked.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public class EOS_Achievements_Interface extends PointerType {
	public EOS_Achievements_Interface(Pointer address) {
		super(address);
	}
	public EOS_Achievements_Interface() {
		super();
	}

	/**
	 * Query for a list of definitions for all existing achievements, including localized text, icon IDs and whether an achievement is hidden.
	 * <p>
	 * <b>When the Social Overlay is enabled then this will be called automatically.  The Social Overlay is enabled by default (see {@link EOS_Platform_Create_Flag#EOS_PF_DISABLE_SOCIAL_OVERLAY}).</b>
	 *
	 * @param options Structure containing information about the application whose achievement definitions we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate This function is called when the query definitions operation completes.
	 */
	public void queryDefinitions(EOS_Achievements_QueryDefinitionsOptions options,
	                             Pointer clientData,
	                             EOS_Achievements_OnQueryDefinitionsCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Achievements_QueryDefinitions(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of achievement definitions that are cached locally.
	 *
	 * @param options The Options associated with retrieving the achievement definition count
	 *
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionByIndex(EOS_Achievements_CopyAchievementDefinitionByIndexOptions, EOS_Achievements_Definition[])
	 *
	 * @return Number of achievement definitions or 0 if there is an error
	 */
	public int getAchievementDefinitionCount(EOS_Achievements_GetAchievementDefinitionCountOptions options) {
		return EOSLibrary.instance.EOS_Achievements_GetAchievementDefinitionCount(this, options);
	}

	/**
	 * Fetches an achievement definition from a given index.
	 *
	 * @param options Structure containing the index being accessed
	 * @param outDefinition The achievement definition for the given index, if it exists and is valid, use EOS_Achievements_Definition_Release when finished
	 *
	 * @see EOS_Achievements_Interface#releaseDefinitionV2(EOS_Achievements_DefinitionV2)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in outDefinition<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the achievement definition is not found<br>
	 *         {@link EOS_EResult#EOS_Invalid_ProductUserID} if any of the userid options are incorrect
	 */
	public EOS_EResult copyAchievementDefinitionV2ByIndex(EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions options,
	                                                      EOS_Achievements_DefinitionV2[] outDefinition) {
		return EOSLibrary.instance.EOS_Achievements_CopyAchievementDefinitionV2ByIndex(this, options, outDefinition);
	}

	/**
	 * Fetches an achievement definition from a given achievement ID.
	 *
	 * @param options Structure containing the achievement ID being accessed
	 * @param outDefinition The achievement definition for the given achievement ID, if it exists and is valid, use EOS_Achievements_Definition_Release when finished
	 *
	 * @see EOS_Achievements_Interface#releaseDefinitionV2(EOS_Achievements_DefinitionV2)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in outDefinition<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the achievement definition is not found<br>
	 *         {@link EOS_EResult#EOS_Invalid_ProductUserID} if any of the userid options are incorrect
	 */
	public EOS_EResult copyAchievementDefinitionV2ByAchievementId(EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions options,
	                                                              EOS_Achievements_DefinitionV2[] outDefinition) {
		return EOSLibrary.instance.EOS_Achievements_CopyAchievementDefinitionV2ByAchievementId(this, options, outDefinition);
	}

	/**
	 * Query for a list of achievements for a specific player, including progress towards completion for each achievement.<br>
	 * <b> When the Social Overlay is enabled then this will be called automatically.  The Social Overlay is enabled by default (seeEOS_Platform_Create_Flag#EOS_PF_DISABLE_SOCIAL_OVERLAY).</b>
	 *
	 * @param options Structure containing information about the player whose achievements we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate This function is called when the query player achievements operation completes.
	 * @see EOS_Platform_Create_Flag#EOS_PF_DISABLE_SOCIAL_OVERLAY
	 */
	public void queryPlayerAchievements(EOS_Achievements_QueryPlayerAchievementsOptions options,
	                                                     Pointer clientData,
	                                                     EOS_Achievements_OnQueryPlayerAchievementsCompleteCallback completionDelegate){
		EOSLibrary.instance.EOS_Achievements_QueryPlayerAchievements(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of player achievements that are cached locally.
	 *
	 * @param options The Options associated with retrieving the player achievement count
	 *
	 * @see EOS_Achievements_Interface#copyPlayerAchievementByIndex(EOS_Achievements_CopyPlayerAchievementByIndexOptions, EOS_Achievements_PlayerAchievement[])
	 *
	 * @return Number of player achievements or 0 if there is an error
	 */
	public int getPlayerAchievementCount(EOS_Achievements_GetPlayerAchievementCountOptions options) {
		return EOSLibrary.instance.EOS_Achievements_GetPlayerAchievementCount(this, options);
	}

	/**
	 * Fetches a player achievement from a given index.
	 *
	 * @param options Structure containing the Product User ID and index being accessed
	 * @param outAchievement The player achievement data for the given index, if it exists and is valid, use EOS_Achievements_PlayerAchievement_Release when finished
	 *
	 * @see EOS_Achievements_Interface#releasePlayerAchievement(EOS_Achievements_PlayerAchievement)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAchievement<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the player achievement is not found<br>
	 *         {@link EOS_EResult#EOS_Invalid_ProductUserID} if you pass an invalid user ID
	 */
	public EOS_EResult copyPlayerAchievementByIndex(EOS_Achievements_CopyPlayerAchievementByIndexOptions options, EOS_Achievements_PlayerAchievement[] outAchievement) {
		return EOSLibrary.instance.EOS_Achievements_CopyPlayerAchievementByIndex(this, options, outAchievement);
	}

	/**
	 * Fetches a player achievement from a given achievement ID.
	 *
	 * @param options Structure containing the Product User ID and achievement ID being accessed
	 * @param outAchievement The player achievement data for the given achievement ID, if it exists and is valid, use EOS_Achievements_PlayerAchievement_Release when finished
	 *
	 * @see EOS_Achievements_Interface#releasePlayerAchievement(EOS_Achievements_PlayerAchievement)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAchievement<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the player achievement is not found<br>
	 *         {@link EOS_EResult#EOS_Invalid_ProductUserID} if you pass an invalid user ID
	 */
	public EOS_EResult copyPlayerAchievementByAchievementId(EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions options, EOS_Achievements_PlayerAchievement[] outAchievement) {
		return EOSLibrary.instance.EOS_Achievements_CopyPlayerAchievementByAchievementId(this, options, outAchievement);
	}

	/**
	 * Unlocks a number of achievements for a specific player.
	 *
	 * @param options Structure containing information about the achievements and the player whose achievements we're unlocking.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate This function is called when the unlock achievements operation completes.
	 */
	public void unlockAchievements(EOS_Achievements_UnlockAchievementsOptions options, Pointer clientData, EOS_Achievements_OnUnlockAchievementsCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Achievements_UnlockAchievements(this, options, clientData, completionDelegate);
	}

	/**
	 * Register to receive achievement unlocked notifications.<br>
	 * <b>Must call EOS_Achievements_RemoveNotifyAchievementsUnlocked to remove the notification</b>
	 *
	 * @see EOS_Achievements_Interface#removeNotifyAchievementsUnlocked(EOS_NotificationId)
	 *
	 * @param options Structure containing information about the achievement unlocked notification
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param notificationFn A callback that is fired when an achievement unlocked notification for a user has been received
	 *
	 * @return handle representing the registered callback
	 */
	public EOS_NotificationId addNotifyAchievementsUnlockedV2(EOS_Achievements_AddNotifyAchievementsUnlockedV2Options options,
	                                                                           Pointer clientData,
	                                                                           EOS_Achievements_OnAchievementsUnlockedCallbackV2 notificationFn) {
		return EOSLibrary.instance.EOS_Achievements_AddNotifyAchievementsUnlockedV2(this, options, clientData, notificationFn);
	}

	/**
	 * Unregister from receiving achievement unlocked notifications.
	 *
	 * @see EOS_Achievements_Interface#addNotifyAchievementsUnlocked(EOS_Achievements_AddNotifyAchievementsUnlockedOptions, Pointer, EOS_Achievements_OnAchievementsUnlockedCallback)
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyAchievementsUnlocked(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Achievements_RemoveNotifyAchievementsUnlocked(this, inId);
	}

	/**
	 * Fetches an achievement definition from a given index.
	 * @deprecated Use {@link #copyAchievementDefinitionV2ByIndex(EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions, EOS_Achievements_DefinitionV2[])} instead.
	 * @param options Structure containing the index being accessed
	 * @param outDefinition The achievement definition for the given index, if it exists and is valid, use EOS_Achievements_Definition_Release when finished
	 *
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionV2ByIndex(EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions, EOS_Achievements_DefinitionV2[])
	 * @see EOS_Achievements_Interface#releaseDefinition(EOS_Achievements_Definition)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in outDefinition<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the achievement definition is not found
	 */
	@Deprecated
	public EOS_EResult copyAchievementDefinitionByIndex(EOS_Achievements_CopyAchievementDefinitionByIndexOptions options,
	                                                                     EOS_Achievements_Definition[] outDefinition) {
		return EOSLibrary.instance.EOS_Achievements_CopyAchievementDefinitionByIndex(this, options, outDefinition);
	}

	/**
	 * Fetches an achievement definition from a given achievement ID.
	 * @deprecated Use {@link #copyAchievementDefinitionV2ByAchievementId(EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions, EOS_Achievements_DefinitionV2[])} instead.
	 * @param options Structure containing the achievement ID being accessed
	 * @param outDefinition The achievement definition for the given achievement ID, if it exists and is valid, use EOS_Achievements_Definition_Release when finished
	 *
	 * @see EOS_Achievements_Interface#releaseDefinition(EOS_Achievements_Definition)
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionV2ByAchievementId(EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions, EOS_Achievements_DefinitionV2[])
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in outDefinition<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the achievement definition is not found
	 */
	@Deprecated
	public EOS_EResult copyAchievementDefinitionByAchievementId(EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions options,
	                                                                             EOS_Achievements_Definition[] outDefinition) {
		return EOSLibrary.instance.EOS_Achievements_CopyAchievementDefinitionByAchievementId(this, options, outDefinition);
	}

	/**
	 * Fetch the number of unlocked achievements that are cached locally.
	 * @deprecated Use {@link #getPlayerAchievementCount(EOS_Achievements_GetPlayerAchievementCountOptions)},
	 * {@link #copyPlayerAchievementByIndex(EOS_Achievements_CopyPlayerAchievementByIndexOptions, EOS_Achievements_PlayerAchievement[])}
	 * and filter for unlocked instead.
	 * @param options The Options associated with retrieving the unlocked achievement count
	 *
	 * @see EOS_Achievements_Interface#copyUnlockedAchievementByIndex(EOS_Achievements_CopyUnlockedAchievementByIndexOptions, EOS_Achievements_UnlockedAchievement[])
	 *
	 * @return Number of unlocked achievements or 0 if there is an error
	 */
	@Deprecated
	public int getUnlockedAchievementCount(EOS_Achievements_GetUnlockedAchievementCountOptions options) {
		return EOSLibrary.instance.EOS_Achievements_GetUnlockedAchievementCount(this, options);
	}

	/**
	 * Fetches an unlocked achievement from a given index.
	 * @deprecated Use {@link #copyPlayerAchievementByAchievementId(EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions, EOS_Achievements_PlayerAchievement[])} instead.
	 * @param options Structure containing the Product User ID and index being accessed
	 * @param outAchievement The unlocked achievement data for the given index, if it exists and is valid, use EOS_Achievements_UnlockedAchievement_Release when finished
	 *
	 * @see EOS_Achievements_Interface#releaseUnlockedAchievement(EOS_Achievements_UnlockedAchievement)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAchievement<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the unlocked achievement is not found
	 */
	@Deprecated
	public EOS_EResult copyUnlockedAchievementByIndex(EOS_Achievements_CopyUnlockedAchievementByIndexOptions options,
	                                                                   EOS_Achievements_UnlockedAchievement[] outAchievement) {
		return EOSLibrary.instance.EOS_Achievements_CopyUnlockedAchievementByIndex(this, options, outAchievement);
	}

	/**
	 * Fetches an unlocked achievement from a given achievement ID.
	 * @deprecated Use {@link #copyPlayerAchievementByAchievementId(EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions, EOS_Achievements_PlayerAchievement[])} instead.
	 * @param options Structure containing the Product User ID and achievement ID being accessed
	 * @param outAchievement The unlocked achievement data for the given achievement ID, if it exists and is valid, use EOS_Achievements_UnlockedAchievement_Release when finished
	 *
	 * @see EOS_Achievements_Interface#releaseUnlockedAchievement(EOS_Achievements_UnlockedAchievement)
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAchievement<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the unlocked achievement is not found
	 */
	@Deprecated
	public EOS_EResult copyUnlockedAchievementByAchievementId(EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions options, EOS_Achievements_UnlockedAchievement[] outAchievement) {
		return EOSLibrary.instance.EOS_Achievements_CopyUnlockedAchievementByAchievementId(this, options, outAchievement);
	}

	/**
	 * Register to receive achievement unlocked notifications.
	 * <p>
	 * <b>Must call {@link #removeNotifyAchievementsUnlocked(EOS_NotificationId)} to remove the notification</b>
	 * @deprecated Use {@link #addNotifyAchievementsUnlockedV2(EOS_Achievements_AddNotifyAchievementsUnlockedV2Options, Pointer, EOS_Achievements_OnAchievementsUnlockedCallbackV2)} instead.
	 * @see EOS_Achievements_Interface#removeNotifyAchievementsUnlocked(EOS_NotificationId)
	 *
	 * @param options Structure containing information about the achievement unlocked notification
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param notificationFn A callback that is fired when an achievement unlocked notification for a user has been received
	 *
	 * @return handle representing the registered callback
	 */
	@Deprecated
	public EOS_NotificationId addNotifyAchievementsUnlocked(EOS_Achievements_AddNotifyAchievementsUnlockedOptions options,
	                                                                         Pointer clientData,
	                                                                         EOS_Achievements_OnAchievementsUnlockedCallback notificationFn) {
		return EOSLibrary.instance.EOS_Achievements_AddNotifyAchievementsUnlocked(this, options, clientData, notificationFn);
	}

	/**
	 * Release the memory associated with achievement definitions. This must be called on data retrieved from
	 * EOS_Achievements_CopyAchievementDefinitionByIndex or EOS_Achievements_CopyAchievementDefinitionByAchievementId.
	 *
	 * @param achievementDefinition - The achievement definition to release.
	 *
	 * @see EOS_Achievements_Definition
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionByIndex(EOS_Achievements_CopyAchievementDefinitionByIndexOptions, EOS_Achievements_Definition[])
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionByAchievementId(EOS_Achievements_CopyAchievementDefinitionByAchievementIdOptions, EOS_Achievements_Definition[])
	 */
	public static void releaseDefinition(EOS_Achievements_Definition achievementDefinition) {
		EOSLibrary.instance.EOS_Achievements_Definition_Release(achievementDefinition);
	}

	/**
	 * Release the memory associated with EOS_Achievements_DefinitionV2. This must be called on data retrieved from
	 * EOS_Achievements_CopyAchievementDefinitionV2ByIndex or EOS_Achievements_CopyAchievementDefinitionV2ByAchievementId.
	 *
	 * @param achievementDefinition - The achievement definition to release.
	 *
	 * @see EOS_Achievements_DefinitionV2
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionV2ByIndex(EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions, EOS_Achievements_DefinitionV2[])
	 * @see EOS_Achievements_Interface#copyAchievementDefinitionV2ByAchievementId(EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions, EOS_Achievements_DefinitionV2[])
	 */
	public static void releaseDefinitionV2(EOS_Achievements_DefinitionV2 achievementDefinition) {
		EOSLibrary.instance.EOS_Achievements_DefinitionV2_Release(achievementDefinition);
	}

	/**
	 * Release the memory associated with an unlocked achievement. This must be called on data retrieved from
	 * EOS_Achievements_CopyUnlockedAchievementByIndex or EOS_Achievements_CopyUnlockedAchievementByAchievementId.
	 *
	 * @param achievement - The unlocked achievement data to release.
	 *
	 * @see EOS_Achievements_UnlockedAchievement
	 * @see EOS_Achievements_Interface#copyUnlockedAchievementByIndex(EOS_Achievements_CopyUnlockedAchievementByIndexOptions, EOS_Achievements_UnlockedAchievement[])
	 * @see EOS_Achievements_Interface#copyUnlockedAchievementByAchievementId(EOS_Achievements_CopyUnlockedAchievementByAchievementIdOptions, EOS_Achievements_UnlockedAchievement[])
	 */
	public static void releaseUnlockedAchievement(EOS_Achievements_UnlockedAchievement achievement) {
		EOSLibrary.instance.EOS_Achievements_UnlockedAchievement_Release(achievement);
	}

	/**
	 * Release the memory associated with a player achievement. This must be called on data retrieved from
	 * EOS_Achievements_CopyPlayerAchievementByIndex or EOS_Achievements_CopyPlayerAchievementByAchievementId.
	 *
	 * @param achievement - The achievement data to release.
	 *
	 * @see EOS_Achievements_PlayerAchievement
	 * @see EOS_Achievements_Interface#copyPlayerAchievementByIndex(EOS_Achievements_CopyPlayerAchievementByIndexOptions, EOS_Achievements_PlayerAchievement[])
	 * @see EOS_Achievements_Interface#copyPlayerAchievementByAchievementId(EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions, EOS_Achievements_PlayerAchievement[])
	 */
	public static void releasePlayerAchievement(EOS_Achievements_PlayerAchievement achievement) {
		EOSLibrary.instance.EOS_Achievements_PlayerAchievement_Release(achievement);
	}
}