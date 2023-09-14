/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.init;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({ "ApiVersion", "NetworkWork", "StorageIo", "WebSocketIo", "P2PIo", "HttpRequestIo", "RTCIo"})
public class EOS_Initialize_ThreadAffinity extends Structure {
	/** The most recent version of the EOS_Initialize_ThreadAffinity API. */
	public static int EOS_INITIALIZE_THREADAFFINITY_API_LATEST = 2;

	/** API Version: Set this to EOS_ANTICHEATSERVER_UNPROTECTMESSAGE_API_LATEST. */
	public int ApiVersion;
	/** Any thread related to network management that is not IO. */
	public long NetworkWork;
	/** Any thread that will interact with a storage device. */
	public long StorageIo;
	/** Any thread that will generate web socket IO. */
	public long WebSocketIo;
	/** Any thread that will generate IO related to P2P traffic and management. */
	public long P2PIo;
	/** Any thread that will generate http request IO. */
	public long HttpRequestIo;
	/** Any thread that will generate IO related to RTC traffic and management. */
	public long RTCIo;

	public EOS_Initialize_ThreadAffinity() {
		super();
		ApiVersion = EOS_INITIALIZE_THREADAFFINITY_API_LATEST;
	}

	public EOS_Initialize_ThreadAffinity(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Initialize_ThreadAffinity implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Initialize_ThreadAffinity implements Structure.ByValue {
	}
}