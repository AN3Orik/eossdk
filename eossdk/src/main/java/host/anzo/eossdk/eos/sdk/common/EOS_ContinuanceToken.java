/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import java.nio.IntBuffer;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public class EOS_ContinuanceToken extends PointerType {
	public EOS_ContinuanceToken(Pointer address) {
		super(address);
	}

	public EOS_ContinuanceToken() {
		super();
	}

	@Override
	public String toString() {
		String outBuffer = "";
		final IntBuffer inOutBufferLength = IntBuffer.allocate(64);
		final EOS_EResult result = EOSLibrary.instance.EOS_ContinuanceToken_ToString(this, outBuffer, inOutBufferLength);
		if (result.isSuccess()) {
			return outBuffer;
		}
		throw new RuntimeException("Error while EOS_ContinuanceToken.toString(): " + result);
	}
}