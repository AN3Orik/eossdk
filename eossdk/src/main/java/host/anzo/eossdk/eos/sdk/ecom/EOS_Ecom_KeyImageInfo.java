package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Ecom_Interface;
import host.anzo.eossdk.eos.sdk.ecom.options.EOS_Ecom_CopyItemImageInfoByIndexOptions;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a key image used by the catalog.  Instances of this structure are
 * created by EOS_Ecom_CopyItemImageInfoByIndex.  They must be passed to {@link EOS_Ecom_KeyImageInfo#release()}.
 * A Key Image is defined within Dev Portal and is associated with a Catalog Item.  A Key Image is
 * intended to be used to provide imagery for an in-game store.
 *
 * @see EOS_Ecom_Interface#copyItemImageInfoByIndex(EOS_Ecom_CopyItemImageInfoByIndexOptions)
 * @see EOS_Ecom_KeyImageInfo#release()
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "Type", "Url", "Width", "Height"})
public class EOS_Ecom_KeyImageInfo extends Structure implements AutoCloseable {
	/** The most recent version of the EOS_Ecom_KeyImageInfo struct. */
	public static final int EOS_ECOM_KEYIMAGEINFO_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_KEYIMAGEINFO_API_LATEST. */
	public int ApiVersion;
	/** Describes the usage of the image (ex: home_thumbnail) */
	public String Type;
	/** The URL of the image */
	public String Url;
	/** The expected width in pixels of the image */
	public int Width;
	/** The expected height in pixels of the image */
	public int Height;

	public EOS_Ecom_KeyImageInfo() {
		super();
		ApiVersion = EOS_ECOM_KEYIMAGEINFO_API_LATEST;
	}

	public EOS_Ecom_KeyImageInfo(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_Ecom_KeyImageInfo_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Ecom_KeyImageInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_KeyImageInfo implements Structure.ByValue {
	}
}