package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.sanctions.EOS_Sanctions_PlayerSanction;
import host.anzo.eossdk.eos.sdk.sanctions.callbacks.EOS_Sanctions_OnQueryActivePlayerSanctionsCallback;
import host.anzo.eossdk.eos.sdk.sanctions.options.EOS_Sanctions_CopyPlayerSanctionByIndexOptions;
import host.anzo.eossdk.eos.sdk.sanctions.options.EOS_Sanctions_GetPlayerSanctionCountOptions;
import host.anzo.eossdk.eos.sdk.sanctions.options.EOS_Sanctions_QueryActivePlayerSanctionsOptions;

/**
 * The following EOS_Sanctions_* functions allow you to query sanctions info for specified players
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public class EOS_Sanctions_Interface extends PointerType {
	public EOS_Sanctions_Interface(Pointer address) {
		super(address);
	}

	public EOS_Sanctions_Interface() {
		super();
	}

	/**
	 * Start an asynchronous query to retrieve any active sanctions for a specified user.
	 * Call EOS_Sanctions_GetPlayerSanctionCount and EOS_Sanctions_CopyPlayerSanctionByIndex to retrieve the data.
	 *
	 * @param options Structure containing the input parameters
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the async operation completes, either successfully or in error
	 *
	 * @see #getPlayerSanctionCount(EOS_Sanctions_GetPlayerSanctionCountOptions)
	 * @see #copyPlayerSanctionByIndex(EOS_Sanctions_CopyPlayerSanctionByIndexOptions)
	 */
	public void queryActivePlayerSanctions(EOS_Sanctions_QueryActivePlayerSanctionsOptions options,
	                                       Pointer clientData,
	                                       EOS_Sanctions_OnQueryActivePlayerSanctionsCallback completionDelegate) {
		EOSLibrary.instance.EOS_Sanctions_QueryActivePlayerSanctions(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetch the number of player sanctions that have been retrieved for a given player.
	 * You must call QueryActivePlayerSanctions first to retrieve the data from the service backend.
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @see #queryActivePlayerSanctions(EOS_Sanctions_QueryActivePlayerSanctionsOptions, Pointer, EOS_Sanctions_OnQueryActivePlayerSanctionsCallback)
	 * @see #copyPlayerSanctionByIndex(EOS_Sanctions_CopyPlayerSanctionByIndexOptions)
	 *
	 * @return Number of available sanctions for this player.
	 */
	public int getPlayerSanctionCount(EOS_Sanctions_GetPlayerSanctionCountOptions options) {
		return EOSLibrary.instance.EOS_Sanctions_GetPlayerSanctionCount(this, options);
	}

	/**
	 * Copies an active player sanction.
	 * You must call QueryActivePlayerSanctions first to retrieve the data from the service backend.
	 * On success, EOS_Sanctions_PlayerSanction_Release must be called on OutSanction to free memory.
	 *
	 * @param options Structure containing the input parameters
	 * @return The player sanction data for the given index, if it exists and is valid
	 *
	 * @see #queryActivePlayerSanctions(EOS_Sanctions_QueryActivePlayerSanctionsOptions, Pointer, EOS_Sanctions_OnQueryActivePlayerSanctionsCallback)
	 * @see EOS_Sanctions_PlayerSanction#release()
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the player achievement is not found
	 */
	public EOS_Sanctions_PlayerSanction copyPlayerSanctionByIndex(EOS_Sanctions_CopyPlayerSanctionByIndexOptions options) throws EOSException {
		final EOS_Sanctions_PlayerSanction.ByReference outSanction = new EOS_Sanctions_PlayerSanction.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Sanctions_CopyPlayerSanctionByIndex(this, options, outSanction);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outSanction;
	}
}