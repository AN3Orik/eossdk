package host.anzo.eossdk.eos.sdk.auth.enums;

import com.sun.jna.FromNativeContext;
import host.anzo.eossdk.jna.runtime.NativeMappedBitMask;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Flags that describe user permissions
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter class EOS_EAuthScopeFlags extends NativeMappedBitMask {
	/** Default value, no permissions required */
	public static final int EOS_AS_NoFlags = 0x0;
	/** Permissions to see your account ID, display name, and language */
	public static final int EOS_AS_BasicProfile = 0x1;
	/** Permissions to see a list of your friends who use this application */
	public static final int EOS_AS_FriendsList = 0x2;
	/** Permissions to set your online presence and see presence of your friends */
	public static final int EOS_AS_Presence = 0x4;
	/** Permissions to manage the Epic friends list. This scope is restricted to Epic first party products, and attempting to use it will result in authentication failures. */
	public static final int EOS_AS_FriendsManagement = 0x8;
	/** Permissions to see email in the response when fetching information for a user. This scope is restricted to Epic first party products, and attempting to use it will result in authentication failures. */
	public static final int EOS_AS_Email = 0x10;
	/** Permissions to see your country */
	public static final int EOS_AS_Country = 0x20;

	public static @NotNull EOS_EAuthScopeFlags of(int... flags) {
		final EOS_EAuthScopeFlags result = new EOS_EAuthScopeFlags();
		result.setFlags(flags);
		return result;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		final EOS_EAuthScopeFlags value = new EOS_EAuthScopeFlags();
		value.bitMask = (int) nativeValue;
		return value;
	}
}