package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.presence.EOS_PresenceModification_DataRecordId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_PresenceModification_DeleteData function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "RecordsCount", "Records"})
public class EOS_PresenceModification_DeleteDataOptions extends Structure {
	public static int EOS_PRESENCEMODIFICATION_DELETEDATA_API_LATEST = 1;

	/** API Version: Set this to EOS_PRESENCEMODIFICATION_DELETEDATA_API_LATEST. */
	public int ApiVersion;
	/** The count of data keys to delete */
	public int RecordsCount;
	/** The pointer to start of a sequential array */
	public EOS_PresenceModification_DataRecordId.ByReference Records;

	public EOS_PresenceModification_DeleteDataOptions() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_DELETEDATA_API_LATEST;
	}

	public EOS_PresenceModification_DeleteDataOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_DeleteDataOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_DeleteDataOptions implements Structure.ByValue {
	}
}