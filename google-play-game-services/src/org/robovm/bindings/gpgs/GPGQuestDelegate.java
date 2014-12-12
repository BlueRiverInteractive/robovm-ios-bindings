package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGQuestDelegate extends NSObjectProtocol {
	
	@Method(selector = "didCompleteQuest:")
	void didCompleteQuest(GPGQuest quest);
}
