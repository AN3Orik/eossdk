package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.sdk.logging.enums.EOS_ELogCategory;
import host.anzo.eossdk.eos.sdk.logging.enums.EOS_ELogLevel;
import host.anzo.eossdk.eos.sdk.platform.enums.EOS_Platform_Create_Flag;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Getter
public @SuperBuilder class EOSBaseOptions {
	// Initialize
	private String productName;
	private String productVersion;
	private @Builder.Default String cacheDirectory = System.getProperty("java.io.tmpdir");

	// Logging
	private @Builder.Default EOS_ELogCategory logCategory = EOS_ELogCategory.EOS_LC_ALL_CATEGORIES;
	private @Builder.Default EOS_ELogLevel logLevel = EOS_ELogLevel.EOS_LOG_VeryVerbose;

	// Platform
	private @Builder.Default boolean isServer = false;
	private @Builder.Default EOS_Platform_Create_Flag flags = EOS_Platform_Create_Flag.of(EOS_Platform_Create_Flag.EOS_PF_DISABLE_OVERLAY);
	private @Builder.Default String encryptionKey = "1111111111111111111111111111111111111111111111111111111111111111";
	private String productId;
	private String sandboxId;
	private String deploymentId;
	private String clientId;
	private String clientSecret;
	private @Builder.Default int tickPeriod = 100;

	// Anti-Cheat
	private @Builder.Default boolean antiCheatEnabled = true;
	private @Builder.Default boolean enableNetworkProtection = true;
}
