
package org.robovm.bindings.admob.sample;

import org.robovm.apple.coregraphics.CGSize;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.bindings.admob.GADAdSize;
import org.robovm.bindings.admob.GADAdSizeManager;
import org.robovm.bindings.admob.GADBannerView;

public class Sample extends UIApplicationDelegateAdapter {

	@Override
	public void didFinishLaunching (UIApplication application) {
		GADBannerView banner = new GADBannerView(GADAdSizeManager.banner());
		System.out.println(banner);
		GADBannerView portrait = new GADBannerView(GADAdSizeManager.getFullWidthPortrait(50));
		System.out.println(portrait);
		GADAdSize size = GADAdSizeManager.getGADAdSize(new CGSize(480, 800));
		GADBannerView special = new GADBannerView(size);
		System.out.println(special);
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}
