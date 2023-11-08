package host.anzo.eossdk.eos.sdk.kws.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_KWS_CopyPermissionByIndex function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Index"})
public class EOS_KWS_CopyPermissionByIndexOptions extends Structure {
	/** The most recent version of the EOS_KWS_CopyPermissionByIndex API. */
	public static final int EOS_KWS_COPYPERMISSIONBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_KWS_COPYPERMISSIONBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user whose permissions are being accessed */
	public EOS_ProductUserId LocalUserId;
	/** The index of the permission to get. */
	public int Index;

	public EOS_KWS_CopyPermissionByIndexOptions() {
		super();
		ApiVersion = EOS_KWS_COPYPERMISSIONBYINDEX_API_LATEST;
	}

	public EOS_KWS_CopyPermissionByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_CopyPermissionByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_CopyPermissionByIndexOptions implements Structure.ByValue {
	}
}