package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_Presence_CreatePresenceModification function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Presence_CreatePresenceModificationOptions extends Structure {
	/** The most recent version of the EOS_Presence_CreatePresenceModification API. */
	public static final int EOS_PRESENCE_CREATEPRESENCEMODIFICATION_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCE_CREATEPRESENCEMODIFICATION_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged-in user making the request */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Presence_CreatePresenceModificationOptions() {
		super();
		ApiVersion = EOS_PRESENCE_CREATEPRESENCEMODIFICATION_API_LATEST;
	}

	public EOS_Presence_CreatePresenceModificationOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_CreatePresenceModificationOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_CreatePresenceModificationOptions implements Structure.ByValue {
	}
}