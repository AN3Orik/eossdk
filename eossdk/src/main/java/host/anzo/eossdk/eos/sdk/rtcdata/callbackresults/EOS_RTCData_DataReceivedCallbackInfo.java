package host.anzo.eossdk.eos.sdk.rtcdata.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Defines;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import java.nio.ByteBuffer;

import static com.sun.jna.Structure.*;

/**
 * This struct is passed in with a call to EOS_RTCData_AddNotifyDataReceived registered event.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
@FieldOrder({"ClientData", "LocalUserId", "RoomName", "DataLengthBytes", "Data", "ParticipantId"})
public class EOS_RTCData_DataReceivedCallbackInfo extends Structure {
	/** Client-specified data passed into EOS_RTCData_AddNotifyDataReceived. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId LocalUserId;
	/** The room associated with this event. */
	public String RoomName;
	/** The size of the data received. Max value is {@link EOS_Defines#EOS_RTCDATA_MAX_PACKET_SIZE}. */
	public int DataLengthBytes;
	/** The data received. */
	public Pointer Data;
	/** The Product User ID of the participant which sent the data. */
	public EOS_ProductUserId ParticipantId;

	public EOS_RTCData_DataReceivedCallbackInfo() {
		super();
	}

	public EOS_RTCData_DataReceivedCallbackInfo(Pointer peer) {
		super(peer);
	}

	public ByteBuffer getDataByteBuffer() {
		return Data.getByteBuffer(0, DataLengthBytes);
	}

	public static class ByReference extends EOS_RTCData_DataReceivedCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCData_DataReceivedCallbackInfo implements Structure.ByValue {
	}
}