package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionModification;
import host.anzo.eossdk.eos.sdk.sessions.EOS_Sessions_AttributeData;
import host.anzo.eossdk.eos.sdk.sessions.enums.EOS_ESessionAttributeAdvertisementType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOS_SessionModification#addAttribute(EOS_SessionModification_AddAttributeOptions)} function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "SessionAttribute", "AdvertisementType"})
public class EOS_SessionModification_AddAttributeOptions extends Structure {
	/** API Version: Set this to EOS_SESSIONMODIFICATION_ADDATTRIBUTE_API_LATEST. */
	public int ApiVersion;
	/** Key/Value pair describing the attribute to add to the session */
	public EOS_Sessions_AttributeData.ByReference SessionAttribute;
	/** Is this attribution advertised with the backend or simply stored locally */
	public EOS_ESessionAttributeAdvertisementType AdvertisementType;

	public EOS_SessionModification_AddAttributeOptions() {
		super();
	}

	public EOS_SessionModification_AddAttributeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_AddAttributeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_AddAttributeOptions implements Structure.ByValue {
	}
}