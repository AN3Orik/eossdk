package host.anzo.eossdk.eos.sdk.friends.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.friends.callbackresults.EOS_Friends_OnBlockedUsersUpdateInfo;

/**
 * Callback for information related to a blocklist update.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_Friends_OnBlockedUsersUpdateCallback extends Callback {
	void apply(EOS_Friends_OnBlockedUsersUpdateInfo data);
}