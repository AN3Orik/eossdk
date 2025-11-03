package host.anzo.eossdk.eos.sdk.rtc;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Defines;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to get information about a specific participant metadata item.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "Key", "Value"})
public class EOS_RTC_ParticipantMetadata extends Structure {
	/** The most recent version of the EOS_RTC_ParticipantMetadata struct. */
	public static final int EOS_RTC_PARTICIPANTMETADATA_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTC_PARTICIPANTMETADATA_API_LATEST}. */
	public int ApiVersion;
	/** The unique key of this metadata item. The max size of the string is {@link EOS_Defines#EOS_RTC_PARTICIPANTMETADATA_KEY_MAXCHARCOUNT}. */
	public String Key;
	/** The value of this metadata item. The max size of the string is {@link EOS_Defines#EOS_RTC_PARTICIPANTMETADATA_VALUE_MAXCHARCOUNT}. */
	public String Value;

	public EOS_RTC_ParticipantMetadata() {
		super();
		ApiVersion = EOS_RTC_PARTICIPANTMETADATA_API_LATEST;
	}

	public EOS_RTC_ParticipantMetadata(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_ParticipantMetadata implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_ParticipantMetadata implements Structure.ByValue {
	}
}