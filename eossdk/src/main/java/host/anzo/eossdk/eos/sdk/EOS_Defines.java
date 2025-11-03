package host.anzo.eossdk.eos.sdk;

import host.anzo.eossdk.eos.sdk.anticheat.client.callbacks.EOS_AntiCheatClient_OnMessageToPeerCallback;
import host.anzo.eossdk.eos.sdk.anticheat.client.callbacks.EOS_AntiCheatClient_OnMessageToServerCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.callbacks.EOS_AntiCheatServer_OnMessageToClientCallback;
import host.anzo.eossdk.eos.sdk.anticheat.server.options.EOS_AntiCheatServer_BeginSessionOptions;
import host.anzo.eossdk.eos.sdk.integratedplatform.options.EOS_IntegratedPlatform_Steam_Options;
import host.anzo.eossdk.eos.sdk.rtc.EOS_RTC_Option;
import host.anzo.eossdk.eos.sdk.rtc.EOS_RTC_ParticipantMetadata;

/**
 * @author Anton Lasevich
 * @since 3/23/2024
 */
@SuppressWarnings("unused")
public class EOS_Defines {
	/** The maximum length of a Country Code */
	public static int EOS_COUNTRYCODE_MAX_LENGTH = 4;
	/** The maximum length of a Country Code buffer */
	public static int EOS_COUNTRYCODE_MAX_BUFFER_LEN = EOS_COUNTRYCODE_MAX_LENGTH + 1;
	/** The maximum length of a Locale Code */
	public static int EOS_LOCALECODE_MAX_LENGTH = 9;
	/** The maximum length of a Locale Code buffer */
	public static int EOS_LOCALECODE_MAX_BUFFER_LEN = EOS_LOCALECODE_MAX_LENGTH + 1;

	/** Max length of an invite ID */
	public static final int EOS_LOBBY_INVITEID_MAX_LENGTH = 64;

	/** The buffer size to provide to the  EOS_Lobby_GetConnectString API. */
	public static int EOS_LOBBY_GETCONNECTSTRING_BUFFER_SIZE = 256;

	/** The buffer size to provide to the EOS_Lobby_ParseConnectString API. */
	public static int EOS_LOBBY_PARSECONNECTSTRING_BUFFER_SIZE = 256;

	/** Max length of a product id, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_PRODUCTID_MAX_LENGTH = 64;

	/** Max length of a sandbox id, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_SANDBOXID_MAX_LENGTH = 64;

	/** Length of an encryption key, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_ENCRYPTIONKEY_LENGTH = 64;

	/** Max length of a deployment id, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_DEPLOYMENTID_MAX_LENGTH = 64;

	/** The maximum size of the SteamApiInterfaceVersionsArray in the {@link EOS_IntegratedPlatform_Steam_Options} struct. */
	public static int EOS_INTEGRATEDPLATFORM_STEAM_MAX_STEAMAPIINTERFACEVERSIONSARRAY_SIZE = 4096;

	/** Maximum size of an individual message provided through {@link EOS_AntiCheatClient_OnMessageToServerCallback}. */
	public static final int EOS_ANTICHEATCLIENT_ONMESSAGETOSERVERCALLBACK_MAX_MESSAGE_SIZE = 512;

	/** Maximum size of an individual message provided through {@link EOS_AntiCheatClient_OnMessageToPeerCallback}. */
	public static final int EOS_ANTICHEATCLIENT_ONMESSAGETOPEERCALLBACK_MAX_MESSAGE_SIZE = 512;

	/** Maximum size of an individual message provided through {@link EOS_AntiCheatServer_OnMessageToClientCallback}. */
	public static final int EOS_ANTICHEATSERVER_ONMESSAGETOCLIENTCALLBACK_MAX_MESSAGE_SIZE = 512;

	/** The minimum value for the RegisterTimeoutSeconds parameter in the {@link EOS_AntiCheatServer_BeginSessionOptions} struct. */
	public static final int EOS_ANTICHEATSERVER_BEGINSESSION_MIN_REGISTERTIMEOUT = 10;

