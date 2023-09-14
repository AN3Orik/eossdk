package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.sdk.anticheat.server.options.EOS_AntiCheatServer_BeginSessionOptions;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Getter
public @SuperBuilder class EOSServerOptions extends EOSBaseOptions {
	// Anti-Cheat Server
	private String antiCheatServerName;
	private @Builder.Default int antiCheatRegisterTimeoutSeconds = EOS_AntiCheatServer_BeginSessionOptions.EOS_ANTICHEATSERVER_BEGINSESSION_MIN_REGISTERTIMEOUT;
	private @Builder.Default boolean antiCheatEnableGamePlayData = false;
}