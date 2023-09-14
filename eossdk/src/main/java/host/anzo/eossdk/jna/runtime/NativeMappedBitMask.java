package host.anzo.eossdk.jna.runtime;

import com.sun.jna.NativeMapped;

/**
 * @author Anton Lasevich
 * @since 9/11/2023
 */
public abstract class NativeMappedBitMask implements NativeMapped {
	protected int bitMask;

	public NativeMappedBitMask() {
	}

	protected void setFlags(int... flags) {
		for(int flag : flags) {
			bitMask |= flag;
		}
	}

	public boolean hasFlag(int flag) {
		return (this.bitMask & flag) == flag;
	}

	@Override
	public Object toNative() {
		return bitMask;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}
