package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_QueryInvites function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Sessions_QueryInvitesOptions extends Structure {
	public static final int EOS_SESSIONS_QUERYINVITES_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONS_QUERYINVITES_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID to query for invitations */
	public EOS_ProductUserId LocalUserId;

	public EOS_Sessions_QueryInvitesOptions() {
		super();
	}

	public EOS_Sessions_QueryInvitesOptions(Pointer peer) {
		super(peer);
		ApiVersion = EOS_SESSIONS_QUERYINVITES_API_LATEST;
	}

	public static class ByReference extends EOS_Sessions_QueryInvitesOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_QueryInvitesOptions implements Structure.ByValue {
	}
}