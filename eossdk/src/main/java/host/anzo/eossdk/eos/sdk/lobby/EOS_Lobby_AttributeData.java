package host.anzo.eossdk.eos.sdk.lobby;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EAttributeType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/16/2023
 */
@FieldOrder({"ApiVersion", "Key", "Value", "ValueType"})
public class EOS_Lobby_AttributeData extends Structure {
	/** The most recent version of the EOS_Lobby_AttributeData struct. */
	public static final int EOS_LOBBY_ATTRIBUTEDATA_API_LATEST = 1;

	/** API Version: Set this to EOS_LOBBY_ATTRIBUTEDATA_API_LATEST. */
	public int ApiVersion;
	/** Name of the lobby attribute */
	public String Key;
	/** Union depend on value type */
	public Value_union Value;
	/** Type of value stored in the union */
	public EOS_EAttributeType ValueType;

	public static class Value_union extends Union {
		/** Stored as an 8 byte integer */
		public long AsInt64;
		/** Stored as a double precision floating point */
		public double AsDouble;
		/** Stored as a boolean */
		public int AsBool;
		/** Stored as a null terminated UTF8 string */
		public Pointer AsUtf8;

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

		public Value_union(Pointer AsUtf8) {
			super();
			this.AsUtf8 = AsUtf8;
			setType(Pointer.class);
		}

		public static class ByReference extends Value_union implements Structure.ByReference {
		}
		public static class ByValue extends Value_union implements Structure.ByValue {
		}
	}
	public EOS_Lobby_AttributeData() {
		super();
		ApiVersion = EOS_LOBBY_ATTRIBUTEDATA_API_LATEST;
	}

	public EOS_Lobby_AttributeData(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Lobby_AttributeData implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Lobby_AttributeData implements Structure.ByValue {
	}
}