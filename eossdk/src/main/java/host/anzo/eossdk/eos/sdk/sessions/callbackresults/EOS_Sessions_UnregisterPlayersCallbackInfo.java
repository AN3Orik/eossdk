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
 * Output parameters for the {@link EOSLibrary#EOS_Sessions_UnregisterPlayers} function.
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ResultCode", "ClientData", "UnregisteredPlayers", "UnregisteredPlayersCount"})
public class EOS_Sessions_UnregisterPlayersCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the unregister completes successfully<br>
	 * {@link EOS_EResult#EOS_NoChange} if the players to unregister were not found<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect<br>
	 * {@link EOS_EResult#EOS_Sessions_OutOfSync} if the session is out of sync and will be updated on the next connection with the backendv
	 * {@link EOS_EResult#EOS_NotFound} if a session to be unregister players does not exist
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Sessions_UnregisterPlayers */
	public Pointer ClientData;
	/** The players that successfully unregistered */
	public Pointer UnregisteredPlayers;
	/** The number of players that successfully unregistered */
	public int UnregisteredPlayersCount;

	public EOS_Sessions_UnregisterPlayersCallbackInfo() {
		super();
	}

	public EOS_Sessions_UnregisterPlayersCallbackInfo(Pointer peer) {
		super(peer);
	}

	/**
	 * @return list of unregistered players
	 */
	public List<EOS_ProductUserId> getUnregisteredPlayers() {
		if (UnregisteredPlayers == null || UnregisteredPlayersCount == 0) {
			return Collections.emptyList();
		}
		final Pointer[] pointers = UnregisteredPlayers.getPointerArray(0, UnregisteredPlayersCount);
		final List<EOS_ProductUserId> players = new ArrayList<>(UnregisteredPlayersCount);
		for (Pointer p : pointers) {
			EOS_ProductUserId userId = new EOS_ProductUserId();
			userId.setPointer(p);
			players.add(userId);
		}
		return players;
	}

	public static class ByReference extends EOS_Sessions_UnregisterPlayersCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_UnregisterPlayersCallbackInfo implements Structure.ByValue {
	}
}