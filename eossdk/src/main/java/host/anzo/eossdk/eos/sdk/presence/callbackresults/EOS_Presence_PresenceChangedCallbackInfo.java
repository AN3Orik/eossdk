package host.anzo.eossdk.eos.sdk.presence.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing which users presence has changed
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "PresenceUserId"})
public class EOS_Presence_PresenceChangedCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_Presence_AddNotifyOnPresenceChanged */
	public Pointer ClientData;
	/** The Epic Account ID of the local user who is being informed for PresenceUserId's presence change */
	public EOS_EpicAccountId LocalUserId;
	/** The Epic Account ID of the user who had their presence changed */
	public EOS_EpicAccountId PresenceUserId;

	public EOS_Presence_PresenceChangedCallbackInfo() {
		super();
	}

	public EOS_Presence_PresenceChangedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Presence_PresenceChangedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Presence_PresenceChangedCallbackInfo implements Structure.ByValue {
	}
}