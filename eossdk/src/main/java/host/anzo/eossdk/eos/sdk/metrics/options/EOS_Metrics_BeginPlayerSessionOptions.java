package host.anzo.eossdk.eos.sdk.metrics.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.metrics.enums.EOS_EMetricsAccountIdType;
import host.anzo.eossdk.eos.sdk.metrics.enums.EOS_EUserControllerType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * BeginPlayerSession
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "AccountIdType", "AccountId", "DisplayName", "ControllerType", "ServerIp", "GameSessionId"})
public class EOS_Metrics_BeginPlayerSessionOptions extends Structure {
	/** The most recent version of the EOS_Metrics_BeginPlayerSessionOptions struct. */
	public static final int EOS_METRICS_BEGINPLAYERSESSION_API_LATEST = 1;

	/** API Version: Set this to EOS_METRICS_BEGINPLAYERSESSION_API_LATEST. */
	public int ApiVersion;
	/** The Account ID type that is set in the union. */
	public EOS_EMetricsAccountIdType AccountIdType;
	/** The Account ID for the player whose session is beginning. */
	public AccountId_union AccountId;
	/** The in-game display name for the user as UTF-8 string. */
	public String DisplayName;
	/**
	 * The user's game controller type.
	 */
	public EOS_EUserControllerType ControllerType;
	/**
	 * IP address of the game server hosting the game session. For a localhost session, set to NULL.<br>
	 * <b>Must be in either one of the following IPv4 or IPv6 string formats:</b>
	 * <ul>
	 *     <li>"127.0.0.1".
	 *     <li>"1200:0000:AB00:1234:0000:2552:7777:1313".
	 * </ul>
	 * If both IPv4 and IPv6 addresses are available, use the IPv6 address.
	 */
	public String ServerIp;
	/**
	 * Optional, application-defined custom match session identifier. If the identifier is not used, set to NULL.<br>
	 * <b>The game can tag each game session with a custom session match identifier, which will be shown in the Played Sessions listing at the user profile dashboard.</b>
	 */
	public String GameSessionId;

	public EOS_Metrics_BeginPlayerSessionOptions() {
		super();
		ApiVersion = EOS_METRICS_BEGINPLAYERSESSION_API_LATEST;
	}

	public EOS_Metrics_BeginPlayerSessionOptions(Pointer peer) {
		super(peer);
	}

	public static class AccountId_union extends Union {
		/** An Epic Account ID. Set this field when AccountIdType is set to EOS_MAIT_Epic. */
		public EOS_EpicAccountId Epic;
		/** An Account ID for another service. Set this field when AccountIdType is set to EOS_MAIT_External. */
		public String External;

		public AccountId_union() {
			super();
		}

		public AccountId_union(EOS_EpicAccountId Epic) {
			super();
			this.Epic = Epic;
			setType(EOS_EpicAccountId.class);
		}

		public AccountId_union(String External) {
			super();
			this.External = External;
			setType(String.class);
		}

		public static class ByReference extends AccountId_union implements Structure.ByReference {
		}

		public static class ByValue extends AccountId_union implements Structure.ByValue {
		}
	}

	public static class ByReference extends EOS_Metrics_BeginPlayerSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Metrics_BeginPlayerSessionOptions implements Structure.ByValue {
	}
}