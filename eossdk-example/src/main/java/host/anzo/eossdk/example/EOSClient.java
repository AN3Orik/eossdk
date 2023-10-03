package host.anzo.eossdk.example;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalCredentialType;
import host.anzo.eossdk.eos.sdk.connect.EOS_Connect_Credentials;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_LoginOptions;
import host.anzo.eossdk.eos.sdk.logging.EOS_LogMessage;
import host.anzo.eossdk.eosex.AEOSClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.jetbrains.annotations.NotNull;
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
	protected EOS_Connect_LoginOptions getConnectLoginOptions() {
		String token;
		if (options.getAuthExternalCredentialType() == EOS_EExternalCredentialType.EOS_ECT_OPENID_ACCESS_TOKEN) {
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
		}
		else {
			throw new UnsupportedOperationException("EOS_EExternalCredentialType." + options.getAuthExternalCredentialType() + " isn't supported");
		}

		log.info("Successfully received token=[{}] from OpenID", token);

		final EOS_Connect_Credentials.ByReference credentials = new EOS_Connect_Credentials.ByReference();
		credentials.Type = options.getAuthExternalCredentialType();
		credentials.Token = token;
		return new EOS_Connect_LoginOptions(credentials);
	}
}