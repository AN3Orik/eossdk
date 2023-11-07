/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.auth.enums.EOS_ELinkAccountFlags;
import host.anzo.eossdk.eos.sdk.common.EOS_ContinuanceToken;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Auth_LinkAccount function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LinkAccountFlags", "ContinuanceToken", "LocalUserId"})
public class EOS_Auth_LinkAccountOptions extends Structure {
	/** The most recent version of the EOS_Auth_LinkAccount API. */
	public static int EOS_AUTH_LINKACCOUNT_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_AUTH_LINKACCOUNT_API_LATEST}. */
	public int ApiVersion;
	/**
	 * Combination of the enumeration flags to specify how the account linking operation will be performed.
	 * @see EOS_ELinkAccountFlags
	 */
	public EOS_ELinkAccountFlags LinkAccountFlags;
	/**
	 * Continuance token received from a previous call to the EOS_Auth_Login API.
	 * <p>
	 * A continuance token is received in the case when the external account used for login was not found to be linked
	 * against any existing Epic Account. In such case, the application needs to proceed with an account linking operation in which case
	 * the user is first asked to create a new account or login into their existing Epic Account, and then link their external account to it.
	 * Alternatively, the application may suggest the user to login using another external account that they have already linked to their existing Epic Account.
	 * In this flow, the external account is typically the currently logged in local platform user account.
	 * It can also be another external user account that the user is offered to login with.
	 */
	public EOS_ContinuanceToken ContinuanceToken;
	/**
	 * The Epic Account ID of the logged in local user whose Epic Account will be linked with the local Nintendo NSA ID Account. By default set to NULL.
	 * <p>
	 * This parameter is only used and required to be set when EOS_ELinkAccountFlags::EOS_LA_NintendoNsaId is specified.
	 * Otherwise, set to NULL, as the standard account linking and login flow using continuance token will handle logging in the user to their Epic Account.
	 */
	public EOS_EpicAccountId LocalUserId;

	public EOS_Auth_LinkAccountOptions() {
		super();
		ApiVersion = EOS_AUTH_LINKACCOUNT_API_LATEST;
	}

	public EOS_Auth_LinkAccountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_LinkAccountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_LinkAccountOptions implements Structure.ByValue {
	}
}