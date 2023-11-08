/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.init.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.init.callbacks.EOS_AllocateMemoryFunc;
import host.anzo.eossdk.eos.sdk.init.callbacks.EOS_ReallocateMemoryFunc;
import host.anzo.eossdk.eos.sdk.init.callbacks.EOS_ReleaseMemoryFunc;
import host.anzo.eossdk.eosex.EOSBaseOptions;
import org.jetbrains.annotations.NotNull;

/**
 * Options for initializing the Epic Online Services SDK.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "AllocateMemoryFunction", "ReallocateMemoryFunction", "ReleaseMemoryFunction", "ProductName",
		"ProductVersion", "Reserved", "SystemInitializeOptions", "OverrideThreadAffinity"})
public class EOS_InitializeOptions extends Structure {
	/** The most recent version of the EOS_Initialize API. */
	public static int EOS_INITIALIZE_API_LATEST = 4;

	/** Max length of a product name, not including the terminating null. */
	public static int EOS_INITIALIZEOPTIONS_PRODUCTNAME_MAX_LENGTH = 64;
	/** Max length of a product version, not including the terminating null. */
	public static int EOS_INITIALIZEOPTIONS_PRODUCTVERSION_MAX_LENGTH = 64;

	/** API Version: Set this to {@link #EOS_INITIALIZE_API_LATEST}. */
	public int ApiVersion;
	/** A custom memory allocator, if desired. */
	public EOS_AllocateMemoryFunc AllocateMemoryFunction;
	/** A corresponding memory reallocator. If the AllocateMemoryFunction is nulled, then this field must also be nulled. */
	public EOS_ReallocateMemoryFunc ReallocateMemoryFunction;
	/** A corresponding memory releaser. If the AllocateMemoryFunction is nulled, then this field must also be nulled. */
	public EOS_ReleaseMemoryFunc ReleaseMemoryFunction;
	/**
	 * The name of the product using the Epic Online Services SDK.
	 * <p>
	 * The name string is required to be non-empty and at maximum of EOS_INITIALIZEOPTIONS_PRODUCTNAME_MAX_LENGTH bytes long.
	 * The string buffer can consist of the following characters:
	 * A-Z, a-z, 0-9, dot, underscore, space, exclamation mark, question mark, and sign, hyphen, parenthesis, plus, minus, colon.
	 */
	public String ProductName;
	/**
	 * Product version of the running application.
	 * <p>
	 * The version string is required to be non-empty and at maximum of EOS_INITIALIZEOPTIONS_PRODUCTVERSION_MAX_LENGTH bytes long.
	 * The string buffer can consist of the following characters:
	 * A-Z, a-z, 0-9, dot, underscore, space, exclamation mark, question mark, and sign, hyphen, parenthesis, plus, minus, colon.
	 */
	public String ProductVersion;
	/** A reserved field that should always be nulled. */
	public Pointer Reserved;
	/**
	 * This field is for system specific initialization if any.
	 * <p>
	 * If provided then the structure will be located in (System)/eos_system.h.
	 * The structure will be named EOS_(System)_InitializeOptions.
	 */
	public Pointer SystemInitializeOptions;
	/** The thread affinity override values for each category of thread. */
	public Pointer OverrideThreadAffinity;

	public EOS_InitializeOptions() {
		super();
		ApiVersion = EOS_INITIALIZE_API_LATEST;
	}

	public EOS_InitializeOptions(@NotNull EOSBaseOptions options) {
		this();
		this.ProductName = options.getProductName();
		this.ProductVersion = options.getProductVersion();
		this.Reserved = Pointer.NULL;
		this.SystemInitializeOptions = Pointer.NULL;
		this.OverrideThreadAffinity = Pointer.NULL;
	}

	public static class ByReference extends EOS_InitializeOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_InitializeOptions implements Structure.ByValue {
	}
}
