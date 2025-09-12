package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A page query is part of query options. It is used to allow pagination of query results.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"ApiVersion", "StartIndex", "MaxCount"})
public class EOS_PageQuery extends Structure {
	/** API Version: Set this to EOS_PAGEQUERY_API_LATEST. */
	public static int EOS_PAGEQUERY_API_LATEST = 1;

	/** The default MaxCount used for a EOS_PageQuery when the API allows the EOS_PageQuery to be omitted. */
	public static int EOS_PAGEQUERY_MAXCOUNT_DEFAULT = 10;
	/** The maximum MaxCount used for a EOS_PageQuery. */
	public static int EOS_PAGEQUERY_MAXCOUNT_MAXIMUM = 100;

	/** API Version: Set this to EOS_PAGEQUERY_API_LATEST. */
	public int ApiVersion;
	/** The index into the ordered query results to start the page at. */
	public int StartIndex;
	/** The maximum number of results to have in the page. */
	public int MaxCount;

	public EOS_PageQuery() {
		super();
		ApiVersion = EOS_PAGEQUERY_API_LATEST;
	}

	public EOS_PageQuery(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PageQuery implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PageQuery implements Structure.ByValue {
	}
}