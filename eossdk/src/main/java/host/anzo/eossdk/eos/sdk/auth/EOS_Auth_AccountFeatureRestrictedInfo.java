/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Intermediate data needed to complete account restriction verification during login flow, returned by EOS_Auth_LoginCallbackInfo when the ResultCode is EOS_Auth_AccountFeatureRestricted
 * The URI inside should be exposed to the user for entry in a web browser. The URI must be copied out of this struct before completion of the callback.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "VerificationURI"})
public class EOS_Auth_AccountFeatureRestrictedInfo extends Structure {
	/** The most recent version of the EOS_Auth_AccountFeatureRestrictedInfo struct. */
	public static int EOS_AUTH_ACCOUNTFEATURERESTRICTEDINFO_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_AUTH_ACCOUNTFEATURERESTRICTEDINFO_API_LATEST}. */
	public int ApiVersion;
	/** The end-user verification URI. Users must be asked to open the page in a browser to address the restrictions */
	public String VerificationURI;

	public EOS_Auth_AccountFeatureRestrictedInfo() {
		super();
		ApiVersion = EOS_AUTH_ACCOUNTFEATURERESTRICTEDINFO_API_LATEST;
	}

	public EOS_Auth_AccountFeatureRestrictedInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Auth_AccountFeatureRestrictedInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Auth_AccountFeatureRestrictedInfo implements Structure.ByValue {
	}
}