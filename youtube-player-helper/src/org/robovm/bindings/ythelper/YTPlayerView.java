package org.robovm.bindings.ythelper;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.foundation.NSURLRequest;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIWebView;
import org.robovm.apple.uikit.UIWebViewDelegate;
import org.robovm.apple.uikit.UIWebViewNavigationType;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

//Copyright 2014 Google Inc. All rights reserved.
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

/**
 * YTPlayerView is a custom UIView that client developers will use to include YouTube
 * videos in their iOS applications. It can be instantiated programmatically, or via
 * Interface Builder. Use the methods YTPlayerView::loadWithVideoId:,
 * YTPlayerView::loadWithPlaylistId: or their variants to set the video or playlist
 * to populate the view with.
 */
@NativeClass
public class YTPlayerView extends UIView implements UIWebViewDelegate {

@Property(selector = "webView", strongRef=true)
public native UIWebView getWebView();


/** A delegate to be notified on playback events. */
@Property(selector = "delegate")
public native YTPlayerViewDelegate getDelegate();

@Property(selector = "setDelegate:", strongRef = true)
public native void setDelegate(YTPlayerViewDelegate delegate);

/**
 * This method loads the player with the given video ID.
 * This is a convenience method for calling YTPlayerView::loadPlayerWithVideoId:withPlayerVars:
 * without player variables.
 *
 * This method reloads the entire contents of the UIWebView and regenerates its HTML contents.
 * To change the currently loaded video without reloading the entire UIWebView, use the
 * YTPlayerView::cueVideoById:startSeconds:suggestedQuality: family of methods.
 *
 * @param videoId The YouTube video ID of the video to load in the player view.
 * @return YES if player has been configured correctly, NO otherwise.
 */
@Method(selector = "loadWithVideoId:")
public native boolean loadWithVideoId(NSString videoId);

/**
 * This method loads the player with the given playlist ID.
 * This is a convenience method for calling YTPlayerView::loadWithPlaylistId:withPlayerVars:
 * without player variables.
 *
 * This method reloads the entire contents of the UIWebView and regenerates its HTML contents.
 * To change the currently loaded video without reloading the entire UIWebView, use the
 * YTPlayerView::cuePlaylistByPlaylistId:index:startSeconds:suggestedQuality:
 * family of methods.
 *
 * @param playlistId The YouTube playlist ID of the playlist to load in the player view.
 * @return YES if player has been configured correctly, NO otherwise.
 */
@Method(selector = "loadWithPlaylistId:")
public native boolean loadWithPlaylistId(NSString playlistId);

/**
 * This method loads the player with the given video ID and player variables. Player variables
 * specify optional parameters for video playback. For instance, to play a YouTube
 * video inline, the following playerVars dictionary would be used:
 *
 * @code
 * @{ @"playsinline" : @1 };
 * @endcode
 *
 * Note that when the documentation specifies a valid value as a number (typically 0, 1 or 2),
 * both strings and integers are valid values. The full list of parameters is defined at:
 *   https://developers.google.com/youtube/player_parameters?playerVersion=HTML5.
 *
 * This method reloads the entire contents of the UIWebView and regenerates its HTML contents.
 * To change the currently loaded video without reloading the entire UIWebView, use the
 * YTPlayerView::cueVideoById:startSeconds:suggestedQuality: family of methods.
 *
 * @param videoId The YouTube video ID of the video to load in the player view.
 * @param playerVars An NSDictionary of player parameters.
 * @return YES if player has been configured correctly, NO otherwise.
 */
@Method(selector = "loadWithVideoId:playerVars:")
public native boolean loadWithVideoId(NSString videoId, NSDictionary<NSString, NSString> playerVars);

/**
 * This method loads the player with the given playlist ID and player variables. Player variables
 * specify optional parameters for video playback. For instance, to play a YouTube
 * video inline, the following playerVars dictionary would be used:
 *
 * @code
 * @{ @"playsinline" : @1 };
 * @endcode
 *
 * Note that when the documentation specifies a valid value as a number (typically 0, 1 or 2),
 * both strings and integers are valid values. The full list of parameters is defined at:
 *   https://developers.google.com/youtube/player_parameters?playerVersion=HTML5.
 *
 * This method reloads the entire contents of the UIWebView and regenerates its HTML contents.
 * To change the currently loaded video without reloading the entire UIWebView, use the
 * YTPlayerView::cuePlaylistByPlaylistId:index:startSeconds:suggestedQuality:
 * family of methods.
 *
 * @param playlistId The YouTube playlist ID of the playlist to load in the player view.
 * @param playerVars An NSDictionary of player parameters.
 * @return YES if player has been configured correctly, NO otherwise.
 */
@Method(selector = "loadWithPlaylistId:playerVars:")
public native boolean loadWithPlaylistId(NSString playlistId, NSDictionary<NSString, NSString> playerVars);

@Method(selector = "loadWithPlayerParams:")
public native boolean loadWithPlayerParams(NSDictionary<NSString, NSString> additionalPlayerParams);

//#pragma mark - Player controls

// These methods correspond to their JavaScript equivalents as documented here:
//   https://developers.google.com/youtube/js_api_reference#Playback_controls

/**
 * Starts or resumes playback on the loaded video. Corresponds to this method from
 * the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#playVideo
 */
@Method(selector = "playVideo")
public native void playVideo();

/**
 * Pauses playback on a playing video. Corresponds to this method from
 * the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#pauseVideo
 */
@Method(selector = "pauseVideo")
public native void pauseVideo();

/**
 * Stops playback on a playing video. Corresponds to this method from
 * the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#stopVideo
 */
@Method(selector = "stopVideo")
public native void stopVideo();

/**
 * Seek to a given time on a playing video. Corresponds to this method from
 * the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#seekTo
 *
 * @param seekToSeconds The time in seconds to seek to in the loaded video.
 * @param allowSeekAhead Whether to make a new request to the server if the time is
 *                       outside what is currently buffered. Recommended to set to YES.
 */
@Method(selector = "seekToSeconds:allowSeekAhead:")
public native void seekToSeconds(float seekToSeconds, boolean allowSeekAhead);

/**
 * Clears the loaded video from the player. Corresponds to this method from
 * the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#clearVideo
 */
@Method(selector = "clearVideo")
public native void clearVideo();

//#pragma mark - Queuing videos

// Queueing functions for videos. These methods correspond to their JavaScript
// equivalents as documented here:
//   https://developers.google.com/youtube/js_api_reference#Queueing_Functions

/**
 * Cues a given video by its video ID for playback starting at the given time and with the
 * suggested quality. Cueing loads a video, but does not start video playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#cueVideoById
 *
 * @param videoId A video ID to cue.
 * @param startSeconds Time in seconds to start the video when YTPlayerView::playVideo is called.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "cueVideoById:startSeconds:suggestedQuality:")
public native void cueVideoById(NSString videoId, float startSeconds, YTPlaybackQuality suggestedQuality);

/**
 * Cues a given video by its video ID for playback starting and ending at the given times
 * with the suggested quality. Cueing loads a video, but does not start video playback. This
 * method corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#cueVideoById
 *
 * @param videoId A video ID to cue.
 * @param startSeconds Time in seconds to start the video when playVideo() is called.
 * @param endSeconds Time in seconds to end the video after it begins playing.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "cueVideoById:startSeconds:endSeconds:suggestedQuality:")
public native void cueVideoById(NSString videoId, float startSeconds, float endSeconds, YTPlaybackQuality suggestedQuality);

/**
 * Loads a given video by its video ID for playback starting at the given time and with the
 * suggested quality. Loading a video both loads it and begins playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#loadVideoById
 *
 * @param videoId A video ID to load and begin playing.
 * @param startSeconds Time in seconds to start the video when it has loaded.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "loadVideoById:startSeconds:suggestedQuality:")
public native void loadVideoById(NSString videoId, float startSeconds, YTPlaybackQuality suggestedQuality);

/**
 * Loads a given video by its video ID for playback starting and ending at the given times
 * with the suggested quality. Loading a video both loads it and begins playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#loadVideoById
 *
 * @param videoId A video ID to load and begin playing.
 * @param startSeconds Time in seconds to start the video when it has loaded.
 * @param endSeconds Time in seconds to end the video after it begins playing.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "loadVideoById:startSeconds:endSeconds:suggestedQuality:")
public native void loadVideoById(NSString videoId, float startSeconds, float endSeconds, YTPlaybackQuality suggestedQuality);

           
/**
 * Cues a given video by its URL on YouTube.com for playback starting at the given time
 * and with the suggested quality. Cueing loads a video, but does not start video playback.
 * This method corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#cueVideoByUrl
 *
 * @param videoURL URL of a YouTube video to cue for playback.
 * @param startSeconds Time in seconds to start the video when YTPlayerView::playVideo is called.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "cueVideoByURL:startSeconds:suggestedQuality:")
public native void cueVideoByURL(NSString videoURL, float startSeconds, YTPlaybackQuality suggestedQuality);
         

/**
 * Cues a given video by its URL on YouTube.com for playback starting at the given time
 * and with the suggested quality. Cueing loads a video, but does not start video playback.
 * This method corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#cueVideoByUrl
 *
 * @param videoURL URL of a YouTube video to cue for playback.
 * @param startSeconds Time in seconds to start the video when YTPlayerView::playVideo is called.
 * @param endSeconds Time in seconds to end the video after it begins playing.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "cueVideoByURL:startSeconds:endSeconds:suggestedQuality:")
public native void cueVideoByURL(NSString videoURL, float startSeconds, float endSeconds, YTPlaybackQuality suggestedQuality);

           
/**
 * Loads a given video by its video ID for playback starting at the given time
 * with the suggested quality. Loading a video both loads it and begins playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#loadVideoByUrl
 *
 * @param videoURL URL of a YouTube video to load and play.
 * @param startSeconds Time in seconds to start the video when it has loaded.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "loadVideoByURL:startSeconds:suggestedQuality:")
public native void loadVideoByURL(NSString videoURL, float startSeconds, YTPlaybackQuality suggestedQuality);

/**
 * Loads a given video by its video ID for playback starting and ending at the given times
 * with the suggested quality. Loading a video both loads it and begins playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#loadVideoByUrl
 *
 * @param videoURL URL of a YouTube video to load and play.
 * @param startSeconds Time in seconds to start the video when it has loaded.
 * @param endSeconds Time in seconds to end the video after it begins playing.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "loadVideoByURL:startSeconds:endSeconds:suggestedQuality:")
public native void loadVideoByURL(NSString videoURL, float startSeconds, float endSeconds, YTPlaybackQuality suggestedQuality);

//#pragma mark - Queuing functions for playlists

// Queueing functions for playlists. These methods correspond to
// the JavaScript methods defined here:
//    https://developers.google.com/youtube/js_api_reference#Playlist_Queueing_Functions

/**
 * Cues a given playlist with the given ID. The |index| parameter specifies the 0-indexed
 * position of the first video to play, starting at the given time and with the
 * suggested quality. Cueing loads a playlist, but does not start video playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#cuePlaylist
 *
 * @param playlistId Playlist ID of a YouTube playlist to cue.
 * @param index A 0-indexed position specifying the first video to play.
 * @param startSeconds Time in seconds to start the video when YTPlayerView::playVideo is called.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "cuePlaylistByPlaylistId:index:startSeconds:suggestedQuality:")
public native void cuePlaylistByPlaylistId(NSString laylistId, int index, float startSeconds, YTPlaybackQuality suggestedQuality);

/**
 * Cues a playlist of videos with the given video IDs. The |index| parameter specifies the
 * 0-indexed position of the first video to play, starting at the given time and with the
 * suggested quality. Cueing loads a playlist, but does not start video playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#cuePlaylist
 *
 * @param videoIds An NSArray of video IDs to compose the playlist of.
 * @param index A 0-indexed position specifying the first video to play.
 * @param startSeconds Time in seconds to start the video when YTPlayerView::playVideo is called.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "cuePlaylistByVideos:index:startSeconds:suggestedQuality:")
public native void cuePlaylistByVideos(NSArray videoIds, int index, float startSeconds, YTPlaybackQuality suggestedQuality);

/**
 * Loads a given playlist with the given ID. The |index| parameter specifies the 0-indexed
 * position of the first video to play, starting at the given time and with the
 * suggested quality. Loading a playlist starts video playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#loadPlaylist
 *
 * @param playlistId Playlist ID of a YouTube playlist to cue.
 * @param index A 0-indexed position specifying the first video to play.
 * @param startSeconds Time in seconds to start the video when YTPlayerView::playVideo is called.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "loadPlaylistByPlaylistId:index:startSeconds:suggestedQuality:")
public native void loadPlaylistByPlaylistId(NSString playlistId, int index, float startSeconds, YTPlaybackQuality suggestedQuality);

/**
 * Loads a playlist of videos with the given video IDs. The |index| parameter specifies the
 * 0-indexed position of the first video to play, starting at the given time and with the
 * suggested quality. Loading a playlist starts video playback. This method
 * corresponds with its JavaScript API equivalent as documented here:
 *    https://developers.google.com/youtube/iframe_api_reference#loadPlaylist
 *
 * @param videoIds An NSArray of video IDs to compose the playlist of.
 * @param index A 0-indexed position specifying the first video to play.
 * @param startSeconds Time in seconds to start the video when YTPlayerView::playVideo is called.
 * @param suggestedQuality YTPlaybackQuality value suggesting a playback quality.
 */
@Method(selector = "loadPlaylistByVideos:index:startSeconds:suggestedQuality:")
public native void loadPlaylistByVideos(NSArray videoIds, int index, float startSeconds, YTPlaybackQuality suggestedQuality);

//#pragma mark - Playing a video in a playlist

// These methods correspond to the JavaScript API as defined under the
// "Playing a video in a playlist" section here:
//    https://developers.google.com/youtube/js_api_reference#Playback_status

/**
 * Loads and plays the next video in the playlist. Corresponds to this method from
 * the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#nextVideo
 */
@Method(selector = "nextVideo")
public native void nextVideo();

/**
 * Loads and plays the previous video in the playlist. Corresponds to this method from
 * the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#previousVideo
 */
@Method(selector = "previousVideo")
public native void previousVideo();

/**
 * Loads and plays the video at the given 0-indexed position in the playlist.
 * Corresponds to this method from the JavaScript API:
 *   https://developers.google.com/youtube/iframe_api_reference#playVideoAt
 *
 * @param index The 0-indexed position of the video in the playlist to load and play.
 */
@Method(selector = "playVideoAt:")
public native void playVideoAt(int index);

//#pragma mark - Setting the playback rate

/**
 * Gets the playback rate. The default value is 1.0, which represents a video
 * playing at normal speed. Other values may include 0.25 or 0.5 for slower
 * speeds, and 1.5 or 2.0 for faster speeds. This method corresponds to the
 * JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getPlaybackRate
 *
 * @return An integer value between 0 and 100 representing the current volume.
 */
@Method(selector = "playbackRate")
public native float playbackRate();

/**
 * Sets the playback rate. The default value is 1.0, which represents a video
 * playing at normal speed. Other values may include 0.25 or 0.5 for slower
 * speeds, and 1.5 or 2.0 for faster speeds. To fetch a list of valid values for
 * this method, call YTPlayerView::getAvailablePlaybackRates. This method does not
 * guarantee that the playback rate will change.
 * This method corresponds to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#setPlaybackRate
 *
 * @param suggestedRate A playback rate to suggest for the player.
 */
@Method(selector = "setPlaybackRate:")
public native void setPlaybackRate(float suggestedRate);

/**
 * Gets a list of the valid playback rates, useful in conjunction with
 * YTPlayerView::setPlaybackRate. This method corresponds to the
 * JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getPlaybackRate
 *
 * @return An NSArray containing available playback rates. nil if there is an error.
 */
@Method(selector = "availablePlaybackRates")
public native NSArray availablePlaybackRates();

//#pragma mark - Setting playback behavior for playlists

/**
 * Sets whether the player should loop back to the first video in the playlist
 * after it has finished playing the last video. This method corresponds to the
 * JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#loopPlaylist
 *
 * @param loop A boolean representing whether the player should loop.
 */
@Method(selector = "setLoop:")
public native void setLoop(boolean loop);

/**
 * Sets whether the player should shuffle through the playlist. This method
 * corresponds to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#shufflePlaylist
 *
 * @param shuffle A boolean representing whether the player should
 *                shuffle through the playlist.
 */
@Method(selector = "setShuffle:")
public native void setShuffle(boolean shuffle);

//#pragma mark - Playback status
// These methods correspond to the JavaScript methods defined here:
//    https://developers.google.com/youtube/js_api_reference#Playback_status

/**
 * Returns a number between 0 and 1 that specifies the percentage of the video
 * that the player shows as buffered. This method corresponds to the
 * JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getVideoLoadedFraction
 *
 * @return A float value between 0 and 1 representing the percentage of the video
 *         already loaded.
 */
@Method(selector = "videoLoadedFraction")
public native float videoLoadedFraction();

/**
 * Returns the state of the player. This method corresponds to the
 * JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getPlayerState
 *
 * @return |YTPlayerState| representing the state of the player.
 */
@Method(selector = "playerState")
public native YTPlayerState playerState();

/**
 * Returns the elapsed time in seconds since the video started playing. This
 * method corresponds to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getCurrentTime
 *
 * @return Time in seconds since the video started playing.
 */
@Method(selector = "currentTime")
public native float currentTime();

//#pragma mark - Playback quality

// Playback quality. These methods correspond to the JavaScript
// methods defined here:
//   https://developers.google.com/youtube/js_api_reference#Playback_quality

/**
 * Returns the playback quality. This method corresponds to the
 * JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getPlaybackQuality
 *
 * @return YTPlaybackQuality representing the current playback quality.
 */
@Method(selector = "playbackQuality")
public native YTPlaybackQuality playbackQuality();

/**
 * Suggests playback quality for the video. It is recommended to leave this setting to
 * |default|. This method corresponds to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#setPlaybackQuality
 *
 * @param quality YTPlaybackQuality value to suggest for the player.
 */
@Method(selector = "setPlaybackQuality:")
public native void setPlaybackQuality(YTPlaybackQuality suggestedQuality);

/**
 * Gets a list of the valid playback quality values, useful in conjunction with
 * YTPlayerView::setPlaybackQuality. This method corresponds to the
 * JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getAvailableQualityLevels
 *
 * @return An NSArray containing available playback quality levels.
 */

@Method(selector = "availableQualityLevels")
public native NSArray availableQualityLevels();

//#pragma mark - Retrieving video information

// Retrieving video information. These methods correspond to the JavaScript
// methods defined here:
//   https://developers.google.com/youtube/js_api_reference#Retrieving_video_information

/**
 * Returns the duration in seconds since the video of the video. This
 * method corresponds to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getDuration
 *
 * @return Length of the video in seconds.
 */
@Method(selector = "duration")
public native double duration();

/**
 * Returns the YouTube.com URL for the video. This method corresponds
 * to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getVideoUrl
 *
 * @return The YouTube.com URL for the video.
 */
@Method(selector = "videoUrl")
public native NSURL videoUrl();

/**
 * Returns the embed code for the current video. This method corresponds
 * to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getVideoEmbedCode
 *
 * @return The embed code for the current video.
 */
//- (NSString *)videoEmbedCode;

@Method(selector = "videoEmbedCode")
public native NSString videoEmbedCode();

//#pragma mark - Retrieving playlist information

// Retrieving playlist information. These methods correspond to the
// JavaScript defined here:
//    https://developers.google.com/youtube/js_api_reference#Retrieving_playlist_information

/**
 * Returns an ordered array of video IDs in the playlist. This method corresponds
 * to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getPlaylist
 *
 * @return An NSArray containing all the video IDs in the current playlist. |nil| on error.
 */
//- (NSArray *)playlist;

@Method(selector = "playlist")
public native NSArray playlist();

/**
 * Returns the 0-based index of the currently playing item in the playlist.
 * This method corresponds to the JavaScript API defined here:
 *   https://developers.google.com/youtube/iframe_api_reference#getPlaylistIndex
 *
 * @return The 0-based index of the currently playing item in the playlist.
 */
//- (int)playlistIndex;

@Method(selector = "playlistIndex")
public native int playlistIndex();

//- (void)removeWebView;

@Method(selector = "removeWebView")
public native void removeWebView();


@Override
@Method(selector = "webView:shouldStartLoadWithRequest:navigationType:")
public boolean shouldStartLoad(UIWebView webView, NSURLRequest request,
		UIWebViewNavigationType navigationType) {
	// TODO Auto-generated method stub
	return false;
}


@Override
@Method(selector = "webViewDidStartLoad:")
public void didStartLoad(UIWebView webView) {
	// TODO Auto-generated method stub
	
}


@Override
@Method(selector = "webViewDidFinishLoad:")
public void didFinishLoad(UIWebView webView) {
	// TODO Auto-generated method stub
	
}


@Override
@Method(selector = "webView:didFailLoadWithError:")
public void didFailLoad(UIWebView webView, NSError error) {
	// TODO Auto-generated method stub
	
}

//@end


}
