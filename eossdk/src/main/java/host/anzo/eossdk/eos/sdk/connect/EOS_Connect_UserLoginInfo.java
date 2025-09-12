package host.anzo.eossdk.eos.sdk.connect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Additional information about the local user.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "DisplayName", "NsaIdToken"})
public class EOS_Connect_UserLoginInfo extends Structure {
	/** Max length of a display name, not including the terminating null. */
	public static int EOS_CONNECT_USERLOGININFO_DISPLAYNAME_MAX_LENGTH = 32;

	/** The most recent version of the EOS_Connect_UserLoginInfo struct. */
	public static int EOS_CONNECT_USERLOGININFO_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_CONNECT_USERLOGININFO_API_LATEST}. */
	public int ApiVersion;
	/**
	 * The user's display name on the identity provider systems as UTF-8 encoded null-terminated string.
	 * The length of the name can be at maximum up to EOS_CONNECT_USERLOGININFO_DISPLAYNAME_MAX_LENGTH bytes.
	 * <p>
	 * As the display name passed here is client-controlled and not part of user authentication tokens,
	 * it is only treated as non-authoritative informational data to be used by some of the feature services.
	 * For example displaying player names in Leaderboards rankings.
	 */
	public String DisplayName;

	/**
	 * Nintendo Service Account ID Token (NSA ID).
	 * <p>
	 * This field is required to be set and only used when running on the Nintendo Switch device,
	 * and the user is being authenticated using any other credential type than EOS_ECT_NINTENDO_NSA_ID_TOKEN.
	 * <p>
	 * In order to use the Lobbies and Sessions interfaces, a valid NSA ID Token is required to be provided
	 * for the active local Nintendo Switch user. Otherwise, attempting to use either of the Lobbies or
	 * Sessions interfaces will return the EOS_Permission_OnlinePlayRestricted error result.
	 */
	public String NsaIdToken;

	public EOS_Connect_UserLoginInfo() {
		super();
		ApiVersion = EOS_CONNECT_USERLOGININFO_API_LATEST;
	}

	public EOS_Connect_UserLoginInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_UserLoginInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_UserLoginInfo implements Structure.ByValue {
	}
}