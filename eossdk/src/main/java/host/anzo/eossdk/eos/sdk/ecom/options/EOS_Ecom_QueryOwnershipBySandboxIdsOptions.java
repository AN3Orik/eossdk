package host.anzo.eossdk.eos.sdk.ecom.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Ecom_QueryOwnershipBySandboxIds function.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "SandboxIds", "SandboxIdsCount"})
public class EOS_Ecom_QueryOwnershipBySandboxIdsOptions extends Structure {
	/** The maximum number of Sandbox Ids that may be queried in a single pass. */
	public static final int EOS_ECOM_QUERYOWNERSHIP_MAX_SANDBOX_IDS = 10;

	/** The most recent version of the EOS_Ecom_QueryOwnershipBySandboxIds API. */
	public static final int EOS_ECOM_QUERYOWNERSHIPBYSANDBOXIDSOPTIONS_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_QUERYOWNERSHIPBYSANDBOXIDSOPTIONS_API_LATEST. */
	public int ApiVersion;
	/** The Epic Account ID of the local user whose ownership to query. */
	public EOS_EpicAccountId LocalUserId;
	/** The array of Sandbox IDs to check for ownership. */
	public StringArray SandboxIds;
	/** The number of Sandbox IDs in the query. */
	public int SandboxIdsCount;

	public EOS_Ecom_QueryOwnershipBySandboxIdsOptions() {
		super();
		ApiVersion = EOS_ECOM_QUERYOWNERSHIPBYSANDBOXIDSOPTIONS_API_LATEST;
	}

	public EOS_Ecom_QueryOwnershipBySandboxIdsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Ecom_QueryOwnershipBySandboxIdsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_QueryOwnershipBySandboxIdsOptions implements Structure.ByValue {
	}
}