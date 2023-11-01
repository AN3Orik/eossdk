package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidProductUserIDException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_DefinitionV2;
import host.anzo.eossdk.eos.sdk.achievements.EOS_Achievements_PlayerAchievement;
import host.anzo.eossdk.eos.sdk.achievements.callbacks.EOS_Achievements_OnAchievementsUnlockedCallbackV2;
import host.anzo.eossdk.eos.sdk.achievements.callbacks.EOS_Achievements_OnQueryDefinitionsCompleteCallback;
import host.anzo.eossdk.eos.sdk.achievements.callbacks.EOS_Achievements_OnQueryPlayerAchievementsCompleteCallback;
import host.anzo.eossdk.eos.sdk.achievements.callbacks.EOS_Achievements_OnUnlockAchievementsCompleteCallback;
import host.anzo.eossdk.eos.sdk.achievements.options.*;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.platform.enums.EOS_Platform_Create_Flag;
import host.anzo.eossdk.eos.utils.CallbackUtils;

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
	 * @see #copyAchievementDefinitionV2ByIndex(EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions)
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
	 * @return The achievement definition for the given index, if it exists and is valid, use EOS_Achievements_Definition_Release when finished
	 *
	 * @see EOS_Achievements_DefinitionV2#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the achievement definition is not found
	 * @throws EOSInvalidProductUserIDException if any of the userid options are incorrect
	 */
	public EOS_Achievements_DefinitionV2 copyAchievementDefinitionV2ByIndex(EOS_Achievements_CopyAchievementDefinitionV2ByIndexOptions options) throws EOSException {
		final EOS_Achievements_DefinitionV2.ByReference achievementsDefinitionReference = new EOS_Achievements_DefinitionV2.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Achievements_CopyAchievementDefinitionV2ByIndex(this, options, achievementsDefinitionReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return achievementsDefinitionReference;
	}

	/**
	 * Fetches an achievement definition from a given achievement ID.
	 *
	 * @param options Structure containing the achievement ID being accessed
	 * @return The achievement definition for the given achievement ID, if it exists and is valid, use EOS_Achievements_Definition_Release when finished
	 *
	 * @see EOS_Achievements_DefinitionV2#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the achievement definition is not found
	 * @throws EOSInvalidProductUserIDException if any of the userid options are incorrect
	 */
	public EOS_Achievements_DefinitionV2 copyAchievementDefinitionV2ByAchievementId(EOS_Achievements_CopyAchievementDefinitionV2ByAchievementIdOptions options) throws EOSException {
		final EOS_Achievements_DefinitionV2.ByReference achievementsDefinitionReference = new EOS_Achievements_DefinitionV2.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Achievements_CopyAchievementDefinitionV2ByAchievementId(this, options, achievementsDefinitionReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return achievementsDefinitionReference;
	}

	/**
	 * Query for a list of achievements for a specific player, including progress towards completion for each achievement.<br>
	 * <b> When the Social Overlay is enabled then this will be called automatically.  The Social Overlay is enabled by default (see EOS_Platform_Create_Flag#EOS_PF_DISABLE_SOCIAL_OVERLAY).</b>
	 *
	 * @param options Structure containing information about the player whose achievements we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate This function is called when the query player achievements operation completes.
	 * @see EOS_Platform_Create_Flag#EOS_PF_DISABLE_SOCIAL_OVERLAY
	 */
	public void queryPlayerAchievements(EOS_Achievements_QueryPlayerAchievementsOptions options,
	                                    Pointer clientData,
	                                    EOS_Achievements_OnQueryPlayerAchievementsCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Achievements_QueryPlayerAchievements(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of player achievements that are cached locally.
	 *
	 * @param options The Options associated with retrieving the player achievement count
	 *
	 * @see #copyPlayerAchievementByIndex(EOS_Achievements_CopyPlayerAchievementByIndexOptions)
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
	 * @return The player achievement data for the given index, if it exists and is valid, use EOS_Achievements_PlayerAchievement_Release when finished
	 *
	 * @see EOS_Achievements_PlayerAchievement#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the player achievement is not found
	 * @throws EOSInvalidProductUserIDException if you pass an invalid user ID
	 */
	public EOS_Achievements_PlayerAchievement copyPlayerAchievementByIndex(EOS_Achievements_CopyPlayerAchievementByIndexOptions options) throws EOSException {
		final EOS_Achievements_PlayerAchievement.ByReference playerAchievementReference = new EOS_Achievements_PlayerAchievement.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Achievements_CopyPlayerAchievementByIndex(this, options, playerAchievementReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return playerAchievementReference;
	}

	/**
	 * Fetches a player achievement from a given achievement ID.
	 *
	 * @param options Structure containing the Product User ID and achievement ID being accessed
	 * @return The player achievement data for the given achievement ID, if it exists and is valid, use EOS_Achievements_PlayerAchievement_Release when finished
	 *
	 * @see EOS_Achievements_PlayerAchievement#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the player achievement is not found
	 * @throws EOSInvalidProductUserIDException if you pass an invalid user ID
	 */
	public EOS_Achievements_PlayerAchievement copyPlayerAchievementByAchievementId(EOS_Achievements_CopyPlayerAchievementByAchievementIdOptions options) throws EOSException {
		final EOS_Achievements_PlayerAchievement.ByReference playerAchievementReference = new EOS_Achievements_PlayerAchievement.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Achievements_CopyPlayerAchievementByAchievementId(this, options, playerAchievementReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return playerAchievementReference;
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
	 * @see #removeNotifyAchievementsUnlocked(EOS_NotificationId)
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
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_Achievements_AddNotifyAchievementsUnlockedV2(this, options, clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Unregister from receiving achievement unlocked notifications.
	 *
	 * @see #addNotifyAchievementsUnlockedV2(EOS_Achievements_AddNotifyAchievementsUnlockedV2Options, Pointer, EOS_Achievements_OnAchievementsUnlockedCallbackV2)
	 *
	 * @param inId Handle representing the registered callback
	 */
	public void removeNotifyAchievementsUnlocked(EOS_NotificationId inId) {
		EOSLibrary.instance.EOS_Achievements_RemoveNotifyAchievementsUnlocked(this, inId);
		CallbackUtils.unregisterNotificationCallback(inId);
	}
}