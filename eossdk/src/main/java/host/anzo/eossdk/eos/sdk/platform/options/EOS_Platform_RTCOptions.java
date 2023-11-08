/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.platform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ERTCBackgroundMode;
import host.anzo.eossdk.eos.sdk.common.options.EOS_Windows_RTCOptions;

/**
 * Platform RTC options.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "PlatformSpecificOptions", "BackgroundMode"})
public class EOS_Platform_RTCOptions extends Structure {
	/** The most recent version of the EOS_Platform_RTCOptions API. */
	public static int EOS_PLATFORM_RTCOPTIONS_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_PLATFORM_RTCOPTIONS_API_LATEST}. */
	public int ApiVersion;
	/**
	 * This field is for platform specific initialization if any.
	 * <p>
	 * If provided then the structure will be located in System/eos_System.h.
	 * The structure will be named EOS_(System)_RTCOptions.
	 */
	public EOS_Windows_RTCOptions.ByReference PlatformSpecificOptions;
	/** Configures RTC behavior upon entering to any background application statuses */
	public EOS_ERTCBackgroundMode BackgroundMode;

	public EOS_Platform_RTCOptions() {
		super();
		ApiVersion = EOS_PLATFORM_RTCOPTIONS_API_LATEST;
	}

	public EOS_Platform_RTCOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Platform_RTCOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Platform_RTCOptions implements Structure.ByValue {
	}
}