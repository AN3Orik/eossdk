/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing details about a new message that must be dispatched to a connected client/peer.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ClientData", "ClientHandle", "MessageData", "MessageDataSizeBytes"})
public class EOS_AntiCheatCommon_OnMessageToClientCallbackInfo extends Structure {
	/** Caller-specified context data */
	public Pointer ClientData;
	/** The identifier of the client/peer that this message must be delivered to. See the RegisterClient and RegisterPeer functions. */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** The message data that must be sent to the client */
	public Pointer MessageData;
	/** The size in bytes of MessageData */
	public int MessageDataSizeBytes;

	public EOS_AntiCheatCommon_OnMessageToClientCallbackInfo() {
		super();
	}

	public EOS_AntiCheatCommon_OnMessageToClientCallbackInfo(Pointer peer) {
		super(peer);
	}

	public byte[] getMessageBytes() {
		return MessageData.getByteArray(0, MessageDataSizeBytes);
	}

	public static class ByReference extends EOS_AntiCheatCommon_OnMessageToClientCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_OnMessageToClientCallbackInfo implements Structure.ByValue {
	}
}