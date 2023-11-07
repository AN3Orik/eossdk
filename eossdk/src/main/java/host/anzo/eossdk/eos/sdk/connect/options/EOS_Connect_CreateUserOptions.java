/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ContinuanceToken;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_CreateUser function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ContinuanceToken"})
public class EOS_Connect_CreateUserOptions extends Structure {
	/** The most recent version of the EOS_Connect_CreateUser API. */
	public static int EOS_CONNECT_CREATEUSER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CONNECT_CREATEUSER_API_LATEST}. */
	public int ApiVersion;
	/** Continuance token from previous call to EOS_Connect_Login */
	public EOS_ContinuanceToken ContinuanceToken;

	public EOS_Connect_CreateUserOptions() {
		super();
		ApiVersion = EOS_CONNECT_CREATEUSER_API_LATEST;
	}

	public EOS_Connect_CreateUserOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_CreateUserOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_CreateUserOptions implements Structure.ByValue {
	}
}