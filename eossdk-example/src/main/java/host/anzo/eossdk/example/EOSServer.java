package host.anzo.eossdk.example;

import host.anzo.eossdk.eosex.AEOSServer;
import host.anzo.eossdk.eosex.IEOSNetworkClient;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public class EOSServer extends AEOSServer {
	@Getter(lazy = true)
	private final static EOSServer instance = new EOSServer();

	@Override
	protected void onNetworkClientAdded(@NotNull IEOSNetworkClient antiCheatClient) {
		// TODO: Implement me
	}
}