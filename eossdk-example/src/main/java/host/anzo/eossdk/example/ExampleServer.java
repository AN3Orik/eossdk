package host.anzo.eossdk.example;

import host.anzo.eossdk.eosex.AEOSClient;
import host.anzo.eossdk.eosex.AEOSServer;
import host.anzo.eossdk.eosex.EOSClientOptions;
import host.anzo.eossdk.eosex.EOSServerOptions;
import jfork.nproperty.ConfigParser;

/**
 * @author Anton Lasevich
 * @since 6/25/2023
 */
public class ExampleServer {
	private static AEOSClient client;
	private static AEOSServer server;

	public static void main(String[] args) {
		try {
			ConfigParser.parse(DefaultConfig.class, "config/default.ini");
		}
		catch (Exception e) {
			throw new RuntimeException("Error while loading config", e);
		}

		if (DefaultConfig.IS_SERVER_MODE) {
			startServer();
		}
		else {
			startClient();
		}

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private static void startClient() {
		client = EOSClient.getInstance().start(EOSClientOptions.builder()
						.productName(DefaultConfig.PRODUCT_NAME)
						.productVersion(DefaultConfig.PRODUCT_VERSION)
						.isServer(DefaultConfig.IS_SERVER_MODE)
						.productId(DefaultConfig.PRODUCT_ID)
						.sandboxId(DefaultConfig.SANDBOX_ID)
						.deploymentId(DefaultConfig.DEPLOYMENT_ID)
						.clientId(DefaultConfig.CLIENT_CREDENTIALS[0])
						.clientSecret(DefaultConfig.CLIENT_CREDENTIALS[1])
						.antiCheatEnabled(DefaultConfig.ANTI_CHEAT_ENABLED)
						.build());
	}

	private static void startServer() {
		server = EOSServer.getInstance().start(EOSServerOptions.builder()
				.productName(DefaultConfig.PRODUCT_NAME)
				.productVersion(DefaultConfig.PRODUCT_VERSION)
				.isServer(DefaultConfig.IS_SERVER_MODE)
				.productId(DefaultConfig.PRODUCT_ID)
				.sandboxId(DefaultConfig.SANDBOX_ID)
				.deploymentId(DefaultConfig.DEPLOYMENT_ID)
				.clientId(DefaultConfig.SERVER_CREDENTIALS[0])
				.clientSecret(DefaultConfig.SERVER_CREDENTIALS[1])
				.tickPeriod(DefaultConfig.PLATFORM_TICK_RATE)
				.antiCheatEnabled(DefaultConfig.ANTI_CHEAT_ENABLED)
				.antiCheatServerName(DefaultConfig.ANTI_CHEAT_SERVER_NAME)
				.antiCheatRegisterTimeoutSeconds(DefaultConfig.ANTI_CHEAT_SERVER_REGISTER_TIMEOUT)
				.build());
	}
}