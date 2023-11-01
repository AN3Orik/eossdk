package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSIncompatibleVersionException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.sessions.options.*;

/**
 * This class represents the details of a session, including its session properties and the attribution associated with it
 * Locally created or joined active sessions will contain this information as will search results.
 * A handle to a session is required to join a session via search or invite
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
public class EOS_SessionDetails extends PointerType implements AutoCloseable {
	public EOS_SessionDetails(Pointer address) {
		super(address);
	}

	public EOS_SessionDetails() {
		super();
	}

	/**
	 * EOS_SessionDetails_CopyInfo is used to immediately retrieve a copy of session information from a given source such as a active session or a search result.
	 * If the call returns an EOS_Success result, the out parameter, OutSessionInfo, must be passed to EOS_SessionDetails_Info_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @return Out parameter used to receive the EOS_SessionDetails_Info structure.
	 *
	 * @throws EOSInvalidParametersException if the information is available and passed out in outSessionInfo
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_SessionDetails_Info
	 * @see EOS_SessionDetails_CopyInfoOptions
	 * @see EOS_SessionDetails_Info#release()
	 */
	public EOS_SessionDetails_Info copyInfo(EOS_SessionDetails_CopyInfoOptions options) throws EOSException {
		final EOS_SessionDetails_Info.ByReference outSessionInfo = new EOS_SessionDetails_Info.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_SessionDetails_CopyInfo(this, options, outSessionInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outSessionInfo;
	}

	/**
	 * Get the number of attributes associated with this session
	 *
	 * @param options the options associated with retrieving the attribute count
	 *
	 * @return number of attributes on the session or 0 if there is an error
	 */
	public int getSessionAttributeCount(EOS_SessionDetails_GetSessionAttributeCountOptions options) {
		return EOSLibrary.instance.EOS_SessionDetails_GetSessionAttributeCount(this, options);
	}

	/**
	 * EOS_SessionDetails_CopySessionAttributeByIndex is used to immediately retrieve a copy of session attribution from a given source such as an active session or a search result.
	 * If the call returns an EOS_Success result, the out parameter, outSessionAttribute, must be passed to EOS_SessionDetails_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @return Out parameter used to receive the EOS_SessionDetails_Attribute structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_SessionDetails_Attribute
	 * @see EOS_SessionDetails_CopySessionAttributeByIndexOptions
	 * @see EOS_SessionDetails_Attribute#release()
	 */
	public EOS_SessionDetails_Attribute copySessionAttributeByIndex(EOS_SessionDetails_CopySessionAttributeByIndexOptions options) throws EOSException {
		final EOS_SessionDetails_Attribute.ByReference outSessionAttribute = new EOS_SessionDetails_Attribute.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_SessionDetails_CopySessionAttributeByIndex(this, options, outSessionAttribute);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outSessionAttribute;
	}

	/**
	 * EOS_SessionDetails_CopySessionAttributeByKey is used to immediately retrieve a copy of session attribution from a given source such as a active session or a search result.
	 * If the call returns an EOS_Success result, the out parameter, OutSessionAttribute, must be passed to EOS_SessionDetails_Attribute_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @return Out parameter used to receive the EOS_SessionDetails_Attribute structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_SessionDetails_Attribute
	 * @see EOS_SessionDetails_CopySessionAttributeByKeyOptions
	 * @see EOS_SessionDetails_Attribute#release()
	 */
	public EOS_SessionDetails_Attribute copySessionAttributeByKey(EOS_SessionDetails_CopySessionAttributeByKeyOptions options) throws EOSException {
		final EOS_SessionDetails_Attribute.ByReference outSessionAttribute = new EOS_SessionDetails_Attribute.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_SessionDetails_CopySessionAttributeByKey(this, options, outSessionAttribute);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outSessionAttribute;
	}

	/**
	 * Release the memory associated with a single session. This must be called on data retrieved from EOS_SessionSearch_CopySearchResultByIndex.
	 *
	 * @see EOS_SessionSearch#copySearchResultByIndex(EOS_SessionSearch_CopySearchResultByIndexOptions, EOS_SessionDetails)
	 */
	public void release() {
		EOSLibrary.instance.EOS_SessionDetails_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}