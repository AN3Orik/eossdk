package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails_Attribute;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionModification;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOS_SessionDetails#copySessionAttributeByKey(EOS_SessionDetails_CopySessionAttributeByKeyOptions, EOS_SessionDetails_Attribute[])} function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "AttrKey"})
public class EOS_SessionDetails_CopySessionAttributeByKeyOptions extends Structure {
	public static final int EOS_SESSIONDETAILS_COPYSESSIONATTRIBUTEBYKEY_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONDETAILS_COPYSESSIONATTRIBUTEBYKEY_API_LATEST. */
	public int ApiVersion;
	/** The name of the key to get the session attribution for
	 * @see EOS_SessionModification#addAttribute(EOS_SessionModification_AddAttributeOptions)
	 */
	public String AttrKey;

	public EOS_SessionDetails_CopySessionAttributeByKeyOptions() {
		super();
		ApiVersion = EOS_SESSIONDETAILS_COPYSESSIONATTRIBUTEBYKEY_API_LATEST;
	}

	public EOS_SessionDetails_CopySessionAttributeByKeyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionDetails_CopySessionAttributeByKeyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionDetails_CopySessionAttributeByKeyOptions implements Structure.ByValue {
	}
}