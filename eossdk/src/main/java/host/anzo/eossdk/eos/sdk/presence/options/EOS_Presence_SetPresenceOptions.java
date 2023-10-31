package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.presence.EOS_PresenceModification;

/**
 * Data for the EOS_Presence_SetPresence function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "PresenceModificationHandle"})
public class EOS_Presence_SetPresenceOptions extends Structure {
	/** The most recent version of the EOS_Presence_SetPresence API. */
	public static final int EOS_PRESENCE_SETPRESENCE_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCE_SETPRESENCE_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged-in user making the request */
	public EOS_EpicAccountId LocalUserId;
	/** The handle to the presence update */
	public EOS_PresenceModification PresenceModificationHandle;

	public EOS_Presence_SetPresenceOptions() {
		super();
		ApiVersion = EOS_PRESENCE_SETPRESENCE_API_LATEST;
	}

	public EOS_Presence_SetPresenceOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_SetPresenceOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_SetPresenceOptions implements Structure.ByValue {
	}
}