package host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the information about a file transfer in progress (or one that has completed)
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "Filename", "BytesTransferred", "TotalFileSizeBytes"})
public class EOS_PlayerDataStorage_FileTransferProgressCallbackInfo extends Structure {
	/** Client-specified data passed into the file request */
	public Pointer ClientData;
	/** The Product User ID of the local user who initiated this request */
	public EOS_ProductUserId LocalUserId;
	/** The file name of the file being transferred */
	public String Filename;
	/** Amount of bytes transferred so far in this request, out of TotalFileSizeBytes */
	public int BytesTransferred;
	/** The total size of the file being transferred (Includes file header in addition to file contents, can be slightly more than expected) */
	public int TotalFileSizeBytes;

	public EOS_PlayerDataStorage_FileTransferProgressCallbackInfo() {
		super();
	}

	public EOS_PlayerDataStorage_FileTransferProgressCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_FileTransferProgressCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_FileTransferProgressCallbackInfo implements Structure.ByValue {
	}
}