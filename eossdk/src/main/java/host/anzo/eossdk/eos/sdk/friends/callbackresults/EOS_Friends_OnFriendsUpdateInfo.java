package host.anzo.eossdk.eos.sdk.friends.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.friends.enums.EOS_EFriendsStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about a friend status update.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "TargetUserId", "PreviousStatus", "CurrentStatus"})
public class EOS_Friends_OnFriendsUpdateInfo extends Structure {
	/** Client-specified data passed into EOS_Friends_AddNotifyFriendsUpdate */
	public Pointer ClientData;
	/** The Epic Account ID of the local user who is receiving the update */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user whose status is being updated. */
	public EOS_EpicAccountId TargetUserId;

	/**
	 * The previous status of the user.
	 */
	public EOS_EFriendsStatus PreviousStatus;
	/**
	 * The current status of the user.
	 */
	public EOS_EFriendsStatus CurrentStatus;

	public EOS_Friends_OnFriendsUpdateInfo() {
		super();
	}

	public EOS_Friends_OnFriendsUpdateInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_OnFriendsUpdateInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_OnFriendsUpdateInfo implements Structure.ByValue {
	}
}