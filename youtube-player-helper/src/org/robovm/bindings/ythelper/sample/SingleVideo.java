
package org.robovm.bindings.ythelper.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIViewAutoresizing;
import org.robovm.apple.uikit.UIViewContentMode;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.bindings.ythelper.YTPlaybackQuality;
import org.robovm.bindings.ythelper.YTPlayerError;
import org.robovm.bindings.ythelper.YTPlayerOptions;
import org.robovm.bindings.ythelper.YTPlayerOptions.Parameters;
import org.robovm.bindings.ythelper.YTPlayerState;
import org.robovm.bindings.ythelper.YTPlayerView;
import org.robovm.bindings.ythelper.YTPlayerViewDelegate;

public class SingleVideo extends UIViewController implements YTPlayerViewDelegate {
    YTPlayerView playerView;

    @Override
    public void viewDidLoad () {
        setupViews();
    }

    private void setupViews () {
        // For a full list of player parameters, see the documentation for the
        // HTML5 player
        // at:
        // https://developers.google.com/youtube/player_parameters?playerVersion=HTML5

        YTPlayerOptions playerOptions = new YTPlayerOptions();
        playerOptions.set(Parameters.CONTROLS, 0);
        playerOptions.set(Parameters.PLAYSINLINE, 1);
        playerOptions.set(Parameters.AUTOHIDE, 1);
        playerOptions.set(Parameters.SHOWINFO, 0);
        playerOptions.set(Parameters.MODESTBRANDING, 1);

        playerView = new YTPlayerView();
        playerView.setFrame(new CGRect(10, 80, 300, 275));
        playerView.setBackgroundColor(UIColor.green());
        playerView.setContentMode(UIViewContentMode.ScaleAspectFill);
        playerView.setAutoresizingMask(UIViewAutoresizing.with(UIViewAutoresizing.FlexibleWidth,
            UIViewAutoresizing.FlexibleHeight));
        playerView.setDelegate(this);
        playerView.setTranslatesAutoresizingMaskIntoConstraints(false);

        getView().addSubview(playerView);

        playerView.loadWithVideoId("M7lc1UVf-VE", playerOptions);

        UIButton playBtn = new UIButton(new CGRect(10, 400, 120, 80));
        playBtn.setTitle("Play", UIControlState.Normal);
        playBtn.setBackgroundColor(UIColor.red());
        playBtn.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                playerView.playVideo();
            }
        });

        UIButton stopBtn = new UIButton(new CGRect(190, 400, 120, 80));
        stopBtn.setTitle("Stop", UIControlState.Normal);
        stopBtn.setBackgroundColor(UIColor.red());
        stopBtn.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                playerView.stopVideo();
            }
        });
        playBtn.setTranslatesAutoresizingMaskIntoConstraints(false);
        getView().addSubview(playBtn);

        stopBtn.setTranslatesAutoresizingMaskIntoConstraints(false);
        getView().addSubview(stopBtn);

    }


    @Override
    public void didBecomeReady(YTPlayerView playerView) {
        System.out.println("video ready");
        playerView.playVideo();
    }

    @Override
    public void didChangeState(YTPlayerView playerView, YTPlayerState didChangeToState) {
        System.out.println("video state:"+didChangeToState);
    }

    @Override
    public void didChangeQuality(YTPlayerView playerView, YTPlaybackQuality didChangeToQuality) {

    }

    @Override
    public void didReceivedError(YTPlayerView playerView, YTPlayerError receivedError) {

    }

    @Override
    public void didReceivePlayTime(YTPlayerView playerView, float didPlayTime) {

    }

    @Override
    public UIColor preferredWebViewBackgroundColor(YTPlayerView playerView) {
        return null;
    }
}
