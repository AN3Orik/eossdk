package host.anzo.eossdk.eos.sdk.integratedplatform;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import host.anzo.eossdk.eos.sdk.EOSLibrary;
import host.anzo.eossdk.eos.sdk.EOS_IntegratedPlatform_Interface;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.integratedplatform.options.EOS_IntegratedPlatformOptionsContainer_AddOptions;
import host.anzo.eossdk.eos.sdk.integratedplatform.options.EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions;

/**
 * @author Anton Lasevich
 * @since 8/9/2023
 */
public class EOS_IntegratedPlatformOptionsContainer extends PointerType implements AutoCloseable {
	public EOS_IntegratedPlatformOptionsContainer(Pointer address) {
		super(address);
	}

	public EOS_IntegratedPlatformOptionsContainer() {
		super();
	}

	/**
	 * Adds an integrated platform options to the container.
	 * @param options Object containing properties related to setting a user's Status
	 * @return {@link EOS_EResult#EOS_Success} if modification was added successfully, otherwise an error code related to the problem
	 */
	public EOS_EResult add(EOS_IntegratedPlatformOptionsContainer_AddOptions options) {
		return EOSLibrary.instance.EOS_IntegratedPlatformOptionsContainer_Add(this, options);
	}

	/**
	 * Release the memory associated with an EOS_HIntegratedPlatformOptionsContainer handle. This must be called on Handles retrieved from EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainer.
	 * This can be safely called on a NULL integrated platform options container handle.
	 * @see EOS_IntegratedPlatform_Interface#createIntegratedPlatformOptionsContainer(EOS_IntegratedPlatform_CreateIntegratedPlatformOptionsContainerOptions, EOS_IntegratedPlatformOptionsContainer)
	 */
	public void release() {
		EOSLibrary.instance.EOS_IntegratedPlatformOptionsContainer_Release(this);
	}

	@Override
	public void close() throws Exception {
		release();
	}
}