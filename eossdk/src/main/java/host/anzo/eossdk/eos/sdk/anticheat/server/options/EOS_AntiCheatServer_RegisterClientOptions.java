/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientPlatform;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientType;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eosex.IEOSNetworkClient;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle", "ClientType", "ClientPlatform", "AccountId_DEPRECATED", "IpAddress", "UserId"})
public class EOS_AntiCheatServer_RegisterClientOptions extends Structure {
	public static int EOS_ANTICHEATSERVER_REGISTERCLIENT_API_LATEST = 2;

	/** API Version: Set this to EOS_ANTICHEATSERVER_REGISTERCLIENT_API_LATEST. */
	public int ApiVersion;
	/** Locally unique value describing the remote user (e.g. a player object pointer) */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** Type of remote user being registered */
	public EOS_EAntiCheatCommonClientType ClientType;
	/** Remote user's platform, if known */
	public EOS_EAntiCheatCommonClientPlatform ClientPlatform;
	/**
	 * DEPRECATED - New code should set this to null and specify UserId instead.
	 * Identifier for the remote user. This is typically a string representation of an
	 * account ID, but it can be any string which is both unique (two different users will never
	 * have the same string) and consistent (if the same user connects to this game session
	 * twice, the same string will be used) in the scope of a single protected game session.
	 */
	public String AccountId_DEPRECATED;
	/**
	 * Optional IP address for the remote user. May be null if not available.
	 * IPv4 format: "0.0.0.0"
	 * IPv6 format: "0:0:0:0:0:0:0:0"
	 */
	public String IpAddress;
	/** The Product User ID for the remote user who is being registered. */
	public EOS_ProductUserId UserId;

	public EOS_AntiCheatServer_RegisterClientOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_REGISTERCLIENT_API_LATEST;
	}

	public EOS_AntiCheatServer_RegisterClientOptions(@NotNull IEOSNetworkClient client) {
		this();
		ClientHandle = client.getHandle();
		ClientType = client.getProtectedType();
		ClientPlatform = client.getPlatformType();
		IpAddress = client.getIpAddress();
		UserId = client.getProductUserId();
	}

	public EOS_AntiCheatServer_RegisterClientOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_RegisterClientOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatServer_RegisterClientOptions implements Structure.ByValue {
	}
}