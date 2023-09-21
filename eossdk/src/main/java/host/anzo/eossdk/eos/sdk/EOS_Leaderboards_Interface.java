package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_Definition;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_LeaderboardRecord;
import host.anzo.eossdk.eos.sdk.leaderboards.EOS_Leaderboards_LeaderboardUserScore;
import host.anzo.eossdk.eos.sdk.leaderboards.callbacks.EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallback;
import host.anzo.eossdk.eos.sdk.leaderboards.callbacks.EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallback;
import host.anzo.eossdk.eos.sdk.leaderboards.callbacks.EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallback;
import host.anzo.eossdk.eos.sdk.leaderboards.options.*;

/**
 * The following EOS_Leaderboards_* functions allow you to query existing leaderboard definitions that have been defined for your application.
 * You can retrieve a list of scores for the top users for each Leaderboard.
 * You can also query scores for one or more users.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public class EOS_Leaderboards_Interface extends PointerType {
	public EOS_Leaderboards_Interface(Pointer address) {
		super(address);
	}
	
	public EOS_Leaderboards_Interface() {
		super();
	}

	/**
	 * Query for a list of existing leaderboards definitions including their attributes.
	 *
	 * @param options Structure containing information about the application whose leaderboard definitions we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param completionDelegate This function is called when the query operation completes.
	 */
	public void queryLeaderboardDefinitions(EOS_Leaderboards_QueryLeaderboardDefinitionsOptions options,
	                                                         Pointer clientData,
	                                                         EOS_Leaderboards_OnQueryLeaderboardDefinitionsCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Leaderboards_QueryLeaderboardDefinitions(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of leaderboards definitions that are cached locally.
	 *
	 * @param options The Options associated with retrieving the leaderboard count.
	 *
	 * @see EOS_Leaderboards_Interface#copyLeaderboardDefinitionByIndex(EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions, EOS_Leaderboards_Definition[])
	 * @see EOS_Leaderboards_Interface#copyLeaderboardDefinitionByLeaderboardId(EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions, EOS_Leaderboards_Definition[])
	 *
	 * @return Number of leaderboards or 0 if there is an error
	 */
	public int getLeaderboardDefinitionCount(EOS_Leaderboards_GetLeaderboardDefinitionCountOptions options) {
		return EOSLibrary.instance.EOS_Leaderboards_GetLeaderboardDefinitionCount(this, options);
	}

	/**
	 * Fetches a leaderboard definition from the cache using an index.
	 *
	 * @param options Structure containing the index being accessed.
	 * @param outLeaderboardDefinition The leaderboard data for the given index, if it exists and is valid, use EOS_Leaderboards_Definition_Release when finished.
	 *
	 * @see EOS_Leaderboards_Definition#release()
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutLeaderboardDefinition<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the leaderboard is not found
	 */
	public EOS_EResult copyLeaderboardDefinitionByIndex(EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions options,
	                                                                     EOS_Leaderboards_Definition[] outLeaderboardDefinition) {
		return EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardDefinitionByIndex(this, options, outLeaderboardDefinition);
	}

	/**
	 * Fetches a leaderboard definition from the cache using a leaderboard ID.
	 *
	 * @param options Structure containing the leaderboard ID being accessed.
	 * @param outLeaderboardDefinition The leaderboard definition for the given leaderboard ID, if it exists and is valid, use EOS_Leaderboards_Definition_Release when finished.
	 *
	 * @see EOS_Leaderboards_Definition#release()
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutLeaderboardDefinition<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the leaderboard data is not found
	 */
	public EOS_EResult copyLeaderboardDefinitionByLeaderboardId(EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions options,
	                                                                             EOS_Leaderboards_Definition[] outLeaderboardDefinition) {
		return EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardId(this, options, outLeaderboardDefinition);
	}

	/**
	 * Retrieves top leaderboard records by rank in the leaderboard matching the given leaderboard ID.
	 *
	 * @param options Structure containing information about the leaderboard records we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param completionDelegate This function is called when the query operation completes.
	 */
	public void queryLeaderboardRanks(EOS_Leaderboards_QueryLeaderboardRanksOptions options,
	                                                   Pointer clientData,
	                                                   EOS_Leaderboards_OnQueryLeaderboardRanksCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Leaderboards_QueryLeaderboardRanks(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of leaderboard records that are cached locally.
	 *
	 * @param options The Options associated with retrieving the leaderboard record count.
	 *
	 * @see #copyLeaderboardRecordByIndex(EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions, EOS_Leaderboards_LeaderboardRecord[])
	 * @see #copyLeaderboardRecordByUserId(EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions, EOS_Leaderboards_LeaderboardRecord[])
	 *
	 * @return Number of leaderboard records or 0 if there is an error
	 */
	public int getLeaderboardRecordCount(EOS_Leaderboards_GetLeaderboardRecordCountOptions options) {
		return EOSLibrary.instance.EOS_Leaderboards_GetLeaderboardRecordCount(this, options);
	}

	/**
	 * Fetches a leaderboard record from a given index.
	 *
	 * @param options Structure containing the index being accessed.
	 * @param outLeaderboardRecord The leaderboard record for the given index, if it exists and is valid, use EOS_Leaderboards_LeaderboardRecord_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardRecord#release()
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the leaderboard record is available and passed out in outLeaderboardRecord<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the leaderboard is not found
	 */
	public EOS_EResult copyLeaderboardRecordByIndex(EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions options,
	                                                                 EOS_Leaderboards_LeaderboardRecord[] outLeaderboardRecord) {
		return EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardRecordByIndex(this, options, outLeaderboardRecord);
	}

	/**
	 * Fetches a leaderboard record from a given user ID.
	 *
	 * @param options Structure containing the user ID being accessed.
	 * @param outLeaderboardRecord The leaderboard record for the given user ID, if it exists and is valid, use EOS_Leaderboards_LeaderboardRecord_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardRecord#release()
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the leaderboard record is available and passed out in outLeaderboardRecord<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the leaderboard data is not found
	 */
	public EOS_EResult copyLeaderboardRecordByUserId(EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions options,
	                                                                  EOS_Leaderboards_LeaderboardRecord[] outLeaderboardRecord) {
		return EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardRecordByUserId(this, options, outLeaderboardRecord);
	}

	/**
	 * Query for a list of scores for a given list of users.
	 *
	 * @param options Structure containing information about the users whose scores we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param completionDelegate This function is called when the query operation completes.
	 */
	public void queryLeaderboardUserScores(EOS_Leaderboards_QueryLeaderboardUserScoresOptions options,
	                                                        Pointer clientData,
	                                                        EOS_Leaderboards_OnQueryLeaderboardUserScoresCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Leaderboards_QueryLeaderboardUserScores(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of leaderboard user scores that are cached locally.
	 *
	 * @param options The Options associated with retrieving the leaderboard user scores count.
	 *
	 * @see #copyLeaderboardUserScoreByIndex(EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions, EOS_Leaderboards_LeaderboardUserScore[])
	 * @see #copyLeaderboardUserScoreByUserId(EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions, EOS_Leaderboards_LeaderboardUserScore[])
	 *
	 * @return Number of leaderboard records or 0 if there is an error
	 *
	 */
	public int getLeaderboardUserScoreCount(EOS_Leaderboards_GetLeaderboardUserScoreCountOptions options) {
		return EOSLibrary.instance.EOS_Leaderboards_GetLeaderboardUserScoreCount(this, options);
	}

	/**
	 * Fetches leaderboard user score from a given index.
	 *
	 * @param options Structure containing the index being accessed.
	 * @param outLeaderboardUserScore The leaderboard user score for the given index, if it exists and is valid, use EOS_Leaderboards_LeaderboardUserScore_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardUserScore#release()
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the leaderboard scores are available and passed out in outLeaderboardUserScore<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the leaderboard user scores are not found
	 */
	public EOS_EResult copyLeaderboardUserScoreByIndex(EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions options,
	                                                                    EOS_Leaderboards_LeaderboardUserScore[] outLeaderboardUserScore) {
		return EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardUserScoreByIndex(this, options, outLeaderboardUserScore);
	}

	/**
	 * Fetches leaderboard user score from a given user ID.
	 *
	 * @param options Structure containing the user ID being accessed.
	 * @param outLeaderboardUserScore The leaderboard user score for the given user ID, if it exists and is valid, use EOS_Leaderboards_LeaderboardUserScore_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardUserScore#release()
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the leaderboard scores are available and passed out in outLeaderboardUserScore<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the leaderboard user scores are not found
	 */
	public EOS_EResult copyLeaderboardUserScoreByUserId(EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions options,
	                                                                     EOS_Leaderboards_LeaderboardUserScore[] outLeaderboardUserScore) {
		return EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardUserScoreByUserId(this, options, outLeaderboardUserScore);
	}
}