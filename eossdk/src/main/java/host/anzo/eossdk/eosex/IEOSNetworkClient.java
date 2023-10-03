package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.*;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import java.nio.ByteBuffer;

/**
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public interface IEOSNetworkClient {
	EOS_AntiCheatCommon_ClientHandle getHandle();
	String getIpAddress();
	EOS_EAntiCheatCommonClientType getProtectedType();
	EOS_EAntiCheatCommonClientPlatform getPlatformType();
	EOS_EAntiCheatCommonClientFlags getFlags();
	EOS_EAntiCheatCommonClientInput getInputMethod();
	EOS_ProductUserId getProductUserId();

	void close(String reason);
	void onSendEacData(ByteBuffer data);
	void onKickFromAntiCheat(EOS_EAntiCheatCommonClientActionReason actionReasonCode, String actionReasonDetails);
}