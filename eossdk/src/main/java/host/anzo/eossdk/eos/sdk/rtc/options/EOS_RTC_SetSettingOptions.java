package host.anzo.eossdk.eos.sdk.rtc.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTC_SetSetting
 * <p>
 * Available values of SettingName:
 * <ul>
 *     <li>DisableEchoCancelation: Disables the use of echo cancellation for the audio channel. Default "False".
 *     <li>DisableNoiseSupression: Disables the use of noise suppression for the audio channel. Default "False".
 *     <li>DisableAutoGainControl: Disables the use of auto gain control for the audio channel. Default "False".
 *     <li>DisableDtx: Allows to disable the use of DTX.  Default "False".
 * </ul>
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "SettingName", "SettingValue"})
public class EOS_RTC_SetSettingOptions extends Structure {
	/** The most recent version of the EOS_RTC_SetSetting API. */
	public static final int EOS_RTC_SETSETTING_API_LATEST = 1;

	/** API Version: Set this to EOS_RTC_SETSETTING_API_LATEST. */
	public int ApiVersion;
	/** Setting that should be set. */
	public String SettingName;
	/** Value to set the setting to. */
	public String SettingValue;

	public EOS_RTC_SetSettingOptions() {
		super();
		ApiVersion = EOS_RTC_SETSETTING_API_LATEST;
	}

	public EOS_RTC_SetSettingOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_SetSettingOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_SetSettingOptions implements Structure.ByValue {
	}
}