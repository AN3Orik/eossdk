package host.anzo.eossdk.eos.sdk.presence.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Presence_OnJoinGameAcceptedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "JoinInfo", "LocalUserId", "TargetUserId", "UiEventId"})
public class EOS_Presence_JoinGameAcceptedCallbackInfo extends Structure {
	/** Context that was passed into EOS_Presence_AddNotifyJoinGameAccepted */
	public Pointer ClientData;
	/**
	 * The Join Info custom game-data string to use to join the target user.
	 * Set to a null pointer to delete the value.
	 */
	public String JoinInfo;
	/** The Epic Account ID of the user who accepted the invitation */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user who sent the invitation */
	public EOS_EpicAccountId TargetUserId;
	/**
	 * If the value is not EOS_UI_EVENTID_INVALID then it must be passed back to the SDK using EOS_UI_AcknowledgeEventId.
	 * This should be done after attempting to join the game and either succeeding or failing to connect.
	 * This is necessary to allow the Social Overlay UI to manage the `Join` button.
	 */
	public long UiEventId;

	public EOS_Presence_JoinGameAcceptedCallbackInfo() {
		super();
	}

	public EOS_Presence_JoinGameAcceptedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_JoinGameAcceptedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_JoinGameAcceptedCallbackInfo implements Structure.ByValue {
	}
}