package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_CreateLobbyOptions;
import host.anzo.eossdk.eos.sdk.lobby.options.EOS_Lobby_JoinLobbyOptions;
import host.anzo.eossdk.eos.sdk.presence.options.EOS_PresenceModification_SetJoinInfoOptions;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_JoinSession function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "SessionName", "SessionHandle", "LocalUserId", "IsPresenceEnabled"})
public class EOS_Sessions_JoinSessionOptions extends Structure {
	public static final int EOS_SESSIONS_JOINSESSION_API_LATEST = 2;

	/** API Version: Set this to EOS_SESSIONS_JOINSESSION_API_LATEST. */
	public int ApiVersion;
	/** Name of the session to create after joining session */
	public String SessionName;
	/** Session handle to join */
	public EOS_SessionDetails SessionHandle;
	/** The Product User ID of the local user who is joining the session */
	public EOS_ProductUserId LocalUserId;
	/**
	 * Determines whether or not this session should be the one associated with the local user's presence information.
	 * If true, this session will be associated with presence. Only one session at a time can have this flag true.
	 * This affects the ability of the Social Overlay to show game related actions to take in the user's social graph.<br>
	 * <b>The Social Overlay can handle only one of the following three options at a time:</b>
	 * <ul>
	 * <li>using the bPresenceEnabled flags within the Sessions interface
	 * <li>using the bPresenceEnabled flags within the Lobby interface
	 * <li>using EOS_PresenceModification_SetJoinInfo
	 * </ul>
	 * @see EOS_PresenceModification_SetJoinInfoOptions
	 * @see EOS_Lobby_CreateLobbyOptions
	 * @see EOS_Lobby_JoinLobbyOptions
	 * @see EOS_Sessions_CreateSessionModificationOptions
	 */
	public EOS_Bool IsPresenceEnabled;

	public EOS_Sessions_JoinSessionOptions() {
		super();
		ApiVersion = EOS_SESSIONS_JOINSESSION_API_LATEST;
	}

	public EOS_Sessions_JoinSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_JoinSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_JoinSessionOptions implements Structure.ByValue {
	}
}