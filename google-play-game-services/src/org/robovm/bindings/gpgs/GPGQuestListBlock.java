package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface GPGQuestListBlock {
	void invoke(NSArray quests, NSError error);
}
