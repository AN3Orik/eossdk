package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_CustomInvites_AddNotifyCustomInviteAcceptedOptions extends Structure {
	/** The most recent version of the EOS_CustomInvites_AddNotifyCustomInviteAccepted API. */
	public static final int EOS_CUSTOMINVITES_ADDNOTIFYCUSTOMINVITEACCEPTED_API_LATEST = 1;

	/** API Version: Set this to EOS_CUSTOMINVITES_ADDNOTIFYCUSTOMINVITEACCEPTED_API_LATEST. */
	public int ApiVersion;

	public EOS_CustomInvites_AddNotifyCustomInviteAcceptedOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_ADDNOTIFYCUSTOMINVITEACCEPTED_API_LATEST;
	}

	public EOS_CustomInvites_AddNotifyCustomInviteAcceptedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_AddNotifyCustomInviteAcceptedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_AddNotifyCustomInviteAcceptedOptions implements Structure.ByValue {
	}
}