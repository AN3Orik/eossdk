/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common;

import lombok.Builder;

/**
 * @author Anton Lasevich
 * @since 8/5/2023
 */
public @Builder class EOS_PageResult {
	/** The index into the ordered query results to start the page at. */
	private int startIndex;
	/** The number of results in the current page. */
	private int count;
	/** The number of results associated with they original query options. */
	private int totalCount;
}