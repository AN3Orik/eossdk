package host.anzo.eossdk.eos.sdk.connect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Connect_Interface;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EExternalAccountType;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_CopyProductUserExternalAccountByAccountTypeOptions;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_CopyProductUserExternalAccountByIndexOptions;
import host.anzo.eossdk.eos.sdk.connect.options.EOS_Connect_CopyProductUserInfoOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about an external account linked with a Product User ID.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ProductUserId", "DisplayName", "AccountId", "AccountIdType", "LastLoginTime"})
public class EOS_Connect_ExternalAccountInfo extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Connect_CopyProductUserExternalAccountByAccountId API. */
	public static int EOS_CONNECT_COPYPRODUCTUSEREXTERNALACCOUNTBYACCOUNTID_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_CONNECT_COPYPRODUCTUSEREXTERNALACCOUNTBYACCOUNTID_API_LATEST}. */
	public int ApiVersion;
	/** The Product User ID of the target user. */
	public EOS_ProductUserId ProductUserId;
	/** Display name, can be null if not set. */
	public String DisplayName;
	/**
	 * External account ID.
	 * <p>
	 * May be set to an empty string if the AccountIdType of another user belongs
	 * to different account system than the local user's authenticated account.
	 * The availability of this field is dependent on account system specifics.
	 */
	public String AccountId;
	/** The identity provider that owns the external account. */
	public EOS_EExternalAccountType AccountIdType;
	/** The POSIX timestamp for the time the user last logged in, or EOS_CONNECT_TIME_UNDEFINED. */
	public long LastLoginTime;

	public EOS_Connect_ExternalAccountInfo() {
		super();
		ApiVersion = EOS_CONNECT_COPYPRODUCTUSEREXTERNALACCOUNTBYACCOUNTID_API_LATEST;
	}

	public EOS_Connect_ExternalAccountInfo(Pointer peer) {
		super(peer);
	}

	/**
	 * Release the memory associated with an external account info. This must be called on data retrieved from
	 * EOS_Connect_CopyProductUserExternalAccountByIndex, EOS_Connect_CopyProductUserExternalAccountByAccountType,
	 * EOS_Connect_CopyProductUserExternalAccountByAccountId or EOS_Connect_CopyProductUserInfo.
	 *
	 * @see EOS_Connect_Interface#copyProductUserExternalAccountByIndex(EOS_Connect_CopyProductUserExternalAccountByIndexOptions)
	 * @see EOS_Connect_Interface#copyProductUserExternalAccountByAccountType(EOS_Connect_CopyProductUserExternalAccountByAccountTypeOptions)
	 * @see EOS_Connect_Interface#copyProductUserExternalAccountByAccountId(EOS_Connect_CopyProductUserExternalAccountByAccountIdOptions)
	 * @see EOS_Connect_Interface#copyProductUserInfo(EOS_Connect_CopyProductUserInfoOptions)
	 */
	public void release() {
		EOSLibrary.instance.EOS_Connect_ExternalAccountInfo_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Connect_ExternalAccountInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Connect_ExternalAccountInfo implements Structure.ByValue {
	}
}