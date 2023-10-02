/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Output parameters for the EOS_Auth_VerifyIdToken Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "ApplicationId", "ClientId", "ProductId", "SandboxId", "DeploymentId", "DisplayName", "IsExternalAccountInfoPresent", "ExternalAccountIdType", "ExternalAccountId", "ExternalAccountDisplayName", "Platform"})
public class EOS_Auth_VerifyIdTokenCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. {@link EOS_EResult#EOS_Success} indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Auth_VerifyIdToken */
	public Pointer ClientData;
	/**
	 * Epic Account Services Application ID.
	 */
	public String ApplicationId;
	/**
	 * Client ID of the authorized client.
	 */
	public String ClientId;
	/**
	 * Product ID.
	 */
	public String ProductId;
	/**
	 * Sandbox ID.
	 */
	public String SandboxId;
	/**
	 * Deployment ID.
	 */
	public String DeploymentId;
	/**
	 * Epic Account display name.
	 * <p>
	 * This value may be set to an empty string.
	 */
	public String DisplayName;
	/**
	 * Flag set to indicate whether external account information is present.
	 * Applications must always first check this value to be set before attempting
	 * to read the ExternalAccountIdType, ExternalAccountId, ExternalAccountDisplayName and Platform fields.
	 * <p>
	 * This flag is set when the user has logged in to their Epic Account using external account credentials, e.g. through local platform authentication.
	 */
	public EOS_Bool IsExternalAccountInfoPresent;
	/**
	 * The identity provider that the user logged in with to their Epic Account.
	 * <p>
	 * If IsExternalAccountInfoPresent is set, this field describes the external account type.
	 */
	public EOS_EExternalAccountType ExternalAccountIdType;
	/**
	 * The external account ID of the logged in user.
	 * <p>
	 * This value may be set to an empty string.
	 */
	public String ExternalAccountId;
	/**
	 * The external account display name.
	 * <p>
	 * This value may be set to an empty string.
	 */
	public String ExternalAccountDisplayName;
	/**
	 * Platform that the user is connected from.
	 * <p>
	 * This value may be set to an empty string.
	 */
	public String Platform;

	public EOS_Auth_VerifyIdTokenCallbackInfo() {
		super();
	}

	public EOS_Auth_VerifyIdTokenCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_VerifyIdTokenCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_VerifyIdTokenCallbackInfo implements Structure.ByValue {
	}
}