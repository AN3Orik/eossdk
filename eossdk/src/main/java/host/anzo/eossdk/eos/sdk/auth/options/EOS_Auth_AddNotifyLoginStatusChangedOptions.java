/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Auth_AddNotifyLoginStatusChanged Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Auth_AddNotifyLoginStatusChangedOptions extends Structure {
	/** The most recent version of the EOS_Auth_AddNotifyLoginStatusChanged API. */
	public static int EOS_AUTH_ADDNOTIFYLOGINSTATUSCHANGED_API_LATEST = 1;

	/** API Version: Set this to EOS_AUTH_ADDNOTIFYLOGINSTATUSCHANGED_API_LATEST. */
	public int ApiVersion;

	public EOS_Auth_AddNotifyLoginStatusChangedOptions() {
		super();
		ApiVersion = EOS_AUTH_ADDNOTIFYLOGINSTATUSCHANGED_API_LATEST;
	}

	public EOS_Auth_AddNotifyLoginStatusChangedOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_AddNotifyLoginStatusChangedOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_AddNotifyLoginStatusChangedOptions implements Structure.ByValue {
	}
}