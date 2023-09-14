package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_CustomInvites_AddNotifyCustomInviteReceivedOptions extends Structure {
	public static final int EOS_CUSTOMINVITES_ADDNOTIFYCUSTOMINVITERECEIVED_API_LATEST = 1;

	/** API Version: Set this to EOS_CUSTOMINVITES_ADDNOTIFYCUSTOMINVITERECEIVED_API_LATEST. */
	public int ApiVersion;

	public EOS_CustomInvites_AddNotifyCustomInviteReceivedOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_ADDNOTIFYCUSTOMINVITERECEIVED_API_LATEST;
	}

	public EOS_CustomInvites_AddNotifyCustomInviteReceivedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_AddNotifyCustomInviteReceivedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_AddNotifyCustomInviteReceivedOptions implements Structure.ByValue {
	}
}