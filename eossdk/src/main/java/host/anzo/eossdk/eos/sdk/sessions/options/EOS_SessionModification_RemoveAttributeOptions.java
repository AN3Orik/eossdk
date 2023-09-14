package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionModification_RemoveAttribute function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "Key"})
public class EOS_SessionModification_RemoveAttributeOptions extends Structure {
	public static final int EOS_SESSIONMODIFICATION_REMOVEATTRIBUTE_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONMODIFICATION_REMOVEATTRIBUTE_API_LATEST. */
	public int ApiVersion;
	/** Session attribute to remove from the session */
	public String Key;

	public EOS_SessionModification_RemoveAttributeOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_REMOVEATTRIBUTE_API_LATEST;
	}

	public EOS_SessionModification_RemoveAttributeOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_RemoveAttributeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_RemoveAttributeOptions implements Structure.ByValue {
	}
}