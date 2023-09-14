package host.anzo.eossdk.eos.sdk.ui.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_UI_ShowFriends function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_UI_ShowFriendsCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} If the Social Overlay has been notified about the request.<br>
	 * {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 * {@link EOS_EResult#EOS_NotConfigured} If the Social Overlay is not properly configured.<br>
	 * {@link EOS_EResult#EOS_NoChange} If the Social Overlay is already visible.<br>
	 * {@link EOS_EResult#EOS_ApplicationSuspended} If the application is suspended.<br>
	 * {@link EOS_EResult#EOS_NetworkDisconnected} If the network is disconnected.
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_UI_ShowFriends */
	public Pointer ClientData;
	/** The Epic Account ID of the user whose friend list is being shown. */
	public EOS_EpicAccountId LocalUserId;

	public EOS_UI_ShowFriendsCallbackInfo() {
		super();
	}

	public EOS_UI_ShowFriendsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_ShowFriendsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_ShowFriendsCallbackInfo implements Structure.ByValue {
	}
}