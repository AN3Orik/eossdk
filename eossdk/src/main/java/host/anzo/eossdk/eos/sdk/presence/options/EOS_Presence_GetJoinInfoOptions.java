package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_Presence_GetJoinInfo function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_Presence_GetJoinInfoOptions extends Structure {
	public static int EOS_PRESENCE_GETJOININFO_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCE_GETJOININFO_API_LATEST. */
	public int ApiVersion;
	/** The local user's Epic Account ID */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID to query for join info; this value must either be a logged-in local user, or a friend of that user */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Presence_GetJoinInfoOptions() {
		super();
		ApiVersion = EOS_PRESENCE_GETJOININFO_API_LATEST;
	}

	public EOS_Presence_GetJoinInfoOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_GetJoinInfoOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_GetJoinInfoOptions implements Structure.ByValue {
	}
}