/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * All possible states of the application
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EApplicationStatus implements NativeMapped {
	/**
	 * Xbox only.
	 * <p>
	 * Notifies the SDK that the application has entered constrained mode.
	 * While in constrained mode, the application has reduced access to reserved system resources.
	 */
	EOS_AS_BackgroundConstrained(0),
	/**
	 * Xbox only.
	 * <p>
	 * Notifies the SDK that the application has returned from constrained mode,
	 * and is back to running in a regular state with full access to system resources.
	 * <p>
	 * The SDK will handle this state change and automatically transition its active state to EOS_AS_Foreground.
	 * As result, after the application has set the EOS_AS_BackgroundUnconstrained state,
	 * calling EOS_Platform_GetApplicationStatus will return EOS_AS_Foreground as the persisted active state.
	 */
	EOS_AS_BackgroundUnconstrained(1),
	/**
	 * Notifies the SDK that the application has been put into suspended state by the platform system.
	 */
	EOS_AS_BackgroundSuspended(2),
	/**
	 * Notifies the SDK that the application has been resumed from suspended state.
	 * <p>
	 * This is the default active state on all platforms.
	 */
	EOS_AS_Foreground(3);

	private final int id;

	private static final Map<Integer, EOS_EApplicationStatus> values = new HashMap<>();

	static {
		for (EOS_EApplicationStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EApplicationStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_AS_BackgroundConstrained);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}

	/**
	 * Gets the string representation of an EOS_EApplicationStatus value.
	 * <p>
	 * Example: EOS_EApplicationStatus_ToString(EOS_EApplicationStatus::EOS_AS_Foreground) returns "EOS_AS_Foreground".
	 *
	 * @return Pointer to a static string representing the input enum value.
	 *         The returned string is guaranteed to be non-null, and must not be freed by the application.
	 */
	@Override
	public String toString() {
		return EOSLibrary.instance.EOS_EApplicationStatus_ToString(this);
	}
}