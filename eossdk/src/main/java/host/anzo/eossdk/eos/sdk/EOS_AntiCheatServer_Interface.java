package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidUserException;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.options.*;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnClientActionRequiredCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnClientAuthStatusChangedCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnMessageToClientCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.*;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.utils.CallbackUtils;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

/**
 * The Anti-Cheat server Interface is used to implement anti-cheat interface at game server side
 *
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public class EOS_AntiCheatServer_Interface extends PointerType {
	public EOS_AntiCheatServer_Interface(Pointer address) {
		super(address);
	}

	public EOS_AntiCheatServer_Interface() {
		super();
	}

	/**
	 * Add a callback issued when a new message must be dispatched to a connected client. The bound function
	 * will only be called between a successful call to EOS_AntiCheatServer_BeginSession and the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyMessageToClient(Pointer clientData, EOS_AntiCheatServer_OnMessageToClientCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatServer_AddNotifyMessageToClient(this, new EOS_AntiCheatServer_AddNotifyMessageToClientOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatServer_AddNotifyMessageToClient handler.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyMessageToClient(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatServer_RemoveNotifyMessageToClient(this, notificationId);
		CallbackUtils.unregisterNotificationCallback(notificationId);
	}

	/**
	 * Add a callback issued when an action must be applied to a connected client. The bound function
	 * will only be called between a successful call to EOS_AntiCheatServer_BeginSession and the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyClientActionRequired(Pointer clientData, EOS_AntiCheatServer_OnClientActionRequiredCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatServer_AddNotifyClientActionRequired(this, new EOS_AntiCheatServer_AddNotifyClientActionRequiredOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatServer_AddNotifyClientActionRequired handler.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyClientActionRequired(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatServer_RemoveNotifyClientActionRequired(this, notificationId);
		CallbackUtils.unregisterNotificationCallback(notificationId);
	}

	/**
	 * Add an optional callback issued when a connected client's authentication status changes. The bound function
	 * will only be called between a successful call to EOS_AntiCheatServer_BeginSession and the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyClientAuthStatusChanged(Pointer clientData, EOS_AntiCheatServer_OnClientAuthStatusChangedCallback notificationFn) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_AntiCheatServer_AddNotifyClientAuthStatusChanged(this, new EOS_AntiCheatServer_AddNotifyClientAuthStatusChangedOptions(), clientData, notificationFn);
		if (notificationId.isValid()) {
			CallbackUtils.registerNotificationCallback(notificationId, notificationFn);
		}
		return notificationId;
	}

	/**
	 * Remove a previously bound EOS_AntiCheatServer_AddNotifyClientAuthStatusChanged handler.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyClientAuthStatusChanged(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatServer_RemoveNotifyClientAuthStatusChanged(this, notificationId);
		CallbackUtils.unregisterNotificationCallback(notificationId);
	}

	/**
	 * Begin the gameplay session. Event callbacks must be configured with EOS_AntiCheatServer_AddNotifyMessageToClient
	 * and EOS_AntiCheatServer_AddNotifyClientActionRequired before calling this function.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the initialization succeeded
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult beginSession(EOS_AntiCheatServer_BeginSessionOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_BeginSession(this, options);
	}

	/**
	 * End the gameplay session. Should be called when the server is shutting down or entering an idle state.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the initialization succeeded
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult endSession() {
		return EOSLibrary.instance.EOS_AntiCheatServer_EndSession(this, new EOS_AntiCheatServer_EndSessionOptions());
	}

	/**
	 * Register a connected client. Must be paired with a call to UnregisterClient.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the player was registered successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult registerClient(EOS_AntiCheatServer_RegisterClientOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_RegisterClient(this, options);
	}

	/**
	 * Unregister a disconnected client.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param clientHandle Locally unique value describing the remote user, as previously passed to RegisterClient
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the player was unregistered successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult unregisterClient(@NotNull EOS_AntiCheatCommon_ClientHandle clientHandle) {
		return EOSLibrary.instance.EOS_AntiCheatServer_UnregisterClient(this, new EOS_AntiCheatServer_UnregisterClientOptions(clientHandle));
	}

	/**
	 * Call when an anti-cheat message is received from a client.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param clientHandle Locally unique value describing the corresponding remote user, as previously passed to RegisterClient
	 * @param data The data received
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was processed successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_InvalidRequest} - If message contents were corrupt and could not be processed
	 */
	public EOS_EResult receiveMessageFromClient(@NotNull EOS_AntiCheatCommon_ClientHandle clientHandle, byte @NotNull [] data) {
		return EOSLibrary.instance.EOS_AntiCheatServer_ReceiveMessageFromClient(this, new EOS_AntiCheatServer_ReceiveMessageFromClientOptions(clientHandle, data));
	}

	/**
	 * Optional. Sets or updates client details including input device and admin status.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the flags were updated successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult setClientDetails(EOS_AntiCheatCommon_SetClientDetailsOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_SetClientDetails(this, options);
	}

	/**
	 * Optional. Sets or updates a game session identifier which can be attached to other data for reference.
	 * The identifier can be updated at any time for currently and subsequently registered clients.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param gameSessionId Game session identifier
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the game session identifier was set successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult setGameSessionId(String gameSessionId) {
		return EOSLibrary.instance.EOS_AntiCheatServer_SetGameSessionId(this, new EOS_AntiCheatCommon_SetGameSessionIdOptions(gameSessionId));
	}

	/**
	 * Optional. Can be used to indicate that a client is legitimately known to be
	 * temporarily unable to communicate, for example as a result of loading a new level.
	 * <p>
	 * The IsNetworkActive flag must be set back to true when users enter normal
	 * gameplay, otherwise anti-cheat enforcement will not work correctly.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param clientHandle Locally unique value describing the remote user (e.g. a player object pointer)
	 * @param isNetworkActive true if the network is functioning normally, false if temporarily interrupted
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the network state was updated successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult setClientNetworkState(EOS_AntiCheatCommon_ClientHandle clientHandle, boolean isNetworkActive) {
		return EOSLibrary.instance.EOS_AntiCheatServer_SetClientNetworkState(this, new EOS_AntiCheatServer_SetClientNetworkStateOptions(clientHandle, isNetworkActive));
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Calculates the required decrypted buffer size for a given input data length.
	 * This will not change for a given SDK version, and allows one time allocation of reusable buffers.
	 *
	 * @param dataSize input data size
	 *
	 * @return On success, the OutBuffer length in bytes that is required to call ProtectMessage on the given input size.
	 *
	 * @throws EOSInvalidParametersException If input data was invalid
	 */
	public int getProtectMessageOutputLength(int dataSize) throws EOSException {
		final IntByReference sizeBytesReference = new IntByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_AntiCheatServer_GetProtectMessageOutputLength(this, new EOS_AntiCheatServer_GetProtectMessageOutputLengthOptions(dataSize), sizeBytesReference);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return sizeBytesReference.getValue();
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Encrypts an arbitrary message that will be sent to a game client and decrypted on the other side.
	 * <p>
	 * Options.Data and OutBuffer may refer to the same buffer to encrypt in place.
	 *
	 * @param clientHandle Locally unique value describing the remote user to whom the message will be sent
	 * @param data The data to encrypt
	 * @param outBufferSizeBytes The size in bytes of OutBuffer
	 *
	 * @return buffer with an encrypted data message
	 *
	 * @throws EOSInvalidParametersException If input data was invalid
	 * @throws EOSInvalidUserException If the specified ClientHandle was invalid or not currently registered. See {@link #registerClient(EOS_AntiCheatServer_RegisterClientOptions)}
	 */
	public ByteBuffer protectMessage(EOS_AntiCheatCommon_ClientHandle clientHandle, byte[] data, int outBufferSizeBytes) throws EOSException {
		final EOS_AntiCheatServer_ProtectMessageOptions.ByReference options = new EOS_AntiCheatServer_ProtectMessageOptions.ByReference(clientHandle, data, outBufferSizeBytes);

		final ByteBuffer outBuffer = ByteBuffer.allocate(outBufferSizeBytes);
		final IntByReference outBytesWritten = new IntByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_AntiCheatServer_ProtectMessage(this, options, outBuffer, outBytesWritten);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outBuffer;
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Decrypts an encrypted message received from a game client.
	 * <p>
	 * Options.Data and OutBuffer may refer to the same buffer to decrypt in place.
	 *
	 * @param clientHandle Locally unique value describing the remote user from whom the message was received
	 * @param data The data to decrypt
	 *
	 * @return buffer with a decrypted data message
	 *
	 * @throws EOSInvalidParametersException If input data was invalid
	 */
	public ByteBuffer unprotectMessage(EOS_AntiCheatCommon_ClientHandle clientHandle, byte[] data) throws EOSException {
		final EOS_AntiCheatServer_UnprotectMessageOptions.ByReference options = new EOS_AntiCheatServer_UnprotectMessageOptions.ByReference(clientHandle, data);
		final IntByReference outBytesWritten = new IntByReference();
		final ByteBuffer outBuffer = ByteBuffer.allocate(data.length);
		final EOS_EResult result = EOSLibrary.instance.EOS_AntiCheatServer_UnprotectMessage(this, options, outBuffer, outBytesWritten);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		outBuffer.limit(outBytesWritten.getValue());
		return outBuffer;
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Registers a custom gameplay event.
	 * <p>
	 * All custom game events must be registered before EOS_AntiCheatServer_BeginSession is called for the first time.
	 * After the first call to EOS_AntiCheatServer_BeginSession, this function cannot be called any longer.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was registered successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult registerEvent(EOS_AntiCheatCommon_RegisterEventOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_RegisterEvent(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs a custom gameplay event.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logEvent(EOS_AntiCheatCommon_LogEventOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogEvent(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs a new game round start.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logGameRoundStart(EOS_AntiCheatCommon_LogGameRoundStartOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogGameRoundStart(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs a game round's end and outcome.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param winningTeamId Optional identifier for the winning team
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logGameRoundEnd(int winningTeamId) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogGameRoundEnd(this, new EOS_AntiCheatCommon_LogGameRoundEndOptions(winningTeamId));
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs a player spawning into the game.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logPlayerSpawn(EOS_AntiCheatCommon_LogPlayerSpawnOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogPlayerSpawn(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs a player despawning in the game, for example as a result of the character's death,
	 * switching to spectator mode, etc.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logPlayerDespawn(EOS_AntiCheatCommon_LogPlayerDespawnOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogPlayerDespawn(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs a player being revived after being downed (see EOS_AntiCheatServer_LogPlayerTakeDamage options).
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logPlayerRevive(EOS_AntiCheatCommon_LogPlayerReviveOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogPlayerRevive(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs a player's general state including position and view direction.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logPlayerTick(EOS_AntiCheatCommon_LogPlayerTickOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogPlayerTick(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs that a player has used a weapon, for example firing one bullet or making one melee attack.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logPlayerUseWeapon(EOS_AntiCheatCommon_LogPlayerUseWeaponOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogPlayerUseWeapon(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs that a player has used a special ability or item which affects their character's capabilities,
	 * for example temporarily increasing their speed or allowing them to see nearby players behind walls.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logPlayerUseAbility(EOS_AntiCheatCommon_LogPlayerUseAbilityOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogPlayerUseAbility(this, options);
	}

	/**
	 * Optional Cerberus feature for gameplay data collection.
	 * Logs that a player has taken damage.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logPlayerTakeDamage(EOS_AntiCheatCommon_LogPlayerTakeDamageOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogPlayerTakeDamage(this, options);
	}
}