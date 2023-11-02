package host.anzo.eossdk.eos.sdk.rtc.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTC_BlockParticipant.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "ParticipantId", "IsBlocked"})
public class EOS_RTC_BlockParticipantOptions extends Structure {
	/** The most recent version of the EOS_RTC_BlockParticipant API. */
	public static final int EOS_RTC_BLOCKPARTICIPANT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTC_BLOCKPARTICIPANT_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room the users should be blocked on. */
	public String RoomName;
	/** Product User ID of the participant to block */
	public EOS_ProductUserId ParticipantId;
	/** Block or unblock the participant */
	public EOS_Bool IsBlocked;

	public EOS_RTC_BlockParticipantOptions() {
		super();
		ApiVersion = EOS_RTC_BLOCKPARTICIPANT_API_LATEST;
	}

	public EOS_RTC_BlockParticipantOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_BlockParticipantOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_BlockParticipantOptions implements Structure.ByValue {
	}
}