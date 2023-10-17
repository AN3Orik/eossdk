package host.anzo.eossdk.example;

import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_Credentials;
import host.anzo.eossdk.eos.sdk.auth.EOS_Auth_IdToken;
import host.anzo.eossdk.eos.sdk.auth.enums.EOS_ELoginCredentialType;
import host.anzo.eossdk.eos.sdk.auth.options.EOS_Auth_LoginOptions;
import host.anzo.eossdk.eos.sdk.connect.EOS_Connect_Credentials;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_LoginOptions;
import host.anzo.eossdk.eosex.AEOSClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@Slf4j
public class EOSClient extends AEOSClient {
	@Getter(lazy = true)
	private final static EOSClient instance = new EOSClient();

	@Override
	protected EOS_Auth_LoginOptions getAuthLoginOptions() {
		final EOS_Auth_LoginOptions loginOptions = new EOS_Auth_LoginOptions();
		loginOptions.Credentials = new EOS_Auth_Credentials.ByReference();
		loginOptions.Credentials.Type = EOS_ELoginCredentialType.EOS_LCT_Developer;
		loginOptions.Credentials.Id = "localhost:1234";
		loginOptions.Credentials.Token = "test";
		return loginOptions;
	}

	@Override
	protected EOS_Connect_LoginOptions getConnectLoginOptions(EOS_Auth_IdToken authIdToken) {
		String token;
		switch (options.getAuthExternalCredentialType()) {
			case EOS_ECT_OPENID_ACCESS_TOKEN:
				final Request request = Request.post(options.getOpenIdSignInUrl())
						.bodyForm(Form.form()
								.add("user_name", options.getUserLogin())
								.add("password", options.getUserPassword())
								.build());
				try {
					final JSONObject result = new JSONObject(request.execute().returnContent().toString());
					if (result.getInt("messageResultType") > 0) {
						throw new RuntimeException("Token request failed with message from server: " + result.getString("message"));
					}
					else {
						token = result.getString("message");
					}
				}
				catch (IOException e) {
					throw new RuntimeException("Error while token request", e);
				}
				break;
			case EOS_ECT_EPIC_ID_TOKEN:
				if (authIdToken == null) {
					throw new RuntimeException("AuthIdToken is null");
				}
				token = authIdToken.JsonWebToken;
				break;
			default:
				throw new UnsupportedOperationException("EOS_EExternalCredentialType." + options.getAuthExternalCredentialType() + " isn't supported");
		}

		log.info("Successfully received token=[{}] via [{}]", token, options.getAuthExternalCredentialType());

		final EOS_Connect_Credentials.ByReference credentials = new EOS_Connect_Credentials.ByReference();
		credentials.Type = options.getAuthExternalCredentialType();
		credentials.Token = token;
		return new EOS_Connect_LoginOptions(credentials);
	}
}