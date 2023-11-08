package host.anzo.eossdk.eos.sdk.sanctions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sanctions_GetPlayerSanctionCount function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId"})
public class EOS_Sanctions_GetPlayerSanctionCountOptions extends Structure {
	/** The most recent version of the EOS_Sanctions_GetPlayerSanctionCount API. */
	public static final int EOS_SANCTIONS_GETPLAYERSANCTIONCOUNT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SANCTIONS_GETPLAYERSANCTIONCOUNT_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID of the user whose sanction count should be returned */
	public EOS_ProductUserId TargetUserId;

	public EOS_Sanctions_GetPlayerSanctionCountOptions() {
		super();
		ApiVersion = EOS_SANCTIONS_GETPLAYERSANCTIONCOUNT_API_LATEST;
	}

	public EOS_Sanctions_GetPlayerSanctionCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sanctions_GetPlayerSanctionCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sanctions_GetPlayerSanctionCountOptions implements Structure.ByValue {
	}
}