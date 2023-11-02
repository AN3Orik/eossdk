package host.anzo.eossdk.eos.sdk.rtcaudio;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_RTC_Audio_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.rtcaudio.callbacks.EOS_RTCAudio_OnAudioDevicesChangedCallback;
import host.anzo.eossdk.eos.sdk.rtcaudio.options.EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions;
import host.anzo.eossdk.eos.sdk.rtcaudio.options.EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to get information about a specific audio output device.
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
@FieldOrder({"ApiVersion", "IsDefaultDevice", "DeviceId", "DeviceName"})
public class EOS_RTCAudio_OutputDeviceInformation extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_RTCAudio_OutputDeviceInformation struct. */
	public static final int EOS_RTCAUDIO_OUTPUTDEVICEINFORMATION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCAUDIO_OUTPUTDEVICEINFORMATION_API_LATEST}. */
	public int ApiVersion;
	/** True if this is the default audio output device in the system. */
	public EOS_Bool IsDefaultDevice;
	/**
	 * The persistent unique id of the audio output device.<br>
	 * The value can be cached - invalidated only when the audio device pool is changed.
	 *
	 * @see EOS_RTC_Audio_Interface#addNotifyAudioDevicesChanged(EOS_RTCAudio_AddNotifyAudioDevicesChangedOptions, Pointer, EOS_RTCAudio_OnAudioDevicesChangedCallback)
	 */
	public String DeviceId;
	/** Human-readable name of the audio output device */
	public String DeviceName;

	public EOS_RTCAudio_OutputDeviceInformation() {
		super();
		ApiVersion = EOS_RTCAUDIO_OUTPUTDEVICEINFORMATION_API_LATEST;
	}

	public EOS_RTCAudio_OutputDeviceInformation(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with EOS_RTCAudio_OutputDeviceInformation. This must be called on data retrieved from
	 * EOS_RTCAudio_CopyOutputDeviceInformationByIndex.
	 *
	 * @see EOS_RTCAudio_OutputDeviceInformation
	 * @see EOS_RTC_Audio_Interface#copyOutputDeviceInformationByIndex(EOS_RTCAudio_CopyOutputDeviceInformationByIndexOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_RTCAudio_OutputDeviceInformation_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_RTCAudio_OutputDeviceInformation implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_OutputDeviceInformation implements Structure.ByValue {
	}
}