package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_CreateLobbyOptions;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_JoinLobbyOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_Sessions_CreateSessionModificationOptions;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_Sessions_JoinSessionOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_PresenceModification_SetJoinInfo function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "JoinInfo"})
public class EOS_PresenceModification_SetJoinInfoOptions extends Structure {
	/** The most recent version of the EOS_PresenceModification_SetJoinInfo API. */
	public static final int EOS_PRESENCEMODIFICATION_SETJOININFO_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PRESENCEMODIFICATION_SETJOININFO_API_LATEST}. */
	public int ApiVersion;
	/**
	 * The string which will be advertised as this player's join info.
	 * An application is expected to freely define the meaning of this string to use for connecting to an active game session.
	 * The string should not exceed EOS_PRESENCEMODIFICATION_JOININFO_MAX_LENGTH in length.
	 * This affects the ability of the Social Overlay to show game related actions to take in the player's social graph.<br>
	 * <b>The Social Overlay can handle only one of the following three options at a time:</b>
	 * <ul>
	 * <li>using the bPresenceEnabled flags within the Sessions interface
	 * <li>using the bPresenceEnabled flags within the Lobby interface
	 * <li>using EOS_PresenceModification_SetJoinInfo
	 * </ul>
	 * @see EOS_Lobby_CreateLobbyOptions
	 * @see EOS_Lobby_JoinLobbyOptions
	 * @see EOS_Sessions_CreateSessionModificationOptions
	 * @see EOS_Sessions_JoinSessionOptions
	 */
	public String JoinInfo;

	public EOS_PresenceModification_SetJoinInfoOptions() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_SETJOININFO_API_LATEST;
	}

	public EOS_PresenceModification_SetJoinInfoOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_SetJoinInfoOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_SetJoinInfoOptions implements Structure.ByValue {
	}
}