package host.anzo.eossdk.eosex;

import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatClientMode;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalCredentialType;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Getter
public @SuperBuilder class EOSClientOptions extends EOSBaseOptions {
	// Auth
	private @Builder.Default boolean useEpicAuthentication = false;
	private @Builder.Default EOS_EExternalCredentialType authExternalCredentialType = EOS_EExternalCredentialType.EOS_ECT_OPENID_ACCESS_TOKEN;
	private @Builder.Default String userLogin = "login";
	private @Builder.Default String userPassword = "password";
	private @Builder.Default String openIdSignInUrl = "https://localhost/OpenID/sign_in";

	// Anti-Cheat Client
	private @Builder.Default EOS_EAntiCheatClientMode antiCheatMode = EOS_EAntiCheatClientMode.EOS_ACCM_ClientServer;
}