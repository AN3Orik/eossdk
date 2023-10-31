/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.platform;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EDesktopCrossplayStatus;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Platform_GetDesktopCrossplayStatus function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"Status", "ServiceInitResult"})
public class EOS_Platform_DesktopCrossplayStatusInfo extends Structure {
	/**
	 * Status for the availability of desktop crossplay functionality.
	 * <p>
	 * It is recommended to include this value in application logs, and as as part of
	 * any player-facing error screens to help troubleshooting possible issues.
	 */
	public EOS_EDesktopCrossplayStatus Status;
	/**
	 * This field is set when the Status is EOS_DCS_ServiceStartFailed.
	 * <p>
	 * Possible values for this field are not documented. However, it is recommended
	 * to be also included in application logs, and as part of any player-facing
	 * error screens.
	 */
	public int ServiceInitResult;

	public EOS_Platform_DesktopCrossplayStatusInfo() {
		super();
	}

	public EOS_Platform_DesktopCrossplayStatusInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Platform_DesktopCrossplayStatusInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Platform_DesktopCrossplayStatusInfo implements Structure.ByValue {
	}
}