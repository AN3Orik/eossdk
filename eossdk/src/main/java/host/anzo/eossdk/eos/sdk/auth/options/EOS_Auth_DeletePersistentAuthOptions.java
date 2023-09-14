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
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "RefreshToken"})
public class EOS_Auth_DeletePersistentAuthOptions extends Structure {
	public static int EOS_AUTH_DELETEPERSISTENTAUTH_API_LATEST = 2;

	/** API Version: Set this to EOS_AUTH_DELETEPERSISTENTAUTH_API_LATEST. */
	public int ApiVersion;
	/**
	 * A long-lived refresh token that is used with the EOS_LCT_PersistentAuth login type and is to be revoked from the authentication server. Only used on Console platforms.
	 * On Desktop and Mobile platforms, set this parameter to NULL.
	 */
	public String RefreshToken;

	public EOS_Auth_DeletePersistentAuthOptions() {
		super();
		ApiVersion = EOS_AUTH_DELETEPERSISTENTAUTH_API_LATEST;
	}

	public EOS_Auth_DeletePersistentAuthOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_DeletePersistentAuthOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_DeletePersistentAuthOptions implements Structure.ByValue {
	}
}