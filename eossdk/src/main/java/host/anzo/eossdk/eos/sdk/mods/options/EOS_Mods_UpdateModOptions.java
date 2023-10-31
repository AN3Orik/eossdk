package host.anzo.eossdk.eos.sdk.mods.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.mods.EOS_Mod_Identifier;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Mods_UpdateMod Function.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Mod"})
public class EOS_Mods_UpdateModOptions extends Structure {
	/** The most recent version of the EOS_Mods_UpdateModOptions API. */
	public static final int EOS_MODS_UPDATEMOD_API_LATEST = 1;

	/** API Version: Set this to EOS_MODS_UPDATEMOD_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the user for which the mod should be updated */
	public EOS_EpicAccountId LocalUserId;
	/** The mod to update */
	public EOS_Mod_Identifier.ByReference Mod;

	public EOS_Mods_UpdateModOptions() {
		super();
		ApiVersion = EOS_MODS_UPDATEMOD_API_LATEST;
	}

	public EOS_Mods_UpdateModOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Mods_UpdateModOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mods_UpdateModOptions implements Structure.ByValue {
	}
}