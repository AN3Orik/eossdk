package host.anzo.eossdk.eos.sdk.rtcdata.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOS_Defines;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import java.nio.ByteBuffer;

import static com.sun.jna.Structure.FieldOrder;

/**
 * This struct is used to call EOS_RTCData_SendData.
 *
 * @author Anton Lasevich
 * @since 4/4/2024
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "DataLengthBytes", "Data"})
public class EOS_RTCData_SendDataOptions extends Structure {
	/** The most recent version of the EOS_RTCData_SendData API. */
	public final static int EOS_RTCDATA_SENDDATA_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_RTCDATA_SENDDATA_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the user trying to request this operation. */
	public EOS_ProductUserId LocalUserId;
	/** The room this event is registered on. */
	public String RoomName;
	/** The size of the data to be sent to the other participants. Max value is {@link EOS_Defines#EOS_RTCDATA_MAX_PACKET_SIZE}. */
	public int DataLengthBytes;
	/** The data to be sent to the other participants */
	public Pointer Data;

	public EOS_RTCData_SendDataOptions() {
		super();
		ApiVersion = EOS_RTCDATA_SENDDATA_API_LATEST;
	}

	public EOS_RTCData_SendDataOptions(Pointer peer) {
		super(peer);
	}

	public ByteBuffer getDataByteBuffer() {
		return Data.getByteBuffer(0, DataLengthBytes);
	}

	public static class ByReference extends EOS_RTCData_SendDataOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCData_SendDataOptions implements Structure.ByValue {
	}
}