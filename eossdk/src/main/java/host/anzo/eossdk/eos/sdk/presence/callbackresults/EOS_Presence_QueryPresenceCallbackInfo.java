package host.anzo.eossdk.eos.sdk.presence.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * The result meta-data for a presence query.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId", "TargetUserId"})
public class EOS_Presence_QueryPresenceCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned for a successful query, other codes indicate an error */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_Presence_QueryPresence */
	public Pointer ClientData;
	/** The Epic Account ID of the local user who made this request */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user whose presence was potentially queried */
	public EOS_EpicAccountId TargetUserId;

	public EOS_Presence_QueryPresenceCallbackInfo() {
		super();
	}

	public EOS_Presence_QueryPresenceCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_QueryPresenceCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_QueryPresenceCallbackInfo implements Structure.ByValue {
	}
}