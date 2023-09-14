package host.anzo.eossdk.eos.sdk.achievements.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for querying a player's achievements request.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ResultCode", "ClientData", "UserId"})
public class EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.
	 * {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 * {@link EOS_EResult#EOS_Invalid_ProductUserID} if any of the userid options are incorrect<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the other options are incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Achievements_QueryPlayerAchievements. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId UserId;

	public EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo() {
		super();
	}

	public EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_OnQueryPlayerAchievementsCompleteCallbackInfo implements Structure.ByValue {
	}
}