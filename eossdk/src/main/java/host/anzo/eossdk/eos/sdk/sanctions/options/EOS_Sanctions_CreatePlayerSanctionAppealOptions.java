package host.anzo.eossdk.eos.sdk.sanctions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.sanctions.enums.EOS_ESanctionAppealReason;

import static com.sun.jna.Structure.*;

/**
 * Input parameters for the EOS_Sanctions_CreatePlayerSanctionAppeal function.
 *
 * @author Anton Lasevich
 * @since 3/24/2024
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Reason", "ReferenceId"})
public class EOS_Sanctions_CreatePlayerSanctionAppealOptions extends Structure {
	/** The most recent version of the EOS_Sanctions_CreatePlayerSanctionAppeal struct. */
	public static final int EOS_SANCTIONS_CREATEPLAYERSANCTIONAPPEAL_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SANCTIONS_CREATEPLAYERSANCTIONAPPEAL_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user sending their own sanction appeal. */
	public EOS_ProductUserId LocalUserId;
	/** Reason code for the appeal. */
	public EOS_ESanctionAppealReason Reason;
	/** A unique identifier for the specific sanction */
	public String ReferenceId;

	public EOS_Sanctions_CreatePlayerSanctionAppealOptions() {
		super();
		ApiVersion = EOS_SANCTIONS_CREATEPLAYERSANCTIONAPPEAL_API_LATEST;
	}

	public EOS_Sanctions_CreatePlayerSanctionAppealOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sanctions_CreatePlayerSanctionAppealOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sanctions_CreatePlayerSanctionAppealOptions implements Structure.ByValue {
	}
}