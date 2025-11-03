package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_OnlinePlatformType;

/**
 * Contains information about a member of a lobby.
 * @author Anton Lasevich
 * @since 11/03/2025
 */
@FieldOrder({"ApiVersion", "UserId", "Platform", "AllowsCrossplay"})
public class EOS_LobbyDetails_MemberInfo extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_LobbyDetails_Info API. */
	public static final int EOS_LOBBYDETAILS_MEMBERINFO_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_LOBBYDETAILS_MEMBERINFO_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the lobby member. */
	public EOS_ProductUserId UserId;
	/** The platform of the lobby member. */
	public EOS_OnlinePlatformType Platform;
	/** Does this member allow crossplay */
	public int AllowsCrossplay;

	public EOS_LobbyDetails_MemberInfo() {
		super();
		ApiVersion = EOS_LOBBYDETAILS_MEMBERINFO_API_LATEST;
	}

	public EOS_LobbyDetails_MemberInfo(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with a member info. This must be called on data retrieved from {@link EOSLibrary#EOS_LobbyDetails_CopyMemberInfo}.
	 * @see EOSLibrary#EOS_LobbyDetails_CopyMemberInfo
	 */
	public void release() {
		EOSLibrary.instance.EOS_LobbyDetails_MemberInfo_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_LobbyDetails_MemberInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LobbyDetails_MemberInfo implements Structure.ByValue {
	}
}
