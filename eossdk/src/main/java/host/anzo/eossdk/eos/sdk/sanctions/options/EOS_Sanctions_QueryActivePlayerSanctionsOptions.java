package host.anzo.eossdk.eos.sdk.sanctions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sanctions_QueryActivePlayerSanctions API.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "LocalUserId"})
public class EOS_Sanctions_QueryActivePlayerSanctionsOptions extends Structure {
	/** The most recent version of the EOS_Sanctions_QueryActivePlayerSanctions API. */
	public static final int EOS_SANCTIONS_QUERYACTIVEPLAYERSANCTIONS_API_LATEST = 2;

	/** API Version: Set this to EOS_SANCTIONS_QUERYACTIVEPLAYERSANCTIONS_API_LATEST. */
	public int ApiVersion;
	/** Product User ID of the user whose active sanctions are to be retrieved. */
	public EOS_ProductUserId TargetUserId;
	/** The Product User ID of the local user who initiated this request. Dedicated servers should set this to null. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Sanctions_QueryActivePlayerSanctionsOptions() {
		super();
		ApiVersion = EOS_SANCTIONS_QUERYACTIVEPLAYERSANCTIONS_API_LATEST;
	}

	public EOS_Sanctions_QueryActivePlayerSanctionsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sanctions_QueryActivePlayerSanctionsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sanctions_QueryActivePlayerSanctionsOptions implements Structure.ByValue {
	}
}