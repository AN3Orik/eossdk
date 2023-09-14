package host.anzo.eossdk.eos.sdk.ui.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_UI_AcknowledgeEventId.
 *
 * @author Anton Lasevich
 * @since 9/5/2023
 */
@FieldOrder({"ApiVersion", "UiEventId", "Result"})
public class EOS_UI_AcknowledgeEventIdOptions extends Structure {
	/** The most recent version of the EOS_UI_AcknowledgeEventId API. */
	public static final int EOS_UI_ACKNOWLEDGEEVENTID_API_LATEST = 1;

	/** API Version: Set this to EOS_SESSIONSEARCH_SETSESSIONID_API_LATEST. */
	public int ApiVersion;
	/** The ID being acknowledged. */
	public long UiEventId;
	/**
	 * The result to use for the acknowledgment.
	 * When acknowledging EOS_Presence_JoinGameAcceptedCallbackInfo this should be the
	 * result code from the JoinSession call.
	 */
	public EOS_EResult Result;

	public EOS_UI_AcknowledgeEventIdOptions() {
		super();
		ApiVersion = EOS_UI_ACKNOWLEDGEEVENTID_API_LATEST;
	}

	public EOS_UI_AcknowledgeEventIdOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_AcknowledgeEventIdOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_AcknowledgeEventIdOptions implements Structure.ByValue {
	}
}
