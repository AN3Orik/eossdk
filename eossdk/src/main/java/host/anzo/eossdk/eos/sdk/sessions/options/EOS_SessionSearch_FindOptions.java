package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_Find function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_SessionSearch_FindOptions extends Structure {
	public static final int EOS_SESSIONSEARCH_FIND_API_LATEST = 2;

	/** API Version: Set this to EOS_SESSIONSEARCH_FIND_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the local user who is searching */
	public EOS_ProductUserId LocalUserId;

	public EOS_SessionSearch_FindOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_FIND_API_LATEST;
	}

	public EOS_SessionSearch_FindOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_FindOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_FindOptions implements Structure.ByValue {
	}
}