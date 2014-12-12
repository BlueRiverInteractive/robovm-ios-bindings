package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGPlayerPickerLauncherDelegate extends NSObjectProtocol {

	@Method(selector = "minPlayersForPlayerPickerLauncher")
	int minPlayersForPlayerPickerLauncher();
	
	@Method(selector = "maxPlayersForPlayerPickerLauncher")
	int maxPlayersForPlayerPickerLauncher();
	
	@Method(selector = "playerPickerLauncherDidPickPlayers:autoPickPlayerCount:")
	void playerPickerLauncherDidPickPlayers(NSArray players, int autoPickPlayerCount);
}
