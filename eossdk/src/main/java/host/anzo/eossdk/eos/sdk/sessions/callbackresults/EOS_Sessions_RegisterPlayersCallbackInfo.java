package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ResultCode", "ClientData", "RegisteredPlayers", "RegisteredPlayersCount", "SanctionedPlayers", "SanctionedPlayersCount"})
public class EOS_Sessions_RegisterPlayersCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the register completes successfully<br>
	 * {@link EOS_EResult#EOS_NoChange} if the players to register registered previously<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_Sessions_OutOfSync} if the session is out of sync and will be updated on the next connection with the backend<br>
	 * {@link EOS_EResult#EOS_NotFound} if a session to register players does not exist<br>
	 * {@link EOS_EResult#EOS_LimitExceeded} if registering the requested players would drive the total number of registered players beyond EOS_SESSIONS_MAXREGISTEREDPLAYERS (API Version {@literal <=} 2)<br>
	 * {@link EOS_EResult#EOS_Sessions_TooManyPlayers} if registering the requested players would drive the total number of registered players beyond EOS_SESSIONS_MAXREGISTEREDPLAYERS (API Version {@literal >} 2)
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Sessions_RegisterPlayers */
	public Pointer ClientData;
	/** The players that were successfully registered */
	public EOS_ProductUserId RegisteredPlayers; // TODO: Array
	/** The number of players successfully registered */
	public int RegisteredPlayersCount;
	/** The players that failed to register because they are sanctioned */
	public EOS_ProductUserId SanctionedPlayers; // TODO: Array
	/** The number of players that failed to register because they are sanctioned */
	public int SanctionedPlayersCount;

	public EOS_Sessions_RegisterPlayersCallbackInfo() {
		super();
	}

	public EOS_Sessions_RegisterPlayersCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_RegisterPlayersCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_RegisterPlayersCallbackInfo implements Structure.ByValue {
	}
}