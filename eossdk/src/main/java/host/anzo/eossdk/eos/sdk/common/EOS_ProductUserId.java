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
import host.anzo.eossdk.eos.sdk.EOS_Connect_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalCredentialType;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_LoginOptions;

import java.nio.ByteBuffer;

/**
 * A handle to a user's Product User ID (game services related ecosystem)
 * This ID is associated with any of the external account providers (of which Epic Account Services is one)
 * @see EOS_Connect_Interface#login(EOS_Connect_LoginOptions, Pointer, EOS_Connect_OnLoginCallback)
 * @see EOS_EExternalCredentialType
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public class EOS_ProductUserId extends PointerType {
	/** A character buffer of this size is large enough to fit a successful output of EOS_ProductUserId_ToString. This length does not include the null-terminator. */
	public static int EOS_PRODUCTUSERID_MAX_LENGTH = 32;

	public EOS_ProductUserId(Pointer address) {
		super(address);
	}

	public EOS_ProductUserId() {
		super();
	}

	/**
	 * Retrieve an EOS_ProductUserId from a raw string representing an Epic Online Services Product User ID. The input string must be null-terminated.
	 * NOTE: There is no validation on the string format, this should only be used with values serialized from legitimate sources such as EOS_ProductUserId_ToString
	 *
	 * @param productUserIdString The stringified product user ID for which to retrieve the Epic Online Services Product User ID
	 * @return The EOS_ProductUserId that corresponds to the ProductUserIdString
	 */
	public static EOS_ProductUserId fromString(String productUserIdString) {
		return EOSLibrary.instance.EOS_ProductUserId_FromString(productUserIdString);
	}

	/**
	 * Check whether or not the given account unique ID is considered valid
	 * NOTE: This will return true for any EOS_ProductUserId created with EOS_ProductUserId_FromString as there is no validation
	 *
	 * @return {@link EOS_Bool#EOS_TRUE} if the EOS_ProductUserId is valid, otherwise {@link EOS_Bool#EOS_FALSE}
	 */
	public boolean isValid() {
		return EOSLibrary.instance.EOS_ProductUserId_IsValid(this) == EOS_Bool.EOS_TRUE;
	}

	/**
	 * Retrieve a null-terminated stringified Product User ID from an EOS_ProductUserId. This is useful for replication of Product User IDs in multiplayer games.
	 * This string will be no larger than EOS_PRODUCTUSERID_MAX_LENGTH + 1 and will only contain UTF8-encoded printable characters as well as the null-terminator.
	 *
	 * @return The Product User ID stringified version
	 *
	 * @throws EOSInvalidParametersException Either OutBuffer or InOutBufferLength were passed as NULL parameters.
	 * @throws EOSInvalidUserException The AccountId is invalid and cannot be stringified.
	 * @throws EOSLimitExceededException The OutBuffer is not large enough to receive the Product User ID string. InOutBufferLength contains the required minimum length to perform the operation successfully.
	 */
	public String getString() throws EOSException {
		final ByteBuffer outBuffer = ByteBuffer.allocate(EOS_PRODUCTUSERID_MAX_LENGTH + 1);
		final IntByReference inOutBufferLength = new IntByReference(outBuffer.capacity());
		final EOS_EResult result = EOSLibrary.instance.EOS_ProductUserId_ToString(this, outBuffer, inOutBufferLength);
		if (result.isSuccess()) {
			return new String(outBuffer.array(), 0, inOutBufferLength.getValue()).trim();
		}
		throw EOSException.fromResult(result);
	}
}