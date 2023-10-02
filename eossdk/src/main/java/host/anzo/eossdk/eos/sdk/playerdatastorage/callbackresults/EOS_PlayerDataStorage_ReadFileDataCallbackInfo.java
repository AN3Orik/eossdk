package host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_Bool;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing data for a chunk of a file being read
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "Filename", "TotalFileSizeBytes", "IsLastChunk", "DataChunkLengthBytes", "DataChunk"})
public class EOS_PlayerDataStorage_ReadFileDataCallbackInfo extends Structure {
	/** Client-specified data passed into the file request */
	public Pointer ClientData;
	/** The Product User ID of the local user who initiated this request */
	public EOS_ProductUserId LocalUserId;
	/** The file name being read */
	public String Filename;
	/** The total file size of the file being read */
	public int TotalFileSizeBytes;
	/** Is this chunk the last chunk of data? */
	public EOS_Bool IsLastChunk;
	/** The length of DataChunk in bytes that can be safely read */
	public int DataChunkLengthBytes;
	/** Pointer to the start of data to be read */
	public Pointer DataChunk;

	public EOS_PlayerDataStorage_ReadFileDataCallbackInfo() {
		super();
	}

	public EOS_PlayerDataStorage_ReadFileDataCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_ReadFileDataCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_ReadFileDataCallbackInfo implements Structure.ByValue {
	}
}