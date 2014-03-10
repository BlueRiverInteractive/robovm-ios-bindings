
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGLocalPlayerRank extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGLocalPlayerRank.class);

	static {
		ObjCRuntime.bind(GPGLocalPlayerRank.class);
	}

	// @property (nonatomic, readonly, copy) NSString *formattedRank;
	private static final Selector formattedRank$ = Selector.register("formattedRank");

	@Bridge
	private native static String objc_formattedRank (GPGLocalPlayerRank __self__, Selector __cmd__);

	public String formattedRank () {
		return objc_formattedRank(this, formattedRank$);
	}

	// @property (nonatomic, readonly, copy) NSString *formattedNumScores;
	private static final Selector formattedNumScores$ = Selector.register("formattedNumScores");

	@Bridge
	private native static String objc_formattedNumScores (GPGLocalPlayerRank __self__, Selector __cmd__);

	public String formattedNumScores () {
		return objc_formattedNumScores(this, formattedNumScores$);
	}

	// @property (nonatomic, readonly, assign) unsigned long long numScores;
	private static final Selector numScores$ = Selector.register("numScores");

	@Bridge
	private native static long objc_numScores (GPGLocalPlayerRank __self__, Selector __cmd__);

	public long numScores () {
		return objc_numScores(this, numScores$);
	}

	// @property (nonatomic, readonly, assign) unsigned long long rank;
	private static final Selector rank$ = Selector.register("rank");

	@Bridge
	private native static long objc_rank (GPGLocalPlayerRank __self__, Selector __cmd__);

	public long rank () {
		return objc_rank(this, rank$);
	}
}
