/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.logging.enums;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;
import host.anzo.eossdk.eos.sdk.EOS_Logging_Interface;
import host.anzo.eossdk.eos.sdk.logging.callbacks.EOS_LogMessageFunc;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Logging levels. When a log message is output, it has an associated log level.
 * Messages will only be sent to the callback function if the message's associated log level is less than or equal to the configured log level for that category.
 *
 * @see EOS_Logging_Interface#setCallback(EOS_LogMessageFunc)
 * @see EOS_Logging_Interface#setLogLevel(EOS_ELogCategory, EOS_ELogLevel)
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Getter enum EOS_ELogLevel implements NativeMapped {
	EOS_LOG_Off(0),
	EOS_LOG_Fatal(100),
	EOS_LOG_Error(200),
	EOS_LOG_Warning(300),
	EOS_LOG_Info(400),
	EOS_LOG_Verbose(500),
	EOS_LOG_VeryVerbose(600);

	private final int id;

	private static final Map<Integer, EOS_ELogLevel> values = new HashMap<>();

	static {
		for (EOS_ELogLevel result : values()) {
			values.put(result.id, result);
		}
	}

	EOS_ELogLevel(int id) {
		this.id = id;
	}

	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		return values.getOrDefault((int) nativeValue, EOS_LOG_Off);
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