package host.anzo.eossdk.eos.sdk.kws.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_KWS_GetPermissionByKey function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Key"})
public class EOS_KWS_GetPermissionByKeyOptions extends Structure {
	/** The most recent version of the EOS_KWS_CreateUser API. */
	public static final int EOS_KWS_GETPERMISSIONBYKEY_API_LATEST = 1;

	/** API Version: Set this to EOS_KWS_GETPERMISSIONBYKEY_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user getting permissions */
	public EOS_ProductUserId LocalUserId;
	/** Permission name to query */
	public String Key;

	public EOS_KWS_GetPermissionByKeyOptions() {
		super();
		ApiVersion = EOS_KWS_GETPERMISSIONBYKEY_API_LATEST;
	}

	public EOS_KWS_GetPermissionByKeyOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_GetPermissionByKeyOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_GetPermissionByKeyOptions implements Structure.ByValue {
	}
}