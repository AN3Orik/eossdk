package host.anzo.eossdk.eos.sdk.sanctions;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single player sanction.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "TimePlaced", "Action", "TimeExpires", "ReferenceId"})
public class EOS_Sanctions_PlayerSanction extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Sanctions_PlayerSanction struct. */
	public static final int EOS_SANCTIONS_PLAYERSANCTION_API_LATEST = 2;

	/** API Version: This will be set to EOS_SANCTIONS_PLAYERSANCTION_API_LATEST. */
	public int ApiVersion;
	/** The POSIX timestamp when the sanction was placed */
	public long TimePlaced;
	/** The action associated with this sanction */
	public String Action;
	/** The POSIX timestamp when the sanction will expire. If the sanction is permanent, this will be 0. */
	public long TimeExpires;
	/** A unique identifier for this specific sanction */
	public String ReferenceId;

	public EOS_Sanctions_PlayerSanction() {
		super();
		ApiVersion = EOS_SANCTIONS_PLAYERSANCTION_API_LATEST;
	}

	public EOS_Sanctions_PlayerSanction(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_Sanctions_PlayerSanction_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Sanctions_PlayerSanction implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Sanctions_PlayerSanction implements Structure.ByValue {
	}
}