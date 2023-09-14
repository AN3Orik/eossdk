/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common;

import lombok.Builder;

/**
 * A page query is part of query options. It is used to allow pagination of query results.
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Builder class EOS_PageQuery {
	public static int EOS_PAGEQUERY_API_LATEST = 1;

	/** API Version: Set this to EOS_PAGEQUERY_API_LATEST. */
	private @Builder.Default int apiVersion = EOS_PAGEQUERY_API_LATEST;
	/** The index into the ordered query results to start the page at. */
	private int startIndex;
	/** The maximum number of results to have in the page. */
	private int maxCount;
}