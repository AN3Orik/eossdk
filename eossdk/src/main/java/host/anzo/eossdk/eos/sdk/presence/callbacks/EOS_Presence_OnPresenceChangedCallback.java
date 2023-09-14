package host.anzo.eossdk.eos.sdk.presence.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.presence.callbackresults.EOS_Presence_PresenceChangedCallbackInfo;

/**
 * Callback for information related to notifications from EOS_Presence_AddNotifyOnPresenceChanged triggering.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public interface EOS_Presence_OnPresenceChangedCallback extends Callback {
	void apply(EOS_Presence_PresenceChangedCallbackInfo Data);
}