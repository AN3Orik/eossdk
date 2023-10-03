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
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.utils.CallbackUtils;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

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
	 * between a successful call to {@link #beginSession(EOS_ProductUserId, EOS_EAntiCheatClientMode)} and the matching {@link #endSession()} call in mode EOS_ACCM_ClientServer.
	 * <p>
	 * Mode: {@link EOS_EAntiCheatClientMode#EOS_ACCM_ClientServer}.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyMessageToServer(Pointer clientData, EOS_AntiCheatClient_OnMessageToServerCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyMessageToServer(this, new EOS_AntiCheatClient_AddNotifyMessageToServerOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyMessageToServer handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyMessageToServer(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyMessageToServer(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Add a callback issued when a new message must be dispatched to a connected peer. The bound function will only be called
	 * between a successful call to EOS_AntiCheatClient_BeginSession and the matching EOS_AntiCheatClient_EndSession call in mode EOS_ACCM_PeerToPeer.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyMessageToPeer(Pointer clientData, EOS_AntiCheatClient_OnMessageToPeerCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyMessageToPeer(this, new EOS_AntiCheatClient_AddNotifyMessageToPeerOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyMessageToPeer handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyMessageToPeer(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyMessageToPeer(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Add a callback issued when an action must be applied to a connected client. The bound function will only be called
	 * between a successful call to EOS_AntiCheatClient_BeginSession and the matching EOS_AntiCheatClient_EndSession call in mode EOS_ACCM_PeerToPeer.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyPeerActionRequired(Pointer clientData, EOS_AntiCheatClient_OnPeerActionRequiredCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyPeerActionRequired(this, new EOS_AntiCheatClient_AddNotifyPeerActionRequiredOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyPeerActionRequired handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyPeerActionRequired(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyPeerActionRequired(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Add an optional callback issued when a connected peer's authentication status changes. The bound function will only be called
	 * between a successful call to EOS_AntiCheatClient_BeginSession and the matching EOS_AntiCheatClient_EndSession call in mode EOS_ACCM_PeerToPeer.<br>
	 * Mode: EOS_ACCM_PeerToPeer.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyPeerAuthStatusChanged(Pointer clientData, EOS_AntiCheatClient_OnPeerAuthStatusChangedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyPeerAuthStatusChanged(this, new EOS_AntiCheatClient_AddNotifyPeerAuthStatusChangedOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyPeerAuthStatusChanged handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyPeerAuthStatusChanged(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyPeerAuthStatusChanged(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Add a callback when a message must be displayed to the local client informing them on a local integrity violation,
	 * which will prevent further online play.<br>
	 * Mode: Any.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyClientIntegrityViolated(Pointer clientData, EOS_AntiCheatClient_OnClientIntegrityViolatedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatClient_AddNotifyClientIntegrityViolated(this, new EOS_AntiCheatClient_AddNotifyClientIntegrityViolatedOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatClient_AddNotifyClientIntegrityViolated handler.<br>
	 * Mode: Any.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyClientIntegrityViolated(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatClient_RemoveNotifyClientIntegrityViolated(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Begins a multiplayer game session. After this call returns successfully, the client is ready to exchange
	 * anti-cheat messages with a game server or peer(s). When leaving one game session and connecting to a
	 * different one, a new anti-cheat session must be created by calling EOS_AntiCheatClient_EndSession and EOS_AntiCheatClient_BeginSession again.<br>
	 * Mode: All
	 *
	 * @param productUserId Logged in user identifier from earlier call to EOS_Connect_Login family of functions
	 * @param mode Operating mode
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the session was started successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult beginSession(EOS_ProductUserId productUserId, EOS_EAntiCheatClientMode mode) {
		return EOSLibrary.instance.EOS_AntiCheatClient_BeginSession(this, new EOS_AntiCheatClient_BeginSessionOptions(productUserId, mode));
	}

	/**
	 * Ends a multiplayer game session, either by leaving an ongoing session or shutting it down entirely.<br>
	 * Mode: All
	 * <p>
	 * Must be called when the multiplayer session ends, or when the local user leaves a session in progress.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the session was ended normally
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_AntiCheat_InvalidMode} - If the current mode does not support this function
	 */
	public EOS_EResult endSession() {
		return EOSLibrary.instance.EOS_AntiCheatClient_EndSession(this, new EOS_AntiCheatClient_EndSessionOptions());
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
	 * @param dataSize input data size
	 *
	 * @return On success, the OutBuffer length in bytes that is required to call ProtectMessage on the given input size.
	 *
	 * @throws EOSInvalidParametersException If input data was invalid
	 * @throws EOSAntiCheatInvalidModeException If the current mode does not support this function
	 */
	public int getProtectMessageOutputLength(int dataSize) throws EOSException {
		final IntByReference sizeBytesReference = new IntByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_AntiCheatClient_GetProtectMessageOutputLength(this, new EOS_AntiCheatClient_GetProtectMessageOutputLengthOptions(dataSize), sizeBytesReference);
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
	 * @param data The data to encrypt
	 * @param outBufferSizeBytes The size in bytes of OutBuffer
	 *
	 * @return buffer with an encrypted data message
	 *
	 * @throws EOSInvalidParametersException If input data was invalid
	 * @throws EOSAntiCheatInvalidModeException If the current mode does not support this function
	 */
	public ByteBuffer protectMessage(byte @NotNull [] data, int outBufferSizeBytes) throws EOSException {
		final EOS_AntiCheatClient_ProtectMessageOptions.ByReference options = new EOS_AntiCheatClient_ProtectMessageOptions.ByReference(data, outBufferSizeBytes);
		final ByteBuffer outBuffer = ByteBuffer.allocate(outBufferSizeBytes);
		final IntByReference outBytesWritten = new IntByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_AntiCheatClient_ProtectMessage(this, options, outBuffer, outBytesWritten);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outBuffer;
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Decrypts an encrypted message received from the game server.<br>
	 * Mode: EOS_ACCM_ClientServer.
	 * <p>
	 * options.Data and OutBuffer may refer to the same buffer to decrypt in place.
	 *
	 * @param data The data to decrypt
	 *
	 * @return buffer with a decrypted data message
	 *
	 * @throws EOSInvalidParametersException If input data was invalid
	 * @throws EOSAntiCheatInvalidModeException If the current mode does not support this function
	 */
	public ByteBuffer unprotectMessage(byte[] data) throws EOSException {
		final EOS_AntiCheatClient_UnprotectMessageOptions.ByReference options = new EOS_AntiCheatClient_UnprotectMessageOptions.ByReference(data);
		final IntByReference outBytesWritten = new IntByReference();
		final ByteBuffer outBuffer = ByteBuffer.allocate(data.length);
		final EOS_EResult result = EOSLibrary.instance.EOS_AntiCheatClient_UnprotectMessage(this, options, outBuffer, outBytesWritten);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		outBuffer.limit(outBytesWritten.getValue());
		return outBuffer;
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