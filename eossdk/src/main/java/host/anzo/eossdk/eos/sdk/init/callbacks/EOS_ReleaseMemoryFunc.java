package host.anzo.eossdk.eos.sdk.init.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public interface EOS_ReleaseMemoryFunc extends Callback {
	/**
	 * Function prototype type definition for functions that release memory.
	 * <p>
	 * When the SDK is done with memory that has been allocated by a custom allocator passed to EOS_Initialize, it will call the corresponding memory release function.
	 */
	void run(Pointer pointer);
}