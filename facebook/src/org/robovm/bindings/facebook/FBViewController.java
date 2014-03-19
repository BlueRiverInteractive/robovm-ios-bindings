
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.annotation.NativeClass;

/** The FBViewController class is a base class encapsulating functionality common to several other view controller classes.
 * Specifically, it provides UI when a view controller is presented modally, in the form of optional Cancel and Done buttons. */
@NativeClass
public class FBViewController extends UIViewController {

//
// /*!
// @abstract
// The Cancel button to display when presented modally. If nil, no Cancel button is displayed.
// If this button is provided, its target and action will be redirected to internal handlers, replacing
// any previous target that may have been set.
// */
// @property (nonatomic, retain) IBOutlet UIBarButtonItem *cancelButton;
//
// /*!
// @abstract
// The Done button to display when presented modally. If nil, no Done button is displayed.
// If this button is provided, its target and action will be redirected to internal handlers, replacing
// any previous target that may have been set.
// */
// @property (nonatomic, retain) IBOutlet UIBarButtonItem *doneButton;
//
// /*!
// @abstract
// The delegate that will be called when Cancel or Done is pressed. Derived classes may specify
// derived types for their delegates that provide additional functionality.
// */
// @property (nonatomic, assign) IBOutlet id<FBViewControllerDelegate> delegate;
//
// /*!
// @abstract
// The view into which derived classes should put their subviews. This view will be resized correctly
// depending on whether or not a toolbar is displayed.
// */
// @property (nonatomic, readonly, retain) UIView *canvasView;
//
// /*!
// @abstract
// Provides a wrapper that presents the view controller modally and automatically dismisses it
// when either the Done or Cancel button is pressed.
//
// @param viewController The view controller that is presenting this view controller.
// @param animated If YES, presenting and dismissing the view controller is animated.
// @param handler The block called when the Done or Cancel button is pressed.
// */
// - (void)presentModallyFromViewController:(UIViewController*)viewController
// animated:(BOOL)animated
// handler:(FBModalCompletionHandler)handler;

}
