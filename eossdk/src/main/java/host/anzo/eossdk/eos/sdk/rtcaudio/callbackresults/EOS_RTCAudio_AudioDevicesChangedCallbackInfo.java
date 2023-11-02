package host.anzo.eossdk.eos.sdk.rtcaudio.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is passed in with a call to EOS_RTCAudio_AddNotifyAudioDevicesChanged registered event.
 *
 * @author Anton Lasevich
 * @since 11/2/2023
 */
@FieldOrder({"ClientData"})
public class EOS_RTCAudio_AudioDevicesChangedCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_RTCAudio_AddNotifyAudioDevicesChanged. */
	public Pointer ClientData;

	public EOS_RTCAudio_AudioDevicesChangedCallbackInfo() {
		super();
	}

	public EOS_RTCAudio_AudioDevicesChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAudio_AudioDevicesChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAudio_AudioDevicesChangedCallbackInfo implements Structure.ByValue {
	}
}