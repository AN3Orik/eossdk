package host.anzo.eossdk.eos.sdk.ecom;

import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.EOSLibrary;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Contains information about a single release within the catalog. Instances of this structure are
 * created by EOS_Ecom_CopyItemReleaseByIndex. They must be passed to {@link EOS_Ecom_CatalogRelease#release()}.
 *
 * @author Anton Lasevich
 * @since 8/20/2023
 */
@FieldOrder({"ApiVersion", "CompatibleAppIdCount", "CompatibleAppIds", "CompatiblePlatformCount", "CompatiblePlatforms", "ReleaseNote"})
public class EOS_Ecom_CatalogRelease extends Structure implements AutoCloseable {
	public static final int EOS_ECOM_CATALOGRELEASE_API_LATEST = 1;

	/** API Version: Set this to EOS_ECOM_CATALOGRELEASE_API_LATEST. */
	public int ApiVersion;
	/** The number of APP IDs */
	public int CompatibleAppIdCount;
	/** A list of compatible APP IDs */
	public StringArray CompatibleAppIds;
	/** The number of platforms */
	public int CompatiblePlatformCount;
	/** A list of compatible Platforms */
	public StringArray CompatiblePlatforms;
	/** Release note for compatible versions */
	public String ReleaseNote;

	public EOS_Ecom_CatalogRelease() {
		super();
		ApiVersion = EOS_ECOM_CATALOGRELEASE_API_LATEST;
	}

	public EOS_Ecom_CatalogRelease(Pointer peer) {
		super(peer);
	}

	public void release() {
		EOSLibrary.instance.EOS_Ecom_CatalogRelease_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}

	public static class ByReference extends EOS_Ecom_CatalogRelease implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Ecom_CatalogRelease implements Structure.ByValue {
	}
}