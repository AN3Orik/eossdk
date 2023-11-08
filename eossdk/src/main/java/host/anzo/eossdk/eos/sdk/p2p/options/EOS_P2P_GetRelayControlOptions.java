package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about getting the relay control setting.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_P2P_GetRelayControlOptions extends Structure {
	/** The most recent version of the EOS_P2P_GetRelayControl API. */
	public static final int EOS_P2P_GETRELAYCONTROL_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_P2P_GETRELAYCONTROL_API_LATEST}. */
	public int ApiVersion;

	public EOS_P2P_GetRelayControlOptions() {
		super();
		ApiVersion = EOS_P2P_GETRELAYCONTROL_API_LATEST;
	}

	public EOS_P2P_GetRelayControlOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_GetRelayControlOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_GetRelayControlOptions implements Structure.ByValue {
	}
}