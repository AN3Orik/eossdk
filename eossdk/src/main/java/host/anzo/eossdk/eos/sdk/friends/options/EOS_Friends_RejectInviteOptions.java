package host.anzo.eossdk.eos.sdk.friends.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Friends_RejectInvite function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_Friends_RejectInviteOptions extends Structure {
	public static final int EOS_FRIENDS_REJECTINVITE_API_LATEST = 1;

	/** API Version: Set this to EOS_FRIENDS_REJECTINVITE_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged-in user who is rejecting a friends list invitation */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user who sent the friends list invitation */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Friends_RejectInviteOptions() {
		super();
		ApiVersion = EOS_FRIENDS_REJECTINVITE_API_LATEST;
	}

	public EOS_Friends_RejectInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_RejectInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_RejectInviteOptions implements Structure.ByValue {
	}
}