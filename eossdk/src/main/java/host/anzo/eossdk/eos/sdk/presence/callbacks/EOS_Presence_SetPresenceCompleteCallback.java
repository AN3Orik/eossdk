package host.anzo.eossdk.eos.sdk.presence.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.presence.callbackresults.EOS_Presence_SetPresenceCallbackInfo;

/**
 * Callback for information related to EOS_Presence_SetPresence finishing.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_Presence_SetPresenceCompleteCallback extends Callback {
	void apply(EOS_Presence_SetPresenceCallbackInfo Data);
}