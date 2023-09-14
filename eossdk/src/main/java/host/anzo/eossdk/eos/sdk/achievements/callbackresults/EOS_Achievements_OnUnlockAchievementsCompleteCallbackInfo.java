package host.anzo.eossdk.eos.sdk.achievements.callbackresults;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

import static com.sun.jna.Structure.FieldOrder;

/**
 * Data containing the result information for unlocking achievements request.
 *
 * @author Anton Lasevich
 * @since 8/19/2023
 */
@FieldOrder({"ResultCode", "ClientData", "UserId", "AchievementsCount"})
public class EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo extends Structure {
	/**
	 * The EOS_EResult code for the operation. EOS_Success indicates that the operation succeeded; other codes indicate errors.
	 * {@link EOS_EResult#EOS_Success} if the operation completes successfully<br>
	 * {@link EOS_EResult#EOS_InvalidParameters} if any of the options are incorrect
	 */
	public EOS_EResult ResultCode;
	/** Context that was passed into EOS_Achievements_UnlockAchievements. */
	public Pointer ClientData;
	/** The Product User ID of the user who initiated this request. */
	public EOS_ProductUserId UserId;
	/** The number of achievements that the operation unlocked. */
	public int AchievementsCount;

	public EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo() {
		super();
	}

	public EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo implements Structure.ByReference {
	}

	public static class ByValue extends EOS_Achievements_OnUnlockAchievementsCompleteCallbackInfo implements Structure.ByValue {
	}
}