package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientPlatform;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientType;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "PeerHandle", "ClientType", "ClientPlatform", "AuthenticationTimeout", "AccountId_DEPRECATED", "IpAddress", "PeerProductUserId"})
public class EOS_AntiCheatClient_RegisterPeerOptions extends Structure {
	/**
	 * A special peer handle that represents the client itself.
	 * It does not need to be registered or unregistered and is
	 * used in OnPeerActionRequiredCallback to quickly signal to the user
	 * that they will not be able to join online play.
	 */
	public static final EOS_AntiCheatCommon_ClientHandle EOS_ANTICHEATCLIENT_PEER_SELF = new EOS_AntiCheatCommon_ClientHandle(-1);
	public static final int EOS_ANTICHEATCLIENT_REGISTERPEER_MIN_AUTHENTICATIONTIMEOUT = 40;
	public static final int EOS_ANTICHEATCLIENT_REGISTERPEER_MAX_AUTHENTICATIONTIMEOUT = 120;
	public static final int EOS_ANTICHEATCLIENT_REGISTERPEER_API_LATEST = 3;

	/** API Version: Set this to EOS_ANTICHEATCLIENT_REGISTERPEER_API_LATEST. */
	public int ApiVersion;
	/** Locally unique value describing the remote user (e.g. a player object pointer) */
	public EOS_AntiCheatCommon_ClientHandle PeerHandle;
	/** Type of remote user being registered */
	public EOS_EAntiCheatCommonClientType ClientType;
	/** Remote user's platform, if known */
	public EOS_EAntiCheatCommonClientPlatform ClientPlatform;
	/**
	 * Time in seconds to allow newly registered peers to send the initial message containing their token.
	 * Recommended value: 60
	 */
	public int AuthenticationTimeout;
	/** Deprecated - use PeerProductUserId instead */
	public String AccountId_DEPRECATED;
	/**
	 * Optional IP address for the remote user. May be null if not available.
	 * IPv4 format: "0.0.0.0"
	 * IPv6 format: "0:0:0:0:0:0:0:0"
	 */
	public String IpAddress;
	/** EOS_ProductUserId Identifier for the remote user */
	public EOS_ProductUserId PeerProductUserId;

	public EOS_AntiCheatClient_RegisterPeerOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_REGISTERPEER_API_LATEST;
	}

	public EOS_AntiCheatClient_RegisterPeerOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_RegisterPeerOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_RegisterPeerOptions implements Structure.ByValue {
	}
}