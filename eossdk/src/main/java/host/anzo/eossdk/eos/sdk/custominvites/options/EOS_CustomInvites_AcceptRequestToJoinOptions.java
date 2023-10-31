package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserId"})
public class EOS_CustomInvites_AcceptRequestToJoinOptions extends Structure {
	/** The most recent version of the EOS_CustomInvites_AcceptRequestToJoin API. */
	public static final int EOS_CUSTOMINVITES_ACCEPTREQUESTTOJOIN_API_LATEST = 1;

	/** API Version: Set this to EOS_CUSTOMINVITES_ACCEPTREQUESTTOJOIN_API_LATEST. */
	public int ApiVersion;
	/** Local user accepting a request to join */
	public EOS_ProductUserId LocalUserId;
	/** Target user that sent original request to join */
	public EOS_ProductUserId TargetUserId;

	public EOS_CustomInvites_AcceptRequestToJoinOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_ACCEPTREQUESTTOJOIN_API_LATEST;
	}

	public EOS_CustomInvites_AcceptRequestToJoinOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_AcceptRequestToJoinOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_AcceptRequestToJoinOptions implements Structure.ByValue {
	}
}