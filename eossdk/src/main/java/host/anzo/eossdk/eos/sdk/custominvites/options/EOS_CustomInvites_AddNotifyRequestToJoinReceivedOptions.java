package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_CustomInvites_AddNotifyRequestToJoinReceivedOptions extends Structure {
	/** The most recent version of the AddNotifyRequestToJoinReceived API. */
	public static final int EOS_CUSTOMINVITES_ADDNOTIFYREQUESTTOJOINRECEIVED_API_LATEST = 1;

	/** API Version: Set this to EOS_CUSTOMINVITES_ADDNOTIFYREQUESTTOJOINRECEIVED_API_LATEST. */
	public int ApiVersion;

	public EOS_CustomInvites_AddNotifyRequestToJoinReceivedOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_ADDNOTIFYREQUESTTOJOINRECEIVED_API_LATEST;
	}

	public EOS_CustomInvites_AddNotifyRequestToJoinReceivedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_AddNotifyRequestToJoinReceivedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_AddNotifyRequestToJoinReceivedOptions implements Structure.ByValue {
	}
}