package host.anzo.eossdk.eos.sdk.sessions;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EAttributeType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about both session and search parameter attribution
 *
 * @author Anton Lasevich
 * @since 9/6/2023
 */
@FieldOrder({"ApiVersion", "Key", "Value", "ValueType"})
public class EOS_Sessions_AttributeData extends Structure {
	/** The most recent version of the EOS_Sessions_AttributeData struct. */
	public static final int EOS_SESSIONS_ATTRIBUTEDATA_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_SESSIONS_ATTRIBUTEDATA_API_LATEST}. */
	public int ApiVersion;
	/** Name of the session attribute */
	public String Key;
	public Value_union Value;
	/** Type of value stored in the union */
	public EOS_EAttributeType ValueType;

	/** Value of the session attribute */
	public static class Value_union extends Union {
		/** Stored as an 8 byte integer */
		public long AsInt64;
		/** Stored as a double precision floating point */
		public double AsDouble;
		/** Stored as a boolean */
		public int AsBool;
		/** Stored as a null terminated UTF8 string. Should not be nullptr */
		public String AsUtf8;

		public Value_union() {
			super();
		}

		public Value_union(long AsInt64) {
			super();
			this.AsInt64 = AsInt64;
			setType(Long.TYPE);
		}

		public Value_union(double AsDouble) {
			super();
			this.AsDouble = AsDouble;
			setType(Double.TYPE);
		}

		public Value_union(int AsBool) {
			super();
			this.AsBool = AsBool;
			setType(Integer.TYPE);
		}

		public Value_union(String AsUtf8) {
			super();
			this.AsUtf8 = AsUtf8;
			setType(String.class);
		}

		public static class ByReference extends Value_union implements Structure.ByReference {
		}

		public static class ByValue extends Value_union implements Structure.ByValue {
		}
	}

	public EOS_Sessions_AttributeData() {
		super();
		ApiVersion = EOS_SESSIONS_ATTRIBUTEDATA_API_LATEST;
	}

	public EOS_Sessions_AttributeData(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Sessions_AttributeData implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sessions_AttributeData implements Structure.ByValue {
	}
}
