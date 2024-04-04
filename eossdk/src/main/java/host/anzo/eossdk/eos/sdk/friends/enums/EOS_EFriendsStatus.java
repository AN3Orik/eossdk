package host.anzo.eossdk.eos.sdk.friends.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Friends_Interface;
import host.anzo.eossdk.eos.sdk.friends.callbacks.EOS_Friends_OnFriendsUpdateCallback;
import host.anzo.eossdk.eos.sdk.friends.options.EOS_Friends_AddNotifyFriendsUpdateOptions;
import host.anzo.eossdk.eos.sdk.friends.options.EOS_Friends_GetStatusOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of the different friendship statuses.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public @Getter enum EOS_EFriendsStatus implements NativeMapped {
	/** The two accounts have no friendship status. */
	EOS_FS_NotFriends(0),
	/**
	 * The local account has sent a friend invite to the other account.
	 * <p>
	 * NOTE: EOS_FS_InviteSent is not returned by {@link EOS_Friends_Interface#getStatus(EOS_Friends_GetStatusOptions)} or in {@link EOS_Friends_Interface#addNotifyFriendsUpdate(EOS_Friends_AddNotifyFriendsUpdateOptions, Pointer, EOS_Friends_OnFriendsUpdateCallback)} callbacks unless
	 *       the local account was logged in with the EOS_AS_FriendsManagement authentication scope. Friend invites are managed
	 *       automatically by the Social Overlay.
	 */
	EOS_FS_InviteSent(1),
	/**
	 * The other account has sent a friend invite to the local account.
	 * <p>
	 * NOTE: EOS_FS_InviteReceived is not returned by {@link EOS_Friends_Interface#getStatus(EOS_Friends_GetStatusOptions)} or in {@link EOS_Friends_Interface#addNotifyFriendsUpdate(EOS_Friends_AddNotifyFriendsUpdateOptions, Pointer, EOS_Friends_OnFriendsUpdateCallback)} callbacks unless
	 *       the local account was logged in with the EOS_AS_FriendsManagement authentication scope. Friend invites are managed
	 *       automatically by the Social Overlay.
	 */
	EOS_FS_InviteReceived(2),
	/** The accounts have accepted friendship. */
	EOS_FS_Friends(3);

	private final int id;

	private static final Map<Integer, EOS_EFriendsStatus> values = new HashMap<>();

	static {
		for (EOS_EFriendsStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EFriendsStatus(int id) {
		this.id = id;
	}

	@SuppressWarnings("unused")
	public static EOS_EFriendsStatus fromId(Integer id) {
		return values.getOrDefault(id, EOS_FS_NotFriends);
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_FS_NotFriends);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}