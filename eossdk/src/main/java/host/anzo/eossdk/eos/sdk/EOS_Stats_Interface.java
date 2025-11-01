package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.stats.EOS_Stats_Stat;
import host.anzo.eossdk.eos.sdk.stats.callbacks.EOS_Stats_OnIngestStatCompleteCallback;
import host.anzo.eossdk.eos.sdk.stats.callbacks.EOS_Stats_OnQueryStatsCompleteCallback;
import host.anzo.eossdk.eos.sdk.stats.options.*;

/**
 * The Stats Interface manages user stats like number of items collected, fastest completion time for a level, number of wins/losses, number of times that a user has performed a certain action, and so on.
 * You can use stats to determine when to unlock achievements and how to use rank users in leaderboards.
 * All Stats Interface calls take a handle of type EOS_HStats as the first parameter.
 * This handle can be retrieved from an EOS_HPlatform handle by using the EOS_Platform_GetStatsInterface function.
 *
 * @see EOS_Platform_Interface#getStatsInterface()
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
public class EOS_Stats_Interface extends PointerType {
	public EOS_Stats_Interface(Pointer address) {
		super(address);
	}

	public EOS_Stats_Interface() {
		super();
	}

	/**
	 * Ingest a stat by the amount specified in Options.
	 * When the operation is complete and the delegate is triggered the stat will be uploaded to the backend to be processed.
	 * The stat may not be updated immediately and an achievement using the stat may take a while to be unlocked once the stat has been uploaded.
	 *
	 * @param options Structure containing information about the stat we're ingesting.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate.
	 * @param completionDelegate This function is called when the ingest stat operation completes.
	 */
	public void ingestStat(EOS_Stats_IngestStatOptions options, Pointer clientData, EOS_Stats_OnIngestStatCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Stats_IngestStat(this, options, clientData, completionDelegate);
	}

	/**
	 * Query for a list of stats for a specific player.
	 *
	 * @param options Structure containing information about the player whose stats we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the completionDelegate
	 * @param completionDelegate This function is called when the query player stats operation completes.
	 */
	public void queryStats(EOS_Stats_QueryStatsOptions options, Pointer clientData, EOS_Stats_OnQueryStatsCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Stats_QueryStats(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of stats that are cached locally.
	 *
	 * @param options The Options associated with retrieving the stat count
	 *
	 * @see #copyStatByIndex(EOS_Stats_CopyStatByIndexOptions)
	 * @see #copyStatByName(EOS_Stats_CopyStatByNameOptions)
	 *
	 * @return Number of stats or 0 if there is an error
	 */
	public int getStatsCount(EOS_Stats_GetStatCountOptions options) {
		return EOSLibrary.instance.EOS_Stats_GetStatsCount(this, options);
	}

	/**
	 * Fetches a stat from a given index. Use EOS_Stats_Stat_Release when finished with the data.
	 *
	 * @param options Structure containing the Product User ID and index being accessed
	 * @return The stat data for the given index, if it exists and is valid
	 *
	 * @see EOS_Stats_Stat#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the stat is not found
	 */
	public EOS_Stats_Stat copyStatByIndex(EOS_Stats_CopyStatByIndexOptions options) throws EOSException {
		final PointerByReference outStat = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Stats_CopyStatByIndex(this, options, outStat);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Stats_Stat stat = new EOS_Stats_Stat(outStat.getValue());
		stat.read();
		return stat;
	}

	/**
	 * Fetches a stat from cached stats by name. Use EOS_Stats_Stat_Release when finished with the data.
	 *
	 * @param options Structure containing the Product User ID and name being accessed
	 * @return The stat data for the given name, if it exists and is valid
	 *
	 * @see EOS_Stats_Stat#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the stat is not found
	 */
	public EOS_Stats_Stat copyStatByName(EOS_Stats_CopyStatByNameOptions options) throws EOSException {
		final PointerByReference outStat = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Stats_CopyStatByName(this, options, outStat);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Stats_Stat stat = new EOS_Stats_Stat(outStat.getValue());
		stat.read();
		return stat;
	}
}