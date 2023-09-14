package host.anzo.eossdk.eos.sdk.ui.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_UI_ShowNativeProfile function.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_UI_ShowNativeProfileCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.
	 * {@link EOS_EResult#EOS_Success} If the native SDK has been requested to display a profile.<br>
	 * {@link EOS_EResult#EOS_IncompatibleVersion} if the API version passed in is incorrect.<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} If any of the options are incorrect.<br>
	 * {@link EOS_EResult#EOS_ApplicationSuspended} If the application is suspended.<br>
	 * {@link EOS_EResult#EOS_NetworkDisconnected} If the network is disconnected.<br>
	 * {@link EOS_EResult#EOS_NotFound} If the platform ID for the target player cannot be found.
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_UI_ShowNativeProfile */
	public Pointer ClientData;
	/** The Epic Online Services Account ID of the user who requested the profile. */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Online Services Account ID of the user who was to have a profile shown. */
	public EOS_EpicAccountId TargetUserId;

	public EOS_UI_ShowNativeProfileCallbackInfo() {
		super();
	}

	public EOS_UI_ShowNativeProfileCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_ShowNativeProfileCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_ShowNativeProfileCallbackInfo implements Structure.ByValue {
	}
}