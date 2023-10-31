package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;

/**
 * Exception wrapper for {@link EOS_EResult#EOS_ProgressionSnapshot_SnapshotIdUnavailable}
 *
 * @author Anton Lasevich
 * @since 9/25/2023
 */
public class EOSProgressionSnapshotSnapshotIdUnavailableException extends EOSException {
	protected EOSProgressionSnapshotSnapshotIdUnavailableException() {
		super(EOS_EResult.EOS_ProgressionSnapshot_SnapshotIdUnavailable);
	}
}