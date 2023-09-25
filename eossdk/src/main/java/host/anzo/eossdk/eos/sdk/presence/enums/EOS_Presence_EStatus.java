package host.anzo.eossdk.eos.sdk.presence.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.EOS_Presence_Interface;
import host.anzo.eossdk.eos.sdk.presence.EOS_PresenceModification;
import host.anzo.eossdk.eos.sdk.presence.options.EOS_PresenceModification_SetStatusOptions;
import host.anzo.eossdk.eos.sdk.presence.options.EOS_Presence_CopyPresenceOptions;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Presence Status states of a user
 *
 * @see EOS_Presence_Interface#copyPresence(EOS_Presence_CopyPresenceOptions)
 * @see EOS_PresenceModification#setStatus(EOS_PresenceModification_SetStatusOptions)
 *
 * @author Anton Lasevich
 * @since 8/22/2023
 */
public @Getter enum EOS_Presence_EStatus implements NativeMapped {
	/** The status of the account is offline or not known */
	EOS_PS_Offline(0),
	/** The status of the account is online */
	EOS_PS_Online(1),
	/** The status of the account is away */
	EOS_PS_Away(2),
	/** The status of the account is away, and has been away for a while */
	EOS_PS_ExtendedAway(3),
	/** The status of the account is do-not-disturb */
	EOS_PS_DoNotDisturb(4);

	private final int id;

	private static final Map<Integer, EOS_Presence_EStatus> values = new HashMap<>();

	static {
		for (EOS_Presence_EStatus result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_Presence_EStatus(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_PS_Offline);
	}

	@Override
	public Object toNative() {
		return id;
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}