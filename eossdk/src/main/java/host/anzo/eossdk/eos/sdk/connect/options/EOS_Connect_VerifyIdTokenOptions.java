/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.connect.EOS_Connect_IdToken;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_VerifyIdToken function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "IdToken"})
public class EOS_Connect_VerifyIdTokenOptions extends Structure {
	public static int EOS_CONNECT_VERIFYIDTOKEN_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_VERIFYIDTOKEN_API_LATEST. */
	public int ApiVersion;
	/**
	 * The ID token to verify.
	 * Use EOS_ProductUserId_FromString to populate the ProductUserId field of this struct.
	 */
	public EOS_Connect_IdToken.ByReference IdToken;

	public EOS_Connect_VerifyIdTokenOptions() {
		super();
		ApiVersion = EOS_CONNECT_VERIFYIDTOKEN_API_LATEST;
	}

	public EOS_Connect_VerifyIdTokenOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_VerifyIdTokenOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_VerifyIdTokenOptions implements Structure.ByValue {
	}
}