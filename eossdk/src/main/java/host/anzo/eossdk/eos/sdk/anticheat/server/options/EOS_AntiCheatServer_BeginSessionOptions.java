/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eosex.EOSServerOptions;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "RegisterTimeoutSeconds", "ServerName", "EnableGameplayData", "LocalUserId"})
public class EOS_AntiCheatServer_BeginSessionOptions extends Structure {
	/** Limits on RegisterTimeoutSeconds parameter */
	public static int EOS_ANTICHEATSERVER_BEGINSESSION_MIN_REGISTERTIMEOUT = 10;
	public static int EOS_ANTICHEATSERVER_BEGINSESSION_MAX_REGISTERTIMEOUT = 120;

	public static int EOS_ANTICHEATSERVER_BEGINSESSION_API_LATEST = 3;

	/** API Version: Set this to {@link #EOS_ANTICHEATSERVER_BEGINSESSION_API_LATEST}. */
	public int ApiVersion;
	/**
	 * Time in seconds to allow newly registered clients to complete anti-cheat authentication.
	 * Recommended value: 60
	 */
	public int RegisterTimeoutSeconds;
	/** Optional name of this game server */
	public String ServerName;
	/**
	 * Gameplay data collection APIs such as LogPlayerTick will be enabled if set to true.
	 * If you do not use these APIs, it is more efficient to set this value to false.
	 */
	public EOS_Bool EnableGameplayData;
	/** The Product User ID of the local user who is associated with this session. Dedicated servers should set this to null. */
	public EOS_ProductUserId LocalUserId;

	public EOS_AntiCheatServer_BeginSessionOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_BEGINSESSION_API_LATEST;
	}

	public EOS_AntiCheatServer_BeginSessionOptions(@NotNull EOSServerOptions options) {
		this();
		RegisterTimeoutSeconds = Math.min(Math.max(options.getAntiCheatRegisterTimeoutSeconds(), EOS_ANTICHEATSERVER_BEGINSESSION_MIN_REGISTERTIMEOUT), EOS_ANTICHEATSERVER_BEGINSESSION_MAX_REGISTERTIMEOUT);
		ServerName = options.getAntiCheatServerName();
		EnableGameplayData = EOS_Bool.of(options.isAntiCheatEnableGamePlayData());
		LocalUserId = null;
	}

	public EOS_AntiCheatServer_BeginSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_BeginSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatServer_BeginSessionOptions implements Structure.ByValue {
	}
}