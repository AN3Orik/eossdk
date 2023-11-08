package host.anzo.eossdk.eos.sdk.mods.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.mods.EOS_Mod_Identifier;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Mods_InstallMod Function.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Mod", "IsRemoveAfterExit"})
public class EOS_Mods_InstallModOptions extends Structure {
	/** The most recent version of the EOS_Mods_InstallMod API. */
	public static int EOS_MODS_INSTALLMOD_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_MODS_INSTALLMOD_API_LATEST}. */
	public int ApiVersion;
	/** The Epic Account ID of the user for which the mod should be installed */
	public EOS_EpicAccountId LocalUserId;
	/** The mod to install */
	public EOS_Mod_Identifier.ByReference Mod;
	/** Indicates whether the mod should be uninstalled after exiting the game or not. */
	public EOS_Bool IsRemoveAfterExit;

	public EOS_Mods_InstallModOptions() {
		super();
		ApiVersion = EOS_MODS_INSTALLMOD_API_LATEST;
	}

	public EOS_Mods_InstallModOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Mods_InstallModOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mods_InstallModOptions implements Structure.ByValue {
	}
}