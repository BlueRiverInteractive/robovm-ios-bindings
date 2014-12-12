package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGQuestListLauncherDelegate extends NSObjectProtocol {

	@Method(selector = "questListLauncherDidAcceptQuest:")
	void questListLauncherDidAcceptQuest(GPGQuest quest);
	
	@Method(selector = "questListLauncherDidClaimRewardsForQuestMilestone:")
	void questListLauncherDidClaimRewardsForQuestMilestone(GPGQuestMilestone milestone);
	
	@Method(selector = "questListLauncherShouldShowQuest:")
	boolean questListLauncherShouldShowQuest(GPGQuest quest);
}
