package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.mods.EOS_Mods_ModInfo;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnEnumerateModsCallback;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnInstallModCallback;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnUninstallModCallback;
import host.anzo.eossdk.eos.sdk.mods.callbacks.EOS_Mods_OnUpdateModCallback;
import host.anzo.eossdk.eos.sdk.mods.options.*;

/**
 * The Mods Interface is used to manage a user's mods. Allowing a user to install/uninstall/enumerate mods.
 * All Mods Interface calls take a handle of type EOS_HMods as the first parameter.
 * This handle can be retrieved from a EOS_HPlatform handle by using the EOS_Platform_GetModsInterface function.
 * <p>
 * NOTE: At this time, this feature is only available for desktop platforms and for products that are part of the Epic Games store.
 *
 * @see EOS_Platform_Interface#getModsInterface()
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public class EOS_Mods_Interface extends PointerType {
	public EOS_Mods_Interface(Pointer address) {
		super(address);
	}

	public EOS_Mods_Interface() {
		super();
	}

	/**
	 * Starts an asynchronous task that makes a request to install the specified mod.
	 *
	 * @param options structure containing the game and mod identifiers
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void installMod(EOS_Mods_InstallModOptions options, Pointer clientData, EOS_Mods_OnInstallModCallback completionDelegate) {
		EOSLibrary.instance.EOS_Mods_InstallMod(this, options, clientData, completionDelegate);
	}

	/**
	 * Starts an asynchronous task that makes a request to uninstall the specified mod.
	 *
	 * @param options structure containing the game and mod identifiers
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void uninstallMod(EOS_Mods_UninstallModOptions options, Pointer clientData, EOS_Mods_OnUninstallModCallback completionDelegate) {
		EOSLibrary.instance.EOS_Mods_UninstallMod(this, options, clientData, completionDelegate);
	}

	/**
	 * Starts an asynchronous task that makes a request to enumerate mods for the specified game.
	 * Types of the mods to enumerate can be specified through EOS_Mods_EnumerateModsOptions
	 *
	 * @param options structure containing the game identifiers
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error
	 */
	public void enumerateMods(EOS_Mods_EnumerateModsOptions options, Pointer clientData, EOS_Mods_OnEnumerateModsCallback completionDelegate) {
		EOSLibrary.instance.EOS_Mods_EnumerateMods(this, options, clientData, completionDelegate);
	}

	/**
	 * Get cached enumerated mods object. If successful, this data must be released by calling EOS_Mods_ModInfo_Release
	 * Types of the cached enumerated mods can be specified through EOS_Mods_CopyModInfoOptions<br>
	 * <b>This request may fail with an EOS_NotFound code if an enumeration of a certain type was not performed before this call.</b>
	 * @param options structure containing the game identifier for which requesting enumerated mods
	 * @return Enumerated mods Info. If the returned result is success, this will be set to data that must be later released, otherwise this will be set to NULL
	 *
	 * @throws EOSException if the request was invalid or we do not have cached data.
	 *
	 * @see EOS_Mods_ModInfo#release()
	 */
	public EOS_Mods_ModInfo copyModInfo(EOS_Mods_CopyModInfoOptions options) throws EOSException {
		final PointerByReference outEnumeratedMods = new PointerByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_Mods_CopyModInfo(this, options, outEnumeratedMods);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		final EOS_Mods_ModInfo modInfo = new EOS_Mods_ModInfo(outEnumeratedMods.getValue());
		modInfo.read();
		return modInfo;
	}

	/**
	 * Starts an asynchronous task that makes a request to update the specified mod to the latest version.
	 *
	 * @param options structure containing the game and mod identifiers
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate a callback that is fired when the async operation completes, either successfully or in error. If the mod is up to date then the operation will complete with success.
	 */
	public void updateMod(EOS_Mods_UpdateModOptions options, Pointer clientData, EOS_Mods_OnUpdateModCallback completionDelegate) {
		EOSLibrary.instance.EOS_Mods_UpdateMod(this, options, clientData, completionDelegate);
	}
}