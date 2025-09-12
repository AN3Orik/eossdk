package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_CreateDeviceId function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "DeviceModel"})
public class EOS_Connect_CreateDeviceIdOptions extends Structure {
	/** Max length of a device model name, not including the terminating null */
	public static int EOS_CONNECT_CREATEDEVICEID_DEVICEMODEL_MAX_LENGTH = 64;

	/** The most recent version of the EOS_Connect_CreateDeviceId API. */
	public static int EOS_CONNECT_CREATEDEVICEID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CONNECT_CREATEDEVICEID_API_LATEST}. */
	public int ApiVersion;
	/**
	 * A freeform text description identifying the device type and model,
	 * which can be used in account linking management to allow the player
	 * and customer support to identify different devices linked to an EOS
	 * user keychain. For example 'iPhone 6S' or 'PC Windows'.
	 * <p>
	 * The input string must be in UTF-8 character format, with a maximum
	 * length of 64 characters. Longer string will be silently truncated.
	 * <p>
	 * This field is required to be present.
	 * <p>
	 * Must be less than {@link #EOS_CONNECT_CREATEDEVICEID_DEVICEMODEL_MAX_LENGTH}
	 */
	public String DeviceModel;

	public EOS_Connect_CreateDeviceIdOptions() {
		super();
		ApiVersion = EOS_CONNECT_CREATEDEVICEID_API_LATEST;
	}

	public EOS_Connect_CreateDeviceIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_CreateDeviceIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_CreateDeviceIdOptions implements Structure.ByValue {
	}
}