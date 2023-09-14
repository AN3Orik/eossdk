package host.anzo.eossdk.example;

import jfork.nproperty.Cfg;

/**
 * @author Anton Lasevich
 * @since 9/14/2023
 */
@Cfg
public class DefaultConfig {
	@Cfg("is_server_mode")
	public static boolean IS_SERVER_MODE = false;
	@Cfg("product_name")
	public static String PRODUCT_NAME;
	@Cfg("product_version")
	public static String PRODUCT_VERSION;
	@Cfg("product_id")
	public static String PRODUCT_ID;
	@Cfg("sandbox_id")
	public static String SANDBOX_ID;
	@Cfg("deployment_id")
	public static String DEPLOYMENT_ID;
	@Cfg("client_credentials")
	public static String[] CLIENT_CREDENTIALS;
	@Cfg("server_credentials")
	public static String[] SERVER_CREDENTIALS;
	@Cfg("platform_tick_rate")
	public static int PLATFORM_TICK_RATE;
	@Cfg("anti_cheat_server_name")
	public static String ANTI_CHEAT_SERVER_NAME;
	@Cfg("anti_cheat_enabled")
	public static boolean ANTI_CHEAT_ENABLED;
	@Cfg("anti_cheat_server_register_timeout")
	public static int ANTI_CHEAT_SERVER_REGISTER_TIMEOUT;
}