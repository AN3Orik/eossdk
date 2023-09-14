package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.metrics.options.EOS_Metrics_BeginPlayerSessionOptions;
import host.anzo.eossdk.eos.sdk.metrics.options.EOS_Metrics_EndPlayerSessionOptions;

/**
 * The Metrics Interface tracks your application's usage and populates the Game Analytics dashboard in the Developer Portal.
 * This data includes active, online instances of the game's client and server, and past sessions played by local players.
 * All Metrics Interface calls take a handle of type EOS_HMetrics as the first parameter.
 * This handle can be retrieved from an EOS_HPlatform handle by using the EOS_Platform_GetMetricsInterface function.
 *
 * @see EOS_Platform_Interface#getMetricsInterface()
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public class EOS_Metrics_Interface extends PointerType {
	public EOS_Metrics_Interface(Pointer address) {
		super(address);
	}
	public EOS_Metrics_Interface() {
		super();
	}

	/**
	 * Logs the start of a new game session for a local player.
	 * <p>
	 * The game client should call this function whenever it joins into a new multiplayer, peer-to-peer or single player game session.
	 * Each call to BeginPlayerSession must be matched with a corresponding call to EndPlayerSession.
	 *
	 * @param options Structure containing the local player's game account and the game session information.
	 *
	 * @return {@link EOS_EResult#EOS_Success} on success, or an error code if the input parameters are invalid or an active session for the player already exists.
	 */
	public EOS_EResult beginPlayerSession(EOS_Metrics_BeginPlayerSessionOptions options) {
		return EOSLibrary.instance.EOS_Metrics_BeginPlayerSession(this, options);
	}

	/**
	 * Logs the end of a game session for a local player.
	 * <p>
	 * Call once when the game client leaves the active game session.
	 * Each call to BeginPlayerSession must be matched with a corresponding call to EndPlayerSession.
	 *
	 * @param options Structure containing the account id of the player whose session to end.
	 *
	 * @return {@link EOS_EResult#EOS_Success} on success, or an error code if the input parameters are invalid or there was no active session for the player.
	 */
	public EOS_EResult endPlayerSession(EOS_Metrics_EndPlayerSessionOptions options) {
		return EOSLibrary.instance.EOS_Metrics_EndPlayerSession(this, options);
	}
}