package host.anzo.eossdk.eos.sdk.stats;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single player stat.
 *
 * @author Anton Lasevich
 * @since 8/31/2023
 */
@FieldOrder({"ApiVersion", "Name", "StartTime", "EndTime", "Value"})
public class EOS_Stats_Stat extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Stats_Stat struct. */
	public static final int EOS_STATS_STAT_API_LATEST = 1;

	/** Timestamp value representing an undefined StartTime or EndTime for EOS_Stats_Stat */
	public static final int EOS_STATS_TIME_UNDEFINED = -1;

	/** API Version: Set this to {@link #EOS_STATS_STAT_API_LATEST}. */
	public int ApiVersion;
	/** Name of the stat. */
	public String Name;
	/** If not {@link #EOS_STATS_TIME_UNDEFINED} then this is the POSIX timestamp for start time. */
	public long StartTime;
	/** If not {@link #EOS_STATS_TIME_UNDEFINED} then this is the POSIX timestamp for end time. */
	public long EndTime;
	/** Current value for the stat. */
	public int Value;

	public EOS_Stats_Stat() {
		super();
		ApiVersion = EOS_STATS_STAT_API_LATEST;
	}

	public EOS_Stats_Stat(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_Stats_Stat_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Stats_Stat implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Stats_Stat implements Structure.ByValue {
	}
}