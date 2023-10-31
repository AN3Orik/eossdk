package host.anzo.eossdk.eos.sdk.mods.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.mods.enums.EOS_EModEnumerationType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Mods_EnumerateMods Function.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Type"})
public class EOS_Mods_EnumerateModsOptions extends Structure {
	/** The most recent version of the EOS_Mods_EnumerateModsOptions API. */
	public static final int EOS_MODS_ENUMERATEMODS_API_LATEST = 1;

	/** API Version: Set this to EOS_MODS_ENUMERATEMODS_API_LATEST. */
	public int ApiVersion;

	/** The Epic Account ID of the user for which the mod should be enumerated */
	public EOS_EpicAccountId LocalUserId;
	/** Type of the mods to enumerate */
	public EOS_EModEnumerationType Type;

	public EOS_Mods_EnumerateModsOptions() {
		super();
		ApiVersion = EOS_MODS_ENUMERATEMODS_API_LATEST;
	}

	public EOS_Mods_EnumerateModsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Mods_EnumerateModsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mods_EnumerateModsOptions implements Structure.ByValue {
	}
}