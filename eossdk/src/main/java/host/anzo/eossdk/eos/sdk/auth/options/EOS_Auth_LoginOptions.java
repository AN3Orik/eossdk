/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.options;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_Credentials;
import host.anzo.eossdk.eos.sdk.auth.enums.EOS_EAuthScopeFlags;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Auth_Login function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "Credentials", "ScopeFlags"})
public class EOS_Auth_LoginOptions extends Structure {
	/**
	 * Specify login to be performed without SDK provided user interface.
	 * By default, and without this flag, the SDK uses the overlay or a system browser to show user interfaces during login
	 * when the user needs to perform some action. With this flag, an error such as EOS_Auth_UserInterfaceRequired is returned
	 * to the login callback, and no user interface is shown in those cases.
	 */
	public static long EOS_LF_NO_USER_INTERFACE = 0x00001;

	/** The most recent version of the EOS_Auth_Login API. */
	public static int EOS_AUTH_LOGIN_API_LATEST = 3;

	/** API Version: Set this to EOS_AUTH_LOGIN_API_LATEST. */
	public int ApiVersion;
	/** Credentials specified for a given login method */
	public EOS_Auth_Credentials.ByReference Credentials;
	/**
	 * Auth scope flags are permissions to request from the user while they are logging in. This is a bitwise-or union of EOS_EAuthScopeFlags flags defined above
	 */
	public EOS_EAuthScopeFlags ScopeFlags;
	/** Optional flags for the desired login behavior, e.g. {@link #EOS_LF_NO_USER_INTERFACE}. This is a bitwise-or union of the defined flags. */
	public NativeLong LoginFlags;

	public EOS_Auth_LoginOptions() {
		super();
		ApiVersion = EOS_AUTH_LOGIN_API_LATEST;
	}

	public EOS_Auth_LoginOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_LoginOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_LoginOptions implements Structure.ByValue {
	}
}