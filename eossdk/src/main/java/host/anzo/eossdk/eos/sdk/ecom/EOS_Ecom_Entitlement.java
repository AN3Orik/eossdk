package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single entitlement associated with an account. Instances of this structure are
 * created by EOS_Ecom_CopyEntitlementByIndex, EOS_Ecom_CopyEntitlementByNameAndIndex, or EOS_Ecom_CopyEntitlementById.
 * They must be passed to EOS_Ecom_Entitlement_Release.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "EntitlementName", "EntitlementId", "CatalogItemId", "ServerIndex", "bRedeemed", "EndTimestamp"})
public class EOS_Ecom_Entitlement extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Ecom_Entitlement struct. */
	public static final int EOS_ECOM_ENTITLEMENT_API_LATEST = 2;

	/** Timestamp value representing an undefined EndTimestamp for EOS_Ecom_Entitlement */
	public static final int EOS_ECOM_ENTITLEMENT_ENDTIMESTAMP_UNDEFINED = -1;

	/** API Version: Set this to EOS_ECOM_ENTITLEMENT_API_LATEST. */
	public int ApiVersion;
	/** Name of the entitlement */
	public String EntitlementName;
	/** ID of the entitlement owned by an account */
	public String EntitlementId;
	/** ID of the item associated with the offer which granted this entitlement */
	public String CatalogItemId;
	/**
	 * If queried using pagination then ServerIndex represents the index of the entitlement as it
	 * exists on the server.  If not queried using pagination then ServerIndex will be -1.
	 */
	public int ServerIndex;
	/** If true then the catalog has this entitlement marked as redeemed */
	public int bRedeemed;
	/** If not -1 then this is a POSIX timestamp that this entitlement will end */
	public long EndTimestamp;

	public EOS_Ecom_Entitlement() {
		super();
		ApiVersion = EOS_ECOM_ENTITLEMENT_API_LATEST;
	}

	public EOS_Ecom_Entitlement(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_Ecom_Entitlement_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Ecom_Entitlement implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_Entitlement implements Structure.ByValue {
	}
}