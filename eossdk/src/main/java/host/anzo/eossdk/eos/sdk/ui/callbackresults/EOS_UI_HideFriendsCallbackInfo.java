package host.anzo.eossdk.eos.sdk.ui.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_UI_HideFriends function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_UI_HideFriendsCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.<br>
	 * {@link EOS_EResult#EOS_Success} If the Social Overlay has been notified about the request.<br>
	 * {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 * {@link EOS_EResult#EOS_NotConfigured} If the Social Overlay is not properly configured.<br>
	 * {@link EOS_EResult#EOS_NoChange} If the Social Overlay is already hidden.
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_UI_HideFriends */
	public Pointer ClientData;
	/** The Epic Account ID of the user whose friend list is being shown. */
	public EOS_EpicAccountId LocalUserId;

	public EOS_UI_HideFriendsCallbackInfo() {
		super();
	}

	public EOS_UI_HideFriendsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_HideFriendsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_HideFriendsCallbackInfo implements Structure.ByValue {
	}
}