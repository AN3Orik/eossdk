package host.anzo.eossdk.eos.sdk;

/**
 * @author Anton Lasevich
 * @since 3/23/2024
 */
public class EOS_Defines {
	public static int EOS_INTEGRATEDPLATFORM_STEAM_MAX_STEAMAPIINTERFACEVERSIONSARRAY_SIZE = 4096;

	/**
	 * Maximum size of an individual message provided through EOS_AntiCheatClient_OnMessageToServerCallback.
	 */
	public static final int EOS_ANTICHEATCLIENT_ONMESSAGETOSERVERCALLBACK_MAX_MESSAGE_SIZE = 512;

	/**
	 * Maximum size of an individual message provided through EOS_AntiCheatClient_OnMessageToPeerCallback.
	 */
	public static final int EOS_ANTICHEATCLIENT_ONMESSAGETOPEERCALLBACK_MAX_MESSAGE_SIZE = 512;

	/**
	 * Maximum size of an individual message provided through EOS_AntiCheatServer_OnMessageToClientCallback.
	 */
	public static final int EOS_ANTICHEATSERVER_ONMESSAGETOCLIENTCALLBACK_MAX_MESSAGE_SIZE = 512;

	/** Limits on RegisterTimeoutSeconds parameter */
	public static final int EOS_ANTICHEATSERVER_BEGINSESSION_MIN_REGISTERTIMEOUT = 10;
	public static final int EOS_ANTICHEATSERVER_BEGINSESSION_MAX_REGISTERTIMEOUT = 120;

	/** The maximum length of data chunk in bytes that can be sent and received */
	public static final int EOS_RTCDATA_MAX_PACKET_SIZE = 1170;
}