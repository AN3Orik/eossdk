/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Connect_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalCredentialType;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_LoginOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A structure that contains external login credentials.
 * <p>
 * This is part of the input structure EOS_Connect_LoginOptions.
 *
 * @see EOS_EExternalCredentialType
 * @see EOS_Connect_Interface#login(EOS_Connect_LoginOptions, Pointer, EOS_Connect_OnLoginCallback)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "Token", "Type"})
public class EOS_Connect_Credentials extends Structure {
	/** The most recent version of the EOS_Connect_Credentials struct. */
	public static int EOS_CONNECT_CREDENTIALS_API_LATEST = 1;

	/** API Version: Set this to EOS_AUTH_CREDENTIALS_API_LATEST. */
	public int ApiVersion;
	/** External token associated with the user logging in. */
	public String Token;
	/** Type of external login; identifies the auth method to use. */
	public EOS_EExternalCredentialType Type;

	public EOS_Connect_Credentials() {
		super();
		ApiVersion = EOS_CONNECT_CREDENTIALS_API_LATEST;
	}

	public EOS_Connect_Credentials(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_Credentials implements Structure.ByReference {
		public ByReference() {
		}

		public ByReference(Pointer p) {
			super(p);
			read();
		}
	}

	public static class ByValue extends EOS_Connect_Credentials implements Structure.ByValue {
	}
}