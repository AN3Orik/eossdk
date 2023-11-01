package host.anzo.eossdk.eos.sdk.presence;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_Presence_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.presence.options.*;

/**
 * To modify your own presence, you must call EOS_Presence_CreatePresenceModification to create a Presence Modification handle. To modify that handle, call
 * EOS_PresenceModification_* methods. Once you are finished, call EOS_Presence_SetPresence with your handle. You must then release your Presence Modification
 * handle by calling {@link EOS_PresenceModification#release()}.
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public class EOS_PresenceModification extends PointerType implements AutoCloseable {
	/**
	 * The maximum of allowed individual pieces of data a user may have. This value is subject to change and data structures should be designed to allow for greater
	 * numbers than this.
	 */
	public static final int EOS_PRESENCE_DATA_MAX_KEYS = 32;
	/**
	 * The maximum allowed length a data's key may be. This value is subject to change and data structures should be designed to allow for greater numbers than this.
	 */
	public static final int EOS_PRESENCE_DATA_MAX_KEY_LENGTH = 64;
	/**
	 * The maximum allowed length a data's value may be. This value is subject to change and data structures should be designed to allow for greater numbers than this.
	 */
	public static final int EOS_PRESENCE_DATA_MAX_VALUE_LENGTH = 255;
	/**
	 * The maximum allowed length a user's rich text string may be. This value is subject to change and data structures should be designed to allow for greater numbers
	 * than this.
	 */
	public static final int EOS_PRESENCE_RICH_TEXT_MAX_VALUE_LENGTH = 255;
	public static final int EOS_PRESENCEMODIFICATION_JOININFO_MAX_LENGTH = EOS_PRESENCE_DATA_MAX_VALUE_LENGTH;

	public EOS_PresenceModification(Pointer address) {
		super(address);
	}

	public EOS_PresenceModification() {
		super();
	}

	/**
	 * Modifies a user's online status to be the new state.
	 *
	 * @param options Object containing properties related to setting a user's Status
	 * @return {@link EOS_EResult#EOS_Success} if modification was added successfully, otherwise an error code related to the problem
	 */
	public EOS_EResult setStatus(EOS_PresenceModification_SetStatusOptions options) {
		return EOSLibrary.instance.EOS_PresenceModification_SetStatus(this, options);
	}

	/**
	 * Modifies a user's Rich Presence string to a new state. This is the exact value other users will see
	 * when they query the local user's presence.
	 *
	 * @param options Object containing properties related to setting a user's RichText string
	 * @return {@link EOS_EResult#EOS_Success} if modification was added successfully, otherwise an error code related to the problem
	 *
	 * @see EOS_PresenceModification#EOS_PRESENCE_RICH_TEXT_MAX_VALUE_LENGTH
	 */
	public EOS_EResult setRawRichText(EOS_PresenceModification_SetRawRichTextOptions options) {
		return EOSLibrary.instance.EOS_PresenceModification_SetRawRichText(this, options);
	}

	/**
	 * Modifies one or more rows of user-defined presence data for a local user. At least one InfoData object
	 * must be specified.
	 *
	 * @param options Object containing an array of new presence data.
	 * @return {@link EOS_EResult#EOS_Success} if modification was added successfully, otherwise an error code related to the problem
	 *
	 * @see EOS_PresenceModification#EOS_PRESENCE_DATA_MAX_KEYS
	 * @see EOS_PresenceModification#EOS_PRESENCE_DATA_MAX_KEY_LENGTH
	 * @see EOS_PresenceModification#EOS_PRESENCE_DATA_MAX_VALUE_LENGTH
	 */
	public EOS_EResult setData(EOS_PresenceModification_SetDataOptions options) {
		return EOSLibrary.instance.EOS_PresenceModification_SetData(this, options);
	}

	/**
	 * Removes one or more rows of user-defined presence data for a local user. At least one DeleteDataInfo object
	 * must be specified.
	 *
	 * @param options Object containing an array of new presence data.
	 * @return {@link EOS_EResult#EOS_Success} if modification was added successfully, otherwise an error code related to the problem
	 *
	 * @see EOS_PresenceModification#EOS_PRESENCE_DATA_MAX_KEYS
	 * @see EOS_PresenceModification#EOS_PRESENCE_DATA_MAX_KEY_LENGTH
	 * @see EOS_PresenceModification#EOS_PRESENCE_DATA_MAX_VALUE_LENGTH
	 */
	public EOS_EResult deleteData(EOS_PresenceModification_DeleteDataOptions options) {
		return EOSLibrary.instance.EOS_PresenceModification_DeleteData(this, options);
	}

	/**
	 * Sets your new join info custom game-data string. This is a helper function for reading the presence data related to how a user can be joined.
	 * Its meaning is entirely application dependent.
	 *
	 * @param options Object containing a join info string and associated user data
	 * @return {@link EOS_EResult#EOS_Success} if modification was added successfully, otherwise an error code related to the problem
	 *
	 * @see EOS_PresenceModification#EOS_PRESENCEMODIFICATION_JOININFO_MAX_LENGTH
	 */
	public EOS_EResult setJoinInfo(EOS_PresenceModification_SetJoinInfoOptions options) {
		return EOSLibrary.instance.EOS_PresenceModification_SetJoinInfo(this, options);
	}

	/**
	 * Release the memory associated with an EOS_HPresenceModification handle. This must be called on Handles retrieved from EOS_Presence_CreatePresenceModification.
	 * This can be safely called on a NULL presence modification handle. This also may be safely called while a call to SetPresence is still pending.
	 * @see EOS_Presence_Interface#createPresenceModification(EOS_Presence_CreatePresenceModificationOptions, EOS_PresenceModification)
	 */
	public void release() {
		EOSLibrary.instance.EOS_PresenceModification_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}