/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_QueryExternalAccountMappings function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "AccountIdType", "ExternalAccountIds", "ExternalAccountIdCount"})
public class EOS_Connect_QueryExternalAccountMappingsOptions extends Structure {
	/** The most recent version of the EOS_Connect_QueryExternalAccountMappings API. */
	public static int EOS_CONNECT_QUERYEXTERNALACCOUNTMAPPINGS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CONNECT_QUERYEXTERNALACCOUNTMAPPINGS_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the existing, logged-in user who is querying account mappings. */
	public EOS_ProductUserId LocalUserId;
	/** External auth service supplying the account IDs in string form. */
	public EOS_EExternalAccountType AccountIdType;
	/** An array of external account IDs to map to the product user ID representation. */
	public PointerByReference ExternalAccountIds;
	/** Number of account IDs to query. */
	public int ExternalAccountIdCount;

	public EOS_Connect_QueryExternalAccountMappingsOptions() {
		super();
		ApiVersion = EOS_CONNECT_QUERYEXTERNALACCOUNTMAPPINGS_API_LATEST;
	}

	public EOS_Connect_QueryExternalAccountMappingsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_QueryExternalAccountMappingsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_QueryExternalAccountMappingsOptions implements Structure.ByValue {
	}
}