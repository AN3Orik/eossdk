/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_GetProductUserExternalAccountCount function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId"})
public class EOS_Connect_GetProductUserExternalAccountCountOptions extends Structure {
	public static int EOS_CONNECT_GETPRODUCTUSEREXTERNALACCOUNTCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_GETPRODUCTUSEREXTERNALACCOUNTCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID to look for when getting external account info count from the cache. */
	public EOS_ProductUserId TargetUserId;

	public EOS_Connect_GetProductUserExternalAccountCountOptions() {
		super();
		ApiVersion = EOS_CONNECT_GETPRODUCTUSEREXTERNALACCOUNTCOUNT_API_LATEST;
	}

	public EOS_Connect_GetProductUserExternalAccountCountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_GetProductUserExternalAccountCountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_GetProductUserExternalAccountCountOptions implements Structure.ByValue {
	}
}