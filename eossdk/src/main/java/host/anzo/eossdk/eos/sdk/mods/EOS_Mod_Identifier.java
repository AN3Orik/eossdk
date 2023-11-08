package host.anzo.eossdk.eos.sdk.mods;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * EOS_Mod_Identifier is used to identify a mod.
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
@FieldOrder({"ApiVersion", "NamespaceId", "ItemId", "ArtifactId", "Title", "Version"})
public class EOS_Mod_Identifier extends Structure {
	/** The most recent version of the EOS_Mod_Identifier struct. */
	public static int EOS_MOD_IDENTIFIER_API_LATEST = 1;

	/** API Version: Set this to {@link #EOS_MOD_IDENTIFIER_API_LATEST}. */
	public int ApiVersion;
	/** Product namespace id in which this mod item exists */
	public String NamespaceId;
	/* Item id of the Mod */
	public String ItemId;
	/* Artifact id of the Mod */
	public String ArtifactId;
	/** Represent mod item title. */
	public String Title;
	/** Represent mod item version. */
	public String Version;

	public EOS_Mod_Identifier() {
		super();
		ApiVersion = EOS_MOD_IDENTIFIER_API_LATEST;
	}

	public EOS_Mod_Identifier(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Mod_Identifier implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Mod_Identifier implements Structure.ByValue {
	}
}