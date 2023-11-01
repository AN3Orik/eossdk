package host.anzo.eossdk.eos.sdk.ecom.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Ecom_Interface;
import host.anzo.eossdk.eos.sdk.ecom.callbacks.EOS_Ecom_OnRedeemEntitlementsCallback;
import host.anzo.eossdk.eos.sdk.ecom.options.EOS_Ecom_RedeemEntitlementsOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration defining the type of catalog item.  The primary use is to identify how the item is expended.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
public @Getter enum EOS_EEcomItemType implements NativeMapped {
	/** This entitlement is intended to persist. */
	EOS_EIT_Durable(0),
	/**
	 * This entitlement is intended to be transient and redeemed.
	 *
	 * @see EOS_Ecom_Interface#redeemEntitlements(EOS_Ecom_RedeemEntitlementsOptions, Pointer, EOS_Ecom_OnRedeemEntitlementsCallback)
	 */
	EOS_EIT_Consumable(1),
	/** This entitlement has a type that is not currently intended for an in-game store. */
	EOS_EIT_Other(2);

	private final int id;

	private static final Map<Integer, EOS_EEcomItemType> values = new HashMap<>();

	static {
		for (EOS_EEcomItemType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EEcomItemType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_EIT_Durable);
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