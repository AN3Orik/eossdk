package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSIncompatibleVersionException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.lobby.options.*;

/**
 * A "read only" representation of an existing lobby that games interact with externally.
 * Both the lobby and lobby search interfaces use this common class for lobby management and search results
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
	 * @return Out parameter used to receive the EOS_LobbyDetails_Info structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_LobbyDetails_Info
	 * @see EOS_LobbyDetails_CopyInfoOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_LobbyDetails_Info copyInfo(EOS_LobbyDetails_CopyInfoOptions options) throws EOSException {
		final EOS_LobbyDetails_Info.ByReference outLobbyDetailsInfo = new EOS_LobbyDetails_Info.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_LobbyDetails_CopyInfo(this, options, outLobbyDetailsInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outLobbyDetailsInfo;
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
	 * @return Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyAttributeByIndexOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_Lobby_Attribute copyAttributeByIndex(EOS_LobbyDetails_CopyAttributeByIndexOptions options) throws EOSException {
		final EOS_Lobby_Attribute.ByReference outAttribute = new EOS_Lobby_Attribute.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_LobbyDetails_CopyAttributeByIndex(this, options, outAttribute);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outAttribute;
	}

	/**
	 * EOS_LobbyDetails_CopyAttributeByKey is used to immediately retrieve a copy of a lobby attribute from a given source such as a existing lobby or a search result.
	 * If the call returns an EOS_Success result, the out parameter, OutAttribute, must be passed to EOS_Lobby_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @return Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyAttributeByKeyOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_Lobby_Attribute copyAttributeByKey(EOS_LobbyDetails_CopyAttributeByKeyOptions options) throws EOSException {
		final EOS_Lobby_Attribute.ByReference outAttribute = new EOS_Lobby_Attribute.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_LobbyDetails_CopyAttributeByKey(this, options, outAttribute);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outAttribute;
	}

	/**
	 * Get the number of members associated with this lobby
	 *
	 * @param options the Options associated with retrieving the member count
	 *
	 * @return number of members in the existing lobby or 0 if there is an error
	 */
	public int getMemberCount(EOS_LobbyDetails_GetMemberCountOptions options) {
		return EOSLibrary.instance.EOS_LobbyDetails_GetMemberCount(this, options);
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
	 * @return Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyMemberAttributeByIndexOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_Lobby_Attribute copyMemberAttributeByIndex(EOS_LobbyDetails_CopyMemberAttributeByIndexOptions options) throws EOSException {
		final EOS_Lobby_Attribute.ByReference outAttribute = new EOS_Lobby_Attribute.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_LobbyDetails_CopyMemberAttributeByIndex(this, options, outAttribute);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outAttribute;
	}

	/**
	 * EOS_LobbyDetails_CopyMemberAttributeByKey is used to immediately retrieve a copy of a lobby member attribute from an existing lobby.
	 * If the call returns an EOS_Success result, the out parameter, OutAttribute, must be passed to EOS_Lobby_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @return Out parameter used to receive the EOS_Lobby_Attribute structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_Lobby_Attribute
	 * @see EOS_LobbyDetails_CopyMemberAttributeByKeyOptions
	 * @see EOS_LobbyDetails#release()
	 */
	public EOS_Lobby_Attribute copyMemberAttributeByKey(EOS_LobbyDetails_CopyMemberAttributeByKeyOptions options) throws EOSException {
		final EOS_Lobby_Attribute.ByReference outAttribute = new EOS_Lobby_Attribute.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_LobbyDetails_CopyMemberAttributeByKey(this, options, outAttribute);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outAttribute;
	}

	public void release() {
		EOSLibrary.instance.EOS_LobbyDetails_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}