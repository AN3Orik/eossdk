package host.anzo.eossdk.eos.sdk.presence;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for identifying which data records should be deleted.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "Key"})
public class EOS_PresenceModification_DataRecordId extends Structure {
	public static final int EOS_PRESENCEMODIFICATION_DATARECORDID_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCEMODIFICATION_DATARECORDID_API_LATEST. */
	public int ApiVersion;
	/** The key to be deleted from the data record */
	public String Key;

	public EOS_PresenceModification_DataRecordId() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_DATARECORDID_API_LATEST;
	}

	public EOS_PresenceModification_DataRecordId(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_DataRecordId implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_DataRecordId implements Structure.ByValue {
	}
}