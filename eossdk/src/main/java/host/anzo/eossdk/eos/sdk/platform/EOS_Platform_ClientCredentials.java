/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.platform;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import lombok.AllArgsConstructor;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@AllArgsConstructor
@FieldOrder({ "ClientId", "ClientSecret" })
public class EOS_Platform_ClientCredentials extends Structure {
	/** Client ID of the service permissions entry. Set to NULL if no service permissions are used. */
	public String ClientId;
	/** Client secret for accessing the set of permissions. Set to NULL if no service permissions are used. */
	public String ClientSecret;

	@SuppressWarnings("unused")
	public EOS_Platform_ClientCredentials() {
		super();
	}

	public static class ByReference extends EOS_Platform_ClientCredentials implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Platform_ClientCredentials implements Structure.ByValue {
	}
}