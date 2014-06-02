
package org.robovm.bindings.tapstream;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface TSApi extends NSObjectProtocol {

	@Method(selector = "fireEvent:")
	void fireEvent (TSEvent event);

// @protocol TSApi<NSObject>
// - (void)fireHit:(TSHit *)hit completion:(void(^)(TSResponse *))completion;
// @end

}
