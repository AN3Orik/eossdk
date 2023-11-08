package host.anzo.eossdk.eos.sdk.kws.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_KWS_RequestPermissions function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "PermissionKeyCount", "PermissionKeys"})
public class EOS_KWS_RequestPermissionsOptions extends Structure {
	/** Maximum number of permissions that may be requested */
	public static final int EOS_KWS_MAX_PERMISSIONS = 16;

	/** Maximum size of the name for the permission */
	public static final int EOS_KWS_MAX_PERMISSION_LENGTH = 32;

	/** The most recent version of the EOS_KWS_RequestPermissions API. */
	public static final int EOS_KWS_REQUESTPERMISSIONS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_KWS_REQUESTPERMISSIONS_API_LATEST}. */
	public int ApiVersion;
	/** Local user requesting new permissions */
	public EOS_ProductUserId LocalUserId;
	/** The number of permissions to request, may not exceed {@link #EOS_KWS_MAX_PERMISSIONS}. Only new permissions need be included. */
	public int PermissionKeyCount;
	/** Names of the permissions to request (Setup with KWS) */
	public StringArray PermissionKeys;

	public EOS_KWS_RequestPermissionsOptions() {
		super();
		ApiVersion = EOS_KWS_REQUESTPERMISSIONS_API_LATEST;
	}

	public EOS_KWS_RequestPermissionsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_RequestPermissionsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_RequestPermissionsOptions implements Structure.ByValue {
	}
}