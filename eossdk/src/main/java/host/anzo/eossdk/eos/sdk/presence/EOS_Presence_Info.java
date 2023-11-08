package host.anzo.eossdk.eos.sdk.presence;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Presence_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.presence.enums.EOS_Presence_EStatus;
import host.anzo.eossdk.eos.sdk.presence.options.EOS_Presence_CopyPresenceOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * All the known presence information for a specific user. This object must be released by calling EOS_Presence_Info_Release.
 *
 * @see EOS_Presence_Interface#copyPresence(EOS_Presence_CopyPresenceOptions)
 * @see EOS_Presence_Info#release()
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ApiVersion", "Status", "UserId", "ProductId", "ProductVersion", "Platform", "RichText", "RecordsCount", "Records", "ProductName", "IntegratedPlatform"})
public class EOS_Presence_Info extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Presence_Info API. */
	public static final int EOS_PRESENCE_INFO_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_PRESENCE_INFO_API_LATEST}. */
	public int ApiVersion;
	/**
	 * The status of the user
	 */
	public EOS_Presence_EStatus Status;
	/** The Epic Account ID of the user */
	public EOS_EpicAccountId UserId;
	/** The product ID that the user is logged in from */
	public String ProductId;
	/** The version of the product the user is logged in from */
	public String ProductVersion;
	/** The platform of that the user is logged in from */
	public String Platform;
	/** The rich-text of the user */
	public String RichText;
	/** The count of records available */
	public int RecordsCount;
	/** The first data record, or NULL if RecordsCount is not at least 1 */
	public EOS_Presence_DataRecord.ByReference Records;
	/** The user-facing name for the product the user is logged in from */
	public String ProductName;
	/** The integrated platform that the user is logged in with */
	public String IntegratedPlatform;

	public EOS_Presence_Info() {
		super();
		ApiVersion = EOS_PRESENCE_INFO_API_LATEST;
	}

	public EOS_Presence_Info(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an EOS_Presence_Info structure and its sub-objects. This must be called on data retrieved from EOS_Presence_CopyPresence.
	 * This can be safely called on a NULL presence info object.
	 */
	public void release() {
		EOSLibrary.instance.EOS_Presence_Info_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Presence_Info implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_Info implements Structure.ByValue {
	}
}