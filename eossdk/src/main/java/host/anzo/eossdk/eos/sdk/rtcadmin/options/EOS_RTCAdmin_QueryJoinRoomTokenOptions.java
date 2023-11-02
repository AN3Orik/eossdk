package host.anzo.eossdk.eos.sdk.rtcadmin.options;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_RTCAdmin_QueryJoinRoomToken function.
 *
 * @author Anton Lasevich
 * @since 11/01/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "RoomName", "TargetUserIds", "TargetUserIdsCount", "TargetUserIpAddresses"})
public class EOS_RTCAdmin_QueryJoinRoomTokenOptions extends Structure {
	/** The most recent version of the EOS_RTCAdmin_QueryJoinRoomToken API */
	public static final int EOS_RTCADMIN_QUERYJOINROOMTOKEN_API_LATEST = 2;

	/** API Version: Set this to {@link #EOS_RTCADMIN_QUERYJOINROOMTOKEN_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID for local user who is querying join room tokens. */
	public EOS_ProductUserId LocalUserId;
	/** Room name to request a token for. */
	public String RoomName;
	/** An array of Product User IDs indicating the users to retrieve a token for. */
	public EOS_ProductUserId TargetUserIds;
	/** The number of users included in the query. */
	public int TargetUserIdsCount;
	/**
	 * Array of IP Addresses, one for each of the users we're querying tokens for.
	 * There should be TargetUserIdsCount Ip Addresses, you can set an entry to NULL if not known.
	 * If TargetUserIpAddresses is set to NULL IP Addresses will be ignored.<br>
	 * IPv4 format: "0.0.0.0"<br>
	 * IPv6 format: "0:0:0:0:0:0:0:0"
	 */
	public StringArray TargetUserIpAddresses;

	public EOS_RTCAdmin_QueryJoinRoomTokenOptions() {
		super();
		ApiVersion = EOS_RTCADMIN_QUERYJOINROOMTOKEN_API_LATEST;
	}

	public EOS_RTCAdmin_QueryJoinRoomTokenOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_RTCAdmin_QueryJoinRoomTokenOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_RTCAdmin_QueryJoinRoomTokenOptions implements Structure.ByValue {
	}
}