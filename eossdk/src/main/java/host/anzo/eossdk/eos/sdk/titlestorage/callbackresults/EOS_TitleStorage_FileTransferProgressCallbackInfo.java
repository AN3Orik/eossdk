package host.anzo.eossdk.eos.sdk.titlestorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing the information about a file transfer in progress (or one that has completed)
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "Filename", "BytesTransferred", "TotalFileSizeBytes"})
public class EOS_TitleStorage_FileTransferProgressCallbackInfo extends Structure {
	/** Client-specified data passed into the file request */
	public Pointer ClientData;
	/** Product User ID of the local user who initiated this request (optional, will only be present in case it was provided during operation start) */
	public EOS_ProductUserId LocalUserId;
	/** The file name of the file being transferred */
	public String Filename;
	/** Amount of bytes transferred so far in this request, out of TotalFileSizeBytes */
	public int BytesTransferred;
	/** The total size of the file being transferred (Includes file header in addition to file contents, can be slightly more than expected) */
	public int TotalFileSizeBytes;

	public EOS_TitleStorage_FileTransferProgressCallbackInfo() {
		super();
	}

	public EOS_TitleStorage_FileTransferProgressCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_FileTransferProgressCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_FileTransferProgressCallbackInfo implements Structure.ByValue {
	}
}