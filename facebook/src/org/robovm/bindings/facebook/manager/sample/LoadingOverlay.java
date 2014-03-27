
package org.robovm.bindings.facebook.manager.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.NSTextAlignment;
import org.robovm.apple.uikit.UIActivityIndicatorView;
import org.robovm.apple.uikit.UIActivityIndicatorViewStyle;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;

public class LoadingOverlay extends UIView {
	private final UIActivityIndicatorView activitySpinner;
	private final UILabel loadingLabel;

	public LoadingOverlay (CGRect frame, String caption) {
		setBackgroundColor(UIColor.blackColor());
		setAlpha(0.75f);
		setUserInteractionEnabled(true);
		setExclusiveTouch(true);

		setFrame(frame);

		double labelHeight = 22;
		double labelWidth = getFrame().size().width() - 20;

		// derive the center x and y
		double centerX = getFrame().size().width() / 2;
		double centerY = getFrame().size().height() / 2;

		// create the activity spinner, center it horizontally and put it 5 points above center x
		activitySpinner = new UIActivityIndicatorView(UIActivityIndicatorViewStyle.WhiteLarge);
		activitySpinner.setFrame(new CGRect(centerX - (activitySpinner.getFrame().size().width() / 2), centerY
			- activitySpinner.getFrame().size().height() - 20, activitySpinner.getFrame().size().width(), activitySpinner.getFrame()
			.size().height()));

		addSubview$(activitySpinner);
		activitySpinner.startAnimating();

		loadingLabel = new UILabel();
		loadingLabel.setFrame(new CGRect(centerX - (labelWidth / 2), centerY + 20, labelWidth, labelHeight));
		loadingLabel.setBackgroundColor(UIColor.clearColor());
		loadingLabel.setTextColor(UIColor.whiteColor());
		loadingLabel.setText(caption);
		loadingLabel.setTextAlignment(NSTextAlignment.Center);
		addSubview$(loadingLabel);
	}

	public void show (UIViewController viewController) {
		setAlpha(0.75f);
		viewController.getView().addSubview$(this);
	}

	public void hide () {
		setAlpha(0);
		removeFromSuperview();
	}
}
