package host.anzo.eossdk.example;

import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonClientActionReason;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eosex.AEOSNetworkClient;
import host.anzo.eossdk.eosex.AEOSServer;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
public class EOSServer extends AEOSServer {
	@Getter(lazy = true)
	private final static EOSServer instance = new EOSServer();

	private final Map<Long, AEOSNetworkClient> networkClients = new ConcurrentHashMap<>();

	@Override
	public AEOSNetworkClient getNetworkClient(long connectionId) {
		return networkClients.getOrDefault(connectionId, null);
	}

	@Override
	public EOS_EResult onNetworkClientConnected(@NotNull AEOSNetworkClient networkClient) {
		final EOS_EResult connectResult = super.onNetworkClientConnected(networkClient);
		if (connectResult.isSuccess()) {
			networkClients.put(networkClient.getConnectionId(), networkClient);
		}
		return connectResult;
	}

	@Override
	public EOS_EResult onNetworkClientDisconnected(@NotNull AEOSNetworkClient networkClient) {
		final EOS_EResult disconnectResult = super.onNetworkClientDisconnected(networkClient);
		if (disconnectResult.isSuccess()) {
			networkClients.remove(networkClient.getConnectionId());
		}
		return disconnectResult;
	}
}