package host.anzo.eossdk.eos.sdk.titlestorage.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input data for the EOS_TitleStorage_QueryFileList function
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ApiVersion", "LocalUserId", "ListOfTags", "ListOfTagsCount"})
public class EOS_TitleStorage_QueryFileListOptions extends Structure {
	/** The most recent version of the EOS_TitleStorage_QueryFileList API. */
	public static final int EOS_TITLESTORAGE_QUERYFILELIST_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_TITLESTORAGE_QUERYFILELIST_API_LATEST}. */
	public int ApiVersion;
	/** Product User ID of the local user who requested file metadata (optional) */
	public EOS_ProductUserId LocalUserId;
	/** List of tags to use for lookup. */
	public PointerByReference ListOfTags;
	/** Number of tags specified in ListOfTags */
	public int ListOfTagsCount;

	public EOS_TitleStorage_QueryFileListOptions() {
		super();
		ApiVersion = EOS_TITLESTORAGE_QUERYFILELIST_API_LATEST;
	}

	public EOS_TitleStorage_QueryFileListOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_QueryFileListOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_QueryFileListOptions implements Structure.ByValue {
	}
}