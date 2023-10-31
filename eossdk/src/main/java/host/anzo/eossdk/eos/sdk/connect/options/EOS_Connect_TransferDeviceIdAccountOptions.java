/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.connect.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Connect_TransferDeviceIdAccount Function.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "PrimaryLocalUserId", "LocalDeviceUserId", "ProductUserIdToPreserve"})
public class EOS_Connect_TransferDeviceIdAccountOptions extends Structure {
	/** The most recent version of the EOS_Connect_TransferDeviceIdAccount API. */
	public static int EOS_CONNECT_TRANSFERDEVICEIDACCOUNT_API_LATEST = 1;

	/** API Version: Set this to EOS_CONNECT_TRANSFERDEVICEIDACCOUNT_API_LATEST. */
	public int ApiVersion;
	/**
	 * The primary product user id, currently logged in, that is already associated with a real external user account (such as Epic Games, PlayStation(TM)Network, Xbox Live and other).
	 * <p>
	 * The account linking keychain that owns this product user will be preserved and receive
	 * the Device ID login credentials under it.
	 */
	public EOS_ProductUserId PrimaryLocalUserId;
	/**
	 * The product user id, currently logged in, that has been originally created using the anonymous local Device ID login type,
	 * and whose Device ID login will be transferred to the keychain of the PrimaryLocalUserId.
	 */
	public EOS_ProductUserId LocalDeviceUserId;
	/**
	 * Specifies which EOS_ProductUserId (i.e. game progression) will be preserved in the operation.
	 * <p>
	 * After a successful transfer operation, subsequent logins using the same external account or
	 * the same local Device ID login will return user session for the ProductUserIdToPreserve.
	 * <p>
	 * Set to either PrimaryLocalUserId or LocalDeviceUserId.
	 */
	public EOS_ProductUserId ProductUserIdToPreserve;

	public EOS_Connect_TransferDeviceIdAccountOptions() {
		super();
		ApiVersion = EOS_CONNECT_TRANSFERDEVICEIDACCOUNT_API_LATEST;
	}

	public EOS_Connect_TransferDeviceIdAccountOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Connect_TransferDeviceIdAccountOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_TransferDeviceIdAccountOptions implements Structure.ByValue {
	}
}