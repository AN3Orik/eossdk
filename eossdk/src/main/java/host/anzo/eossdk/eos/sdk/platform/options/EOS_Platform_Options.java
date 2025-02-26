/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.platform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.DoubleByReference;
import host.anzo.eossdk.eos.sdk.EOS_Platform_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_ENetworkStatus;
import host.anzo.eossdk.eos.sdk.integratedplatform.EOS_IntegratedPlatformOptionsContainer;
import host.anzo.eossdk.eos.sdk.platform.EOS_Platform_ClientCredentials;
import host.anzo.eossdk.eos.sdk.platform.enums.EOS_Platform_Create_Flag;
import host.anzo.eossdk.eosex.EOSBaseOptions;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Platform options for EOS_Platform_Create
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "Reserved", "ProductId", "SandboxId", "ClientCredentials", "IsServer", "EncryptionKey", "OverrideCountryCode", "OverrideLocaleCode", "DeploymentId", "Flags", "CacheDirectory", "TickBudgetInMilliseconds", "RTCOptions", "IntegratedPlatformOptionsContainerHandle", "SystemSpecificOptions", "TaskNetworkTimeoutSeconds"})
public class EOS_Platform_Options extends Structure {
	public static int EOS_COUNTRYCODE_MAX_LENGTH = 4;
	public static int EOS_COUNTRYCODE_MAX_BUFFER_LEN = EOS_COUNTRYCODE_MAX_LENGTH + 1;
	public static int EOS_LOCALECODE_MAX_LENGTH = 9;
	public static int EOS_LOCALECODE_MAX_BUFFER_LEN = EOS_LOCALECODE_MAX_LENGTH + 1;

	/** Max length of a product id, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_PRODUCTID_MAX_LENGTH = 64;

	/** Max length of a sandbox id, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_SANDBOXID_MAX_LENGTH = 64;

	/** Length of an encryption key, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_ENCRYPTIONKEY_LENGTH = 64;

	/** Max length of a deployment id, not including the terminating null. */
	public static int EOS_PLATFORM_OPTIONS_DEPLOYMENTID_MAX_LENGTH = 64;

	/** The most recent version of the EOS_Platform_Create API. */
	public static int EOS_PLATFORM_OPTIONS_API_LATEST = 14;

	/** API Version: Set this to {@link #EOS_PLATFORM_OPTIONS_API_LATEST}. */
	public int ApiVersion;
	/** A reserved field that should always be nulled. */
	public Pointer Reserved;
	/** The product ID for the running application, found on the dev portal. Max length is EOS_PLATFORM_OPTIONS_PRODUCTID_MAX_LENGTH. */
	public String ProductId;
	/** The sandbox ID for the running application, found on the dev portal. Max length is EOS_PLATFORM_OPTIONS_SANDBOXID_MAX_LENGTH. */
	public String SandboxId;
	/** Set of service permissions associated with the running application */
	public EOS_Platform_ClientCredentials ClientCredentials;
	/** Set this to {@link EOS_Bool#EOS_FALSE} if the application is running as a client with a local user, otherwise set to {@link EOS_Bool#EOS_TRUE} (e.g. for a dedicated game server) */
	public EOS_Bool IsServer;
	/** Used by Player Data Storage and Title Storage. Must be null initialized if unused. 256-bit Encryption Key for file encryption in hexadecimal format; EOS_PLATFORM_OPTIONS_ENCRYPTIONKEY_LENGTH hex chars. */
	public String EncryptionKey;
	/** The override country code to use for the logged in user. (EOS_COUNTRYCODE_MAX_LENGTH)*/
	public String OverrideCountryCode;
	/** The override locale code to use for the logged in user. This follows ISO 639. (EOS_LOCALECODE_MAX_LENGTH)*/
	public String OverrideLocaleCode;
	/** The deployment ID for the running application, found on the dev portal. Max length is EOS_PLATFORM_OPTIONS_DEPLOYMENTID_MAX_LENGTH. */
	public String DeploymentId;
	/** Platform creation flags, e.g. EOS_PF_LOADING_IN_EDITOR. This is a bitwise-or union of the defined flags. */
	public EOS_Platform_Create_Flag Flags;
	/** Used by Player Data Storage and Title Storage. Must be null initialized if unused. Cache directory path. Absolute path to the folder that is going to be used for caching temporary data. The path is created if it's missing. */
	public String CacheDirectory;
	/**
	 * A budget, measured in milliseconds, for EOS_Platform_Tick to do its work. When the budget is met or exceeded (or if no work is available), EOS_Platform_Tick will return.
	 * This allows your game to amortize the cost of SDK work across multiple frames in the event that a lot of work is queued for processing.
	 * Zero is interpreted as "perform all available work".
	 */
	public int TickBudgetInMilliseconds;
	/** RTC options. Setting to NULL will disable RTC features (e.g. voice) */
	public EOS_Platform_RTCOptions.ByReference RTCOptions;
	/**
	 * A handle that contains all the options for setting up integrated platforms.
	 * When set to NULL, the EOS Integrated Platform behavior for the host platform will be disabled.
	 */
	public EOS_IntegratedPlatformOptionsContainer IntegratedPlatformOptionsContainerHandle;
	/** Pointer to EOS_"PLATFORM_NAME"_SystemSpecificOptions. This structure will be located in "PLATFORM_NAME"/eos_"PLATFORM_NAME".h */
	public Pointer SystemSpecificOptions;
	/**
	 * Number of seconds for a task to wait for the network to become available before timing out with an EOS_TimedOut error.
	 * This timeout period applies when the network status is not EOS_NS_Online. Tasks that need the network will queue for up to
	 * this timeout until EOS_Platform_SetNetworkStatus is used to set the network status to online.
	 * <p>
	 * Pass a null pointer to use the default.
	 * Otherwise, pass a pointer to a double containing the number of seconds for tasks that are waiting for network to time out.
	 *
	 * @see EOS_Platform_Interface#setNetworkStatus(EOS_ENetworkStatus)
	 * @see EOS_ENetworkStatus
	 */
	public DoubleByReference TaskNetworkTimeoutSeconds;

	public EOS_Platform_Options() {
		super();
		ApiVersion = EOS_PLATFORM_OPTIONS_API_LATEST;
	}

	public EOS_Platform_Options(Pointer peer) {
		super(peer);
	}

	public EOS_Platform_Options(@NotNull EOSBaseOptions options) {
		this();
		ProductId = options.getProductId();
		SandboxId = options.getSandboxId();
		DeploymentId = options.getDeploymentId();
		ClientCredentials = new EOS_Platform_ClientCredentials(options.getClientId(), options.getClientSecret());
		IsServer = EOS_Bool.of(options.isServer());
		EncryptionKey = options.getEncryptionKey();
		Flags = options.getFlags();
		CacheDirectory = options.getCacheDirectory();
	}

	public static class ByReference extends EOS_Platform_Options implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Platform_Options implements Structure.ByValue {
	}
}