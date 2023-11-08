package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.sdk.sessions.EOS_SessionModification;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOS_SessionModification#setAllowedPlatformIds(EOS_SessionModification_SetAllowedPlatformIdsOptions)} function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "AllowedPlatformIds", "AllowedPlatformIdsCount"})
public class EOS_SessionModification_SetAllowedPlatformIdsOptions extends Structure {
	public static final int EOS_SESSIONMODIFICATION_SETALLOWEDPLATFORMIDS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONMODIFICATION_SETALLOWEDPLATFORMIDS_API_LATEST}. */
	public int ApiVersion;
	/**
	 * Array of platform IDs indicating the player platforms allowed to register with the session. Platform IDs are
	 * found in the EOS header file, e.g. EOS_OPT_Epic. For some platforms, the value will be in the EOS Platform specific
	 * header file. If null, the session will be unrestricted.
	 */
	public IntByReference AllowedPlatformIds;
	/** Number of platform IDs in the array */
	public int AllowedPlatformIdsCount;

	public EOS_SessionModification_SetAllowedPlatformIdsOptions() {
		super();
		ApiVersion = EOS_SESSIONMODIFICATION_SETALLOWEDPLATFORMIDS_API_LATEST;
	}

	public EOS_SessionModification_SetAllowedPlatformIdsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionModification_SetAllowedPlatformIdsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionModification_SetAllowedPlatformIdsOptions implements Structure.ByValue {
	}
}