package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information needed to query NAT-types
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_P2P_QueryNATTypeOptions extends Structure {
	/** The most recent version of the EOS_P2P_QueryNATType API. */
	public static final int EOS_P2P_QUERYNATTYPE_API_LATEST = 1;

	/** API Version: Set this to EOS_P2P_QUERYNATTYPE_API_LATEST. */
	public int ApiVersion;

	public EOS_P2P_QueryNATTypeOptions() {
		super();
		ApiVersion = EOS_P2P_QUERYNATTYPE_API_LATEST;
	}

	public EOS_P2P_QueryNATTypeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_QueryNATTypeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_QueryNATTypeOptions implements Structure.ByValue {
	}
}
