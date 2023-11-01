package host.anzo.eossdk.eos.sdk.rtc.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtc.EOS_RTC_ParticipantMetadata;
import host.anzo.eossdk.eos.sdk.rtc.enums.EOS_ERTCParticipantStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTC_AddNotifyParticipantStatusChanged registered event.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "RoomName", "ParticipantId", "ParticipantStatus", "ParticipantMetadataCount", "ParticipantMetadata", "IsParticipantInBlocklist"})
public class EOS_RTC_ParticipantStatusChangedCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_RTC_AddNotifyParticipantStatusChanged. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;
	/** The participant whose status changed. */
	public EOS_ProductUserId ParticipantId;
	/** What status change occurred */
	public EOS_ERTCParticipantStatus ParticipantStatus;
	/** The participant metadata items count.
	 * This is only set for the first notification where ParticipantStatus is EOS_RTCPS_Joined. Subsequent notifications
	 * such as when bParticipantInBlocklist changes will not contain any metadata.
	 */
	public int ParticipantMetadataCount;
	/** The participant metadata items.
	 * This is only set for the first notification where ParticipantStatus is EOS_RTCPS_Joined. Subsequent notifications
	 * such as when bParticipantInBlocklist changes will not contain any metadata.
	 */
	public EOS_RTC_ParticipantMetadata.ByReference ParticipantMetadata;
	/** The participant's block list status, if ParticipantStatus is EOS_RTCPS_Joined.
	 * This is set to true if the participant is in any of the local user's applicable block lists,
	 * such Epic block list or any of the current platform's block lists.
	 * It can be used to detect when an internal automatic RTC block is applied because of trust and safety restrictions.
	 */
	public EOS_Bool IsParticipantInBlocklist;

	public EOS_RTC_ParticipantStatusChangedCallbackInfo() {
		super();
	}

	public EOS_RTC_ParticipantStatusChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_ParticipantStatusChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_ParticipantStatusChangedCallbackInfo implements Structure.ByValue {
	}
}