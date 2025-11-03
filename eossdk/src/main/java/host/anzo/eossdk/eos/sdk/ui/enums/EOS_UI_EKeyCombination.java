package host.anzo.eossdk.eos.sdk.ui.enums;

import com.sun.jna.FromNativeContext;
import host.anzo.eossdk.jna.runtime.NativeMappedBitMask;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Enum flags for storing a key combination. The low 16 bits are the key type, and modifiers are
 * stored in the next significant bits
 *
 * @author Anton Lasevich
 * @since 9/8/2023
 */
public @Getter class EOS_UI_EKeyCombination extends NativeMappedBitMask {
	public static final int EOS_UIK_None = 0;
	public static final int EOS_UIK_Space = 1;
	public static final int EOS_UIK_Backspace = 2;
	public static final int EOS_UIK_Tab = 3;
	public static final int EOS_UIK_Escape = 4;
	public static final int EOS_UIK_PageUp = 5;
	public static final int EOS_UIK_PageDown = 6;
	public static final int EOS_UIK_End = 7;
	public static final int EOS_UIK_Home = 8;
	public static final int EOS_UIK_Insert = 9;
	public static final int EOS_UIK_Delete = 10;
	public static final int EOS_UIK_Left = 11;
	public static final int EOS_UIK_Up = 12;
	public static final int EOS_UIK_Right = 13;
	public static final int EOS_UIK_Down = 14;
	public static final int EOS_UIK_Key0 = 15;
	public static final int EOS_UIK_Key1 = 16;
	public static final int EOS_UIK_Key2 = 17;
	public static final int EOS_UIK_Key3 = 18;
	public static final int EOS_UIK_Key4 = 19;
	public static final int EOS_UIK_Key5 = 20;
	public static final int EOS_UIK_Key6 = 21;
	public static final int EOS_UIK_Key7 = 22;
	public static final int EOS_UIK_Key8 = 23;
	public static final int EOS_UIK_Key9 = 24;
	public static final int EOS_UIK_KeyA = 25;
	public static final int EOS_UIK_KeyB = 26;
	public static final int EOS_UIK_KeyC = 27;
	public static final int EOS_UIK_KeyD = 28;
	public static final int EOS_UIK_KeyE = 29;
	public static final int EOS_UIK_KeyF = 30;
	public static final int EOS_UIK_KeyG = 31;
	public static final int EOS_UIK_KeyH = 32;
	public static final int EOS_UIK_KeyI = 33;
	public static final int EOS_UIK_KeyJ = 34;
	public static final int EOS_UIK_KeyK = 35;
	public static final int EOS_UIK_KeyL = 36;
	public static final int EOS_UIK_KeyM = 37;
	public static final int EOS_UIK_KeyN = 38;
	public static final int EOS_UIK_KeyO = 39;
	public static final int EOS_UIK_KeyP = 40;
	public static final int EOS_UIK_KeyQ = 41;
	public static final int EOS_UIK_KeyR = 42;
	public static final int EOS_UIK_KeyS = 43;
	public static final int EOS_UIK_KeyT = 44;
	public static final int EOS_UIK_KeyU = 45;
	public static final int EOS_UIK_KeyV = 46;
	public static final int EOS_UIK_KeyW = 47;
	public static final int EOS_UIK_KeyX = 48;
	public static final int EOS_UIK_KeyY = 49;
	public static final int EOS_UIK_KeyZ = 50;
	public static final int EOS_UIK_Numpad0 = 51;
	public static final int EOS_UIK_Numpad1 = 52;
	public static final int EOS_UIK_Numpad2 = 53;
	public static final int EOS_UIK_Numpad3 = 54;
	public static final int EOS_UIK_Numpad4 = 55;
	public static final int EOS_UIK_Numpad5 = 56;
	public static final int EOS_UIK_Numpad6 = 57;
	public static final int EOS_UIK_Numpad7 = 58;
	public static final int EOS_UIK_Numpad8 = 59;
	public static final int EOS_UIK_Numpad9 = 60;
	public static final int EOS_UIK_NumpadAsterisk = 61;
	public static final int EOS_UIK_NumpadPlus = 62;
	public static final int EOS_UIK_NumpadMinus = 63;
	public static final int EOS_UIK_NumpadPeriod = 64;
	public static final int EOS_UIK_NumpadDivide = 65;
	public static final int EOS_UIK_F1 = 66;
	public static final int EOS_UIK_F2 = 67;
	public static final int EOS_UIK_F3 = 68;
	public static final int EOS_UIK_F4 = 69;
	public static final int EOS_UIK_F5 = 70;
	public static final int EOS_UIK_F6 = 71;
	public static final int EOS_UIK_F7 = 72;
	public static final int EOS_UIK_F8 = 73;
	public static final int EOS_UIK_F9 = 74;
	public static final int EOS_UIK_F10 = 75;
	public static final int EOS_UIK_F11 = 76;
	public static final int EOS_UIK_F12 = 77;
	public static final int EOS_UIK_F13 = 78;
	public static final int EOS_UIK_F14 = 79;
	public static final int EOS_UIK_F15 = 80;
	public static final int EOS_UIK_F16 = 81;
	public static final int EOS_UIK_F17 = 82;
	public static final int EOS_UIK_F18 = 83;
	public static final int EOS_UIK_F19 = 84;
	public static final int EOS_UIK_F20 = 85;
	public static final int EOS_UIK_F21 = 86;
	public static final int EOS_UIK_F22 = 87;
	public static final int EOS_UIK_F23 = 88;
	public static final int EOS_UIK_F24 = 89;
	public static final int EOS_UIK_OemPlus = 90;
	public static final int EOS_UIK_OemComma = 91;
	public static final int EOS_UIK_OemMinus = 92;
	public static final int EOS_UIK_OemPeriod = 93;
	/**
	 * ';' for US layout, others vary<br>
	 */
	public static final int EOS_UIK_Oem1 = 94;
	/**
	 * '/' for US layout, others vary<br>
	 */
	public static final int EOS_UIK_Oem2 = 95;
	/**
	 * '~' for US layout, others vary<br>
	 */
	public static final int EOS_UIK_Oem3 = 96;
	/**
	 * '[' for US layout, others vary<br>
	 */
	public static final int EOS_UIK_Oem4 = 97;
	/**
	 * '\' for US layout, others vary<br>
	 */
	public static final int EOS_UIK_Oem5 = 98;
	/**
	 * ']' for US layout, others vary<br>
	 */
	public static final int EOS_UIK_Oem6 = 99;
	/**
	 * '"' for US layout, others vary<br>
	 */
	public static final int EOS_UIK_Oem7 = 100;
	/**
	 * varies on all layouts<br>
	 */
	public static final int EOS_UIK_Oem8 = 101;
	/**
	 * Maximum key enumeration value.<br>
	 */
	public static final int EOS_UIK_MaxKeyType = 102;

	/**
	 * Number of bits to shift the modifiers into the integer.<br>
	 */
	public static final int EOS_UIK_ModifierShift = 16;
	/**
	 * A mask to isolate the single key.<br>
	 */
	public static final int EOS_UIK_KeyTypeMask = (1 << EOS_UIK_ModifierShift) - 1;
	/**
	 * A mask to isolate the modifier keys.<br>
	 */
	public static final int EOS_UIK_ModifierMask = ~EOS_UIK_KeyTypeMask;
	/**
	 * The Shift key<br>
	 */
	public static final int EOS_UIK_Shift = 1 << EOS_UIK_ModifierShift;
	/**
	 * The Control key<br>
	 */
	public static final int EOS_UIK_Control = 2 << EOS_UIK_ModifierShift;
	/**
	 * The Alt key<br>
	 */
	public static final int EOS_UIK_Alt = 4 << EOS_UIK_ModifierShift;
	/**
	 * The Windows key on a Windows keyboard or the Command key on a Mac keyboard<br>
	 */
	public static final int EOS_UIK_Meta = 8 << EOS_UIK_ModifierShift;
	/** A mask which contains all of the modifier keys */
	public static final int EOS_UIK_ValidModifierMask = EOS_UIK_Shift | EOS_UIK_Control | EOS_UIK_Alt | EOS_UIK_Meta;

	public static @NotNull EOS_UI_EKeyCombination of(int... flags) {
		final EOS_UI_EKeyCombination result = new EOS_UI_EKeyCombination();
		result.setFlags(flags);
		return result;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		final EOS_UI_EKeyCombination value = new EOS_UI_EKeyCombination();
		value.bitMask = (int) nativeValue;
		return value;
	}
}