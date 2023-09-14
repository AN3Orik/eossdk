/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_IdToken;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Auth_VerifyIdToken function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "IdToken"})
public class EOS_Auth_VerifyIdTokenOptions extends Structure {
	public static int EOS_AUTH_VERIFYIDTOKEN_API_LATEST = 1;

	/** API Version: Set this to EOS_AUTH_VERIFYUSERAUTH_API_LATEST. */
	public int ApiVersion;
	/**
	 * The ID token to verify.
	 * Use EOS_EpicAccountId_FromString to populate the AccountId field of this struct.
	 */
	public EOS_Auth_IdToken.ByReference IdToken;

	public EOS_Auth_VerifyIdTokenOptions() {
		super();
		ApiVersion = EOS_AUTH_VERIFYIDTOKEN_API_LATEST;
	}

	public EOS_Auth_VerifyIdTokenOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_VerifyIdTokenOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_VerifyIdTokenOptions implements Structure.ByValue {
	}
}