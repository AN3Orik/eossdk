package host.anzo.eossdk.eos.sdk.titlestorage.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Return results for EOS_TitleStorage_OnReadFileDataCallback callbacks
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
public @Getter enum EOS_TitleStorage_EReadResult implements NativeMapped {
	/** Signifies the data was read successfully, and we should continue to the next chunk if possible */
	EOS_TS_RR_ContinueReading(1),
	/** Signifies there was a failure reading the data, and the request should end */
	EOS_TS_RR_FailRequest(2),
	/** Signifies the request should be canceled, but not due to an error */
	EOS_TS_RR_CancelRequest(3);

	private final int id;

	private static final Map<Integer, EOS_TitleStorage_EReadResult> values = new HashMap<>();

	static {
		for (EOS_TitleStorage_EReadResult result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_TitleStorage_EReadResult(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_TS_RR_ContinueReading);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}