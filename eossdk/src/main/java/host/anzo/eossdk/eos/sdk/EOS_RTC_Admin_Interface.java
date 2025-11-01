package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.rtcadmin.EOS_RTCAdmin_UserToken;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbackresults.EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbacks.EOS_RTCAdmin_OnKickCompleteCallback;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbacks.EOS_RTCAdmin_OnQueryJoinRoomTokenCompleteCallback;
import host.anzo.eossdk.eos.sdk.rtcadmin.callbacks.EOS_RTCAdmin_OnSetParticipantHardMuteCompleteCallback;
import host.anzo.eossdk.eos.sdk.rtcadmin.options.*;

/**
 * The RTC Admin interface.
 * This is used to manage admin-specific RTC features, such as requesting join tokens, kick users, etc.
 * @see EOS_Platform_Interface#getRTCAdminInterface()
 *
 * @author Anton Lasevich
 * @since 11/1/2023
 */
public class EOS_RTC_Admin_Interface extends PointerType {
	public EOS_RTC_Admin_Interface(Pointer address) {
		super(address);
	}

	public EOS_RTC_Admin_Interface() {
		super();
	}

	/**
	 * Query for a list of user tokens for joining a room.
	 * <p>
	 * Each query generates a query id (see EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo) which should be used
	 * to retrieve the tokens from inside the callback.
	 * <p>
	 * This query id and query result itself are only valid for the duration of the callback.
	 * @see EOS_RTCAdmin_QueryJoinRoomTokenCompleteCallbackInfo
	 * @param options Structure containing information about the application whose user tokens we're retrieving.
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate This function is called when the query join room token operation completes.
	 */
	public void queryJoinRoomToken(EOS_RTCAdmin_QueryJoinRoomTokenOptions options, Pointer clientData, EOS_RTCAdmin_OnQueryJoinRoomTokenCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAdmin_QueryJoinRoomToken(this, options, clientData, completionDelegate);
	}

	/**
	 * Fetches a user token when called inside of the OnQueryJoinRoomTokenComplete callback.
	 *
	 * @param options Structure containing the index being accessed
	 * <p>
	 * <b>The order of the tokens doesn't necessarily match the order of the EOS_ProductUserId array specified in the EOS_RTCAdmin_QueryJoinRoomTokenOptions when
	 * initiating the query.</b>
	 *
	 * @see EOS_RTCAdmin_UserToken#release()
	 * @return The user token for the given index, if it exists and is valid. Use {@link EOS_RTCAdmin_UserToken#release()} when finished
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the user token is not found
	 */
	public EOS_RTCAdmin_UserToken copyUserTokenByIndex(EOS_RTCAdmin_CopyUserTokenByIndexOptions options) throws EOSException {
		final PointerByReference outUserToken = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_RTCAdmin_CopyUserTokenByIndex(this, options, outUserToken);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_RTCAdmin_UserToken userToken = new EOS_RTCAdmin_UserToken(outUserToken.getValue());
		userToken.read();
		return userToken;
	}

	/**
	 * Fetches a user token for a given user ID when called inside of the OnQueryJoinRoomTokenComplete callback.
	 *
	 * @param options Structure containing the user ID being accessed
	 *
	 * @see EOS_RTCAdmin_UserToken#release()
	 * @return The user token for the given user ID, if it exists and is valid. Use {@link EOS_RTCAdmin_UserToken#release()} when finished
	 * @throws EOSInvalidParametersException if you pass a null pointer for the out parameter
	 * @throws EOSNotFoundException if the user token is not found
	 */
	public EOS_RTCAdmin_UserToken copyUserTokenByUserId(EOS_RTCAdmin_CopyUserTokenByUserIdOptions options) throws EOSException {
		final PointerByReference outUserToken = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_RTCAdmin_CopyUserTokenByUserId(this, options, outUserToken);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_RTCAdmin_UserToken userToken = new EOS_RTCAdmin_UserToken(outUserToken.getValue());
		userToken.read();
		return userToken;
	}

	/**
	 * Starts an asynchronous task that removes a participant from a room and revokes their token.
	 *
	 * @param options structure containing the room and user to revoke the token from.
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void kick(EOS_RTCAdmin_KickOptions options, Pointer clientData, EOS_RTCAdmin_OnKickCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAdmin_Kick(this, options, clientData, completionDelegate);
	}

	/**
	 * Starts an asynchronous task remotely mutes/unmutes a room participant.
	 * <p>
	 * This remotely mutes the specified participant, so no audio is sent from that participant to any other participant in the room.
	 *
	 * @param options structure containing the room and user to mute.
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void setParticipantHardMute(EOS_RTCAdmin_SetParticipantHardMuteOptions options, Pointer clientData, EOS_RTCAdmin_OnSetParticipantHardMuteCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_RTCAdmin_SetParticipantHardMute(this, options, clientData, completionDelegate);
	}
}