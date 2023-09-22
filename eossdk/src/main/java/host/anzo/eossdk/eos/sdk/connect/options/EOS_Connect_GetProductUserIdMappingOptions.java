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
 * Input parameters for the EOS_Connect_GetProductUserIdMapping function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "AccountIdType", "TargetProductUserId"})
public class EOS_Connect_GetProductUserIdMappingOptions extends Structure {
	/** The most recent version of the EOS_Connect_GetProductUserIdMapping API. */
	public static int EOS_CONNECT_GETPRODUCTUSERIDMAPPING_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_GETPRODUCTUSERIDMAPPING_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID of the existing, logged-in user that is querying account mappings. */
	private EOS_ProductUserId LocalUserId;
	/** External auth service mapping to retrieve. */
	private EOS_EExternalAccountType AccountIdType;
	/** The Product User ID of the user whose information is being requested. */
	private EOS_ProductUserId TargetProductUserId;

	public EOS_Connect_GetProductUserIdMappingOptions() {
		super();
		ApiVersion = EOS_CONNECT_GETPRODUCTUSERIDMAPPING_API_LATEST;
	}

	public EOS_Connect_GetProductUserIdMappingOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_GetProductUserIdMappingOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_GetProductUserIdMappingOptions implements Structure.ByValue {
	}
}