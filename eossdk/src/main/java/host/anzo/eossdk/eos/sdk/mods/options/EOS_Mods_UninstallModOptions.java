package host.anzo.eossdk.eos.sdk.mods.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.mods.EOS_Mod_Identifier;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Mods_UninstallMod Function.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Mod"})
public class EOS_Mods_UninstallModOptions extends Structure {
	/** The most recent version of the EOS_Mods_UninstallModOptions API. */
	public static final int EOS_MODS_UNINSTALLMOD_API_LATEST = 1;

	/** API Version: Set this to EOS_MODS_UNINSTALLMOD_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the user for which the mod should be uninstalled */
	public EOS_EpicAccountId LocalUserId;
	/** The mod to uninstall */
	public EOS_Mod_Identifier.ByReference Mod;

	public EOS_Mods_UninstallModOptions() {
		super();
		ApiVersion = EOS_MODS_UNINSTALLMOD_API_LATEST;
	}

	public EOS_Mods_UninstallModOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Mods_UninstallModOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mods_UninstallModOptions implements Structure.ByValue {
	}
}