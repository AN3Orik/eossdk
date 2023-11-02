package host.anzo.eossdk.eos.sdk.rtc.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTC_SetRoomSetting
 * <p>
 * Available values of SettingName:
 * <ul>
 * <li>DisableEchoCancelation: Disables the use of echo cancellation for the audio channel. Default "False".
 * <li>DisableNoiseSupression: Disables the use of noise suppression for the audio channel. Default "False".
 * <li>DisableAutoGainControl: Disables the use of auto gain control for the audio channel. Default "False".
 * <li>DisableDtx: Allows to disable the use of DTX.  Default "False".
 * </ul>
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "SettingName", "SettingValue"})
public class EOS_RTC_SetRoomSettingOptions extends Structure {
	/** The most recent version of the EOS_RTC_SetRoomSetting API. */
	public static final int EOS_RTC_SETROOMSETTING_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTC_SETROOMSETTING_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room the setting will be applied to. */
	public String RoomName;
	/** Setting that should be set. */
	public String SettingName;
	/** Value to set the setting to. */
	public String SettingValue;

	public EOS_RTC_SetRoomSettingOptions() {
		super();
		ApiVersion = EOS_RTC_SETROOMSETTING_API_LATEST;
	}

	public EOS_RTC_SetRoomSettingOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTC_SetRoomSettingOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTC_SetRoomSettingOptions implements Structure.ByValue {
	}
}