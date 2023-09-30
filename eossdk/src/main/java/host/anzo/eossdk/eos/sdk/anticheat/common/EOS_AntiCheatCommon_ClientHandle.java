package host.anzo.eossdk.eos.sdk.anticheat.common;

import com.sun.jna.ptr.IntByReference;

/**
 * Arbitrary data that is a unique local identifier for
 * a single remote client or peer.
 * Typically this is a pointer to an object describing the
 * player, but it can be anything that is locally unique.
 *
 * @author Anton Lasevich
 * @since 9/7/2023
 */
public class EOS_AntiCheatCommon_ClientHandle extends IntByReference {
	public EOS_AntiCheatCommon_ClientHandle() {
		super();
	}

	public EOS_AntiCheatCommon_ClientHandle(int id) {
		super(id);
	}
}