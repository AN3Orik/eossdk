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
public class EOS_CustomInvites_RejectRequestToJoinOptions extends Structure {
	public static final int  EOS_CUSTOMINVITES_REJECTREQUESTTOJOIN_API_LATEST = 1;

	/** API Version: Set this to EOS_CUSTOMINVITES_REJECTREQUESTTOJOIN_API_LATEST. */
	public int ApiVersion;
	/** Local user declining an invite request */
	public EOS_ProductUserId LocalUserId;
	/** Target user that sent original invite request */
	public EOS_ProductUserId TargetUserId;

	public EOS_CustomInvites_RejectRequestToJoinOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_REJECTREQUESTTOJOIN_API_LATEST;
	}

	public EOS_CustomInvites_RejectRequestToJoinOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_RejectRequestToJoinOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_RejectRequestToJoinOptions implements Structure.ByValue {
	}
}