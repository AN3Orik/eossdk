/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.platform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Platform_GetDesktopCrossplayStatus function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Platform_GetDesktopCrossplayStatusOptions extends Structure {
	/** The most recent version of the EOS_Platform_GetDesktopCrossplayStatus API. */
	public static int EOS_PLATFORM_GETDESKTOPCROSSPLAYSTATUS_API_LATEST = 1;

	/** API Version: Set this to EOS_PLATFORM_GETDESKTOPCROSSPLAYSTATUS_API_LATEST. */
	public int ApiVersion;

	public EOS_Platform_GetDesktopCrossplayStatusOptions() {
		super();
		ApiVersion = EOS_PLATFORM_GETDESKTOPCROSSPLAYSTATUS_API_LATEST;
	}

	public EOS_Platform_GetDesktopCrossplayStatusOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Platform_GetDesktopCrossplayStatusOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Platform_GetDesktopCrossplayStatusOptions implements Structure.ByValue {
	}
}