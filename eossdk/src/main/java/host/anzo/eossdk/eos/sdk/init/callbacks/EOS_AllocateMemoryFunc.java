package host.anzo.eossdk.eos.sdk.init.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import host.anzo.eossdk.jna.runtime.NativeSize;

/**
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public interface EOS_AllocateMemoryFunc extends Callback {
	/**
	 * Function prototype type definition for functions that allocate memory.
	 * <p>
	 * Functions passed to EOS_Initialize to serve as memory allocators should return a pointer to the allocated memory.
	 * <p>
	 * The returned pointer should have at least SizeInBytes available capacity and the memory address should be a multiple of Alignment.
	 * The SDK will always call the provided function with an Alignment that is a power of 2.
	 * Allocation failures should return a null pointer.
	 */
	Pointer run(NativeSize sizeInBytes, NativeSize alignment);
}