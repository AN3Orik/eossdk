package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_Presence_CopyPresence function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_Presence_CopyPresenceOptions extends Structure {
	/** The most recent version of the EOS_Presence_CopyPresence API. */
	public static final int EOS_PRESENCE_COPYPRESENCE_API_LATEST = 3;

	/** API Version: Set this to EOS_PRESENCE_COPYPRESENCE_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local, logged-in user making the request */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user whose cached presence data you want to copy from the cache */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Presence_CopyPresenceOptions() {
		super();
		ApiVersion = EOS_PRESENCE_COPYPRESENCE_API_LATEST;
	}

	public EOS_Presence_CopyPresenceOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_CopyPresenceOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_CopyPresenceOptions implements Structure.ByValue {
	}
}