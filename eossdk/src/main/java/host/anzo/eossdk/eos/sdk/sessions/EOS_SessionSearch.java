package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Sessions_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EComparisonOp;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.sessions.callbacks.EOS_SessionSearch_OnFindCallback;
import host.anzo.eossdk.eos.sdk.sessions.options.*;

/**
 * Class responsible for the creation, setup, and execution of a search query.
 * Search parameters are defined, the query is executed and the search results are returned within this object
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
public class EOS_SessionSearch extends PointerType implements AutoCloseable {
	public EOS_SessionSearch(Pointer address) {
		super(address);
	}

	public EOS_SessionSearch() {
		super();
	}

	/**
	 * Set a session ID to find and will return at most one search result.  Setting TargetUserId or SearchParameters will result in EOS_SessionSearch_Find failing
	 *
	 * @param options A specific session ID for which to search
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this session ID was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the session ID is invalid or null<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setSessionId(EOS_SessionSearch_SetSessionIdOptions options) {
		return EOSLibrary.instance.EOS_SessionSearch_SetSessionId(this, options);
	}

	/**
	 * Set a target user ID to find and will return at most one search result.  Setting SessionId or SearchParameters will result in EOS_SessionSearch_Find failing<br>
	 * <b>A search result will only be found if this user is in a public session</b>
	 *
	 * @param options a specific target user ID to find
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this target user ID was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the target user ID is invalid or null<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setTargetUserId(EOS_SessionSearch_SetTargetUserIdOptions options) {
		return EOSLibrary.instance.EOS_SessionSearch_SetTargetUserId(this, options);
	}

	/**
	 * Add a parameter to an array of search criteria combined via an implicit AND operator.  Setting SessionId or TargetUserId will result in EOS_SessionSearch_Find failing
	 *
	 * @param options a search parameter and its comparison op
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting this search parameter was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the search criteria is invalid or null<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_Sessions_AttributeData
	 * @see EOS_EComparisonOp
	 */
	public EOS_EResult setParameter(EOS_SessionSearch_SetParameterOptions options) {
		return EOSLibrary.instance.EOS_SessionSearch_SetParameter(this, options);
	}

	/**
	 * Remove a parameter from the array of search criteria.
	 *
	 * @param options a search parameter key name to remove
	 *
	 * @return {@link EOS_EResult#EOS_Success} if removing this search parameter was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the search key is invalid or null<br>
	 *         {@link EOS_EResult#EOS_NotFound} if the parameter was not a part of the search criteria<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult removeParameter(EOS_SessionSearch_RemoveParameterOptions options) {
		return EOSLibrary.instance.EOS_SessionSearch_RemoveParameter(this, options);
	}

	/**
	 * Set the maximum number of search results to return in the query, can't be more than {@link EOS_SessionSearch_SetMaxResultsOptions#EOS_SESSIONS_MAX_SEARCH_RESULTS}
	 *
	 * @param options maximum number of search results to return in the query
	 *
	 * @return {@link EOS_EResult#EOS_Success} if setting the max results was successful<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if the number of results requested is invalid<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 */
	public EOS_EResult setMaxResults(EOS_SessionSearch_SetMaxResultsOptions options) {
		return EOSLibrary.instance.EOS_SessionSearch_SetMaxResults(this, options);
	}

	/**
	 * Find sessions matching the search criteria setup via this session search handle.
	 * When the operation completes, this handle will have the search results that can be parsed
	 *
	 * @param options Structure containing information about the search criteria to use
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate A callback that is fired when the search operation completes, either successfully or in error
	 */
	public void find(EOS_SessionSearch_FindOptions options, Pointer clientData, EOS_SessionSearch_OnFindCallback completionDelegate) {
		EOSLibrary.instance.EOS_SessionSearch_Find(this, options, clientData, completionDelegate);
	}

	/**
	 * Get the number of search results found by the search parameters in this search
	 *
	 * @param options Options associated with the search count
	 *
	 * @return return the number of search results found by the query or 0 if search is not complete
	 */
	public int getSearchResultCount(EOS_SessionSearch_GetSearchResultCountOptions options) {
		return EOSLibrary.instance.EOS_SessionSearch_GetSearchResultCount(this, options);
	}

	/**
	 * EOS_SessionSearch_CopySearchResultByIndex is used to immediately retrieve a handle to the session information from a given search result.
	 * If the call returns an EOS_Success result, the out parameter, OutSessionHandle, must be passed to EOS_SessionDetails_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outSessionHandle out parameter used to receive the session handle
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutSessionHandle<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass an invalid index or a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_SessionSearch_CopySearchResultByIndexOptions
	 * @see EOS_SessionDetails#release()
	 */
	public EOS_EResult copySearchResultByIndex(EOS_SessionSearch_CopySearchResultByIndexOptions options, EOS_SessionDetails outSessionHandle) {
		return EOSLibrary.instance.EOS_SessionSearch_CopySearchResultByIndex(this, options, outSessionHandle);
	}

	/**
	 * Release the memory associated with a session search. This must be called on data retrieved from EOS_Sessions_CreateSessionSearch.
	 *
	 * @see EOS_Sessions_Interface#createSessionSearch(EOS_Sessions_CreateSessionSearchOptions, EOS_SessionSearch)
	 */
	public void release() {
		EOSLibrary.instance.EOS_SessionSearch_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}