/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import host.anzo.eossdk.eos.sdk.anticheat.common.enums.EOS_EAntiCheatCommonEventParamType;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ParamValueType", "ParamValue"})
public class EOS_AntiCheatCommon_LogEventParamPair extends Structure {
	public static int EOS_ANTICHEATCOMMON_LOGEVENT_STRING_MAX_LENGTH = 39;

	/** Parameter type */
	public EOS_EAntiCheatCommonEventParamType ParamValueType;
	/** Parameter value */
	public ParamValue_union ParamValue;

	public static class ParamValue_union extends Union {
		public EOS_AntiCheatCommon_ClientHandle ClientHandle;
		/** Will be truncated if longer than {@link #EOS_ANTICHEATCOMMON_LOGEVENT_STRING_MAX_LENGTH} bytes. */
		public String String;
		public int UInt32;
		public int Int32;
		public long UInt64;
		public long Int64;
		public EOS_AntiCheatCommon_Vec3f Vec3f;
		public EOS_AntiCheatCommon_Quat Quat;

		public ParamValue_union() {
			super();
		}

		public ParamValue_union(String string) {
			super();
			this.String = string;
			setType(String.class);
		}

		public ParamValue_union(EOS_AntiCheatCommon_ClientHandle clientHandle) {
			super();
			this.ClientHandle = clientHandle;
			setType(EOS_AntiCheatCommon_ClientHandle.class);
		}

		public ParamValue_union(int UInt32_or_Int32) {
			super();
			this.Int32 = this.UInt32 = UInt32_or_Int32;
			setType(Integer.TYPE);
		}

		public ParamValue_union(long UInt64_or_Int64) {
			super();
			this.Int64 = this.UInt64 = UInt64_or_Int64;
			setType(Long.TYPE);
		}

		public ParamValue_union(EOS_AntiCheatCommon_Vec3f Vec3f) {
			super();
			this.Vec3f = Vec3f;
			setType(EOS_AntiCheatCommon_Vec3f.class);
		}

		public ParamValue_union(EOS_AntiCheatCommon_Quat Quat) {
			super();
			this.Quat = Quat;
			setType(EOS_AntiCheatCommon_Quat.class);
		}

		public static class ByReference extends ParamValue_union implements Structure.ByReference {
		}

		public static class ByValue extends ParamValue_union implements Structure.ByValue {
		}
	}

	public EOS_AntiCheatCommon_LogEventParamPair() {
		super();
	}

	public EOS_AntiCheatCommon_LogEventParamPair(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_LogEventParamPair implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_LogEventParamPair implements Structure.ByValue {
	}
}