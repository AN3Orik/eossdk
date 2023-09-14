package host.anzo.eossdk.eos.sdk.presence;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * An individual presence data record that belongs to a EOS_Presence_Info object. This object is released when its parent EOS_Presence_Info object is released.
 *
 * @see EOS_Presence_Info
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "Key", "Value"})
public class EOS_Presence_DataRecord extends Structure {
	public static final int EOS_PRESENCE_DATARECORD_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCE_DATARECORD_API_LATEST. */
	public int ApiVersion;
	/** The name of this data */
	public String Key;
	/** The value of this data */
	public String Value;

	public EOS_Presence_DataRecord() {
		super();
		ApiVersion = EOS_PRESENCE_DATARECORD_API_LATEST;
	}

	public EOS_Presence_DataRecord(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_DataRecord implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_DataRecord implements Structure.ByValue {
	}
}