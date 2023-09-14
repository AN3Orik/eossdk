package host.anzo.eossdk.eos.sdk.ui.enums;

import com.sun.jna.FromNativeContext;
import host.anzo.eossdk.jna.runtime.NativeMappedBitMask;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Flags used in EOS_UI_ReportInputStateOptions to identify buttons which are down.
 *
 * @author Anton Lasevich
 * @since 9/8/2023
 */
public @Getter class EOS_UI_EInputStateButtonFlags extends NativeMappedBitMask {
	/**
	 * No buttons
	 */
	public static final int EOS_UISBF_None = 0;
	/**
	 * Controller directional pad left
	 */
	public static final int EOS_UISBF_DPad_Left = 1 << 0;
	/**
	 * Controller directional pad right
	 */
	public static final int EOS_UISBF_DPad_Right = 1 << 1;
	/**
	 * Controller directional pad down
	 */
	public static final int EOS_UISBF_DPad_Down = 1 << 2;
	/**
	 * Controller directional pad up
	 */
	public static final int EOS_UISBF_DPad_Up = 1 << 3;
	/**
	 * Controller left main face button
	 */
	public static final int EOS_UISBF_FaceButton_Left = 1 << 4;
	/**
	 * Controller right main face button
	 */
	public static final int EOS_UISBF_FaceButton_Right = 1 << 5;
	/**
	 * Controller bottom main face button
	 */
	public static final int EOS_UISBF_FaceButton_Bottom = 1 << 6;
	/**
	 * Controller top main face button
	 */
	public static final int EOS_UISBF_FaceButton_Top = 1 << 7;
	/**
	 * Controller left upper shoulder button.
	 */
	public static final int EOS_UISBF_LeftShoulder = 1 << 8;
	/**
	 * Controller right upper shoulder button.
	 */
	public static final int EOS_UISBF_RightShoulder = 1 << 9;
	/**
	 * Controller left lower trigger button.
	 */
	public static final int EOS_UISBF_LeftTrigger = 1 << 10;
	/**
	 * Controller right lower trigger button.
	 */
	public static final int EOS_UISBF_RightTrigger = 1 << 11;
	/**
	 * Controller special button on left.
	 */
	public static final int EOS_UISBF_Special_Left = 1 << 12;
	/**
	 * Controller special button on right.
	 */
	public static final int EOS_UISBF_Special_Right = 1 << 13;
	/**
	 * Controller left thumbstick as a button.
	 */
	public static final int EOS_UISBF_LeftThumbstick = 1 << 14;
	/**
	 * Controller right thumbstick as a button.
	 */
	public static final int EOS_UISBF_RightThumbstick = 1 << 15;

	public static @NotNull EOS_UI_EInputStateButtonFlags of(int... flags) {
		final EOS_UI_EInputStateButtonFlags result = new EOS_UI_EInputStateButtonFlags();
		result.setFlags(flags);
		return result;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		final EOS_UI_EInputStateButtonFlags value = new EOS_UI_EInputStateButtonFlags();
		value.bitMask = (int)nativeValue;
		return value;
	}
}