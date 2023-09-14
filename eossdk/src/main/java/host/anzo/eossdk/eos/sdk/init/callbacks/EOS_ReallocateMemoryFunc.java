package host.anzo.eossdk.eos.sdk.init.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import host.anzo.eossdk.jna.runtime.NativeSize;

/**
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public interface EOS_ReallocateMemoryFunc extends Callback {
	/**
	 * Function prototype type definition for functions that reallocate memory.
	 * <p>
	 * Functions passed to EOS_Initialize to serve as memory reallocators should return a pointer to the reallocated memory.
	 * The returned pointer should have at least SizeInBytes available capacity and the memory address should be a multiple of alignment.
	 * The SDK will always call the provided function with an Alignment that is a power of 2.
	 * Reallocation failures should return a null pointer.
	 */
	Pointer run(Pointer pointer, NativeSize sizeInBytes, NativeSize alignment);
}