package host.anzo.eossdk.eos.sdk.ui;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A rectangle.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ApiVersion", "X", "Y", "Width", "Height"})
public class EOS_UI_Rect extends Structure {
	/** The most recent version of the EOS_UI_Rect struct. */
	public static final int EOS_UI_RECT_API_LATEST = 1;

	/** API Version: Set this to EOS_UI_RECT_API_LATEST. */
	public int ApiVersion;
	/** Left coordinate. */
	public int X;
	/** Top coordinate. */
	public int Y;
	/** Width. */
	public int Width;
	/** Height. */
	public int Height;

	public EOS_UI_Rect() {
		super();
		ApiVersion = EOS_UI_RECT_API_LATEST;
	}

	public EOS_UI_Rect(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_Rect implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_Rect implements Structure.ByValue {
	}
}
