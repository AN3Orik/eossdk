package host.anzo.eossdk.eos.sdk.custominvites.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_CustomInvites_SendCustomInvite Function. These parameters are received through the callback provided to EOS_CustomInvites_SendCustomInvite
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserIds", "TargetUserIdsCount"})
public class EOS_CustomInvites_SendCustomInviteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} if the query completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options values are incorrect<br>
	 * {@link EOS_EResult#EOS_TooManyRequests} if the number of allowed queries is exceeded<br>
	 * {@link EOS_EResult#EOS_NotFound} if SetCustomInvite has not been previously successfully called for this user
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_CustomInvites_SendCustomInvite */
	public Pointer ClientData;
	/** Local user sending a CustomInvite */
	public EOS_ProductUserId LocalUserId;
	/** Users to whom the invites were successfully sent (can be different than original call if an invite for same Payload was previously sent) */
	public EOS_ProductUserId TargetUserIds;
	/** The number of users we are sending to */
	public int TargetUserIdsCount;

	public EOS_CustomInvites_SendCustomInviteCallbackInfo() {
		super();
	}

	public EOS_CustomInvites_SendCustomInviteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_SendCustomInviteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_SendCustomInviteCallbackInfo implements Structure.ByValue {
	}
}