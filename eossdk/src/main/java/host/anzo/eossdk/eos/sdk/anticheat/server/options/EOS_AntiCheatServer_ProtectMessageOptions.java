/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.server.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle", "DataLengthBytes", "Data", "OutBufferSizeBytes"})
public class EOS_AntiCheatServer_ProtectMessageOptions extends Structure {
	public static int EOS_ANTICHEATSERVER_PROTECTMESSAGE_API_LATEST = 1;

	/** API Version: Set this to EOS_ANTICHEATSERVER_PROTECTMESSAGE_API_LATEST. */
	public int ApiVersion;
	/** Locally unique value describing the remote user to whom the message will be sent */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** Length in bytes of input */
	public int DataLengthBytes;
	/** The data to encrypt */
	public byte[] Data;
	/** The size in bytes of OutBuffer */
	public int OutBufferSizeBytes;

	public EOS_AntiCheatServer_ProtectMessageOptions() {
		super();
		ApiVersion = EOS_ANTICHEATSERVER_PROTECTMESSAGE_API_LATEST;
	}

	/**
	 * @param clientHandle Locally unique value describing the remote user to whom the message will be sent
	 * @param data The data to encrypt
	 * @param outBufferSizeBytes The size in bytes of OutBuffer
	 */
	public EOS_AntiCheatServer_ProtectMessageOptions(EOS_AntiCheatCommon_ClientHandle clientHandle, byte[] data, int outBufferSizeBytes) {
		this();
		ClientHandle = clientHandle;
		DataLengthBytes = data.length;
		Data = data;
		OutBufferSizeBytes = outBufferSizeBytes;
		allocateMemory();
	}

	public EOS_AntiCheatServer_ProtectMessageOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatServer_ProtectMessageOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatServer_ProtectMessageOptions implements Structure.ByValue {
	}
}