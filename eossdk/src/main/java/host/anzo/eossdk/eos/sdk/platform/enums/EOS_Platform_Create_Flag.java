/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.platform.enums;

import com.sun.jna.FromNativeContext;
import host.anzo.eossdk.eos.sdk.EOS;
import host.anzo.eossdk.eos.sdk.platform.options.EOS_Platform_Options;
import host.anzo.eossdk.jna.runtime.NativeMappedBitMask;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Platform Creation Flags used in {@link EOS#EOS_Platform_Create(EOS_Platform_Options)}
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter class EOS_Platform_Create_Flag extends NativeMappedBitMask {
	/** A bit that indicates the SDK is being loaded in a game editor, like Unity or UE4 Play-in-Editor */
	public static final int EOS_PF_LOADING_IN_EDITOR = 0x00001;
	/** A bit that indicates the SDK should skip initialization of the overlay, which is used by the in-app purchase flow and social overlay. This bit is implied by {@link #EOS_PF_LOADING_IN_EDITOR} */
	public static final int EOS_PF_DISABLE_OVERLAY = 0x00002;
	/** A bit that indicates the SDK should skip initialization of the social overlay, which provides an overlay UI for social features. This bit is implied by {@link #EOS_PF_LOADING_IN_EDITOR} or {@link #EOS_PF_DISABLE_OVERLAY} */
	public static final int EOS_PF_DISABLE_SOCIAL_OVERLAY = 0x00004;
	/** A reserved bit */
	public static final int EOS_PF_RESERVED1 = 0x00008;
	/** A bit that indicates your game would like to opt-in to experimental Direct3D 9 support for the overlay. This flag is only relevant on Windows */
	public static final int EOS_PF_WINDOWS_ENABLE_OVERLAY_D3D9 = 0x00010;
	/** A bit that indicates your game would like to opt-in to experimental Direct3D 10 support for the overlay. This flag is only relevant on Windows */
	public static final int EOS_PF_WINDOWS_ENABLE_OVERLAY_D3D10 = 0x00020;
	/** A bit that indicates your game would like to opt-in to experimental OpenGL support for the overlay. This flag is only relevant on Windows */
	public static final int EOS_PF_WINDOWS_ENABLE_OVERLAY_OPENGL = 0x00040;
	/** A bit that indicates your game would like to opt-in to automatic unloading of the overlay module when possible. This flag is only relevant on Consoles */
	public static final int EOS_PF_CONSOLE_ENABLE_OVERLAY_AUTOMATIC_UNLOADING = 0x00080;

	public static @NotNull EOS_Platform_Create_Flag of(int... flags) {
		final EOS_Platform_Create_Flag result = new EOS_Platform_Create_Flag();
		result.setFlags(flags);
		return result;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		final EOS_Platform_Create_Flag value = new EOS_Platform_Create_Flag();
		value.bitMask = (int)nativeValue;
		return value;
	}
}