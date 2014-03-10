package org.robovm.bindings.playhaven;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

public interface PHPublisherContentRequestDelegate extends NSObjectProtocol {
	
	//- (void)requestWillGetContent:(PHPublisherContentRequest *)request;
	void requestWillGetContent(PHPublisherContentRequest request);
	//- (void)requestDidGetContent:(PHPublisherContentRequest *)request;
	void requestDidGetContent(PHPublisherContentRequest request);
	//- (void)request:(PHPublisherContentRequest *)request contentWillDisplay:(PHContent *)content;
	void requestWillDisplay(PHPublisherContentRequest request, PHContent content);
	//- (void)request:(PHPublisherContentRequest *)request contentDidDisplay:(PHContent *)content;
	void requestDidDisplay(PHPublisherContentRequest request, PHContent content);
	//- (void)request:(PHPublisherContentRequest *)request contentDidDismissWithType:(PHPublisherContentDismissType *)type;
	void requestDidDismiss(PHPublisherContentRequest request, String type);
	//- (void)request:(PHPublisherContentRequest *)request didFailWithError:(NSError *)error;
	void requestDidFail(PHPublisherContentRequest request, NSError error);
	
	public static class Adapter extends NSObject implements PHPublisherContentRequestDelegate {
		@NotImplemented("requestWillGetContent:")
        public void requestWillGetContent(PHPublisherContentRequest request) {
            throw new UnsupportedOperationException();
        }
		@NotImplemented("requestDidGetContent:")
        public void requestDidGetContent(PHPublisherContentRequest request) {
            throw new UnsupportedOperationException();
        }
		@NotImplemented("request:contentWillDisplay:")
        public void requestWillDisplay(PHPublisherContentRequest request, PHContent content) {
            throw new UnsupportedOperationException();
        }
		@NotImplemented("request:contentDidDisplay:")
        public void requestDidDisplay(PHPublisherContentRequest request, PHContent content) {
            throw new UnsupportedOperationException();
        }
		@NotImplemented("request:contentDidDismissWithType:")
        public void requestDidDismiss(PHPublisherContentRequest request, String type) {
            throw new UnsupportedOperationException();
        }
		@NotImplemented("request:didFailWithError:")
        public void requestDidFail(PHPublisherContentRequest request, NSError error) {
            throw new UnsupportedOperationException();
        }
	}
	
	static class Callbacks {
		@Callback
        @BindSelector("requestWillGetContent:")
        public static void requestWillGetContent(PHPublisherContentRequestDelegate __self__, Selector __cmd__, PHPublisherContentRequest request) {
        	__self__.requestWillGetContent(request);
        }
		@Callback
        @BindSelector("requestDidGetContent:")
        public static void requestDidGetContent(PHPublisherContentRequestDelegate __self__, Selector __cmd__, PHPublisherContentRequest request) {
        	__self__.requestDidGetContent(request);
        }
		@Callback
        @BindSelector("request:contentWillDisplay:")
        public static void requestWillDisplay(PHPublisherContentRequestDelegate __self__, Selector __cmd__, PHPublisherContentRequest request, PHContent content) {
        	__self__.requestWillDisplay(request, content);
        }
		@Callback
        @BindSelector("request:contentDidDisplay:")
        public static void requestDidDisplay(PHPublisherContentRequestDelegate __self__, Selector __cmd__, PHPublisherContentRequest request, PHContent content) {
        	__self__.requestDidDisplay(request, content);
        }
		@Callback
        @BindSelector("request:contentDidDismissWithType:")
        public static void requestDidDismiss(PHPublisherContentRequestDelegate __self__, Selector __cmd__, PHPublisherContentRequest request, String type) {
        	__self__.requestDidDismiss(request, type);
        }
		@Callback
        @BindSelector("request:didFailWithError:")
        public static void requestDidFail(PHPublisherContentRequestDelegate __self__, Selector __cmd__, PHPublisherContentRequest request, NSError error) {
        	__self__.requestDidFail(request, error);
        }
	}

}
