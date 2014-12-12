
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass()
public class GPGLocalPlayerRank extends NSObject {

	@Property(selector = "formattedRank")
	public native String getFormattedRank();
	
	@Property(selector = "formattedNumScores")
	public native String getFormattedNumScores();
	
	@Property(selector = "numScores")
	public native long getNumScores();
	
	@Property(selector = "rank")
	public native long getRank();
}
