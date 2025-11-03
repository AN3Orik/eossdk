package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Internal details about a session, found on both active sessions and within search results
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
@FieldOrder({"ApiVersion", "SessionId", "HostAddress", "NumOpenPublicConnections", "Settings", "OwnerUserId", "OwnerServerClientId"})
public class EOS_SessionDetails_Info extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_SessionDetails_Info struct. */
	public static final int EOS_SESSIONDETAILS_INFO_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_SESSIONDETAILS_INFO_API_LATEST}. */
	public int ApiVersion;
	/** Session ID assigned by the backend service */
	public String SessionId;
	/** IP address of this session as visible by the backend service */
	public String HostAddress;
	/** Number of remaining open spaces on the session (NumPublicConnections - RegisteredPlayers */
	public int NumOpenPublicConnections;
	/** Reference to the additional settings associated with this session */
	public EOS_SessionDetails_Settings.ByReference Settings;
	/** The Product User ID of the session owner. Null if the session is not owned by a user. */
	public EOS_ProductUserId OwnerUserId;
	/** The client id of the session owner. Null if the session is not owned by a server. The session is owned by a server if {@link EOS_Platform_Options#IsServer} is EOS_TRUE. */
	public Pointer OwnerServerClientId;

	public EOS_SessionDetails_Info() {
		super();
		ApiVersion = EOS_SESSIONDETAILS_INFO_API_LATEST;
	}

	public EOS_SessionDetails_Info(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an EOS_SessionDetails_Info structure. This must be called on data retrieved from {@link EOSLibrary#EOS_SessionDetails_CopyInfo}.
	 * @see EOS_SessionDetails_Info
	 * @see EOSLibrary#EOS_SessionDetails_CopyInfo
	 */
	public void release() {
		EOSLibrary.instance.EOS_SessionDetails_Info_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_SessionDetails_Info implements Structure.ByReference {
	}

	public static class ByValue extends EOS_SessionDetails_Info implements Structure.ByValue {
	}
}