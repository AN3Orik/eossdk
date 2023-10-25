package host.anzo.eossdk.eos.sdk.friends.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Friends_GetStatus function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_Friends_GetStatusOptions extends Structure {
	/** The most recent version of the EOS_Friends_GetStatus API. */
	public static final int EOS_FRIENDS_GETSTATUS_API_LATEST = 1;

	/** API Version: Set this to EOS_FRIENDS_GETSTATUS_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged in user */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user whose friendship status with the local user is being queried */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Friends_GetStatusOptions() {
		super();
		ApiVersion = EOS_FRIENDS_GETSTATUS_API_LATEST;
	}

	public EOS_Friends_GetStatusOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_GetStatusOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_GetStatusOptions implements Structure.ByValue {
	}
}