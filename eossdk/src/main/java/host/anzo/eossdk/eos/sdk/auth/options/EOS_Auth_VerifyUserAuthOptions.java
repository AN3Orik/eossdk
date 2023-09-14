/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_Token;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Auth_VerifyUserAuth function.
 * This operation is destructive, the pointer will remain the same but the data pointers inside will update
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "AuthToken"})
public class EOS_Auth_VerifyUserAuthOptions extends Structure {
	public static int EOS_AUTH_VERIFYUSERAUTH_API_LATEST = 1;

	/** API Version: Set this to EOS_AUTH_VERIFYUSERAUTH_API_LATEST. */
	public int ApiVersion;
	/** Auth token to verify against the backend service */
	public EOS_Auth_Token.ByReference AuthToken;

	public EOS_Auth_VerifyUserAuthOptions() {
		super();
		ApiVersion = EOS_AUTH_VERIFYUSERAUTH_API_LATEST;
	}

	public EOS_Auth_VerifyUserAuthOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_VerifyUserAuthOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_VerifyUserAuthOptions implements Structure.ByValue {
	}
}