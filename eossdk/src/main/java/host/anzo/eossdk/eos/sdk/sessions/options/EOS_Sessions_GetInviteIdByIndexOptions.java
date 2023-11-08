package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Sessions_GetInviteIdByIndex function.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Index"})
public class EOS_Sessions_GetInviteIdByIndexOptions extends Structure {
	public static final int EOS_SESSIONS_GETINVITEIDBYINDEX_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_GETINVITEIDBYINDEX_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the local user who has an invitation in the cache */
	public EOS_ProductUserId LocalUserId;
	/** Index of the invite ID to retrieve */
	public int Index;

	public EOS_Sessions_GetInviteIdByIndexOptions() {
		super();
		ApiVersion = EOS_SESSIONS_GETINVITEIDBYINDEX_API_LATEST;
	}

	public EOS_Sessions_GetInviteIdByIndexOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_GetInviteIdByIndexOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_GetInviteIdByIndexOptions implements Structure.ByValue {
	}
}