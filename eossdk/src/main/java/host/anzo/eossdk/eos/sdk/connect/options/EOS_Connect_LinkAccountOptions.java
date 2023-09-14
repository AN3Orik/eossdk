/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ContinuanceToken;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_Login function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ContinuanceToken"})
public class EOS_Connect_LinkAccountOptions extends Structure {
	public static int EOS_CONNECT_LINKACCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_LINKACCOUNT_API_LATEST. */
	public int ApiVersion;
	/** The existing logged in product user for which to link the external account described by the continuance token. */
	public EOS_ProductUserId LocalUserId;
	/** Continuance token from previous call to EOS_Connect_Login. */
	public EOS_ContinuanceToken ContinuanceToken;

	public EOS_Connect_LinkAccountOptions() {
		super();
		ApiVersion = EOS_CONNECT_LINKACCOUNT_API_LATEST;
	}

	public EOS_Connect_LinkAccountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_LinkAccountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_LinkAccountOptions implements Structure.ByValue {
	}
}