package org.robovm.bindings.ythelper;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.uikit.UIColor;
import org.robovm.objc.annotation.Method;

/**
 * A delegate for ViewControllers to respond to YouTube player events outside
 * of the view, such as changes to video playback state or playback errors.
 * The callback functions correlate to the events fired by the JavaScript
 * API. For the full documentation, see the JavaScript documentation here:
 * https://developers.google.com/youtube/js_api_reference#Events
 */

public interface YTPlayerViewDelegate extends NSObjectProtocol{
	
	/**
	* Invoked when the player view is ready to receive API calls.
	*
	* @param playerView The YTPlayerView instance that has become ready.
	*/

	@Method(selector = "playerViewDidBecomeReady:")
	public void didBecomeReady(YTPlayerView playerView);

	/**
	* Callback invoked when player state has changed, e.g. stopped or started playback.
	*
	* @param playerView The YTPlayerView instance where playback state has changed.
	* @param didChangeToState YTPlayerState designating the new playback state.
	*/
	
	@Method(selector = "playerView:didChangeToState:")
	public void didChangeState(YTPlayerView playerView, YTPlayerState didChangeToState);

	/**
	* Callback invoked when playback quality has changed.
	*
	* @param playerView The YTPlayerView instance where playback quality has changed.
	* @param didChangeToQuality YTPlaybackQuality designating the new playback quality.
	*/
	
	@Method(selector = "playerView:didChangeToQuality:")
	public void didChangeQuality(YTPlayerView playerView, YTPlaybackQuality didChangeToQuality);

	/**
	* Callback invoked when an error has occured.
	*
	* @param playerView The YTPlayerView instance where the error has occurred.
	* @param receivedError YTPlayerError containing the error state.
	*/
	
	@Method(selector = "playerView:receivedError:")
	public void didReceivedError(YTPlayerView playerView, YTPlayerError receivedError);

	/**
	 * Callback invoked frequently when playBack is plaing.
	 *
	 * @param playerView The YTPlayerView instance where the error has occurred.
	 * @param didPlayTime   float containing curretn playback time.
	 */
	@Method(selector = "playerView:didPlayTime:")
	public void didReceivePlayTime(YTPlayerView playerView, float didPlayTime);


	/**
	 * Callback invoked when setting up the webview to allow custom colours so it fits in
	 * with app color schemes. If a transparent view is required specify clearColor and
	 * the code will handle the opacity etc.
	 */
	@Method(selector = "playerViewPreferredWebViewBackgroundColor:")
	public UIColor preferredWebViewBackgroundColor(YTPlayerView playerView);


}
