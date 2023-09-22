package host.anzo.eossdk.eos.sdk.achievements;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a collection of stat threshold data.
 * <p>
 * The threshold will depend on the stat aggregate type:
 *   LATEST (Tracks the latest value)
 *   MAX (Tracks the maximum value)
 *   MIN (Tracks the minimum value)
 *   SUM (Generates a rolling sum of the value)
 *
 * @see EOS_Achievements_DefinitionV2
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "Name", "Threshold"})
public class EOS_Achievements_StatThresholds extends Structure {
	/** The most recent version of the EOS_Achievements_StatThresholds struct. */
	public static final int EOS_ACHIEVEMENTS_STATTHRESHOLDS_API_LATEST = 1;

	/** API Version: Set this to EOS_ACHIEVEMENTS_STATTHRESHOLDS_API_LATEST. */
	public int ApiVersion;
	/** The name of the stat. */
	public String Name;
	/** The value that the stat must surpass to satisfy the requirement for unlocking an achievement. */
	public int Threshold;

	public EOS_Achievements_StatThresholds() {
		super();
		ApiVersion = EOS_ACHIEVEMENTS_STATTHRESHOLDS_API_LATEST;
	}

	public EOS_Achievements_StatThresholds(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_StatThresholds implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_StatThresholds implements Structure.ByValue {
	}
}