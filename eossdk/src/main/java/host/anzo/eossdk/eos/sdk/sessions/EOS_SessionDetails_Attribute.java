package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.sessions.enums.EOS_ESessionAttributeAdvertisementType;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_SessionDetails_CopySessionAttributeByIndexOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * An attribution value and its advertisement setting stored with a session.
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "Data", "AdvertisementType"})
public class EOS_SessionDetails_Attribute extends Structure implements AutoCloseable {
	public static final int EOS_SESSIONDETAILS_ATTRIBUTE_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONDETAILS_ATTRIBUTE_API_LATEST. */
	public int ApiVersion;
	/** Key/Value pair describing the attribute */
	public EOS_Sessions_AttributeData.ByReference Data;
	/** Is this attribution advertised with the backend or simply stored locally */
	public EOS_ESessionAttributeAdvertisementType AdvertisementType;

	public EOS_SessionDetails_Attribute() {
		super();
		ApiVersion = EOS_SESSIONDETAILS_ATTRIBUTE_API_LATEST;
	}

	public EOS_SessionDetails_Attribute(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with a session attribute. This must be called on data retrieved from EOS_SessionDetails_CopySessionAttributeByIndex.
	 * @see EOS_SessionDetails#copySessionAttributeByIndex(EOS_SessionDetails_CopySessionAttributeByIndexOptions, EOS_SessionDetails_Attribute[])
	 */
	public void release() {
		EOSLibrary.instance.EOS_SessionDetails_Attribute_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_SessionDetails_Attribute implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionDetails_Attribute implements Structure.ByValue {
	}
}