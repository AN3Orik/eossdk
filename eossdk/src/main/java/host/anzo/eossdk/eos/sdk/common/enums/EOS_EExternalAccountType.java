package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Connect_Interface;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnQueryExternalAccountMappingsCallback;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_QueryExternalAccountMappingsOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * All supported external account providers
 * @see EOS_Connect_Interface#queryExternalAccountMappings(EOS_Connect_QueryExternalAccountMappingsOptions, Pointer, EOS_Connect_OnQueryExternalAccountMappingsCallback)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EExternalAccountType implements NativeMapped {
	/** External account is associated with Epic Games */
	EOS_EAT_EPIC(0),
	/** External account is associated with Steam */
	EOS_EAT_STEAM(1),
	/** External account is associated with PlayStation(TM)Network */
	EOS_EAT_PSN(2),
	/** External account is associated with Xbox Live */
	EOS_EAT_XBL(3),
	/** External account is associated with Discord */
	EOS_EAT_DISCORD(4),
	/** External account is associated with GOG */
	EOS_EAT_GOG(5),
	/**
	 * External account is associated with Nintendo
	 * <p>
	 * With both EOS Connect and EOS UserInfo APIs, the associated account type is Nintendo Service Account ID.
	 * Local user authentication is possible using Nintendo Account ID, while the account type does not get exposed to the SDK in queries related to linked accounts information.
	 */
	EOS_EAT_NINTENDO(6),
	/** External account is associated with Uplay */
	EOS_EAT_UPLAY(7),
	/** External account is associated with an OpenID Provider */
	EOS_EAT_OPENID(8),
	/** External account is associated with Apple */
	EOS_EAT_APPLE(9),
	/** External account is associated with Google */
	EOS_EAT_GOOGLE(10),
	/** External account is associated with Oculus */
	EOS_EAT_OCULUS(11),
	/** External account is associated with itch.io */
	EOS_EAT_ITCHIO(12),
	/** External account is associated with Amazon */
	EOS_EAT_AMAZON(13),
	/** External account is associated with Viveport */
	EOS_EAT_VIVEPORT(14);

	private final int id;

	private static final Map<Integer, EOS_EExternalAccountType> values = new HashMap<>();

	static {
		for (EOS_EExternalAccountType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EExternalAccountType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_EAT_EPIC);
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