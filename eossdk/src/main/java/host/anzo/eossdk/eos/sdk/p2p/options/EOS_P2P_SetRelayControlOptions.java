package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_ERelayControl;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about new relay configurations.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "RelayControl"})
public class EOS_P2P_SetRelayControlOptions extends Structure {
	/** The most recent version of the EOS_P2P_SetRelayControl API. */
	public static final int EOS_P2P_SETRELAYCONTROL_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_SETRELAYCONTROL_API_LATEST. */
	public int ApiVersion;
	/**
	 * The requested level of relay servers for P2P connections. This setting is only applied to new P2P connections, or when existing P2P connections
	 * reconnect during a temporary connectivity outage. Peers with an incompatible setting to the local setting will not be able to connect.
	 */
	public EOS_ERelayControl RelayControl;

	public EOS_P2P_SetRelayControlOptions() {
		super();
		ApiVersion = EOS_P2P_SETRELAYCONTROL_API_LATEST;
	}

	public EOS_P2P_SetRelayControlOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_SetRelayControlOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_SetRelayControlOptions implements Structure.ByValue {
	}
}