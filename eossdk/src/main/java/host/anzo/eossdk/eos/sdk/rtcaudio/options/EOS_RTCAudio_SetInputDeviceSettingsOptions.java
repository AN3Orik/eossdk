package host.anzo.eossdk.eos.sdk.rtcaudio.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_RTC_Audio_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbacks.EOS_RTCAudio_OnAudioDevicesChangedCallback;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTCAudio_SetInputDeviceSettings.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RealDeviceId", "IsPlatformAEC"})
public class EOS_RTCAudio_SetInputDeviceSettingsOptions extends Structure {
	/** The most recent version of the EOS_RTCAudio_SetInputDeviceSettings API. */
	public static final int EOS_RTCAUDIO_SETINPUTDEVICESETTINGS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_SETINPUTDEVICESETTINGS_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/**
	 * The device Id to be used for this user. Pass NULL or empty string to use a default input device.
	 * <p>
	 * If the device ID is invalid, the default device will be used instead.
	 * Despite this fact, that device ID will be stored and the library will try to move on it when an audio device pool is being changed.
	 * <p>
	 * The actual hardware audio input device usage depends on the current payload and optimized not to use it
	 * when generated audio frames cannot be processed by someone else based on a scope of rules (For instance, when a client is alone in a room).
	 *
	 * @see EOS_RTC_Audio_Interface#addNotifyAudioDevicesChanged(EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions, Pointer, EOS_RTCAudio_OnAudioDevicesChangedCallback)
	 */
	public String RealDeviceId;
	/** Enable or disable Platform AEC (Acoustic Echo Cancellation) if available. */
	public EOS_Bool IsPlatformAEC;

	public EOS_RTCAudio_SetInputDeviceSettingsOptions() {
		super();
		ApiVersion = EOS_RTCAUDIO_SETINPUTDEVICESETTINGS_API_LATEST;
	}

	public EOS_RTCAudio_SetInputDeviceSettingsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_SetInputDeviceSettingsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_SetInputDeviceSettingsOptions implements Structure.ByValue {
	}
}