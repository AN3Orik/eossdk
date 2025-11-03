package host.anzo.eossdk.eos.sdk.presence.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.Union;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.presence.enums.EOS_EPresenceModificationTemplateType;

/**
 * Data for the {@link EOSLibrary#EOS_PresenceModification_SetTemplateData} API.
 * @author Anton Lasevich
 * @since 11/03/2025
 */
@FieldOrder({"ApiVersion", "Key", "Value", "ValueType"})
public class EOS_PresenceModification_SetTemplateDataOptions extends Structure {
	/** Most recent version of the EOS_PresenceModification_SetTemplateData API */
	public static final int EOS_PRESENCEMODIFICATION_SETTEMPLATEDATA_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_PRESENCEMODIFICATION_SETTEMPLATEDATA_API_LATEST}. */
	public int ApiVersion;
	/** Key for the named template parameter */
	public String Key;
	/** Union storage for template typed values */
	public Value_union Value;
	/** Type stored in the union */
	public EOS_EPresenceModificationTemplateType ValueType;

	/** Union storage for template typed values */
	public static class Value_union extends Union {
		/** Localized integer */
		public int AsInt32;
		/** Reference a StringId in the Backend */
		public String AsStringId;

		public Value_union() {
			super();
		}

		public Value_union(int AsInt32) {
			super();
			this.AsInt32 = AsInt32;
			setType(Integer.TYPE);
		}

		public Value_union(String AsStringId) {
			super();
			this.AsStringId = AsStringId;
			setType(String.class);
		}

		public static class ByReference extends Value_union implements Structure.ByReference {
		}

		public static class ByValue extends Value_union implements Structure.ByValue {
		}
	}

	public EOS_PresenceModification_SetTemplateDataOptions() {
		super();
		ApiVersion = EOS_PRESENCEMODIFICATION_SETTEMPLATEDATA_API_LATEST;
	}

	public EOS_PresenceModification_SetTemplateDataOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PresenceModification_SetTemplateDataOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PresenceModification_SetTemplateDataOptions implements Structure.ByValue {
	}
}