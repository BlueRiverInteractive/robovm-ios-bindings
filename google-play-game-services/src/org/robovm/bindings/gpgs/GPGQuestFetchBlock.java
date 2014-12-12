package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGQuestFetchBlock {
	void invoke(GPGQuest quest, NSError error);
}
