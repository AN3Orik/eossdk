package host.anzo.eossdk.eos.sdk.friends.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Friends_AcceptInvite function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_Friends_AcceptInviteOptions extends Structure {
	/** The most recent version of the EOS_Friends_AcceptInvite API. */
	public static final int EOS_FRIENDS_ACCEPTINVITE_API_LATEST = 1;

	/** API Version: Set this to EOS_FRIENDS_ACCEPTINVITE_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged-in user who is accepting the friends list invitation */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user who sent the friends list invitation */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Friends_AcceptInviteOptions() {
		super();
		ApiVersion = EOS_FRIENDS_ACCEPTINVITE_API_LATEST;
	}

	public EOS_Friends_AcceptInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_AcceptInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_AcceptInviteOptions implements Structure.ByValue {
	}
}