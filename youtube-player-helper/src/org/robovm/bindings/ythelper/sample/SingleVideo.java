package org.robovm.bindings.ythelper.sample;

import java.util.HashMap;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSString;
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
import org.robovm.bindings.ythelper.YTPlayerState;
import org.robovm.bindings.ythelper.YTPlayerView;
import org.robovm.bindings.ythelper.YTPlayerViewDelegate;

public class SingleVideo extends UIViewController implements
		YTPlayerViewDelegate {
	YTPlayerView playerView;

	@Override
	public void viewDidLoad() {
		setupViews();
	}

	private void setupViews() {
		// For a full list of player parameters, see the documentation for the
		// HTML5 player
		// at:
		// https://developers.google.com/youtube/player_parameters?playerVersion=HTML5

		HashMap<NSString, NSString> playerVarsPara = new HashMap<NSString, NSString>();
		playerVarsPara.put(new NSString("controls"), new NSString("0"));
		playerVarsPara.put(new NSString("playsinline"), new NSString("1"));
		playerVarsPara.put(new NSString("autohide"), new NSString("1"));
		playerVarsPara.put(new NSString("showinfo"), new NSString("0"));
		playerVarsPara.put(new NSString("modestbranding"), new NSString("1"));

		NSDictionary<NSString, NSString> playerVars = new NSDictionary<NSString, NSString>(
				playerVarsPara);

		playerView = new YTPlayerView();
		playerView.setFrame(new CGRect(10, 80, 300, 275));
		playerView.setBackgroundColor(UIColor.green());
		playerView.setContentMode(UIViewContentMode.ScaleAspectFill);
		playerView.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
		playerView.setAutoresizingMask(UIViewAutoresizing.FlexibleHeight);
		playerView.setDelegate(this);
		playerView.setTranslatesAutoresizingMaskIntoConstraints(false);

		getView().addSubview(playerView);

		playerView.loadWithVideoId(new NSString("M7lc1UVf-VE"), playerVars);

		UIButton playBtn = new UIButton(new CGRect(10, 400, 120, 80));
		playBtn.setTitle("Play", UIControlState.Normal);
		playBtn.setBackgroundColor(UIColor.red());
		playBtn.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				playerView.playVideo();
			}
		});

		UIButton stopBtn = new UIButton(new CGRect(190, 400, 120, 80));
		stopBtn.setTitle("Stop", UIControlState.Normal);
		stopBtn.setBackgroundColor(UIColor.red());
		stopBtn.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				playerView.stopVideo();
			}
		});
		playBtn.setTranslatesAutoresizingMaskIntoConstraints(false);
		getView().addSubview(playBtn);

		stopBtn.setTranslatesAutoresizingMaskIntoConstraints(false);
		getView().addSubview(stopBtn);

	}

	@Override
	public void playerViewDidBecomeReady(YTPlayerView playerView) {
		System.out.println("video ready");
		playerView.playVideo();
		// TODO Auto-generated method stub

	}

	@Override
	public void playerView(YTPlayerView playerView, YTPlayerState state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playerView(YTPlayerView playerView, YTPlaybackQuality quality) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playerView(YTPlayerView playerView, YTPlayerError error) {
		// TODO Auto-generated method stub

	}

}
