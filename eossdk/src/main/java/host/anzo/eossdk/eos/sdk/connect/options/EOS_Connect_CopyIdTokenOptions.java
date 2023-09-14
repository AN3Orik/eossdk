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
 * Input parameters for the EOS_Connect_CopyIdToken function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId"})
public class EOS_Connect_CopyIdTokenOptions extends Structure {
	public static int EOS_CONNECT_COPYIDTOKEN_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_COPYIDTOKEN_API_LATEST. */
	public int ApiVersion = EOS_CONNECT_COPYIDTOKEN_API_LATEST;
	/** The local Product User ID whose ID token should be copied. */
	public EOS_ProductUserId LocalUserId;

	public EOS_Connect_CopyIdTokenOptions() {
		super();
		ApiVersion = EOS_CONNECT_COPYIDTOKEN_API_LATEST;
	}

	public EOS_Connect_CopyIdTokenOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_CopyIdTokenOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_CopyIdTokenOptions implements Structure.ByValue {
	}
}
