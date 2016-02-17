package org.robovm.bindings.ythelper;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIColor;
import org.robovm.objc.annotation.NotImplemented;

public class YTPlayerViewDelegateAdapter extends NSObject implements YTPlayerViewDelegate{

	@Override
	@NotImplemented("playerViewDidBecomeReady:")
	public void didBecomeReady(YTPlayerView playerView) {
		throw new UnsupportedOperationException();		
	}

	@Override
	@NotImplemented("playerView:didChangeToState:")
	public void didChangeState(YTPlayerView playerView, YTPlayerState didChangeToState) {
		throw new UnsupportedOperationException();		
	}

	@Override
	@NotImplemented("playerView:didChangeToQuality:")
	public void didChangeQuality(YTPlayerView playerView, YTPlaybackQuality didChangeToQuality) {
		throw new UnsupportedOperationException();		
	}

	@Override
	@NotImplemented("playerView:receivedError:")
	public void didReceivedError(YTPlayerView playerView, YTPlayerError receivedError) {
		throw new UnsupportedOperationException();		
	}

	@Override
	@NotImplemented("playerView:didPlayTime:")
	public void didReceivePlayTime(YTPlayerView playerView, float didPlayTime) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NotImplemented("playerViewPreferredWebViewBackgroundColor:")
	public UIColor preferredWebViewBackgroundColor(YTPlayerView playerView) {
		throw new UnsupportedOperationException();
	}

}
