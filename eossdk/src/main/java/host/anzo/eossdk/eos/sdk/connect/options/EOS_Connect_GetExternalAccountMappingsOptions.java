/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_GetExternalAccountMapping function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "AccountIdType", "TargetExternalUserId"})
public class EOS_Connect_GetExternalAccountMappingsOptions extends Structure {
	/** The most recent version of the EOS_Connect_GetExternalAccountMapping API. */
	public static int EOS_CONNECT_GETEXTERNALACCOUNTMAPPING_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_GETEXTERNALACCOUNTMAPPING_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the existing, logged-in user who is querying account mappings. */
	public EOS_ProductUserId LocalUserId;
	/** External auth service supplying the account IDs in string form. */
	public EOS_EExternalAccountType AccountIdType;
	/** Target user to retrieve the mapping for, as an external account ID. */
	public String TargetExternalUserId;

	public EOS_Connect_GetExternalAccountMappingsOptions() {
		super();
		ApiVersion = EOS_CONNECT_GETEXTERNALACCOUNTMAPPING_API_LATEST;
	}

	public EOS_Connect_GetExternalAccountMappingsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_GetExternalAccountMappingsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_GetExternalAccountMappingsOptions implements Structure.ByValue {
	}
}