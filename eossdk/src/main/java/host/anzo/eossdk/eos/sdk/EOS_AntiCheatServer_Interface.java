package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.anticheat.common.options.*;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnClientActionRequiredCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnClientAuthStatusChangedCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnMessageToClientCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.*;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import java.nio.ByteBuffer;

/**
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
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyMessageToClient(EOS_AntiCheatServer_AddNotifyMessageToClientOptions options,
	                                                   Pointer clientData,
	                                                   EOS_AntiCheatServer_OnMessageToClientCallback notificationFn) {
		return EOSLibrary.instance.EOS_AntiCheatServer_AddNotifyMessageToClient(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatServer_AddNotifyMessageToClient handler.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyMessageToClient(EOS_NotificationId notificationId)  {
		EOSLibrary.instance.EOS_AntiCheatServer_RemoveNotifyMessageToClient(this, notificationId);
	}

	/**
	 * Add a callback issued when an action must be applied to a connected client. The bound function
	 * will only be called between a successful call to EOS_AntiCheatServer_BeginSession and the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyClientActionRequired(EOS_AntiCheatServer_AddNotifyClientActionRequiredOptions options,
	                                                        Pointer clientData,
	                                                        EOS_AntiCheatServer_OnClientActionRequiredCallback notificationFn)  {
		return EOSLibrary.instance.EOS_AntiCheatServer_AddNotifyClientActionRequired(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatServer_AddNotifyClientActionRequired handler.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyClientActionRequired(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatServer_RemoveNotifyClientActionRequired(this, notificationId);
	}

	/**
	 * Add an optional callback issued when a connected client's authentication status changes. The bound function
	 * will only be called between a successful call to EOS_AntiCheatServer_BeginSession and the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data
	 * @param clientData This value is returned to the caller when NotificationFn is invoked
	 * @param notificationFn The callback to be fired
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyClientAuthStatusChanged(EOS_AntiCheatServer_AddNotifyClientAuthStatusChangedOptions options,
	                                                           Pointer clientData,
	                                                           EOS_AntiCheatServer_OnClientAuthStatusChangedCallback notificationFn) {
		return EOSLibrary.instance.EOS_AntiCheatServer_AddNotifyClientAuthStatusChanged(this, options, clientData, notificationFn);
	}

	/**
	 * Remove a previously bound EOS_AntiCheatServer_AddNotifyClientAuthStatusChanged handler.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyClientAuthStatusChanged(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_AntiCheatServer_RemoveNotifyClientAuthStatusChanged(this, notificationId);
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
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the initialization succeeded
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult endSession(EOS_AntiCheatServer_EndSessionOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_EndSession(this, options);
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
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the player was unregistered successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult unregisterClient(EOS_AntiCheatServer_UnregisterClientOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_UnregisterClient(this, options);
	}

	/**
	 * Call when an anti-cheat message is received from a client.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was processed successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_InvalidRequest} - If message contents were corrupt and could not be processed
	 */
	public EOS_EResult receiveMessageFromClient(EOS_AntiCheatServer_ReceiveMessageFromClientOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_ReceiveMessageFromClient(this, options);
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
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the game session identifier was set successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult setGameSessionId(EOS_AntiCheatCommon_SetGameSessionIdOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_SetGameSessionId(this, options);
	}

	/**
	 * Optional. Can be used to indicate that a client is legitimately known to be
	 * temporarily unable to communicate, for example as a result of loading a new level.
	 * <p>
	 * The bIsNetworkActive flag must be set back to true when users enter normal
	 * gameplay, otherwise anti-cheat enforcement will not work correctly.
	 * <p>
	 * This function may only be called between a successful call to EOS_AntiCheatServer_BeginSession and
	 * the matching EOS_AntiCheatServer_EndSession call.
	 *
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the network state was updated successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult setClientNetworkState(EOS_AntiCheatServer_SetClientNetworkStateOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_SetClientNetworkState(this, options);
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Calculates the required decrypted buffer size for a given input data length.
	 * This will not change for a given SDK version, and allows one time allocation of reusable buffers.
	 *
	 * @param options Structure containing input data.
	 * @param outBufferSizeBytes On success, the OutBuffer length in bytes that is required to call ProtectMessage on the given input size.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the output length was calculated successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult getProtectMessageOutputLength(EOS_AntiCheatServer_GetProtectMessageOutputLengthOptions options,
	                                                 IntByReference outBufferSizeBytes)  {

		return EOSLibrary.instance.EOS_AntiCheatServer_GetProtectMessageOutputLength(this, options, outBufferSizeBytes);
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Encrypts an arbitrary message that will be sent to a game client and decrypted on the other side.
	 * <p>
	 * Options.Data and OutBuffer may refer to the same buffer to encrypt in place.
	 *
	 * @param options Structure containing input data.
	 * @param outBuffer On success, buffer where encrypted message data will be written.
	 * @param outBytesWritten On success, the number of bytes that were written to OutBuffer.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was protected successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_InvalidUser} - If the specified ClientHandle was invalid or not currently registered. See RegisterClient.
	 */
	public EOS_EResult protectMessage(EOS_AntiCheatServer_ProtectMessageOptions options, ByteBuffer outBuffer, IntByReference outBytesWritten) {
		return EOSLibrary.instance.EOS_AntiCheatServer_ProtectMessage(this, options, outBuffer, outBytesWritten);
	}

	/**
	 * Optional NetProtect feature for game message encryption.
	 * Decrypts an encrypted message received from a game client.
	 * <p>
	 * Options.Data and OutBuffer may refer to the same buffer to decrypt in place.
	 *
	 * @param options Structure containing input data.
	 * @param outBuffer On success, buffer where encrypted message data will be written.
	 * @param outBytesWritten On success, the number of bytes that were written to OutBuffer.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the message was unprotected successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 */
	public EOS_EResult unprotectMessage(EOS_AntiCheatServer_UnprotectMessageOptions options,
	                                    ByteBuffer outBuffer,
	                                    IntByReference outBytesWritten) {
		return EOSLibrary.instance.EOS_AntiCheatServer_UnprotectMessage(this, options, outBuffer, outBytesWritten);
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
	 * @param options Structure containing input data.
	 *
	 * @return {@link EOS_EResult#EOS_Success} - If the event was logged successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input data was invalid
	 *         {@link EOS_EResult#EOS_NotConfigured} - If called outside of BeginSession/EndSession boundaries
	 */
	public EOS_EResult logGameRoundEnd(EOS_AntiCheatCommon_LogGameRoundEndOptions options) {
		return EOSLibrary.instance.EOS_AntiCheatServer_LogGameRoundEnd(this, options);
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