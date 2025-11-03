package host.anzo.eossdk.eos.sdk.sessions.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the {@link EOSLibrary#EOS_Sessions_RegisterPlayers} function.
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
	public Pointer RegisteredPlayers;
	/** The number of players successfully registered */
	public int RegisteredPlayersCount;
	/** The players that failed to register because they are sanctioned */
	public Pointer SanctionedPlayers;
	/** The number of players that failed to register because they are sanctioned */
	public int SanctionedPlayersCount;

	public EOS_Sessions_RegisterPlayersCallbackInfo() {
		super();
	}

	public EOS_Sessions_RegisterPlayersCallbackInfo(Pointer peer) {
		super(peer);
	}

	/**
	 * @return list of registered players
	 */
	public List<EOS_ProductUserId> getRegisteredPlayers() {
		if (RegisteredPlayers == null || RegisteredPlayersCount == 0) {
			return Collections.emptyList();
		}
		final Pointer[] pointers = RegisteredPlayers.getPointerArray(0, RegisteredPlayersCount);
		final List<EOS_ProductUserId> players = new ArrayList<>(RegisteredPlayersCount);
		for (Pointer p : pointers) {
			EOS_ProductUserId userId = new EOS_ProductUserId();
			userId.setPointer(p);
			players.add(userId);
		}
		return players;
	}

	/**
	 * @return list of sanctioned players
	 */
	public List<EOS_ProductUserId> getSanctionedPlayers() {
		if (SanctionedPlayers == null || SanctionedPlayersCount == 0) {
			return Collections.emptyList();
		}
		final Pointer[] pointers = SanctionedPlayers.getPointerArray(0, SanctionedPlayersCount);
		final List<EOS_ProductUserId> players = new ArrayList<>(SanctionedPlayersCount);
		for (Pointer p : pointers) {
			EOS_ProductUserId userId = new EOS_ProductUserId();
			userId.setPointer(p);
			players.add(userId);
		}
		return players;
	}

	public static class ByReference extends EOS_Sessions_RegisterPlayersCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_RegisterPlayersCallbackInfo implements Structure.ByValue {
	}
}