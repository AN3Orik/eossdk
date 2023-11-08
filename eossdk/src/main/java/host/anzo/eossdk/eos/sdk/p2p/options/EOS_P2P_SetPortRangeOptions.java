package host.anzo.eossdk.eos.sdk.p2p.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about new port range settings.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "Port", "MaxAdditionalPortsToTry"})
public class EOS_P2P_SetPortRangeOptions extends Structure {
	/** The most recent version of the EOS_P2P_SetPortRange API. */
	public static final int EOS_P2P_SETPORTRANGE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_P2P_SETPORTRANGE_API_LATEST}. */
	public int ApiVersion;

	/** The ideal port to use for P2P traffic. The default value is 7777. If set to 0, the OS will choose a port. If set to 0, MaxAdditionalPortsToTry must be set to 0. */
	public short Port;
	/**
	 * The maximum amount of additional ports to try if Port is unavailable. Ports will be tried from Port to Port + MaxAdditionalPortsToTry
	 * inclusive, until one is available or we run out of ports. If no ports are available, P2P connections will fail. The default value is 99.
	 */
	public short MaxAdditionalPortsToTry;

	public EOS_P2P_SetPortRangeOptions() {
		super();
		ApiVersion = EOS_P2P_SETPORTRANGE_API_LATEST;
	}

	public EOS_P2P_SetPortRangeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_SetPortRangeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_SetPortRangeOptions implements Structure.ByValue {
	}
}