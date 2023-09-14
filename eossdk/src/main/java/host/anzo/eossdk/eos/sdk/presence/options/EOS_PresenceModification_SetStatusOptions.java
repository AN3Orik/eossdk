package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.presence.enums.EOS_Presence_EStatus;

/**
 * Data for the EOS_PresenceModification_SetStatus function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public class EOS_PresenceModification_SetStatusOptions extends Structure {
	public static final int EOS_PRESENCEMODIFICATION_SETSTATUS_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCEMODIFICATION_SETSTATUS_API_LATEST. */
	public int ApiVersion;
	/**
	 * The status of the user
	 * @see EOS_Presence_EStatus
	 */
	public int Status;

	public EOS_PresenceModification_SetStatusOptions() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_SETSTATUS_API_LATEST;
	}

	public EOS_PresenceModification_SetStatusOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_SetStatusOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_SetStatusOptions implements Structure.ByValue {
	}
}