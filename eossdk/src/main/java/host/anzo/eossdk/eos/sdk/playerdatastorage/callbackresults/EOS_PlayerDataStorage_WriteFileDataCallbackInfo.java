package host.anzo.eossdk.eos.sdk.playerdatastorage.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing data for a chunk of a file being written
 * @author Anton Lasevich
 * @since 8/22/2023
 */
@FieldOrder({"ClientData", "LocalUserId", "Filename", "DataBufferLengthBytes"})
public class EOS_PlayerDataStorage_WriteFileDataCallbackInfo extends Structure {
	/** Client-specified data passed into the file write request */
	public Pointer ClientData;
	/** The Product User ID of the local user who initiated this request */
	public EOS_ProductUserId LocalUserId;
	/** The file name that is being written to */
	public String Filename;
	/** The maximum amount of data in bytes that can be written safely to DataBuffer */
	public int DataBufferLengthBytes;

	public EOS_PlayerDataStorage_WriteFileDataCallbackInfo() {
		super();
	}

	public EOS_PlayerDataStorage_WriteFileDataCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PlayerDataStorage_WriteFileDataCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PlayerDataStorage_WriteFileDataCallbackInfo implements Structure.ByValue {
	}
}