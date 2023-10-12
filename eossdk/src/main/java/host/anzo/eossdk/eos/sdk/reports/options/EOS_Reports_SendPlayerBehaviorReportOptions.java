package host.anzo.eossdk.eos.sdk.reports.options;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.reports.enums.EOS_EPlayerReportsCategory;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Input parameters for the EOS_Reports_SendPlayerBehaviorReport function.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ApiVersion", "ReporterUserId", "ReportedUserId", "Category", "Message", "Context"})
public class EOS_Reports_SendPlayerBehaviorReportOptions extends Structure {
	/** The most recent version of the EOS_Reports_SendPlayerBehaviorReport API. */
	public static final int EOS_REPORTS_SENDPLAYERBEHAVIORREPORT_API_LATEST = 2;

	/** Max length of a report message text, not including the null terminator. */
	public static final int EOS_REPORTS_REPORTMESSAGE_MAX_LENGTH = 512;

	/** Max length of a report context JSON payload, not including the null terminator. */
	public static final int EOS_REPORTS_REPORTCONTEXT_MAX_LENGTH = 4096;

	/** API Version: Set this to EOS_REPORTS_SENDPLAYERBEHAVIORREPORT_API_LATEST. */
	public int ApiVersion;
	/** Product User ID of the reporting player */
	public EOS_ProductUserId ReporterUserId;
	/** Product User ID of the reported player. */
	public EOS_ProductUserId ReportedUserId;
	/** Category for the player report. */
	public EOS_EPlayerReportsCategory Category;
	/**
	 * Optional plain text string associated with the report as UTF-8 encoded null-terminated string.
	 * <p>
	 * The length of the message can be at maximum up to {@link #EOS_REPORTS_REPORTMESSAGE_MAX_LENGTH} bytes
	 * and any excess characters will be truncated upon sending the report.
	 */
	public String Message;
	/**
	 * Optional JSON string associated with the report as UTF-8 encoded null-terminated string.
	 * This is intended as a way to associate arbitrary structured context information with a report.
	 * <p>
	 * This string needs to be valid JSON, report will fail otherwise.
	 * The length of the context can be at maximum up to {@link #EOS_REPORTS_REPORTCONTEXT_MAX_LENGTH} bytes,
	 * not including the null terminator, report will fail otherwise.
	 */
	public String Context;

	public EOS_Reports_SendPlayerBehaviorReportOptions() {
		super();
		ApiVersion = EOS_REPORTS_SENDPLAYERBEHAVIORREPORT_API_LATEST;
	}

	public EOS_Reports_SendPlayerBehaviorReportOptions(EOS_ProductUserId reporterUserId,
	                                                   EOS_ProductUserId reportedUserId,
	                                                   EOS_EPlayerReportsCategory category,
	                                                   String message,
	                                                   String context) {
		this();
		ReporterUserId = reporterUserId;
		ReportedUserId = reportedUserId;
		Category = category;
		Message = message;
		Context = context;
	}

	public EOS_Reports_SendPlayerBehaviorReportOptions(String reporterUserId,
	                                                   String reportedUserId,
	                                                   EOS_EPlayerReportsCategory category,
	                                                   String message,
	                                                   String context) {
		this(EOS_ProductUserId.fromString(reporterUserId),
				EOS_ProductUserId.fromString(reportedUserId),
				category,
				message,
				context);
	}

	public EOS_Reports_SendPlayerBehaviorReportOptions(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Reports_SendPlayerBehaviorReportOptions implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Reports_SendPlayerBehaviorReportOptions implements Structure.ByValue {
	}
}