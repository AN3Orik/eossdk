package host.anzo.eossdk.eos.sdk.metrics.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import host.anzo.eossdk.eos.sdk.common.EOS_EpicAccountId;
import host.anzo.eossdk.eos.sdk.metrics.enums.EOS_EMetricsAccountIdType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * EndPlayerSession
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
@FieldOrder({"ApiVersion", "AccountIdType", "AccountId"})
public class EOS_Metrics_EndPlayerSessionOptions extends Structure {
	/** The most recent version of the EOS_Metrics_EndPlayerSessionOptions struct. */
	public static final int EOS_METRICS_ENDPLAYERSESSION_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_METRICS_ENDPLAYERSESSION_API_LATEST}. */
	public int ApiVersion;
	/** The Account ID type that is set in the union. */
	public EOS_EMetricsAccountIdType AccountIdType;
	/** The Account ID for the player whose session is ending. */
	public AccountId_union AccountId;

	public EOS_Metrics_EndPlayerSessionOptions() {
		super();
		ApiVersion = EOS_METRICS_ENDPLAYERSESSION_API_LATEST;
	}

	public EOS_Metrics_EndPlayerSessionOptions(Pointer peer) {
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

		public static class ByReference extends EOS_Metrics_BeginPlayerSessionOptions.AccountId_union implements Structure.ByReference {
		}

		public static class ByValue extends EOS_Metrics_BeginPlayerSessionOptions.AccountId_union implements Structure.ByValue {
		}
	}

	public static class ByReference extends EOS_Metrics_EndPlayerSessionOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Metrics_EndPlayerSessionOptions implements Structure.ByValue {
	}
}