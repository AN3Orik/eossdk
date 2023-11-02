package host.anzo.eossdk.eos.sdk.rtc.enums;

import com.sun.jna.FromNativeContext;
import host.anzo.eossdk.jna.runtime.NativeMappedBitMask;
import org.jetbrains.annotations.NotNull;

/**
 * Join room flags
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public class EOS_RTC_JoinRoomOptions_Flags extends NativeMappedBitMask {
	/**
	 * Enables echo mode.
	 * This can be used during development to have the server send your voice back to you so you don't need 2 clients to test
	 * if voice is being sent and received.
	 */
	public static final int EOS_RTC_JOINROOMFLAGS_ENABLE_ECHO = 0x01;
	/**
	 * Enables the (optional) data channel feature for RTC rooms. This feature allows members of a room to send packets to all
	 * members of a room they are in, and automatically receive data packets sent by other players in that room.
	 * Data packets sent this way will be automatically relayed by EOS RTC servers to all other members of the room that are listening.
	 * It is not currently possible to send packets to only a subset of members of a room chosen by the sender, all members
	 * listening will receive the data.
	 */
	public static final int EOS_RTC_JOINROOMFLAGS_ENABLE_DATACHANNEL = 0x04;

	public static @NotNull EOS_RTC_JoinRoomOptions_Flags of(int... flags) {
		final EOS_RTC_JoinRoomOptions_Flags result = new EOS_RTC_JoinRoomOptions_Flags();
		result.setFlags(flags);
		return result;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		final EOS_RTC_JoinRoomOptions_Flags value = new EOS_RTC_JoinRoomOptions_Flags();
		value.bitMask = (int) nativeValue;
		return value;
	}
}