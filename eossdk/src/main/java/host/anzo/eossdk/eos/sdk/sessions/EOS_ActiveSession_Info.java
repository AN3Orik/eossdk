package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.sessions.enums.EOS_EOnlineSessionState;
import host.anzo.eossdk.eos.sdk.sessions.options.EOS_ActiveSession_CopyInfoOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 9/5/2023
 */
@FieldOrder({"ApiVersion", "SessionName", "LocalUserId", "State", "SessionDetails"})
public class EOS_ActiveSession_Info extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_ActiveSession_Info struct. */
	public static final int EOS_ACTIVESESSION_INFO_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ACTIVESESSION_INFO_API_LATEST}. */
	public int ApiVersion;
	/** Name of the session */
	public Pointer SessionName;
	/** The Product User ID of the local user who created or joined the session */
	public EOS_ProductUserId LocalUserId;
	/** Current state of the session */
	public EOS_EOnlineSessionState State;
	/** Session details */
	public EOS_SessionDetails_Info.ByReference SessionDetails;

	public EOS_ActiveSession_Info() {
		super();
		ApiVersion = EOS_ACTIVESESSION_INFO_API_LATEST;
	}

	public EOS_ActiveSession_Info(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an EOS_ActiveSession_Info structure. This must be called on data retrieved from EOS_ActiveSession_CopyInfo.
	 * @see EOS_ActiveSession#copyInfo(EOS_ActiveSession_CopyInfoOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_ActiveSession_Info_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_ActiveSession_Info implements Structure.ByReference {
	}

	public static class ByValue extends EOS_ActiveSession_Info implements Structure.ByValue {
	}
}