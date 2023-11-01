/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.EOS_Platform_Interface;
import host.anzo.eossdk.eos.sdk.platform.EOS_Platform_DesktopCrossplayStatusInfo;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_GetDesktopCrossplayStatusOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Possible statuses for the availability of desktop crossplay functionality.
 * @see EOS_Platform_Interface#getDesktopCrossplayStatus(EOS_Platform_GetDesktopCrossplayStatusOptions, EOS_Platform_DesktopCrossplayStatusInfo)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_EDesktopCrossplayStatus implements NativeMapped {
	/**
	 * Desktop crossplay is ready to use.
	 */
	EOS_DCS_OK(0),
	/**
	 * The application was not launched through the Bootstrapper.
	 */
	EOS_DCS_ApplicationNotBootstrapped(1),
	/**
	 * The redistributable service is not installed.
	 */
	EOS_DCS_ServiceNotInstalled(2),
	/**
	 * The service failed to start.
	 */
	EOS_DCS_ServiceStartFailed(3),
	/**
	 * The service was started successfully, but is no longer running in the background, for an unknown reason.
	 */
	EOS_DCS_ServiceNotRunning(4),
	/**
	 * The application has explicitly disabled the overlay through SDK initialization flags.
	 */
	EOS_DCS_OverlayDisabled(5),
	/**
	 * The overlay is not installed.
	 * <p>
	 * As the overlay is automatically installed and kept up-to-date by the redistributable service,
	 * this indicates that the user may have separately manually removed the installed overlay files.
	 */
	EOS_DCS_OverlayNotInstalled(6),
	/**
	 * The overlay was not loaded due to failing trust check on the digital signature of the file on disk.
	 * This error typically indicates one of the following root causes:
	 * - The Operating System's local certificate store is out of date.
	 * - The local system clock has skewed and is in the wrong time.
	 * - The file has been tampered with.
	 * - The file trust check timed out, either due to an issue with the local system or network connectivity.
	 * The first troubleshooting steps should be to check for any available Operating System updates,
	 * for example using the Windows Update, as well as verifying that the system time is correctly set.
	 */
	EOS_DCS_OverlayTrustCheckFailed(7),
	/**
	 * The overlay failed to load.
	 */
	EOS_DCS_OverlayLoadFailed(8);

	private final int id;

	private static final Map<Integer, EOS_EDesktopCrossplayStatus> values = new HashMap<>();

	static {
		for (EOS_EDesktopCrossplayStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EDesktopCrossplayStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_DCS_OK);
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