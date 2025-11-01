package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSIncompatibleVersionException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Sessions_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_ActiveSession_CopyInfoOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_ActiveSession_GetRegisteredPlayerByIndexOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_ActiveSession_GetRegisteredPlayerCountOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_Sessions_CopyActiveSessionHandleOptions;

/**
 * Representation of an existing session some local players are actively involved in (via Create/Join)
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
public class EOS_ActiveSession extends PointerType implements AutoCloseable {
	public EOS_ActiveSession(Pointer address) {
		super(address);
	}

	public EOS_ActiveSession() {
		super();
	}

	/**
	 * EOS_ActiveSession_CopyInfo is used to immediately retrieve a copy of active session information
	 * If the call returns an EOS_Success result, the out parameter, OutActiveSessionInfo, must be passed to EOS_ActiveSession_Info_Release to release the memory associated with it.
	 *
	 * @param options Structure containing the input parameters
	 * @return Out parameter used to receive the EOS_ActiveSession_Info structure.
	 *
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSIncompatibleVersionException if the API version passed in is incorrect
	 *
	 * @see EOS_ActiveSession_Info
	 * @see EOS_ActiveSession_CopyInfoOptions
	 * @see EOS_ActiveSession_Info#release()
	 */
	public EOS_ActiveSession_Info copyInfo(EOS_ActiveSession_CopyInfoOptions options) throws EOSException {
		final PointerByReference outActiveSessionInfo = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_ActiveSession_CopyInfo(this, options, outActiveSessionInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_ActiveSession_Info info = new EOS_ActiveSession_Info(outActiveSessionInfo.getValue());
		info.read();
		return info;
	}

	/**
	 * Get the number of registered players associated with this active session
	 *
	 * @param options the options associated with retrieving the registered player count
	 *
	 * @return number of registered players in the active session or 0 if there is an error
	 */
	public int getRegisteredPlayerCount(EOS_ActiveSession_GetRegisteredPlayerCountOptions options) {
		return EOSLibrary.instance.EOS_ActiveSession_GetRegisteredPlayerCount(this, options);
	}

	/**
	 * EOS_ActiveSession_GetRegisteredPlayerByIndex is used to immediately retrieve individual players registered with the active session.
	 *
	 * @param options Structure containing the input parameters
	 *
	 * @return the product user ID for the registered player at a given index or null if that index is invalid
	 *
	 * @see EOS_ActiveSession#getRegisteredPlayerCount(EOS_ActiveSession_GetRegisteredPlayerCountOptions)
	 * @see EOS_ActiveSession_GetRegisteredPlayerByIndexOptions
	 */
	public EOS_ProductUserId getRegisteredPlayerByIndex(EOS_ActiveSession_GetRegisteredPlayerByIndexOptions options) {
		return EOSLibrary.instance.EOS_ActiveSession_GetRegisteredPlayerByIndex(this, options);
	}

	/**
	 * Release the memory associated with an active session.
	 * This must be called on data retrieved from EOS_Sessions_CopyActiveSessionHandle
	 *
	 * @see EOS_Sessions_Interface#copyActiveSessionHandle(EOS_Sessions_CopyActiveSessionHandleOptions, EOS_ActiveSession)
	 */
	public void release() {
		EOSLibrary.instance.EOS_ActiveSession_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}