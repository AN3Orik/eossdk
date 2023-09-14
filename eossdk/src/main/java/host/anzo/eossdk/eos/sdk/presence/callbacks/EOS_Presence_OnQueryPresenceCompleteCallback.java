package host.anzo.eossdk.eos.sdk.presence.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.presence.callbackresults.EOS_Presence_QueryPresenceCallbackInfo;

/**
 * Callback for information related to EOS_Presence_QueryPresence finishing.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_Presence_OnQueryPresenceCompleteCallback extends Callback {
	void apply(EOS_Presence_QueryPresenceCallbackInfo data);
}