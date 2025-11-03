package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_CustomInvites_AddNotifySendCustomNativeInviteRequested} function.
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_CustomInvites_AddNotifySendCustomNativeInviteRequestedOptions extends Structure {
	/** The most recent version of the EOS_CustomInvites_AddNotifySendCustomNativeInviteRequested API. */
	public static final int EOS_CUSTOMINVITES_ADDNOTIFYSENDCUSTOMNATIVEINVITEREQUESTED_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CUSTOMINVITES_ADDNOTIFYSENDCUSTOMNATIVEINVITEREQUESTED_API_LATEST}. */
	public int ApiVersion;

	public EOS_CustomInvites_AddNotifySendCustomNativeInviteRequestedOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_ADDNOTIFYSENDCUSTOMNATIVEINVITEREQUESTED_API_LATEST;
	}

	public EOS_CustomInvites_AddNotifySendCustomNativeInviteRequestedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_AddNotifySendCustomNativeInviteRequestedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_AddNotifySendCustomNativeInviteRequestedOptions implements Structure.ByValue {
	}
}