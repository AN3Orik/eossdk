/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Connect_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_CopyIdTokenOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A structure that contains an ID token.
 * These structures are created by {@link EOS_Connect_Interface#copyIdToken(EOS_Connect_CopyIdTokenOptions, ByReference[])} and must be passed to {@link EOS_Connect_IdToken#release()}
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ProductUserId", "JsonWebToken"})
public class EOS_Connect_IdToken extends Structure implements AutoCloseable {
	public static int EOS_CONNECT_IDTOKEN_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_IDTOKEN_API_LATEST. */
	public int ApiVersion;
	/**
	 * The Product User ID described by the ID token.
	 * Use EOS_ProductUserId_FromString to populate this field when validating a received ID token.
	 */
	public EOS_ProductUserId ProductUserId;
	/** The ID token as a Json Web Token (JWT) string. */
	public String JsonWebToken;

	public EOS_Connect_IdToken() {
		super();
		ApiVersion = EOS_CONNECT_IDTOKEN_API_LATEST;
	}

	public EOS_Connect_IdToken(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an EOS_Connect_IdToken structure. This must be called on data retrieved from EOS_Connect_CopyIdToken.
	 *
	 * @see EOS_Connect_IdToken
	 * @see EOS_Connect_Interface#copyIdToken(EOS_Connect_CopyIdTokenOptions, EOS_Connect_IdToken.ByReference[])
	 */
	public void release() {
		EOSLibrary.instance.EOS_Connect_IdToken_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Connect_IdToken implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_IdToken implements Structure.ByValue {
	}
}