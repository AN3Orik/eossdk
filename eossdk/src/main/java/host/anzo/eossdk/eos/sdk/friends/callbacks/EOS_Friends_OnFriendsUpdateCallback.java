package host.anzo.eossdk.eos.sdk.friends.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.sdk.friends.callbackresults.EOS_Friends_OnFriendsUpdateInfo;

/**
 * Callback for information related to a friend status update.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public interface EOS_Friends_OnFriendsUpdateCallback extends Callback {
	void apply(EOS_Friends_OnFriendsUpdateInfo data);
}