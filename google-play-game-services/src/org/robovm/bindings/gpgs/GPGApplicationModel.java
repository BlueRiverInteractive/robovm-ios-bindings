package org.robovm.bindings.gpgs;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.ByVal;
import org.robovm.rt.bro.annotation.GlobalValue;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.Pointer;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGApplicationModel extends GPGKeyedModel {

//  extern NSString *const GPGModelGetAllAppStateKey;
	@GlobalValue(symbol = "GPGModelGetAllAppStateKey", optional=true)
	public static native @ByVal String Key();
	
//- (instancetype)initWithApplicationId:(NSString *)applicationId;
	@Method(selector = "initWithApplicationId:")
	private native @Pointer long init(String applicationId);
	
	/*Constructor*/
	public GPGApplicationModel(String applicationId) {
	    //super((SkipInit)null);
	    initObject(init(applicationId));
	}

	@Property(selector = "appState")
	public native GPGAppStateModel getAppState();
	
}
