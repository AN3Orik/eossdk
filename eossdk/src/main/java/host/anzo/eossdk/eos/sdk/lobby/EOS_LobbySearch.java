package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.lobby.callbacks.EOS_LobbySearch_OnFindCallback;
import host.anzo.eossdk.eos.sdk.lobby.options.*;

/**
 * Class responsible for the creation, setup, and execution of a search query.
 * Search parameters are defined, the query is executed and the search results are returned within this object
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public class EOS_LobbySearch extends PointerType {
	public EOS_LobbySearch(Pointer address) {
		super(address);
	}

	public EOS_LobbySearch() {
		super();
	}

	/**
	 * Find lobbies matching the search criteria setup via this lobby search handle.
	 * When the operation completes, this handle will have the search results that can be parsed
	 *
	 * @param options Structure containing information about the search criteria to use
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the search operation completes, either successfully or in error
	 */
	public void find(EOS_LobbySearch_FindOptions options, Pointer clientData, EOS_LobbySearch_OnFindCallback completionDelegate) {
		EOSLibrary.instance.EOS_LobbySearch_Find(this, options, clientData, completionDelegate);
	}

	/**
	 * Set a lobby ID to find and will return at most one search result.  Setting TargetUserId or SearchParameters will result in EOS_LobbySearch_Find failing
	 *
	 * @param options A specific lobby ID for which to search
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this lobby ID was successful
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the lobby ID is invalid or null
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setLobbyId(EOS_LobbySearch_SetLobbyIdOptions options) {
		return EOSLibrary.instance.EOS_LobbySearch_SetLobbyId(this, options);
	}

	/**
	 * Set a target user ID to find.  Setting LobbyId or SearchParameters will result in EOS_LobbySearch_Find failing<br>
	 * <b>A search result will only be found if this user is in a public lobby</b>
	 *
	 * @param options a specific target user ID to find
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this target user ID was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the target user ID is invalid or null<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setTargetUserId(EOS_LobbySearch_SetTargetUserIdOptions options) {
		return EOSLibrary.instance.EOS_LobbySearch_SetTargetUserId(this, options);
	}

	/**
	 * Add a parameter to an array of search criteria combined via an implicit AND operator.  Setting LobbyId or TargetUserId will result in EOS_LobbySearch_Find failing
	 *
	 * @param options a search parameter and its comparison op
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this search parameter was successful
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the search criteria is invalid or null
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see host.anzo.eossdk.eos.sdk.lobby.EOS_Lobby_AttributeData
	 * @see host.anzo.eossdk.eos.sdk.common.enums.EOS_EComparisonOp
	 */
	public EOS_EResult setParameter(EOS_LobbySearch_SetParameterOptions options) {
		return EOSLibrary.instance.EOS_LobbySearch_SetParameter(this, options);
	}

	/**
	 * Remove a parameter from the array of search criteria.
	 *
	 * @param options a search parameter key name to remove
	 *
	 * @return {@link EOS_EResult#EOS_Success} if removing this search parameter was successful
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the search key is invalid or null
	 *           {@link EOS_EResult#EOS_NotFound} if the parameter was not a part of the search criteria
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult removeParameter(EOS_LobbySearch_RemoveParameterOptions options) {
		return EOSLibrary.instance.EOS_LobbySearch_RemoveParameter(this, options);
	}

	/**
	 * Set the maximum number of search results to return in the query, can't be more than EOS_LOBBY_MAX_SEARCH_RESULTS
	 *
	 * @param options maximum number of search results to return in the query
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting the max results was successful
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the number of results requested is invalid
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setMaxResults(EOS_LobbySearch_SetMaxResultsOptions options) {
		return EOSLibrary.instance.EOS_LobbySearch_SetMaxResults(this, options);
	}

	/**
	 * Get the number of search results found by the search parameters in this search
	 *
	 * @param options Options associated with the search count
	 *
	 * @return return the number of search results found by the query or 0 if search is not complete
	 */
	public int getSearchResultCount(EOS_LobbySearch_GetSearchResultCountOptions options) {
		return EOSLibrary.instance.EOS_LobbySearch_GetSearchResultCount(this, options);
	}

	/**
	 * EOS_LobbySearch_CopySearchResultByIndex is used to immediately retrieve a handle to the lobby information from a given search result.
	 * If the call returns an EOS_Success result, the out parameter, OutLobbyDetailsHandle, must be passed to EOS_LobbyDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outLobbyDetailsHandle out parameter used to receive the lobby details handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutLobbyDetailsHandle
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid index or a null pointer for the out parameter
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_LobbySearch_CopySearchResultByIndexOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_EResult copySearchResultByIndex(EOS_LobbySearch_CopySearchResultByIndexOptions options, EOS_LobbyDetails outLobbyDetailsHandle) {
		return EOSLibrary.instance.EOS_LobbySearch_CopySearchResultByIndex(this, options, outLobbyDetailsHandle);
	}
}