package host.anzo.eossdk.eos.sdk.kws.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_KWS_AddNotifyPermissionsUpdateReceivedOptions extends Structure {
	/** The most recent version of the EOS_KWS_AddNotifyPermissionsUpdateReceived API. */
	public static final int EOS_KWS_ADDNOTIFYPERMISSIONSUPDATERECEIVED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_KWS_ADDNOTIFYPERMISSIONSUPDATERECEIVED_API_LATEST}. */
	public int ApiVersion;

	public EOS_KWS_AddNotifyPermissionsUpdateReceivedOptions() {
		super();
		ApiVersion = EOS_KWS_ADDNOTIFYPERMISSIONSUPDATERECEIVED_API_LATEST;
	}

	public EOS_KWS_AddNotifyPermissionsUpdateReceivedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_AddNotifyPermissionsUpdateReceivedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_AddNotifyPermissionsUpdateReceivedOptions implements Structure.ByValue {
	}
}