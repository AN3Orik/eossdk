package host.anzo.eossdk.eos.sdk.sessions.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_SessionSearch_SetTargetUserId function.
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId"})
public class EOS_SessionSearch_SetTargetUserIdOptions extends Structure {
	/** The most recent version of the EOS_SessionSearch_SetTargetUserId API. */
	public static final int EOS_SESSIONSEARCH_SETTARGETUSERID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONSEARCH_SETTARGETUSERID_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID to find; return any sessions where the user matching this ID is currently registered */
	public EOS_ProductUserId TargetUserId;

	public EOS_SessionSearch_SetTargetUserIdOptions() {
		super();
		ApiVersion = EOS_SESSIONSEARCH_SETTARGETUSERID_API_LATEST;
	}

	public EOS_SessionSearch_SetTargetUserIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_SessionSearch_SetTargetUserIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionSearch_SetTargetUserIdOptions implements Structure.ByValue {
	}
}