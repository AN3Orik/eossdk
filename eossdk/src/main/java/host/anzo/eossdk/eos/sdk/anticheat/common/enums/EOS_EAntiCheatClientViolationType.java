package host.anzo.eossdk.eos.sdk.anticheat.common.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Anti-cheat integrity violation types
 *
 * @author Anton Lasevich
 * @since 8/15/2023
 */
public @Getter enum EOS_EAntiCheatClientViolationType implements NativeMapped {
	/** Not used */
	EOS_ACCVT_Invalid(0),
	/** An anti-cheat asset integrity catalog file could not be found */
	EOS_ACCVT_IntegrityCatalogNotFound(1),
	/** An anti-cheat asset integrity catalog file is corrupt or invalid */
	EOS_ACCVT_IntegrityCatalogError(2),
	/** An anti-cheat asset integrity catalog file's certificate has been revoked. */
	EOS_ACCVT_IntegrityCatalogCertificateRevoked(3),
	/**
	 * The primary anti-cheat asset integrity catalog does not include an entry for the game's
	 * main executable, which is required.
	 */
	EOS_ACCVT_IntegrityCatalogMissingMainExecutable(4),
	/** A disallowed game file modification was detected */
	EOS_ACCVT_GameFileMismatch(5),
	/** A disallowed game file removal was detected */
	EOS_ACCVT_RequiredGameFileNotFound(6),
	/** A disallowed game file addition was detected */
	EOS_ACCVT_UnknownGameFileForbidden(7),
	/** A system file failed an integrity check */
	EOS_ACCVT_SystemFileUntrusted(8),
	/** A disallowed code module was loaded into the game process */
	EOS_ACCVT_ForbiddenModuleLoaded(9),
	/** A disallowed game process memory modification was detected */
	EOS_ACCVT_CorruptedMemory(10),
	/** A disallowed tool was detected running in the system */
	EOS_ACCVT_ForbiddenToolDetected(11),
	/** An internal anti-cheat integrity check failed */
	EOS_ACCVT_InternalAntiCheatViolation(12),
	/** Integrity checks on messages between the game client and game server failed */
	EOS_ACCVT_CorruptedNetworkMessageFlow(13),
	/** The game is running inside a disallowed virtual machine */
	EOS_ACCVT_VirtualMachineNotAllowed(14),
	/** A forbidden operating system configuration was detected */
	EOS_ACCVT_ForbiddenSystemConfiguration(15);

	private final int id;

	private static final Map<Integer, EOS_EAntiCheatClientViolationType> values = new HashMap<>();

	static {
		for (EOS_EAntiCheatClientViolationType result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_EAntiCheatClientViolationType(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int)nativeValue, EOS_ACCVT_Invalid);
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