package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
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
	 * @see #copyLeaderboardDefinitionByIndex(EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions)
	 * @see #copyLeaderboardDefinitionByLeaderboardId(EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions)
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
	 * @return The leaderboard data for the given index, if it exists and is valid, use EOS_Leaderboards_Definition_Release when finished.
	 * @see EOS_Leaderboards_Definition#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the leaderboard is not found
	 */
	public EOS_Leaderboards_Definition copyLeaderboardDefinitionByIndex(EOS_Leaderboards_CopyLeaderboardDefinitionByIndexOptions options) throws EOSException {
		final PointerByReference outLeaderboardDefinition = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardDefinitionByIndex(this, options, outLeaderboardDefinition);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Leaderboards_Definition definition = new EOS_Leaderboards_Definition(outLeaderboardDefinition.getValue());
		definition.read();
		return definition;
	}

	/**
	 * Fetches a leaderboard definition from the cache using a leaderboard ID.
	 *
	 * @param options Structure containing the leaderboard ID being accessed.
	 * @return The leaderboard definition for the given leaderboard ID, if it exists and is valid, use EOS_Leaderboards_Definition_Release when finished.
	 *
	 * @see EOS_Leaderboards_Definition#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the leaderboard data is not found
	 */
	public EOS_Leaderboards_Definition copyLeaderboardDefinitionByLeaderboardId(EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardIdOptions options) throws EOSException {
		final PointerByReference outLeaderboardDefinition = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardDefinitionByLeaderboardId(this, options, outLeaderboardDefinition);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Leaderboards_Definition definition = new EOS_Leaderboards_Definition(outLeaderboardDefinition.getValue());
		definition.read();
		return definition;
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
	 * @see #copyLeaderboardRecordByIndex(EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions)
	 * @see #copyLeaderboardRecordByUserId(EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions)
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
	 * @return The leaderboard record for the given index, if it exists and is valid, use EOS_Leaderboards_LeaderboardRecord_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardRecord#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the leaderboard is not found
	 */
	public EOS_Leaderboards_LeaderboardRecord copyLeaderboardRecordByIndex(EOS_Leaderboards_CopyLeaderboardRecordByIndexOptions options) throws EOSException {
		final PointerByReference outLeaderboardRecord = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardRecordByIndex(this, options, outLeaderboardRecord);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Leaderboards_LeaderboardRecord record = new EOS_Leaderboards_LeaderboardRecord(outLeaderboardRecord.getValue());
		record.read();
		return record;
	}

	/**
	 * Fetches a leaderboard record from a given user ID.
	 *
	 * @param options Structure containing the user ID being accessed.
	 * @return The leaderboard record for the given user ID, if it exists and is valid, use EOS_Leaderboards_LeaderboardRecord_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardRecord#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the leaderboard data is not found
	 */
	public EOS_Leaderboards_LeaderboardRecord copyLeaderboardRecordByUserId(EOS_Leaderboards_CopyLeaderboardRecordByUserIdOptions options) throws EOSException {
		final PointerByReference outLeaderboardRecord = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardRecordByUserId(this, options, outLeaderboardRecord);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Leaderboards_LeaderboardRecord record = new EOS_Leaderboards_LeaderboardRecord(outLeaderboardRecord.getValue());
		record.read();
		return record;
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
	 * @see #copyLeaderboardUserScoreByIndex(EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions)
	 * @see #copyLeaderboardUserScoreByUserId(EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions)
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
	 * @return The leaderboard user score for the given index, if it exists and is valid, use EOS_Leaderboards_LeaderboardUserScore_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardUserScore#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the leaderboard user scores are not found
	 */
	public EOS_Leaderboards_LeaderboardUserScore copyLeaderboardUserScoreByIndex(EOS_Leaderboards_CopyLeaderboardUserScoreByIndexOptions options) throws EOSException {
		final PointerByReference outLeaderboardUserScore = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardUserScoreByIndex(this, options, outLeaderboardUserScore);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Leaderboards_LeaderboardUserScore userScore = new EOS_Leaderboards_LeaderboardUserScore(outLeaderboardUserScore.getValue());
		userScore.read();
		return userScore;
	}

	/**
	 * Fetches leaderboard user score from a given user ID.
	 *
	 * @param options Structure containing the user ID being accessed.
	 * @return The leaderboard user score for the given user ID, if it exists and is valid, use EOS_Leaderboards_LeaderboardUserScore_Release when finished.
	 *
	 * @see EOS_Leaderboards_LeaderboardUserScore#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the leaderboard user scores are not found
	 */
	public EOS_Leaderboards_LeaderboardUserScore copyLeaderboardUserScoreByUserId(EOS_Leaderboards_CopyLeaderboardUserScoreByUserIdOptions options) throws EOSException {
		final PointerByReference outLeaderboardUserScore = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Leaderboards_CopyLeaderboardUserScoreByUserId(this, options, outLeaderboardUserScore);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Leaderboards_LeaderboardUserScore userScore = new EOS_Leaderboards_LeaderboardUserScore(outLeaderboardUserScore.getValue());
		userScore.read();
		return userScore;
	}
}