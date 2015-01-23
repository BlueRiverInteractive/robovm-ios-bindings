
package org.robovm.bindings.ythelper;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NotImplemented;

public class YTPlayerViewDelegateAdapter extends NSObject implements YTPlayerViewDelegate {
    @Override
    @NotImplemented("playerViewDidBecomeReady:")
    public void playerViewDidBecomeReady (YTPlayerView playerView) {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotImplemented("playerView:state:")
    public void playerView (YTPlayerView playerView, YTPlayerState state) {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotImplemented("playerView:quality:")
    public void playerView (YTPlayerView playerView, YTPlaybackQuality quality) {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotImplemented("playerView:error:")
    public void playerView (YTPlayerView playerView, YTPlayerError error) {
        throw new UnsupportedOperationException();
    }
}
