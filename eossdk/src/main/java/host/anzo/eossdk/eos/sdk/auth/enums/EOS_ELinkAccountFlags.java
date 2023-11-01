/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.auth.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.auth.callbacks.EOS_Auth_OnLinkAccountCallback;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_LinkAccountOptions;
import host.anzo.eossdk.jna.runtime.NativeMappedBitMask;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Flags used to describe how the account linking operation is to be performed.
 * @see EOS_Auth_Interface#linkAccount(EOS_Auth_LinkAccountOptions, Pointer, EOS_Auth_OnLinkAccountCallback)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter class EOS_ELinkAccountFlags extends NativeMappedBitMask {
	/**
	 * Default flag used for a standard account linking operation.
	 * <p>
	 * This flag is set when using a continuance token received from a previous call to the EOS_Auth_Login API,
	 * when the local user has not yet been successfully logged in to an Epic Account yet.
	 */
	public static final int EOS_LA_NoFlags = 0x0;
	/**
	 * Specified when the EOS_ContinuanceToken describes a Nintendo NSA ID account type.
	 * <p>
	 * This flag is used only with, and must be set, when the continuance token was received from a previous call
	 * to the EOS_Auth_Login API using the EOS_EExternalCredentialType::EOS_ECT_NINTENDO_NSA_ID_TOKEN login type.
	 */
	public static final int EOS_LA_NintendoNsaId = 0x1;

	public static @NotNull EOS_ELinkAccountFlags of(int... flags) {
		final EOS_ELinkAccountFlags result = new EOS_ELinkAccountFlags();
		result.setFlags(flags);
		return result;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		final EOS_ELinkAccountFlags value = new EOS_ELinkAccountFlags();
		value.bitMask = (int) nativeValue;
		return value;
	}
}