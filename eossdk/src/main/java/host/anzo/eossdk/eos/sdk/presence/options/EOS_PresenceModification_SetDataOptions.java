package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.presence.EOS_Presence_DataRecord;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_PresenceModification_SetData function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "RecordsCount", "Records"})
public class EOS_PresenceModification_SetDataOptions extends Structure {
	/** The most recent version of the EOS_PresenceModification_SetData API. */
	public static final int EOS_PRESENCEMODIFICATION_SETDATA_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PRESENCEMODIFICATION_SETDATA_API_LATEST}. */
	public int ApiVersion;
	/** The count of records to set */
	public int RecordsCount;
	/** The pointer to start of a sequential array of Presence DataRecords */
	public EOS_Presence_DataRecord.ByReference Records;

	public EOS_PresenceModification_SetDataOptions() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_SETDATA_API_LATEST;
	}

	public EOS_PresenceModification_SetDataOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_SetDataOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_SetDataOptions implements Structure.ByValue {
	}
}