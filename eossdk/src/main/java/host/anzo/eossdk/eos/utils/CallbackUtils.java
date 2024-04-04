package host.anzo.eossdk.eos.utils;

import com.sun.jna.Callback;
import com.sun.jna.Native;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.logging.callbacks.EOS_LogMessageFunc;
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
	private static final Map<EOS_NotificationId, Callback> notificationCallbacks = new ConcurrentHashMap<>();
	@SuppressWarnings("FieldCanBeLocal")
	private static EOS_LogMessageFunc loggingCallback;

	static {
		Native.setCallbackExceptionHandler((Callback c, Throwable e) -> log.error("Callback {} throws exception", c.getClass().getInterfaces()[0].getSimpleName(), e));
	}

	/**
	 * Add specified JNA callback to registered callbacks lis
	 * @param notificationId callback NotificationID
	 * @param callback callback functional interface
	 */
	public static void registerNotificationCallback(EOS_NotificationId notificationId, Callback callback) {
		if (VMUtils.DEBUG) {
			log.debug("Registered callback [{}] with id=[{}]", callback.getClass().getInterfaces()[0].getSimpleName(), notificationId);
		}
		notificationCallbacks.put(notificationId, callback);
	}

	/**
	 * Remove JNA callback with specified NotificationID from a registered callbacks list
	 * @param notificationId callback NotificationID to remove
	 */
	public static void unregisterNotificationCallback(EOS_NotificationId notificationId) {
		final Callback callback = notificationCallbacks.remove(notificationId);
		if (callback != null) {
			if (VMUtils.DEBUG) {
				log.debug("Unregistered callback [{}] with id=[{}]", callback.getClass().getInterfaces()[0].getSimpleName(), notificationId);
			}
		}
	}

	/**
	 * Save logging callback reference to avoid removing by Garbage Collector
	 * @param callback logging callback
	 */
	public static void registerLoggingCallback(EOS_LogMessageFunc callback) {
		loggingCallback = callback;
	}

	/**
	 * Print information about registered callbacks to console
	 */
	public static void printNotificationCallbacks() {
		for (Map.Entry<EOS_NotificationId, Callback> entry : notificationCallbacks.entrySet()) {
			log.info("Registered callback [{}] with id=[{}]", entry.getValue().getClass().getInterfaces()[0].getSimpleName(), entry.getKey());
		}
	}
}
