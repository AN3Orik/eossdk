package host.anzo.eossdk.eos.sdk.presence.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * The result meta-data from setting a user's presence.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ResultCode", "ClientData", "LocalUserId"})
public class EOS_Presence_SetPresenceCallbackInfo extends Structure {
	/** Result code for the operation. EOS_Success is returned if presence was successfully set, other codes indicate an error */
	public EOS_EResult ResultCode;
	/** Client-specified data passed into EOS_Presence_SetPresence */
	public Pointer ClientData;
	/** The Epic Account ID of the local user that had their presence set */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Presence_SetPresenceCallbackInfo() {
		super();
	}

	public EOS_Presence_SetPresenceCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_SetPresenceCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_SetPresenceCallbackInfo implements Structure.ByValue {
	}
}