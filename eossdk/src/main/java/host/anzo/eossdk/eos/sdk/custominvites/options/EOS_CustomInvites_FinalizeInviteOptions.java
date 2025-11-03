package host.anzo.eossdk.eos.sdk.custominvites.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_CustomInvites_FinalizeInvite} function.
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "LocalUserId", "CustomInviteId", "ProcessingResult"})
public class EOS_CustomInvites_FinalizeInviteOptions extends Structure {
	/** The most recent version of the EOS_CustomInvites_FinalizeInvite API. */
	public final static int EOS_CUSTOMINVITES_FINALIZEINVITE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CUSTOMINVITES_FINALIZEINVITE_API_LATEST}. */
	public int ApiVersion;
	/** User that sent the custom invite */
	public EOS_ProductUserId TargetUserId;
	/** Recipient Local user id */
	public EOS_ProductUserId LocalUserId;
	/** Id of the Custom Invite accepted */
	public String CustomInviteId;
	/** Result of the Processing operation, transmitted to Social Overlay if applicable */
	public EOS_EResult ProcessingResult;

	public EOS_CustomInvites_FinalizeInviteOptions() {
		super();
		ApiVersion = EOS_CUSTOMINVITES_FINALIZEINVITE_API_LATEST;
	}

	public EOS_CustomInvites_FinalizeInviteOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_CustomInvites_FinalizeInviteOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_CustomInvites_FinalizeInviteOptions implements Structure.ByValue {
	}
}