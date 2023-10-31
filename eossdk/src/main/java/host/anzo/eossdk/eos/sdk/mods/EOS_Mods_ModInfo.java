package host.anzo.eossdk.eos.sdk.mods;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Mods_Interface;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data for the EOS_Mods_CopyModInfo function.
 * @see EOS_Mods_Interface#copyModInfo
 * @see #release()
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "ModsCount", "Mods", "Type"})
public class EOS_Mods_ModInfo extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Mods_ModInfo struct. */
	public static int EOS_MODS_MODINFO_API_LATEST = 1;

	/** API Version: Set this to EOS_MODS_MODINFO_API_LATEST. */
	public int ApiVersion;
	/** The count of enumerated mods */
	public int ModsCount;
	/** The array of enumerated mods or NULL if no such type of mods were enumerated */
	public EOS_Mod_Identifier.ByReference Mods;
	/** Type of the mods */
	public int Type;

	public EOS_Mods_ModInfo() {
		super();
		ApiVersion = EOS_MODS_MODINFO_API_LATEST;
	}

	public EOS_Mods_ModInfo(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an EOS_Mods_ModInfo structure and its sub-objects. This must be called on data retrieved from EOS_Mods_CopyModInfo.
	 */
	public void release() {
		EOSLibrary.instance.EOS_Mods_ModInfo_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Mods_ModInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mods_ModInfo implements Structure.ByValue {
	}
}