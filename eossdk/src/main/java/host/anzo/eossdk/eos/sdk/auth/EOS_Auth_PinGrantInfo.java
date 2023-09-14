/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Intermediate data needed to complete the EOS_LCT_DeviceCode and EOS_LCT_ExternalAuth login flows, returned by EOS_Auth_LoginCallbackInfo.
 * The data inside should be exposed to the user for entry on a secondary device.
 * All data must be copied out before the completion of this callback.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "UserCode", "VerificationURI", "ExpiresIn", "VerificationURIComplete"})
public class EOS_Auth_PinGrantInfo extends Structure {
	public static int EOS_AUTH_PINGRANTINFO_API_LATEST = 2;

	/** API Version: Set this to EOS_AUTH_PINGRANTINFO_API_LATEST. */
	public int ApiVersion;
	/** Code the user must input on an external device to activate the login */
	public String UserCode;
	/** The end-user verification URI. Users can be asked to manually type this into their browser. */
	public String VerificationURI;
	/** Time the user has, in seconds, to complete the process or else timeout */
	public int ExpiresIn;
	/** A verification URI that includes the user code. Useful for non-textual transmission. */
	public String VerificationURIComplete;

	public EOS_Auth_PinGrantInfo() {
		super();
		ApiVersion = EOS_AUTH_PINGRANTINFO_API_LATEST;
	}

	public EOS_Auth_PinGrantInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_PinGrantInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_PinGrantInfo implements Structure.ByValue {
	}
}