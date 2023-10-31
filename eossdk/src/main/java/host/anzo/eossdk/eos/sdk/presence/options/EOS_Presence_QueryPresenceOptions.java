package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_Presence_QueryPresence function
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_Presence_QueryPresenceOptions extends Structure {
	/** The most recent version of the EOS_Presence_QueryPresence API. */
	public static final int EOS_PRESENCE_QUERYPRESENCE_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCE_QUERYPRESENCE_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged-in user making the request */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user whose presence data you want to retrieve; this value must be either the user making the request, or a friend of that user */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Presence_QueryPresenceOptions() {
		super();
		ApiVersion = EOS_PRESENCE_QUERYPRESENCE_API_LATEST;
	}

	public EOS_Presence_QueryPresenceOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_QueryPresenceOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_QueryPresenceOptions implements Structure.ByValue {
	}
}