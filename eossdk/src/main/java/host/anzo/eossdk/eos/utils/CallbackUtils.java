package host.anzo.eossdk.eos.utils;

import com.sun.jna.Callback;
import com.sun.jna.Native;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Util for saving references to JNA callback to prevent collecting by GC
 *
 * @author Anton Lasevich
 * @since 10/2/2023
 */
@Slf4j
public class CallbackUtils {
	private static final Map<EOS_NotificationId, Callback> registeredCallbacks = new ConcurrentHashMap<>();
	static {
		Native.setCallbackExceptionHandler((Callback c, Throwable e) -> log.error("Callback {} throws exception", c.getClass().getInterfaces()[0].getSimpleName(), e));
	}

	/**
	 * Add specified JNA callback to registered callbacks lis
	 * @param notificationId callback NotificationID
	 * @param callback callback functional interface
	 */
	public static void registerCallback(EOS_NotificationId notificationId, Callback callback) {
		if (VMUtils.DEBUG) {
			log.debug("Registered callback [{}] with id=[{}]", callback.getClass().getInterfaces()[0].getSimpleName(), notificationId);
		}
		registeredCallbacks.put(notificationId, callback);
	}

	/**
	 * Remove JNA callback with specified NotificationID from a registered callbacks list
	 * @param notificationId callback NotificationID to remove
	 */
	public static void unregisterCallback(EOS_NotificationId notificationId) {
		final Callback callback = registeredCallbacks.remove(notificationId);
		if (callback != null) {
			if (VMUtils.DEBUG) {
				log.debug("Unregistered callback [{}] with id=[{}]", callback.getClass().getInterfaces()[0].getSimpleName(), notificationId);
			}
		}
	}

	/**
	 * Print information about registered callbacks to console
	 */
	public static void printCallbacks() {
		for (Map.Entry<EOS_NotificationId, Callback> entry : registeredCallbacks.entrySet()) {
			log.info("Registered callback [{}] with id=[{}]", entry.getValue().getClass().getInterfaces()[0].getSimpleName(), entry.getKey());
		}
	}
}
