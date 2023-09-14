package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.lobby.options.*;

/**
 * A "read only" representation of an existing lobby that games interact with externally.
 * Both the lobby and lobby search interfaces interface use this common class for lobby management and search results
 *
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public class EOS_LobbyDetails extends PointerType implements AutoCloseable {
	public EOS_LobbyDetails(Pointer address) {
		super(address);
	}
	public EOS_LobbyDetails() {
		super();
	}

	/**
	 * Get the product user ID of the current owner for a given lobby
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @return the product user ID for the lobby owner or null if the input parameters are invalid
	 */
	public EOS_ProductUserId getLobbyOwner(EOS_LobbyDetails_GetLobbyOwnerOptions options) {
		return EOSLibrary.instance.EOS_LobbyDetails_GetLobbyOwner(this, options);
	}

	/**
	 * EOS_LobbyDetails_CopyInfo is used to immediately retrieve a copy of lobby information from a given source such as a existing lobby or a search result.
	 * If the call returns an EOS_Success result, the out parameter, OutLobbyDetailsInfo, must be passed to EOS_LobbyDetails_Info_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outLobbyDetailsInfo Out parameter used to receive the EOS_LobbyDetails_Info structure.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutLobbyDetailsInfo<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_LobbyDetails_Info
	 * @see EOS_LobbyDetails_CopyInfoOptions
	 * @see EOS_LobbyDetails#releaseLobbyDetailsInfo(EOS_LobbyDetails_Info)
	 */
	public EOS_EResult copyInfo(EOS_LobbyDetails_CopyInfoOptions options, EOS_LobbyDetails_Info[] outLobbyDetailsInfo) {
		return EOSLibrary.instance.EOS_LobbyDetails_CopyInfo(this, options, outLobbyDetailsInfo);
	}

	/**
	 * Get the number of attributes associated with this lobby
	 *
	 * @param options the Options associated with retrieving the attribute count
	 *
	 * @return number of attributes on the lobby or 0 if there is an error
	 */
	public int getAttributeCount(EOS_LobbyDetails_GetAttributeCountOptions options) {
		return EOSLibrary.instance.EOS_LobbyDetails_GetAttributeCount(this, options);
	}

	/**
	 * EOS_LobbyDetails_CopyAttributeByIndex is used to immediately retrieve a copy of a lobby attribute from a given source such as a existing lobby or a search result.
	 * If the call returns an EOS_Success result, the out parameter, OutAttribute, must be passed to EOS_Lobby_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outAttribute Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAttribute<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyAttributeByIndexOptions
	 * @see EOS_LobbyDetails#releaseLobbyAttribute(EOS_Lobby_Attribute)
	 */
	public EOS_EResult copyAttributeByIndex(EOS_LobbyDetails_CopyAttributeByIndexOptions options, EOS_Lobby_Attribute[] outAttribute) {
		return EOSLibrary.instance.EOS_LobbyDetails_CopyAttributeByIndex(this, options, outAttribute);
	}

	/**
	 * EOS_LobbyDetails_CopyAttributeByKey is used to immediately retrieve a copy of a lobby attribute from a given source such as a existing lobby or a search result.
	 * If the call returns an EOS_Success result, the out parameter, OutAttribute, must be passed to EOS_Lobby_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outAttribute Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAttribute<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyAttributeByKeyOptions
	 * @see EOS_LobbyDetails#releaseLobbyAttribute(EOS_Lobby_Attribute)
	 */
	public EOS_EResult copyAttributeByKey(EOS_LobbyDetails_CopyAttributeByKeyOptions options, EOS_Lobby_Attribute[] outAttribute) {
		return EOSLibrary.instance.EOS_LobbyDetails_CopyAttributeByKey(this, options, outAttribute);
	}

	/**
	 * Get the number of members associated with this lobby
	 *
	 * @param options the Options associated with retrieving the member count
	 *
	 * @return number of members in the existing lobby or 0 if there is an error
	 */
	public int getMemberCount(EOS_LobbyDetails_GetMemberCountOptions options) {
		return EOSLibrary.instance.EOS_LobbyDetails_GetMemberCount(this,  options);
	}

	/**
	 * EOS_LobbyDetails_GetMemberByIndex is used to immediately retrieve individual members registered with a lobby.
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @return the product user ID for the registered member at a given index or null if that index is invalid
	 *
	 * @see EOS_LobbyDetails#getMemberCount(EOS_LobbyDetails_GetMemberCountOptions)
	 * @see EOS_LobbyDetails_GetMemberByIndexOptions
	 */
	public EOS_ProductUserId getMemberByIndex(EOS_LobbyDetails_GetMemberByIndexOptions options) {
		return EOSLibrary.instance.EOS_LobbyDetails_GetMemberByIndex(this, options);
	}

	/**
	 * EOS_LobbyDetails_GetMemberAttributeCount is used to immediately retrieve the attribute count for members in a lobby.
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @return the number of attributes associated with a given lobby member or 0 if that member is invalid
	 *
	 * @see EOS_LobbyDetails#getMemberCount(EOS_LobbyDetails_GetMemberCountOptions)
	 * @see EOS_LobbyDetails_GetMemberAttributeCountOptions
	 */
	public int getMemberAttributeCount(EOS_LobbyDetails_GetMemberAttributeCountOptions options) {
		return EOSLibrary.instance.EOS_LobbyDetails_GetMemberAttributeCount(this, options);
	}

	/**
	 * EOS_LobbyDetails_CopyMemberAttributeByIndex is used to immediately retrieve a copy of a lobby member attribute from an existing lobby.
	 * If the call returns an EOS_Success result, the out parameter, OutAttribute, must be passed to EOS_Lobby_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outAttribute Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAttribute<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyMemberAttributeByIndexOptions
	 * @see EOS_LobbyDetails#releaseLobbyAttribute(EOS_Lobby_Attribute)
	 */
	public EOS_EResult copyMemberAttributeByIndex(EOS_LobbyDetails_CopyMemberAttributeByIndexOptions options, EOS_Lobby_Attribute[] outAttribute) {
		return EOSLibrary.instance.EOS_LobbyDetails_CopyMemberAttributeByIndex(this, options, outAttribute);
	}

	/**
	 * EOS_LobbyDetails_CopyMemberAttributeByKey is used to immediately retrieve a copy of a lobby member attribute from an existing lobby.
	 * If the call returns an EOS_Success result, the out parameter, OutAttribute, must be passed to EOS_Lobby_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @param outAttribute Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @return {@link EOS_EResult#EOS_Success} if the information is available and passed out in OutAttribute<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} if you pass a null pointer for the out parameter<br>
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyMemberAttributeByKeyOptions
	 * @see EOS_LobbyDetails#releaseLobbyAttribute(EOS_Lobby_Attribute)
	 */
	public EOS_EResult copyMemberAttributeByKey(EOS_LobbyDetails_CopyMemberAttributeByKeyOptions options, EOS_Lobby_Attribute[] outAttribute) {
		return EOSLibrary.instance.EOS_LobbyDetails_CopyMemberAttributeByKey(this, options, outAttribute);
	}

	public static void releaseLobbyDetailsInfo(EOS_LobbyDetails_Info lobbyDetailsInfo) {
		EOSLibrary.instance.EOS_LobbyDetails_Info_Release(lobbyDetailsInfo);
	}

	public static void releaseLobbyAttribute(EOS_Lobby_Attribute lobbyAttribute) {
		EOSLibrary.instance.EOS_Lobby_Attribute_Release(lobbyAttribute);
	}

	public void release() {
		EOSLibrary.instance.EOS_LobbyDetails_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}