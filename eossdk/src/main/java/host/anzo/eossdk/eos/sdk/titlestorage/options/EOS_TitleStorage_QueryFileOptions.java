package host.anzo.eossdk.eos.sdk.titlestorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_TitleStorage_QueryFile function
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "Filename"})
public class EOS_TitleStorage_QueryFileOptions extends Structure {
	/** The most recent version of the EOS_TitleStorage_QueryFile API. */
	public static final int EOS_TITLESTORAGE_QUERYFILE_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_TITLESTORAGE_QUERYFILE_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID of the local user requesting file metadata (optional) */
	public EOS_ProductUserId LocalUserId;
	/** The requested file's name */
	public String Filename;

	public EOS_TitleStorage_QueryFileOptions() {
		super();
		ApiVersion = EOS_TITLESTORAGE_QUERYFILE_API_LATEST;
	}

	public EOS_TitleStorage_QueryFileOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_QueryFileOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_QueryFileOptions implements Structure.ByValue {
	}
}