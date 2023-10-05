/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientFlags;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientInput;
import host.anzo.eossdk.eosex.AEOSNetworkClient;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle", "ClientFlags", "ClientInputMethod"})
public class EOS_AntiCheatCommon_SetClientDetailsOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_SETCLIENTDETAILS_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATCOMMON_SETCLIENTDETAILS_API_LATEST. */
	public int ApiVersion;
	/** Locally unique value used in RegisterClient/RegisterPeer */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/**
	 * General flags associated with this client, if any
	 */
	public EOS_EAntiCheatCommonClientFlags ClientFlags;
	/** Input device being used by this client, if known */
	public EOS_EAntiCheatCommonClientInput ClientInputMethod;

	public EOS_AntiCheatCommon_SetClientDetailsOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_SETCLIENTDETAILS_API_LATEST;
	}

	public EOS_AntiCheatCommon_SetClientDetailsOptions(@NotNull AEOSNetworkClient client) {
		this();
		ClientHandle = client;
		ClientFlags = client.getFlags();
		ClientInputMethod = client.getInputMethod();
	}

	public EOS_AntiCheatCommon_SetClientDetailsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_SetClientDetailsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_SetClientDetailsOptions implements Structure.ByValue {
	}
}