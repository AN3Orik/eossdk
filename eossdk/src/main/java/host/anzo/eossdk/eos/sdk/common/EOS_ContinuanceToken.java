/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidUserException;
import host.anzo.eossdk.eos.exceptions.EOSLimitExceededException;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import java.nio.ByteBuffer;

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

	/**
	 * Retrieve a null-terminated stringified continuance token from an EOS_ContinuanceToken.
	 * <p>
	 * To get the required buffer size, call once with OutBuffer set to NULL, InOutBufferLength will contain the buffer size needed.
	 * Call again with valid params to get the stringified continuance token which will only contain UTF8-encoded printable characters as well as the null-terminator.
	 *
	 * @return The continuance token stringified version
	 *
	 * @throws EOSInvalidParametersException Either OutBuffer or InOutBufferLength were passed as NULL parameters.
	 * @throws EOSInvalidUserException The AccountId is invalid and cannot be stringified.
	 * @throws EOSLimitExceededException The OutBuffer is not large enough receive the continuance token string. InOutBufferLength contains the required minimum length to perform the operation successfully.
	 */
	public String getString() throws EOSException {
		final ByteBuffer outBuffer = ByteBuffer.allocate(64);
		final IntByReference inOutBufferLength = new IntByReference(outBuffer.capacity());
		final EOS_EResult result = EOSLibrary.instance.EOS_ContinuanceToken_ToString(this, outBuffer, inOutBufferLength);
		if (result.isSuccess()) {
			return new String(outBuffer.array(), 0, inOutBufferLength.getValue()).trim();
		}
		throw EOSException.fromResult(result);
	}
}