package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSAntiCheatInvalidModeException;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.sdk.anticheat.client.callbacks.*;
import host.anzo.eossdk.eos.sdk.anticheat.client.options.*;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatClientMode;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public class EOS_AntiCheatClient_Interface extends PointerType {
	public EOS_AntiCheatClient_Interface(Pointer address) {
		super(address);
	}
	public EOS_AntiCheatClient_Interface() {
		super();
	}

	/**
	 * Add a callback issued when a new message must be dispatched to the game server. The bound function will only be called
	 * between a successful call to {@link #beginSession(EOS_AntiCheatClient_BeginSessionOptions)} and the matching {@link #endSession(EOS_AntiCheatClient_EndSessionOptions)} call in mode EOS_ACCM_ClientServer.
	 * <p>
	 * Mode: {@link EOS_EAntiCheatClientMode#EOS_ACCM_ClientServer}.
	 *
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyMessageToServer(EOS_AntiCheatClient_AddNotifyMessageToServerOptions options,
	                                                   Pointer clientData,
	                                                   EOS_AntiCheatClient_OnMessageToServerCallback notificationFn) {
		return EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyMessageToServer(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyMessageToServer handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyMessageToServer(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyMessageToServer(this, notificationId);
	}

	/**
	 * Add a callback issued when a new message must be dispatched to a connected peer. The bound function will only be called
	 * between a successful call to EOS_AntiCheatClient_BeginSession and the matching EOS_AntiCheatClient_EndSession call in mode EOS_ACCM_PeerToPeer.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 *
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyMessageToPeer(EOS_AntiCheatClient_AddNotifyMessageToPeerOptions options,
	                                                 Pointer clientData,
	                                                 EOS_AntiCheatClient_OnMessageToPeerCallback notificationFn) {
		return EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyMessageToPeer(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyMessageToPeer handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyMessageToPeer(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyMessageToPeer(this, notificationId);
	}

	/**
	 * Add a callback issued when an action must be applied to a connected client. The bound function will only be called
	 * between a successful call to EOS_AntiCheatClient_BeginSession and the matching EOS_AntiCheatClient_EndSession call in mode EOS_ACCM_PeerToPeer.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 *
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyPeerActionRequired(EOS_AntiCheatClient_AddNotifyPeerActionRequiredOptions options,
	                                                      Pointer clientData,
	                                                      EOS_AntiCheatClient_OnPeerActionRequiredCallback notificationFn) {
		return EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyPeerActionRequired(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyPeerActionRequired handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyPeerActionRequired(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyPeerActionRequired(this, notificationId);
	}

	/**
	 * Add an optional callback issued when a connected peer's authentication status changes. The bound function will only be called
	 * between a successful call to EOS_AntiCheatClient_BeginSession and the matching EOS_AntiCheatClient_EndSession call in mode EOS_ACCM_PeerToPeer.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 *
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyPeerAuthStatusChanged(EOS_AntiCheatClient_AddNotifyPeerAuthStatusChangedOptions options,
	                                                                             Pointer clientData,
	                                                                             EOS_AntiCheatClient_OnPeerAuthStatusChangedCallback notificationFn) {
		return EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyPeerAuthStatusChanged(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyPeerAuthStatusChanged handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyPeerAuthStatusChanged(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyPeerAuthStatusChanged(this, notificationId);
	}

	/**
	 * Add a callback when a message must be displayed to the local client informing them on a local integrity violation,
	 * which will prevent further online play.<br>
	 * Mode: Any.
	 *
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyClientIntegrityViolated(EOS_AntiCheatClient_AddNotifyClientIntegrityViolatedOptions options,
	                                                           Pointer clientData,
	                                                           EOS_AntiCheatClient_OnClientIntegrityViolatedCallback notificationFn) {
		return EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyClientIntegrityViolated(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyClientIntegrityViolated handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyClientIntegrityViolated(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyClientIntegrityViolated(this, notificationId);
	}

	/**
	 * Begins a multiplayer game session. After this call returns successfully, the client is ready to exchange
	 * anti-cheat messages with a game server or peer(s). When leaving one game session and connecting to a
	 * different one, a new anti-cheat session must be created by calling EOS_AntiCheatClient_EndSession and EOS_AntiCheatClient_BeginSession again.<br>
	 * Mode: All
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the session was started successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult beginSession(EOS_AntiCheatClient_BeginSessionOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatClient_BeginSession(this, options);
	}

	/**
	 * Ends a multiplayer game session, either by leaving an ongoing session or shutting it down entirely.<br>
	 * Mode: All
	 * <p>
	 * Must be called when the multiplayer session ends, or when the local user leaves a session in progress.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the session was ended normally
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult endSession(EOS_AntiCheatClient_EndSessionOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatClient_EndSession(this, options);
	}

	/**
	 * Optional. Adds an integrity catalog and certificate pair from outside the game directory,
	 * for example to support mods that load from elsewhere.<br>
	 * Mode: All
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the integrity catalog was added successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult addExternalIntegrityCatalog(EOS_AntiCheatClient_AddExternalIntegrityCatalogOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatClient_AddExternalIntegrityCatalog(this, options);
	}

	/**
	 * Call when an anti-cheat message is received from the game server.<br>
	 * Mode: EOS_ACCM_ClientServer.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was processed successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_InvalidRequest} - If message contents were corrupt and could not be processed
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult receiveMessageFromServer(EOS_AntiCheatClient_ReceiveMessageFromServerOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatClient_ReceiveMessageFromServer(this, options);
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Calculates the required decrypted buffer size for a given input data length.
	 * This will not change for a given SDK version, and allows one time allocation of reusable buffers.<br>
	 * Mode: EOS_ACCM_ClientServer.
	 *
	 * @param options Structure containing input data.
	 * @return On success, the OutBuffer length in bytes that is required to call ProtectMessage on the given input size.
	 *
	 * @throws EOSInvalidParametersException If input data was invalid
	 * @throws EOSAntiCheatInvalidModeException If the current mode does not support this function
	 */
	public int getProtectMessageOutputLength(EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions options) throws EOSException {
		final IntByReference sizeBytesReference = new IntByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_AntiCheatClient_GetProtectMessageOutputLength(this, options, sizeBytesReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return sizeBytesReference.getValue();
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Encrypts an arbitrary message that will be sent to the game server and decrypted on the other side.<br>
	 * Mode: EOS_ACCM_ClientServer.
	 * <p>
	 * options.Data and OutBuffer may refer to the same buffer to encrypt in place.
	 *
	 * @param options Structure containing input data.
	 * @param outBuffer On success, buffer where encrypted message data will be written.
	 * @param outBytesWritten On success, the number of bytes that were written to OutBuffer.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was protected successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult protectMessage(EOS_AntiCheatClient_ProtectMessageOptions options, Pointer outBuffer, IntByReference outBytesWritten)  {
		return EOSLibrary.instance.EOS_AntiCheatClient_ProtectMessage(this, options, outBuffer, outBytesWritten);
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Decrypts an encrypted message received from the game server.<br>
	 * Mode: EOS_ACCM_ClientServer.
	 * <p>
	 * options.Data and OutBuffer may refer to the same buffer to decrypt in place.
	 *
	 * @param options Structure containing input data.
	 * @param outBuffer On success, buffer where encrypted message data will be written.
	 * @param outBytesWritten On success, the number of bytes that were written to OutBuffer.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was unprotected successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult unprotectMessage(EOS_AntiCheatClient_UnprotectMessageOptions options, Pointer outBuffer, IntByReference outBytesWritten) {
		return EOSLibrary.instance.EOS_AntiCheatClient_UnprotectMessage(this, options, outBuffer, outBytesWritten);
	}

	/**
	 * Registers a connected peer-to-peer client.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 * <p>
	 * Must be paired with a call to EOS_AntiCheatClient_UnregisterPeer if this user leaves the session
	 * in progress, or EOS_AntiCheatClient_EndSession if the entire session is ending.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the player was registered successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult registerPeer(EOS_AntiCheatClient_RegisterPeerOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatClient_RegisterPeer(this, options);
	}

	/**
	 * Unregisters a disconnected peer-to-peer client.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 * <p>
	 * Must be called when a user leaves a session in progress.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the player was unregistered successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult unregisterPeer(EOS_AntiCheatClient_UnregisterPeerOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatClient_UnregisterPeer(this, options);
	}

	/**
	 * Call when an anti-cheat message is received from a peer.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was processed successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult receiveMessageFromPeer(EOS_AntiCheatClient_ReceiveMessageFromPeerOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatClient_ReceiveMessageFromPeer(this, options);
	}
}