package host.anzo.eossdk.eos.sdk.integratedplatform.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data passed to the application in the EOS_IntegratedPlatform_OnUserPreLogoutCallback function. This contains which user and associated
 * Integrated Platform that was detected as logged-out.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ClientData", "PlatformType", "LocalPlatformUserId", "AccountId", "ProductUserId"})
public class EOS_IntegratedPlatform_UserPreLogoutCallbackInfo extends Structure {
	/** Context that was passed into EOS_IntegratedPlatform_SetUserPreLogoutCallback  */
	public Pointer ClientData;
	/** The integrated platform the local user logged-out of. */
	public String PlatformType;
	/** String version of platform-dependent user id. */
	public String LocalPlatformUserId;
	/** The Epic Games Account ID associated with this Integrated Platform's User (if there is one) */
	public EOS_EpicAccountId AccountId;
	/** The EOS Product User ID associated with this Integrated Platform's User (if there is one) */
	public EOS_ProductUserId ProductUserId;

	public EOS_IntegratedPlatform_UserPreLogoutCallbackInfo() {
		super();
	}

	public EOS_IntegratedPlatform_UserPreLogoutCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IntegratedPlatform_UserPreLogoutCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IntegratedPlatform_UserPreLogoutCallbackInfo implements Structure.ByValue {
	}
}