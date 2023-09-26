package host.anzo.eossdk.eos.sdk.kws;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.kws.enums.EOS_EKWSPermissionStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "Name", "Status"})
public class EOS_KWS_PermissionStatus extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_KWS_PermissionStatus API. */
	public static final int EOS_KWS_PERMISSIONSTATUS_API_LATEST = 1;

	/** API Version: Set this to EOS_KWS_PERMISSIONSTATUS_API_LATEST. */
	public int ApiVersion;
	/** Name of the permission */
	public String Name;
	/**
	 * Status of the permission
	 */
	public EOS_EKWSPermissionStatus Status;

	public EOS_KWS_PermissionStatus() {
		super();
		ApiVersion = EOS_KWS_PERMISSIONSTATUS_API_LATEST;
	}

	public EOS_KWS_PermissionStatus(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_KWS_PermissionStatus_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_KWS_PermissionStatus implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_PermissionStatus implements Structure.ByValue {
	}
}