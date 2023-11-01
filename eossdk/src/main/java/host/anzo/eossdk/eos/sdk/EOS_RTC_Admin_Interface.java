package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * The RTC Interface is used to manage joining and leaving rooms.
 * @see EOS_Platform_Interface#getRTCAdminInterface()
 *
 * @author ANZO
 * @since 11/1/2023
 */
public class EOS_RTC_Admin_Interface extends PointerType {
	public EOS_RTC_Admin_Interface(Pointer address) {
		super(address);
	}
	public EOS_RTC_Admin_Interface() {
		super();
	}
}
