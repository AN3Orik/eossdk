package host.anzo.eossdk.eos.sdk.p2p.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_ENATType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about the local network NAT type
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "ClientData", "NATType"})
public class EOS_P2P_OnQueryNATTypeCompleteInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned for a successful query, other codes indicate an error */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_P2P_QueryNATType */
	public Pointer ClientData;
	/**
	 * The queried NAT type
	 */
	public EOS_ENATType NATType;

	public EOS_P2P_OnQueryNATTypeCompleteInfo() {
		super();
	}

	public EOS_P2P_OnQueryNATTypeCompleteInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_P2P_OnQueryNATTypeCompleteInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_P2P_OnQueryNATTypeCompleteInfo implements Structure.ByValue {
	}
}