package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

/**
 * Data for the {@link EOSLibrary#EOS_PresenceModification_SetTemplateId} function.
 * @author Anton Lasevich
 * @since 11/03/2025
 */
@FieldOrder({"ApiVersion", "TemplateId"})
public class EOS_PresenceModification_SetTemplateIdOptions extends Structure {
	/** Most recent version of the EOS_PresenceModification_SetTemplateData API */
	public static final int EOS_PRESENCEMODIFICATION_SETTEMPLATEID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PRESENCEMODIFICATION_SETTEMPLATEID_API_LATEST}. */
	public int ApiVersion;
	/** The RichPresence Template ID. Setting this value will prevent SetRawRichText from being used on this handle */
	public String TemplateId;

	public EOS_PresenceModification_SetTemplateIdOptions() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_SETTEMPLATEID_API_LATEST;
	}

	public EOS_PresenceModification_SetTemplateIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_SetTemplateIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_SetTemplateIdOptions implements Structure.ByValue {
	}
}

