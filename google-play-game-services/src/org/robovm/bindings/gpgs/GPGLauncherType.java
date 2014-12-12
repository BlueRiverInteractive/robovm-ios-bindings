package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGLauncherType implements ValuedEnum {
	GPGLauncherTypeUnknown(-1), 
	GPGLauncherTypePlayerProfile(0), 
	GPGLauncherTypePlayerPicker(1), 
	GPGLauncherTypeTurnBasedMatchList(2), 
	GPGLauncherTypeQuestList(3), 
	GPGLauncherTypeSnapshotList(4), 
	GPGLauncherTypeLeaderboard(5),
	GPGLauncherTypeLeaderboardList(6), 
	GPGLauncherTypeAchievementList(7), 
	GPGLauncherTypeRTMPInviteFlow(8), 
	GPGLauncherTypeRTMPInvitesList(9), 
	GPGLauncherTypeRTMPWaitingRoom(10), 
	GPGLauncherTypeSettings(11);

	private final long n;

	private GPGLauncherType (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}
