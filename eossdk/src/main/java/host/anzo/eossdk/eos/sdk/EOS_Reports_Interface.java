package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.reports.callbacks.EOS_Reports_OnSendPlayerBehaviorReportCompleteCallback;
import host.anzo.eossdk.eos.sdk.reports.options.EOS_Reports_SendPlayerBehaviorReportOptions;

/**
 * The following EOS_Reports_* functions allow you to send reports directly from the players
 * to the back-end services without having to route these through a game server.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
public class EOS_Reports_Interface extends PointerType {
	public EOS_Reports_Interface(Pointer address) {
		super(address);
	}
	public EOS_Reports_Interface() {
		super();
	}

	/**
	 * Sends the provided report directly to the Epic Online Services back-end.
	 *
	 * @param options Structure containing the player report information.
	 * @param clientData Optional client data provided by the user of the SDK.
	 * @param completionDelegate This function is called when the send operation completes.
	 */
	public void sendPlayerBehaviorReport(EOS_Reports_SendPlayerBehaviorReportOptions options,
	                                                 Pointer clientData,
	                                                 EOS_Reports_OnSendPlayerBehaviorReportCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_Reports_SendPlayerBehaviorReport(this, options, clientData, completionDelegate);
	}
}