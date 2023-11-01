/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;
import host.anzo.eossdk.eos.sdk.EOS_Auth_Interface;
import host.anzo.eossdk.eos.sdk.EOS_Connect_Interface;
import host.anzo.eossdk.eos.sdk.auth.callbacks.EOS_Auth_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.auth.callbacks.EOS_Auth_OnLoginStatusChangedCallback;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_AddNotifyLoginStatusChangedOptions;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_LoginOptions;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnLoginCallback;
import host.anzo.eossdk.eos.sdk.connect.callbacks.EOS_Connect_OnLoginStatusChangedCallback;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_AddNotifyLoginStatusChangedOptions;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_LoginOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * All possible states of a local user
 * @see EOS_Auth_Interface#addNotifyLoginStatusChanged(EOS_Auth_AddNotifyLoginStatusChangedOptions, Pointer, EOS_Auth_OnLoginStatusChangedCallback)
 * @see EOS_Auth_Interface#getLoginStatus(EOS_EpicAccountId)
 * @see EOS_Auth_Interface#login(EOS_Auth_LoginOptions, Pointer, EOS_Auth_OnLoginCallback)
 * @see EOS_Connect_Interface#addNotifyLoginStatusChanged(EOS_Connect_AddNotifyLoginStatusChangedOptions, Pointer, EOS_Connect_OnLoginStatusChangedCallback)
 * @see EOS_Connect_Interface#getLoginStatus(EOS_ProductUserId)
 * @see EOS_Connect_Interface#login(EOS_Connect_LoginOptions, Pointer, EOS_Connect_OnLoginCallback)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_ELoginStatus implements NativeMapped {
	/** Player has not logged in or chosen a local profile */
	EOS_LS_NotLoggedIn(0),
	/** Player is using a local profile but is not logged in */
	EOS_LS_UsingLocalProfile(1),
	/** Player has been validated by the platform specific authentication service */
	EOS_LS_LoggedIn(2);

	private final int id;

	private static final Map<Integer, EOS_ELoginStatus> values = new HashMap<>();

	static {
		for (EOS_ELoginStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELoginStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_LS_NotLoggedIn);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}