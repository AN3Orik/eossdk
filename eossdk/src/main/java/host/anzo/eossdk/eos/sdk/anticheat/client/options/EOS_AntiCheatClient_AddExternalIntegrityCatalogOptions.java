package host.anzo.eossdk.eos.sdk.anticheat.client.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "PathToBinFile"})
public class EOS_AntiCheatClient_AddExternalIntegrityCatalogOptions extends Structure {
	public static final int EOS_ANTICHEATCLIENT_ADDEXTERNALINTEGRITYCATALOG_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_ANTICHEATCLIENT_ADDEXTERNALINTEGRITYCATALOG_API_LATEST}. */
	public int ApiVersion;
	/** UTF-8 path to the .bin catalog file to add */
	public String PathToBinFile;

	public EOS_AntiCheatClient_AddExternalIntegrityCatalogOptions() {
		super();
		ApiVersion = EOS_ANTICHEATCLIENT_ADDEXTERNALINTEGRITYCATALOG_API_LATEST;
	}

	public EOS_AntiCheatClient_AddExternalIntegrityCatalogOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_AntiCheatClient_AddExternalIntegrityCatalogOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_AntiCheatClient_AddExternalIntegrityCatalogOptions implements Structure.ByValue {
	}
}