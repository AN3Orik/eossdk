package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Payload"})
public class EOS_CustomInvites_SetCustomInviteOptions extends Structure {
	public static final int EOS_CUSTOMINVITES_SETCUSTOMINVITE_API_LATEST = 1;

	/** API Version: Set this to EOS_CUSTOMINVITES_SETCUSTOMINVITE_API_LATEST. */
	public int ApiVersion;
	/** Local user creating / sending a Custom Invite */
	public EOS_ProductUserId LocalUserId;
	/** String payload for the Custom Invite (must be less than EOS_CUSTOMINVITES_MAX_PAYLOAD_LENGTH) */
	public String Payload;

	public EOS_CustomInvites_SetCustomInviteOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_SETCUSTOMINVITE_API_LATEST;
	}

	public EOS_CustomInvites_SetCustomInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_SetCustomInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_SetCustomInviteOptions implements Structure.ByValue {
	}
}