package host.anzo.eossdk.eos.sdk.anticheat.client.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.nio.ByteBuffer;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing details about a new message that must be dispatched to the game server.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ClientData", "MessageData", "MessageDataSizeBytes"})
public class EOS_AntiCheatClient_OnMessageToServerCallbackInfo extends Structure {
	/** Caller-specified context data */
	public Pointer ClientData;
	/** The message data that must be sent to the server */
	public Pointer MessageData;
	/** The size in bytes of MessageData */
	public int MessageDataSizeBytes;

	public EOS_AntiCheatClient_OnMessageToServerCallbackInfo() {
		super();
	}

	public EOS_AntiCheatClient_OnMessageToServerCallbackInfo(Pointer peer) {
		super(peer);
	}

	public ByteBuffer getMessageDataByteBuffer() {
		return MessageData.getByteBuffer(0, MessageDataSizeBytes);
	}

	public static class ByReference extends EOS_AntiCheatClient_OnMessageToServerCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_OnMessageToServerCallbackInfo implements Structure.ByValue {
	}
}