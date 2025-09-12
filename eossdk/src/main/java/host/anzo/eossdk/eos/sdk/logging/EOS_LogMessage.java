package host.anzo.eossdk.eos.sdk.logging;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import host.anzo.eossdk.eos.sdk.logging.enums.EOS_ELogLevel;
import lombok.Getter;

/**
 * A structure representing a log message
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"Category", "Message", "Level"})
public @Getter class EOS_LogMessage extends Structure {
	/** A string representation of the log message category, encoded in UTF-8. Only valid during the life of the callback, so copy the string if you need it later. */
	public String Category;
	/** The log message, encoded in UTF-8. Only valid during the life of the callback, so copy the string if you need it later. */
	public String Message;
	/** The log level associated with the message */
	public EOS_ELogLevel Level;

	public EOS_LogMessage() {
		super();
	}

	public static class ByReference extends EOS_LogMessage implements Structure.ByReference {
	}

	public static class ByValue extends EOS_LogMessage implements Structure.ByValue {
	}
}