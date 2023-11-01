package host.anzo.eossdk.eos.sdk.mods.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Mods_EnumerateMods Function. These parameters are received through the callback provided to EOS_Mods_EnumerateMods
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ResultCode", "LocalUserId", "ClientData", "Type"})
public class EOS_Mods_EnumerateModsCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned if the enumeration was successfull, otherwise one of the error codes is returned. */
	public EOS_EResult ResultCode;
	/** The Epic Account ID of the user for which mod enumeration was requested */
	public EOS_EpicAccountId LocalUserId;
	/** Context that is passed into EOS_Mods_EnumerateMods */
	public Pointer ClientData;
	/** Type of the enumerated mods */
	public int Type;

	public EOS_Mods_EnumerateModsCallbackInfo() {
		super();
	}

	public EOS_Mods_EnumerateModsCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Mods_EnumerateModsCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mods_EnumerateModsCallbackInfo implements Structure.ByValue {
	}
}