package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public class EOS_NotificationId extends PointerType {
	public final static EOS_NotificationId EOS_INVALID_NOTIFICATIONID = new EOS_NotificationId(Pointer.NULL);

	public EOS_NotificationId(Pointer address) {
		super(address);
	}

	public EOS_NotificationId() {
		super();
	}
}