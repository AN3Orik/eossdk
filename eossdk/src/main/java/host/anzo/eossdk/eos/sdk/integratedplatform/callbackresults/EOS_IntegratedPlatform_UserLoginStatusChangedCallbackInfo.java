package host.anzo.eossdk.eos.sdk.integratedplatform.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ELoginStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data about which integrated platform and which user that had a login status change and what the login status changed to.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "PlatformType", "LocalPlatformUserId", "AccountId", "ProductUserId", "PreviousLoginStatus", "CurrentLoginStatus"})
public class EOS_IntegratedPlatform_UserLoginStatusChangedCallbackInfo extends Structure {
	/** Context that was passed into EOS_IntegratedPlatform_AddNotifyUserLoginStatusChanged */
	public Pointer ClientData;
	/** The integrated platform of the local platform user. */
	public String PlatformType;
	/** String version of platform's user id. */
	public String LocalPlatformUserId;
	/** The Epic Games Account ID associated with this Integrated Platform's User (if there is one) */
	public EOS_EpicAccountId AccountId;
	/** The EOS Product User ID associated with this Integrated Platform's User (if there is one) */
	public EOS_ProductUserId ProductUserId;
	/**
	 * The login status prior to this change.
	 * @see EOS_ELoginStatus
	 */
	public EOS_ELoginStatus PreviousLoginStatus;
	/**
	 * The login status at the time of this notification.
	 * @see EOS_ELoginStatus
	 */
	public EOS_ELoginStatus CurrentLoginStatus;

	public EOS_IntegratedPlatform_UserLoginStatusChangedCallbackInfo() {
		super();
	}
	public EOS_IntegratedPlatform_UserLoginStatusChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_UserLoginStatusChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_UserLoginStatusChangedCallbackInfo implements Structure.ByValue {
	}
}