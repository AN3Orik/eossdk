package host.anzo.eossdk.eos.sdk.p2p.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.p2p.callbackresults.EOS_P2P_OnQueryNATTypeCompleteInfo;

/**
 * Callback for information related to our NAT type query completing.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_P2P_OnQueryNATTypeCompleteCallback extends Callback {
	void apply(EOS_P2P_OnQueryNATTypeCompleteInfo Data);
}