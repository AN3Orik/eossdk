/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Auth_QueryIdToken function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "TargetAccountId"})
public class EOS_Auth_QueryIdTokenOptions extends Structure {
	public static int EOS_AUTH_QUERYIDTOKEN_API_LATEST = 1;

	/** API Version: Set this to EOS_AUTH_QUERYIDTOKEN_API_LATEST. */
	public int ApiVersion = EOS_AUTH_QUERYIDTOKEN_API_LATEST;
	/** The Epic Account ID of the local authenticated user. */
	public EOS_EpicAccountId LocalUserId;
	/**
	 * The target Epic Account ID for which to query an ID token.
	 * This account id may be the same as the input LocalUserId or another merged account id associated with the local user's Epic account.
	 * <p>
	 * An ID token for the selected account id of a locally authenticated user will always be readily available.
	 * To retrieve it for the selected account ID, you can use EOS_Auth_CopyIdToken directly after a successful user login.
	 */
	public EOS_EpicAccountId TargetAccountId;

	public EOS_Auth_QueryIdTokenOptions() {
		super();
		ApiVersion = EOS_AUTH_QUERYIDTOKEN_API_LATEST;
	}
	public EOS_Auth_QueryIdTokenOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_QueryIdTokenOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_QueryIdTokenOptions implements Structure.ByValue {
	}
}