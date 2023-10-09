package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.*;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import java.nio.ByteBuffer;

/**
 * @author Anton Lasevich
 * @since 10/5/2023
 */
public abstract class AEOSNetworkClient extends EOS_AntiCheatCommon_ClientHandle {
	public AEOSNetworkClient(long connectionId) {
		super(connectionId);
	}

	public long getConnectionId() {
		return getValue();
	}

	public abstract String getIpAddress();

	public abstract EOS_EAntiCheatCommonClientType getProtectedType();
	public abstract EOS_EAntiCheatCommonClientPlatform getPlatformType();
	public abstract EOS_EAntiCheatCommonClientFlags getFlags();
	public abstract EOS_EAntiCheatCommonClientInput getInputMethod();
	public abstract EOS_ProductUserId getProductUserId();

	public abstract void close(EOS_EAntiCheatCommonClientActionReason reason, String reasonMessage);
	public abstract void sendEacData(ByteBuffer data);
}
