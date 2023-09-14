/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.platform.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.integratedplatform.EOS_IntegratedPlatformOptionsContainer;
import host.anzo.eossdk.eos.sdk.platform.EOS_Platform_ClientCredentials;
import host.anzo.eossdk.eos.sdk.platform.enums.EOS_Platform_Create_Flag;
import host.anzo.eossdk.eosex.EOSBaseOptions;
import org.jetbrains.annotations.NotNull;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({ "ApiVersion", "Reserved", "ProductId", "SandboxId", "ClientCredentials", "bIsServer", "EncryptionKey", "OverrideCountryCode", "OverrideLocaleCode", "DeploymentId", "Flags", "CacheDirectory", "TickBudgetInMilliseconds", "RTCOptions", "IntegratedPlatformOptionsContainerHandle", "SystemSpecificOptions"})
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

	public static int EOS_PLATFORM_OPTIONS_API_LATEST = 12;

	/** API Version: Set this to EOS_PLATFORM_OPTIONS_API_LATEST. */
	public int ApiVersion;
	/** A reserved field that should always be nulled. */
	public Pointer Reserved;
	/** The product ID for the running application, found on the dev portal. Max length is EOS_PLATFORM_OPTIONS_PRODUCTID_MAX_LENGTH. */
	public String ProductId;
	/** The sandbox ID for the running application, found on the dev portal. Max length is EOS_PLATFORM_OPTIONS_SANDBOXID_MAX_LENGTH. */
	public String SandboxId;
	/** Set of service permissions associated with the running application */
	public EOS_Platform_ClientCredentials ClientCredentials;
	/** Set this to EOS_FALSE if the application is running as a client with a local user, otherwise set to EOS_TRUE (e.g. for a dedicated game server) */
	public int bIsServer;
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
	/** Pointer to EOS_Platform_SystemSpecificOptions. This structure will be located in Platform/eos_Platform.h */
	public Pointer SystemSpecificOptions;

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
		bIsServer = options.isServer() ? 1 : 0;
		EncryptionKey = options.getEncryptionKey();
		Flags = options.getFlags();
		CacheDirectory = options.getCacheDirectory();
	}

	public static class ByReference extends EOS_Platform_Options implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Platform_Options implements Structure.ByValue {
	}
}