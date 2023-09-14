package host.anzo.eossdk.eos.sdk.friends.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Friends_RejectInvite Function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_Friends_RejectInviteCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned if an invite was accepted, otherwise one of the error codes is returned. See eos_common.h */
	public EOS_EResult ResultCode;
	/** Context that is passed into EOS_Friends_RejectInvite */
	public Pointer ClientData;
	/** The Epic Account ID of the user who is rejecting the friends list invitation */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user who sent the friends list invitation */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Friends_RejectInviteCallbackInfo() {
		super();
	}

	public EOS_Friends_RejectInviteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_RejectInviteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_RejectInviteCallbackInfo implements Structure.ByValue {
	}
}