	/** The maximum value for the RegisterTimeoutSeconds parameter in the {@link EOS_AntiCheatServer_BeginSessionOptions} struct. */
	public static final int EOS_ANTICHEATSERVER_BEGINSESSION_MAX_REGISTERTIMEOUT = 120;

	/** The maximum length of data chunk in bytes that can be sent and received */
	public static final int EOS_RTCDATA_MAX_PACKET_SIZE = 1170;

	/** The maximum number of lobbies a single user can join at once */
	public static final int EOS_LOBBY_MAX_LOBBIES = 16;

	/** The maximum number of players in a lobby */
	public static final int EOS_LOBBY_MAX_LOBBY_MEMBERS = 64;

	/** The maximum number of search results for a query */
	public static final int EOS_LOBBY_MAX_SEARCH_RESULTS =  200;

	/** Timestamp value representing an undefined time for Player Data Storage. */
	public static final int EOS_PLAYERDATASTORAGE_TIME_UNDEFINED = -1;

	/** An invalid ProgressionSnapshot Id. */
	public static final int EOS_INVALID_PROGRESSIONSNAPSHOTID = 0;

	/**
	 * The maximum of allowed individual pieces of data a user may have. This value is subject to change and data structures should be designed to allow for greater
	 * numbers than this.
	 */
	public static final int EOS_PRESENCE_DATA_MAX_KEYS = 32;
	/**
	 * The maximum allowed length a data's key may be. This value is subject to change and data structures should be designed to allow for greater numbers than this.
	 */
	public static final int EOS_PRESENCE_DATA_MAX_KEY_LENGTH = 64;
	/**
	 * The maximum allowed length a data's value may be. This value is subject to change and data structures should be designed to allow for greater numbers than this.
	 */
	public static final int EOS_PRESENCE_DATA_MAX_VALUE_LENGTH = 255;
	/**
	 * The maximum allowed length a user's rich text string may be. This value is subject to change and data structures should be designed to allow for greater numbers
	 * than this.
	 */
	public static final int EOS_PRESENCE_RICH_TEXT_MAX_VALUE_LENGTH = 255;
	public static final int EOS_PRESENCEMODIFICATION_JOININFO_MAX_LENGTH = EOS_PRESENCE_DATA_MAX_VALUE_LENGTH;

	/** The maximum size of the Key string in the {@link EOS_RTC_Option} struct. */
	public static final int EOS_RTC_OPTION_KEY_MAXCHARCOUNT = 256;

	/** The maximum size of the Value string in the {@link EOS_RTC_Option} struct. */
	public static final int EOS_RTC_OPTION_VALUE_MAXCHARCOUNT = 256;

	/** The maximum size of the Key string in the {@link EOS_RTC_ParticipantMetadata} struct. */
	public static final int EOS_RTC_PARTICIPANTMETADATA_KEY_MAXCHARCOUNT = 256;

	/** The maximum size of the Value string in the {@link EOS_RTC_ParticipantMetadata} struct. */
	public static final int EOS_RTC_PARTICIPANTMETADATA_VALUE_MAXCHARCOUNT = 256;

	/** Maximum number of attributes allowed on the session */
	public static int EOS_SESSIONMODIFICATION_MAX_SESSION_ATTRIBUTES = 64;
	/** Maximum length of the name of the attribute associated with the session */
	public static int EOS_SESSIONMODIFICATION_MAX_SESSION_ATTRIBUTE_LENGTH = 64;

	/** Minimum number of characters allowed in the session id override */
	public static int EOS_SESSIONMODIFICATION_MIN_SESSIONIDOVERRIDE_LENGTH = 16;
	/** Maximum number of characters allowed in the session id override */
	public static int EOS_SESSIONMODIFICATION_MAX_SESSIONIDOVERRIDE_LENGTH = 64;
}