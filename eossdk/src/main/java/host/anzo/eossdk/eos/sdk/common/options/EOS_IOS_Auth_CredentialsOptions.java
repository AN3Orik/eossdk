package host.anzo.eossdk.eos.sdk.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Options for initializing login for IOS.
 *
 * @author Anton Lasevich
 * @since 11/7/2023
 */
public class EOS_IOS_Auth_CredentialsOptions extends Structure {
	/** API version of EOS_IOS_Auth_CredentialsOptions. */
	public static final int EOS_IOS_AUTH_CREDENTIALSOPTIONS_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_IOS_AUTH_CREDENTIALSOPTIONS_API_LATEST}. */
	public int ApiVersion;
	/**
	 *  When calling EOS_Auth_Login
	 *  NSObject that implements the ASWebAuthenticationPresentationContextProviding protocol,
	 *  typically this is added to the applications UIViewController.
	 *  Required for iOS 13+ only, for earlier versions this value must be a nullptr.
	 *  Object must be retained and cast to a void* using: (void*)CFBridgingRetain(presentationContextProviding)
	 *  EOSSDK will release this bridged object when the value is consumed for iOS 13+.
	 */
	public Pointer PresentationContextProviding;

	public EOS_IOS_Auth_CredentialsOptions() {
		super();
		ApiVersion = EOS_IOS_AUTH_CREDENTIALSOPTIONS_API_LATEST;
	}

	public EOS_IOS_Auth_CredentialsOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_IOS_Auth_CredentialsOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_IOS_Auth_CredentialsOptions implements Structure.ByValue {
	}
}