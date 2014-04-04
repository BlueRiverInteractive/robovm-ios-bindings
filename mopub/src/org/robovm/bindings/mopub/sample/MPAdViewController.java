
package org.robovm.bindings.mopub.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIInterfaceOrientation;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.bindings.mopub.MPAdView;
import org.robovm.bindings.mopub.MPConstants;
import org.robovm.bindings.mopub.MPNativeAdOrientation;

public class MPAdViewController extends UIViewController {
	private final MPAdView ad;

	public MPAdViewController (MPAdView ad) {
		this.ad = ad;
	}

	@Override
	public void willRotate (UIInterfaceOrientation toInterfaceOrientation, double duration) {
		super.willRotate(toInterfaceOrientation, duration);
		switch (toInterfaceOrientation) {
		case LandscapeLeft:
		case LandscapeRight:
			ad.rotateToOrientation(MPNativeAdOrientation.Landscape);
			break;
		case Portrait:
		case PortraitUpsideDown:
			ad.rotateToOrientation(MPNativeAdOrientation.Portrait);
			break;
		}
	}

	@Override
	public void didRotate (UIInterfaceOrientation fromInterfaceOrientation) {
		super.didRotate(fromInterfaceOrientation);

		double offset = UIScreen.getMainScreen().getApplicationFrame().size().height();

		switch (fromInterfaceOrientation) {
		case LandscapeLeft:
		case LandscapeRight:
			break;
		case Portrait:
		case PortraitUpsideDown:
			offset = UIScreen.getMainScreen().getApplicationFrame().size().width();
			break;
		}

		// Position ad at the bottom.
		double bannerWidth = UIScreen.getMainScreen().getApplicationFrame().size().width();
		double bannerHeight = bannerWidth / MPConstants.MOPUB_BANNER_SIZE.width() * MPConstants.MOPUB_BANNER_SIZE.height();
		ad.setFrame(new CGRect(0, offset - bannerHeight, bannerWidth, bannerHeight));
	}
}
