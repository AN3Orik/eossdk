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
 * Input parameters for the EOS_Connect_CopyProductUserExternalAccountByAccountId function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "TargetUserId", "AccountId"})
public class EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions extends Structure {
	/** The most recent version of the EOS_Connect_CopyProductUserExternalAccountByAccountId API. */
	public static int EOS_CONNECT_COPYPRODUCTUSEREXTERNALACCOUNTBYACCOUNTID_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_COPYPRODUCTUSEREXTERNALACCOUNTBYACCOUNTID_API_LATEST. */
	public int ApiVersion;
	/** The Product User ID to look for when copying external account info from the cache. */
	public EOS_ProductUserId TargetUserId;
	/** External auth service account ID to look for when copying external account info from the cache. */
	public String AccountId;

	public EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions() {
		super();
		ApiVersion = EOS_CONNECT_COPYPRODUCTUSEREXTERNALACCOUNTBYACCOUNTID_API_LATEST;
	}

	public EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions implements Structure.ByValue {
	}
}