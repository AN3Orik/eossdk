/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.anticheat.common;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Vector using left-handed coordinate system (as in Unreal Engine)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"x", "y", "z"})
public class EOS_AntiCheatCommon_Vec3f extends Structure {
	public float x;
	public float y;
	public float z;

	public EOS_AntiCheatCommon_Vec3f() {
		super();
	}

	public EOS_AntiCheatCommon_Vec3f(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatCommon_Vec3f implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatCommon_Vec3f implements Structure.ByValue {
	}
}