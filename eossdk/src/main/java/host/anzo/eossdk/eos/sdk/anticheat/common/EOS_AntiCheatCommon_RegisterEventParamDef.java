package host.anzo.eossdk.eos.sdk.anticheat.common;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonEventParamType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Register Event Parameter Definition.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ParamName", "ParamType"})
public class EOS_AntiCheatCommon_RegisterEventParamDef extends Structure {
	/** Parameter name. Allowed characters are 0-9, A-Z, a-z, '_', '-' */
	public String ParamName;
	/** Parameter type */
	private EOS_EAntiCheatCommonEventParamType ParamType;

	public EOS_AntiCheatCommon_RegisterEventParamDef() {
		super();
	}

	public EOS_AntiCheatCommon_RegisterEventParamDef(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_RegisterEventParamDef implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_RegisterEventParamDef implements Structure.ByValue {
	}
}