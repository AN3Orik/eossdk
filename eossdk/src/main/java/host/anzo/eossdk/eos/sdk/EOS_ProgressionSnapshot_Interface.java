package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.callbacks.EOS_ProgressionSnapshot_OnDeleteSnapshotCallback;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.callbacks.EOS_ProgressionSnapshot_OnSubmitSnapshotCallback;
import host.anzo.eossdk.eos.sdk.progressionsnapshot.options.*;

import java.nio.IntBuffer;

/**
 * Progression Snapshots allow you to store player specific game state.
 * <p>
 * BeginSnapshot must be called to obtain a handle for a given player.
 * AddProgression allows you to add Key/Value pairs that represent some state for that player in the game.
 * SubmitSnapshot sends all the progression data you have added (via AddProgression) to the service.
 * EndSnapshot cleans up internal resources allocated for that snapshot.
 * DeleteSnapshot wipes out all data associated with a particular player.
 *
 * @see EOS_Platform_Interface#getProgressionSnapshotInterface()
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public class EOS_ProgressionSnapshot_Interface extends PointerType {
	public EOS_ProgressionSnapshot_Interface(Pointer address) {
		super(address);
	}

	public EOS_ProgressionSnapshot_Interface() {
		super();
	}

	/**
	 * Creates a new progression-snapshot resource for a given user.
	 *
	 * @param options Object containing properties that identifies the PUID this Snapshot will belong to.
	 * @param outSnapshotId A progression-snapshot identifier output parameter. Use that identifier to reference the snapshot in the other APIs.
	 *
	 * @return {@link EOS_EResult#EOS_Success} when successful.c
	 *         {@link EOS_EResult#EOS_ProgressionSnapshot_SnapshotIdUnavailable} when no IDs are available. This is irrecoverable state.
	 */
	public EOS_EResult beginSnapshot(EOS_ProgressionSnapshot_BeginSnapshotOptions options, IntBuffer outSnapshotId) {
		return EOSLibrary.instance.EOS_ProgressionSnapshot_BeginSnapshot(this, options, outSnapshotId);
	}

	/**
	 * Stores a Key/Value pair in memory for a given snapshot.
	 * If multiple calls happen with the same key, the last invocation wins, overwriting the previous value for that
	 * given key.
	 * <p>
	 * The order in which the Key/Value pairs are added is stored as is for later retrieval/display.
	 * Ideally, you would make multiple calls to AddProgression() followed by a single call to SubmitSnapshot().
	 *
	 * @return {@link EOS_EResult#EOS_Success} when successful; otherwise, {@link EOS_EResult#EOS_NotFound}
	 */
	public EOS_EResult addProgression(EOS_ProgressionSnapshot_AddProgressionOptions options) {
		return EOSLibrary.instance.EOS_ProgressionSnapshot_AddProgression(this, options);
	}

	/**
	 * Saves the previously added Key/Value pairs of a given Snapshot to the service.
	 * <p>
	 * Note: This will overwrite any prior progression data stored with the service that's associated with the user.
	 */
	public void submitSnapshot(EOS_ProgressionSnapshot_SubmitSnapshotOptions options,
	                                            Pointer clientData,
	                                            EOS_ProgressionSnapshot_OnSubmitSnapshotCallback completionDelegate) {
		EOSLibrary.instance.EOS_ProgressionSnapshot_SubmitSnapshot(this, options, clientData, completionDelegate);
	}

	/**
	 * Cleans up and releases resources associated with the given progression snapshot identifier.
	 *
	 * @return {@link EOS_EResult#EOS_Success} when successful; otherwise, {@link EOS_EResult#EOS_NotFound}
	 */
	public EOS_EResult endSnapshot(EOS_ProgressionSnapshot_EndSnapshotOptions options) {
		return EOSLibrary.instance.EOS_ProgressionSnapshot_EndSnapshot(this, options);
	}

	/**
	 * Wipes out all progression data for the given user from the service. However, any previous progression data that haven't
	 * been submitted yet are retained.
	 */
	public void deleteSnapshot(EOS_ProgressionSnapshot_DeleteSnapshotOptions options,
	                                            Pointer clientData,
	                                            EOS_ProgressionSnapshot_OnDeleteSnapshotCallback completionDelegate) {
		EOSLibrary.instance.EOS_ProgressionSnapshot_DeleteSnapshot(this, options, clientData, completionDelegate);
	}
}