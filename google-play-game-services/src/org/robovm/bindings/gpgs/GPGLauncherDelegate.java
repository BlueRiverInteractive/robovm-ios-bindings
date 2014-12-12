package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGLauncherDelegate extends NSObjectProtocol {

	@Method(selector = "launcherWillAppear")
	void launcherWillAppear();
	
	@Method(selector = "launcherDidAppear")
	void launcherDidAppear();
	
	@Method(selector = "launcherWillDisappear")
	void launcherWillDisappear();
	
	@Method(selector = "launcherDidDisappear")
	void launcherDidDisappear();
	
	@Method(selector = "launcherDismissed")
	void launcherDismissed();
}
