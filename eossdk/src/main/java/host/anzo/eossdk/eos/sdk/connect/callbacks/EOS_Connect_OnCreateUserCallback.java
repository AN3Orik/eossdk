package host.anzo.eossdk.eos.sdk.connect.callbacks;

import com.sun.jna.Callback;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.connect.callbackresults.EOS_Connect_CreateUserCallbackInfo;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public interface EOS_Connect_OnCreateUserCallback extends Callback {
	/**
	 * Function prototype definition for callbacks passed to EOS_Connect_CreateUser.
	 * @param data A {@link EOS_Connect_CreateUserCallbackInfo} containing the output information and result.
	 * @throws EOSException when an error occurs during callback processing.
	 */
	void run(EOS_Connect_CreateUserCallbackInfo data) throws EOSException;
}
