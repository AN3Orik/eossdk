package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionDetails_Attribute;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOS_SessionDetails#copySessionAttributeByIndex(EOS_SessionDetails_CopySessionAttributeByIndexOptions)} function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "AttrIndex"})
public class EOS_SessionDetails_CopySessionAttributeByIndexOptions extends Structure {
	/** The most recent version of the EOS_SessionDetails_CopySessionAttributeByIndex API. */
	public static final int EOS_SESSIONDETAILS_COPYSESSIONATTRIBUTEBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONDETAILS_COPYSESSIONATTRIBUTEBYINDEX_API_LATEST. */
	public int ApiVersion;
	/**
	 * The index of the attribute to retrieve
	 * @see EOS_SessionDetails#getSessionAttributeCount(EOS_SessionDetails_GetSessionAttributeCountOptions)
	 */
	public int AttrIndex;

	public EOS_SessionDetails_CopySessionAttributeByIndexOptions() {
		super();
		ApiVersion = EOS_SESSIONDETAILS_COPYSESSIONATTRIBUTEBYINDEX_API_LATEST;
	}

	public EOS_SessionDetails_CopySessionAttributeByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionDetails_CopySessionAttributeByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionDetails_CopySessionAttributeByIndexOptions implements Structure.ByValue {
	}
}