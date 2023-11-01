package host.anzo.eossdk.eos.sdk.playerdatastorage.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Return results for EOS_PlayerDataStorage_OnWriteFileDataCallback callbacks to return
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public @Getter enum EOS_PlayerDataStorage_EWriteResult implements NativeMapped {
	/** Signifies the data was written successfully, and we should write the data the file */
	EOS_WR_ContinueWriting(1),
	/** Signifies all data has now been written successfully, and we should upload the data to the cloud */
	EOS_WR_CompleteRequest(2),
	/** Signifies there was a failure writing the data, and the request should end */
	EOS_WR_FailRequest(3),
	/** Signifies the request should be canceled, but not due to an error */
	EOS_WR_CancelRequest(4);

	private final int id;

	private static final Map<Integer, EOS_PlayerDataStorage_EWriteResult> values = new HashMap<>();

	static {
		for (EOS_PlayerDataStorage_EWriteResult result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_PlayerDataStorage_EWriteResult(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_WR_ContinueWriting);
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