/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing information for the auth expiration notification callback.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion"})
public class EOS_Connect_AddNotifyAuthExpirationOptions extends Structure {
	/** The most recent version of the EOS_Connect_AddNotifyAuthExpiration API. */
	public static int EOS_CONNECT_ADDNOTIFYAUTHEXPIRATION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CONNECT_ADDNOTIFYAUTHEXPIRATION_API_LATEST}. */
	public int ApiVersion;

	public EOS_Connect_AddNotifyAuthExpirationOptions() {
		super();
		ApiVersion = EOS_CONNECT_ADDNOTIFYAUTHEXPIRATION_API_LATEST;
	}

	public EOS_Connect_AddNotifyAuthExpirationOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_AddNotifyAuthExpirationOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_AddNotifyAuthExpirationOptions implements Structure.ByValue {
	}
}