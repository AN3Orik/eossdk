package host.anzo.eossdk.eos.utils;

import java.lang.management.ManagementFactory;

/**
 * @author Anton Lasevich
 * @since 10/2/2023
 */
public class VMUtils {
	public static boolean DEBUG = ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
}
