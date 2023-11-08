package host.anzo.eossdk.eos.sdk.mods.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_Mods_CopyModInfo function.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Type"})
public class EOS_Mods_CopyModInfoOptions extends Structure {
	/** The most recent version of the EOS_Mods_CopyModInfoOptions API. */
	public static final int EOS_MODS_COPYMODINFO_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_MODS_COPYMODINFO_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the user for which mods should be copied */
	public EOS_EpicAccountId LocalUserId;
	/** Type of the enumerated mod to copy */
	public int Type;

	public EOS_Mods_CopyModInfoOptions() {
		super();
		ApiVersion = EOS_MODS_COPYMODINFO_API_LATEST;
	}

	public EOS_Mods_CopyModInfoOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Mods_CopyModInfoOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mods_CopyModInfoOptions implements Structure.ByValue {
	}
}