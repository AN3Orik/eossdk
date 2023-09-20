/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ResultCode", "ClientData", "ProductUserId", "bIsAccountInfoPresent", "AccountIdType", "AccountId", "Platform", "DeviceType", "ClientId", "ProductId", "SandboxId", "DeploymentId"})
public class EOS_Connect_VerifyIdTokenCallbackInfo extends Structure {
	/** The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors. */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Connect_VerifyIdToken */
	public Pointer ClientData;
	/** The Product User ID associated with the ID token. */
	public EOS_ProductUserId ProductUserId;
	/**
	 * Flag set to indicate whether account information is available.
	 * Applications must always first check this value to be set before attempting
	 * to read the AccountType, AccountId, Platform and DeviceType fields.
	 * <p>
	 * This flag is always false for users that authenticated using EOS Connect Device ID.
	 */
	public EOS_Bool bIsAccountInfoPresent;
	/**
	 * The identity provider that the user authenticated with to EOS Connect.
	 * <p>
	 * If bIsAccountInfoPresent is set, this field describes the external account type.
	 */
	public int AccountIdType;
	/**
	 * The external account ID of the authenticated user.
	 * <p>
	 * This value may be set to an empty string.
	 */
	public String AccountId;
	/**
	 * Platform that the user is connected from.
	 * <p>
	 * This value may be set to an empty string.
	 */
	public String Platform;
	/**
	 * Identifies the device type that the user is connected from.
	 * Can be used to securely verify that the user is connected through a real Console device.
	 * <p>
	 * This value may be set to an empty string.
	 */
	public String DeviceType;
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

	public EOS_Connect_VerifyIdTokenCallbackInfo() {
		super();
	}

	public EOS_Connect_VerifyIdTokenCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_VerifyIdTokenCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_VerifyIdTokenCallbackInfo implements Structure.ByValue {
	}
}