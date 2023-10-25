package host.anzo.eossdk.eos.sdk.friends.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information about a blocklist update.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "TargetUserId", "IsBlocked"})
public class EOS_Friends_OnBlockedUsersUpdateInfo extends Structure {
	/** Client-specified data passed into EOS_Friends_AddNotifyBlockedUsersUpdate */
	public Pointer ClientData;
	/** The Epic Account ID of the local user who is receiving the update */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user whose blocked status is being updated. */
	public EOS_EpicAccountId TargetUserId;
	/** TargetUserId block status (blocked or not). */
	public EOS_Bool IsBlocked;

	public EOS_Friends_OnBlockedUsersUpdateInfo() {
		super();
	}

	public EOS_Friends_OnBlockedUsersUpdateInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_OnBlockedUsersUpdateInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_OnBlockedUsersUpdateInfo implements Structure.ByValue {
	}
}