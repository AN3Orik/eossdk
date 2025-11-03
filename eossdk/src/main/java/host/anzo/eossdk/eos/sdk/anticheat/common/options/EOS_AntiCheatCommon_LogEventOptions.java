package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_ClientHandle;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_LogEventParamPair;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the {@link EOSLibrary#EOS_AntiCheatServer_LogEvent} function.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "ClientHandle", "EventId", "ParamsCount", "Params"})
public class EOS_AntiCheatCommon_LogEventOptions extends Structure {
	/** The most recent version of the EOS_AntiCheatCommon_LogEventOptions struct. */
	public static int EOS_ANTICHEATCOMMON_LOGEVENT_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_LOGEVENT_API_LATEST}. */
	public int ApiVersion;
	/** Optional client who this event is primarily associated with. If not applicable, use 0. */
	public EOS_AntiCheatCommon_ClientHandle ClientHandle;
	/** Unique event identifier previously configured in RegisterEvent */
	public int EventId;
	/** Number of parameters described in Params */
	public int ParamsCount;
	/** Set of parameter types previously configured in RegisterEvent, and their values */
	public EOS_AntiCheatCommon_LogEventParamPair.ByReference Params;

	public EOS_AntiCheatCommon_LogEventOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_LOGEVENT_API_LATEST;
	}

	public EOS_AntiCheatCommon_LogEventOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogEventOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogEventOptions implements Structure.ByValue {
	}
}