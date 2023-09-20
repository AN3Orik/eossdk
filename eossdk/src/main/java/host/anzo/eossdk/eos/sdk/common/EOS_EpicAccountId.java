/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.auth.callbacks.EOS_Auth_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_LoginOptions;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import java.nio.IntBuffer;

/**
 * A handle to a user's Epic Account ID
 * This ID is associated with a specific login associated with Epic Account Services
 * @see EOS_Auth_Interface#login(EOS_Auth_LoginOptions, Pointer, EOS_Auth_OnLoginCallback)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public class EOS_EpicAccountId extends PointerType {
	/**
	 * A character buffer of this size is large enough to fit a successful output of EOS_EpicAccountId_ToString. This length does not include the null-terminator.
	 * The EpicAccountId data structure is opaque in nature and no assumptions of its structure should be inferred
	 */
	public static int EOS_EPICACCOUNTID_MAX_LENGTH = 32;

	public EOS_EpicAccountId(Pointer address) {
		super(address);
	}
	public EOS_EpicAccountId() {
		super();
	}

	/**
	 * Retrieve an EOS_EpicAccountId from a raw string representing an Epic Account ID. The input string must be null-terminated.
	 * NOTE: There is no validation on the string format, this should only be used with values serialized from legitimate sources such as EOS_EpicAccountId_ToString
	 *
	 * @param accountIdString The stringified account ID for which to retrieve the Epic Account ID
	 * @return The EOS_EpicAccountId that corresponds to the AccountIdString
	 */
	public static EOS_EpicAccountId fromString(String accountIdString) {
		return EOSLibrary.instance.EOS_EpicAccountId_FromString(accountIdString);
	}

	/**
	 * Check whether or not the given Epic Account ID is considered valid
	 * NOTE: This will return true for any EOS_EpicAccountId created with EOS_EpicAccountId_FromString as there is no validation
	 *
	 * @return {@link EOS_Bool#EOS_TRUE} if the EOS_EpicAccountId is valid, otherwise {@link EOS_Bool#EOS_FALSE}
	 */
	public boolean isValid() {
		return EOSLibrary.instance.EOS_EpicAccountId_IsValid(this) == EOS_Bool.EOS_TRUE;
	}

	@Override
	public String toString() {
		String outBuffer = "";
		final IntBuffer inOutBufferLength = IntBuffer.allocate(EOS_EPICACCOUNTID_MAX_LENGTH + 1);
		final EOS_EResult result = EOSLibrary.instance.EOS_EpicAccountId_ToString(this, outBuffer, inOutBufferLength);
		if (result.isSuccess()) {
			return outBuffer;
		}
		throw new RuntimeException("Error while EOS_EpicAccountId.toString(): " + result);
	}
}