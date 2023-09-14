package host.anzo.eossdk.eos.sdk.p2p.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.p2p.callbackresults.EOS_P2P_OnIncomingPacketQueueFullInfo;

/**
 * Callback for information related to incoming connection requests.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_P2P_OnIncomingPacketQueueFullCallback extends Callback {
	void apply(EOS_P2P_OnIncomingPacketQueueFullInfo data);
}