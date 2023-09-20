package host.anzo.eossdk.eos.sdk.titlestorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Structure containing data for a chunk of a file being read
 *
 * @author Anton Lasevich
 * @since 9/3/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "Filename", "TotalFileSizeBytes", "bIsLastChunk", "DataChunkLengthBytes", "DataChunk"})
public class EOS_TitleStorage_ReadFileDataCallbackInfo extends Structure {
	/** Client-specified data passed into the file request */
	public Pointer ClientData;
	/** Product User ID of the local user who initiated this request (optional, will only be present in case it was provided during operation start) */
	public EOS_ProductUserId LocalUserId;
	/** The file name being read */
	public Pointer Filename;
	/** The total file size of the file being read */
	public int TotalFileSizeBytes;
	/** Is this chunk the last chunk of data? */
	public EOS_Bool bIsLastChunk;
	/** The length of DataChunk in bytes that can be safely read */
	public int DataChunkLengthBytes;
	/** Pointer to the start of data to be read */
	public Pointer DataChunk;

	public EOS_TitleStorage_ReadFileDataCallbackInfo() {
		super();
	}

	public EOS_TitleStorage_ReadFileDataCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_TitleStorage_ReadFileDataCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_TitleStorage_ReadFileDataCallbackInfo implements Structure.ByValue {
	}
}