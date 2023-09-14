package host.anzo.eossdk.eos.sdk.kws.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_KWS_OnPermissionsUpdateReceivedCallback Function.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "KWSUserId", "DateOfBirth", "bIsMinor", "ParentEmail"})
public class EOS_KWS_PermissionsUpdateReceivedCallbackInfo extends Structure {
	/** Context that was passed into EOS_KWS_AddNotifyPermissionsUpdateReceived */
	public Pointer ClientData;
	/** Recipient Local user id */
	public EOS_ProductUserId LocalUserId;
	/** Recipient's associated KWS UserId */
	public String KWSUserId;
	/** Date of birth in ISO8601 form (YYYY-MM-DD) */
	public String DateOfBirth;
	/** Is this user a minor */
	public int bIsMinor;
	/** Parent email. This value may be set to an empty string if the originally registered email recipient declined to be the right person to give consent. */
	public String ParentEmail;

	public EOS_KWS_PermissionsUpdateReceivedCallbackInfo() {
		super();
	}

	public EOS_KWS_PermissionsUpdateReceivedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_KWS_PermissionsUpdateReceivedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_KWS_PermissionsUpdateReceivedCallbackInfo implements Structure.ByValue {
	}
}