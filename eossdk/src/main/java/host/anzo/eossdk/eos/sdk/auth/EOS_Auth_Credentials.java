/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.auth.enums.EOS_ELoginCredentialType;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalCredentialType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "Id", "Token", "Type", "SystemAuthCredentialsOptions", "ExternalType"})
public class EOS_Auth_Credentials extends Structure {
	/** The most recent version of the EOS_Auth_Credentials struct. */
	public static int EOS_AUTH_CREDENTIALS_API_LATEST = 4;

	/** API Version: Set this to EOS_AUTH_CREDENTIALS_API_LATEST. */
	public int ApiVersion;
	/** ID of the user logging in, based on EOS_ELoginCredentialType */
	public String Id;
	/** Credentials or token related to the user logging in */
	public String Token;
	/** Type of login. Needed to identify the auth method to use */
	public EOS_ELoginCredentialType Type;
	/**
	 * This field is for system specific options, if any.
	 * <p>
	 * If provided, the structure will be located in (System)/eos_(system).h.
	 * The structure will be named EOS_(System)_Auth_CredentialsOptions.
	 */
	public Pointer SystemAuthCredentialsOptions;
	/**
	 * Type of external login. Needed to identify the external auth method to use.
	 * Used when login type is set to EOS_LCT_ExternalAuth, ignored for other EOS_ELoginCredentialType methods.
	 */
	public EOS_EExternalCredentialType ExternalType;

	public EOS_Auth_Credentials() {
		super();
		ApiVersion = EOS_AUTH_CREDENTIALS_API_LATEST;
	}

	public EOS_Auth_Credentials(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_Credentials implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_Credentials implements Structure.ByValue {
	}
}