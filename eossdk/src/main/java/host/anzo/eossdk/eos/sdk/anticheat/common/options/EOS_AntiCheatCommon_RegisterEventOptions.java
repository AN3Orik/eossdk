package host.anzo.eossdk.eos.sdk.anticheat.common.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.EOS_AntiCheatCommon_RegisterEventParamDef;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonEventType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "EventId", "EventName", "EventType", "ParamDefsCount", "ParamDefs"})
public class EOS_AntiCheatCommon_RegisterEventOptions extends Structure {
	public static int EOS_ANTICHEATCOMMON_REGISTEREVENT_API_LATEST = 1;
	public static int EOS_ANTICHEATCOMMON_REGISTEREVENT_CUSTOMEVENTBASE = 0x10000000;
	public static int EOS_ANTICHEATCOMMON_REGISTEREVENT_MAX_PARAMDEFSCOUNT = 12;

	/** API Version: Set this to {@link #EOS_ANTICHEATCOMMON_REGISTEREVENT_API_LATEST}. */
	public int ApiVersion;
	/** Unique event identifier. Must be {@literal >=} EOS_ANTICHEATCOMMON_REGISTEREVENT_CUSTOMEVENTBASE. */
	public int EventId;
	/** Name of the custom event. Allowed characters are 0-9, A-Z, a-z, '_', '-' */
	public String EventName;
	/** Type of the custom event */
	public EOS_EAntiCheatCommonEventType EventType;
	/** Number of parameters described in ParamDefs. Must be equal to or less than EOS_ANTICHEATCOMMON_REGISTEREVENT_MAX_PARAMDEFSCOUNT. */
	public int ParamDefsCount;
	/** Pointer to an array of EOS_AntiCheatCommon_RegisterEventParamDef with ParamDefsCount elements */
	public EOS_AntiCheatCommon_RegisterEventParamDef.ByReference ParamDefs;

	public EOS_AntiCheatCommon_RegisterEventOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCOMMON_REGISTEREVENT_API_LATEST;
	}

	public EOS_AntiCheatCommon_RegisterEventOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_RegisterEventOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_RegisterEventOptions implements Structure.ByValue {
	}
}