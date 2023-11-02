package host.anzo.eossdk.eos.sdk.rtc;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to get information about a specific option.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "Key", "Value"})
public class EOS_RTC_Option extends Structure {
	public static final int EOS_RTC_OPTION_KEY_MAXCHARCOUNT = 256;
	public static final int EOS_RTC_OPTION_VALUE_MAXCHARCOUNT = 256;

	/** The most recent version of the EOS_RTC_Option struct. */
	public static final int EOS_RTC_OPTION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTC_OPTION_API_LATEST}. */
	public int ApiVersion;
	/** The unique key of the option. The max size of the string is {@link #EOS_RTC_OPTION_KEY_MAXCHARCOUNT}. */
	public String Key;
	/** The value of the option. The max size of the string is {@link #EOS_RTC_OPTION_VALUE_MAXCHARCOUNT}. */
	public String Value;

	public EOS_RTC_Option() {
		super();
		ApiVersion = EOS_RTC_OPTION_API_LATEST;
	}

	public EOS_RTC_Option(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_Option implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_Option implements Structure.ByValue {
	}
}