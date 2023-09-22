package host.anzo.eossdk.eos.exceptions;

import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @author ANZO
 * @since 9/21/2023
 */
public @Getter class EOSException extends Exception {
	private final EOS_EResult result;

	public EOSException(@NotNull EOS_EResult errorCode) {
		this.result = errorCode;
	}

	public static EOSException fromResult(EOS_EResult result) {
		switch (result) {
			case EOS_InvalidParameters:
				return new EOSInvalidParametersException();
			case EOS_NotFound:
				return new EOSNotFoundException();
			default:
				throw new RuntimeException("Exception for resultType " + result + " not handled.");
		}
	}

	@Override
	public String getMessage() {
		return "EOS SDK Message: " + result;
	}
}