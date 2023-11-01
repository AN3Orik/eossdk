package host.anzo.eossdk.eos.sdk.friends.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Friends_QueryFriends Function. These parameters are received through the callback provided to EOS_Friends_QueryFriends
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Friends_QueryFriendsCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Friends_QueryFriends */
	public Pointer ClientData;
	/** The Epic Account ID of the user whose friends were queried */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Friends_QueryFriendsCallbackInfo() {
		super();
	}

	public EOS_Friends_QueryFriendsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Friends_QueryFriendsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Friends_QueryFriendsCallbackInfo implements Structure.ByValue {
	}
}