package host.anzo.eossdk.eos.sdk.ui.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A structure representing a memory monitoring message.
 *
 * @author Anton Lasevich
 * @since 9/9/2023
 */
@FieldOrder({"ClientData", "SystemMemoryMonitorReport"})
public class EOS_UI_MemoryMonitorCallbackInfo extends Structure {
	/** Context that was passed into EOS_UI_AddNotifyMemoryMonitor */
	public Pointer ClientData;
	/**
	 * This field is for system specific memory monitor report.
	 * <p>
	 * If provided then the structure will be located in eos_(platform)_ui.h
	 * The structure will be named EOS_(platform)_MemoryMonitorReport.
	 */
	public Pointer SystemMemoryMonitorReport;

	public EOS_UI_MemoryMonitorCallbackInfo() {
		super();
	}

	public EOS_UI_MemoryMonitorCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_UI_MemoryMonitorCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_UI_MemoryMonitorCallbackInfo implements Structure.ByValue {
	}
}
