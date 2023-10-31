package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_CustomInvites_SendCustomInvite function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetUserIds", "TargetUserIdsCount"})
public class EOS_CustomInvites_SendCustomInviteOptions extends Structure {
	/** The most recent version of the EOS_CustomInvites_SendCustomInvite API. */
	public static final int EOS_CUSTOMINVITES_SENDCUSTOMINVITE_API_LATEST = 1;

	/** API Version: Set this to EOS_CUSTOMINVITES_SENDCUSTOMINVITE_API_LATEST. */
	public int ApiVersion;
	/** Local user sending a CustomInvite */
	public EOS_ProductUserId LocalUserId;
	/** Users to whom the invites should be sent */
	public EOS_ProductUserId TargetUserIds;
	/** The number of users we are sending to */
	public int TargetUserIdsCount;

	public EOS_CustomInvites_SendCustomInviteOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_SENDCUSTOMINVITE_API_LATEST;
	}

	public EOS_CustomInvites_SendCustomInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_SendCustomInviteOptions implements Structure.ByReference {
	}
	public static class ByValue extends EOS_CustomInvites_SendCustomInviteOptions implements Structure.ByValue {
	}
}
