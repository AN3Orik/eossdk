package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * The RTC Audio Interface. This is used to manage Audio specific RTC features
 * @see EOS_RTC_Interface#getAudioInterface()
 *
 * @author ANZO
 * @since 11/1/2023
 */
public class EOS_RTC_Audio_Interface extends PointerType {
	public EOS_RTC_Audio_Interface(Pointer address) {
		super(address);
	}
	public EOS_RTC_Audio_Interface() {
		super();
	}
}