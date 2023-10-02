package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.NativeLong;

/**
 * Handle to an existing registered notification (0 is an invalid handle)
 *
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public class EOS_NotificationId extends NativeLong {
	public final static EOS_NotificationId EOS_INVALID_NOTIFICATIONID = new EOS_NotificationId();

	public EOS_NotificationId() {
		super();
	}

	public EOS_NotificationId(long value) {
		super(value);
	}

	/**
	 * @return true if it's an invalid notification ID, false otherwise
	 */
	public boolean isValid() {
		return longValue() != EOS_INVALID_NOTIFICATIONID.longValue();
	}
}