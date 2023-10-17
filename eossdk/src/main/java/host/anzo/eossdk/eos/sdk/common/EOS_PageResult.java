/*
 * Copyright © 2016 BDO-Emu authors. All rights reserved.
 * Viewing, editing, running and distribution of this software strongly prohibited.
 * Author: xTz, Anton Lasevich, Tibald
 */

package host.anzo.eossdk.eos.sdk.common;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static com.sun.jna.Structure.FieldOrder;

/**
 * A page result is part of query callback info. It is used to provide pagination details of query results.
 *
 * @author Anton Lasevich
 * @since 8/5/2023
 */
@FieldOrder({"StartIndex", "Count", "TotalCount"})
public class EOS_PageResult extends Structure {
	/** The index into the ordered query results to start the page at. */
	public int StartIndex;
	/** The number of results in the current page. */
	public int Count;
	/** The number of results associated with they original query options. */
	public int TotalCount;

	public EOS_PageResult() {
		super();
	}

	public EOS_PageResult(Pointer peer) {
		super(peer);
	}

	public static class ByReference extends EOS_PageResult implements Structure.ByReference {
	}

	public static class ByValue extends EOS_PageResult implements Structure.ByValue {
	}
}