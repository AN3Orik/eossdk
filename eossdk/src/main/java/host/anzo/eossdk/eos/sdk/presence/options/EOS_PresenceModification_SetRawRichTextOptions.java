package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_PresenceModification_SetRawRichText API.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "RichText"})
public class EOS_PresenceModification_SetRawRichTextOptions extends Structure {
	/** The most recent version of the EOS_PresenceModification_SetRawRichText function. */
	public static final int EOS_PRESENCEMODIFICATION_SETRAWRICHTEXT_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCEMODIFICATION_SETRAWRICHTEXT_API_LATEST. */
	public int ApiVersion;
	/** The status of the user */
	public String RichText;

	public EOS_PresenceModification_SetRawRichTextOptions() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_SETRAWRICHTEXT_API_LATEST;
	}

	public EOS_PresenceModification_SetRawRichTextOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_SetRawRichTextOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_SetRawRichTextOptions implements Structure.ByValue {
	}
}
