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
 * Input parameters for the EOS_Connect_QueryProductUserIdMappings function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "AccountIdType_DEPRECATED", "ProductUserIds", "ProductUserIdCount"})
public class EOS_Connect_QueryProductUserIdMappingsOptions extends Structure {
	/** The most recent version of the EOS_Connect_QueryProductUserIdMappings API. */
	public static int EOS_CONNECT_QUERYPRODUCTUSERIDMAPPINGS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CONNECT_QUERYPRODUCTUSERIDMAPPINGS_API_LATEST}. */
	public int ApiVersion;
	/**
	 * Game Clients set this field to the Product User ID of the local authenticated user querying account mappings.
	 * Game Servers set this field to NULL. Usage is allowed given that the configured client policy for server credentials permit it.
	 */
	public EOS_ProductUserId LocalUserId;
	/** Deprecated - all external mappings are included in this call, it is no longer necessary to specify this value. */
	public EOS_EExternalAccountType AccountIdType_DEPRECATED;
	/** An array of Product User IDs to query for the given external account representation. */
	public EOS_ProductUserId[] ProductUserIds;
	/** Number of Product User IDs to query. */
	public int ProductUserIdCount;

	public EOS_Connect_QueryProductUserIdMappingsOptions() {
		super();
		ApiVersion = EOS_CONNECT_QUERYPRODUCTUSERIDMAPPINGS_API_LATEST;
	}

	public EOS_Connect_QueryProductUserIdMappingsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_QueryProductUserIdMappingsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_QueryProductUserIdMappingsOptions implements Structure.ByValue {
	}
}