package org.robovm.bindings.ythelper;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/**
* A delegate for ViewControllers to respond to YouTube player events outside
* of the view, such as changes to video playback state or playback errors.
* The callback functions correlate to the events fired by the JavaScript
* API. For the full documentation, see the JavaScript documentation here:
*     https://developers.google.com/youtube/js_api_reference#Events
*/

public interface YTPlayerViewDelegate extends NSObjectProtocol{
	
	/**
	* Invoked when the player view is ready to receive API calls.
	*
	* @param playerView The YTPlayerView instance that has become ready.
	*/

	@Method(selector = "playerViewDidBecomeReady:")
	public void playerViewDidBecomeReady(YTPlayerView playerView);

	/**
	* Callback invoked when player state has changed, e.g. stopped or started playback.
	*
	* @param playerView The YTPlayerView instance where playback state has changed.
	* @param state YTPlayerState designating the new playback state.
	*/
	
	@Method(selector = "playerView:state:")
	public void playerView(YTPlayerView playerView, YTPlayerState state);

	/**
	* Callback invoked when playback quality has changed.
	*
	* @param playerView The YTPlayerView instance where playback quality has changed.
	* @param quality YTPlaybackQuality designating the new playback quality.
	*/
	
	@Method(selector = "playerView:quality:")
	public void playerView(YTPlayerView playerView, YTPlaybackQuality quality);

	/**
	* Callback invoked when an error has occured.
	*
	* @param playerView The YTPlayerView instance where the error has occurred.
	* @param error YTPlayerError containing the error state.
	*/
	
	@Method(selector = "playerView:error:")
	public void playerView(YTPlayerView playerView, YTPlayerError error);

}
