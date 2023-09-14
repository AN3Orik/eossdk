package host.anzo.eossdk.eos.sdk.sanctions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sanctions_CopyPlayerSanctionByIndex function
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "SanctionIndex"})
public class EOS_Sanctions_CopyPlayerSanctionByIndexOptions extends Structure {
	public static final int EOS_SANCTIONS_COPYPLAYERSANCTIONBYINDEX_API_LATEST = 1;

	/** API Version: Set this to EOS_SANCTIONS_COPYPLAYERSANCTIONBYINDEX_API_LATEST. */
	public int ApiVersion;
	/** Product User ID of the user whose active sanctions are to be copied */
	public EOS_ProductUserId TargetUserId;
	/** Index of the sanction to retrieve from the cache */
	public int SanctionIndex;

	public EOS_Sanctions_CopyPlayerSanctionByIndexOptions() {
		super();
		ApiVersion = EOS_SANCTIONS_COPYPLAYERSANCTIONBYINDEX_API_LATEST;
	}

	public EOS_Sanctions_CopyPlayerSanctionByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sanctions_CopyPlayerSanctionByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sanctions_CopyPlayerSanctionByIndexOptions implements Structure.ByValue {
	}
}