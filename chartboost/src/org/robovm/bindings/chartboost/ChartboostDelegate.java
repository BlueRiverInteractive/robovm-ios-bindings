package org.robovm.bindings.chartboost;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

public interface ChartboostDelegate extends NSObjectProtocol {
	
	//- (BOOL)shouldRequestInterstitial:(NSString *)location;
	boolean shouldRequestInterstitial(String location);
	//- (BOOL)shouldDisplayInterstitial:(NSString *)location;
	boolean shouldDisplayInterstitial(String location);
	//- (void)didCacheInterstitial:(NSString *)location;
	void didCacheInterstitial(String location);
	//- (void)didFailToLoadInterstitial:(NSString *)location;
	void didFailToLoadInterstitial(String location);
	//- (void)didDismissInterstitial:(NSString *)location;
	void didDismissInterstitial(String location);
	//- (void)didCloseInterstitial:(NSString *)location;
	void didCloseInterstitial(String location);
	//- (void)didClickInterstitial:(NSString *)location;
	void didClickInterstitial(String location);
	//- (BOOL)shouldDisplayLoadingViewForMoreApps;
	boolean shouldDisplayLoadingViewForMoreApps();
	//- (BOOL)shouldDisplayMoreApps;
	boolean shouldDisplayMoreApps();
	//- (void)didCacheMoreApps;
	void didCacheMoreApps();
	//- (void)didFailToLoadMoreApps;
	void didFailToLoadMoreApps();
	//- (void)didDismissMoreApps;
	void didDismissMoreApps();
	//- (void)didCloseMoreApps;
	void didCloseMoreApps();
	//- (void)didClickMoreApps;
	void didClickMoreApps();
	//- (BOOL)shouldRequestInterstitialsInFirstSession;
	boolean shouldRequestInterstitialsInFirstSession();
	
	public static class Adapter extends NSObject implements ChartboostDelegate {
		@NotImplemented("shouldRequestInterstitial:")
        public boolean shouldRequestInterstitial(String location) {
            throw new UnsupportedOperationException();
        }
		
		@NotImplemented("shouldDisplayInterstitial:")
		public boolean shouldDisplayInterstitial(String location){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didCacheInterstitial:")
		public void didCacheInterstitial(String location){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didFailToLoadInterstitial:")
		public void didFailToLoadInterstitial(String location){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didDismissInterstitial:")
		public void didDismissInterstitial(String location){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didCloseInterstitial:")
		public void didCloseInterstitial(String location){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didClickInterstitial:")
		public void didClickInterstitial(String location){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("shouldDisplayLoadingViewForMoreApps")
		public boolean shouldDisplayLoadingViewForMoreApps(){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("shouldDisplayMoreApps")
		public boolean shouldDisplayMoreApps(){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didCacheMoreApps")
		public void didCacheMoreApps(){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didFailToLoadMoreApps")
		public void didFailToLoadMoreApps(){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didDismissMoreApps")
		public void didDismissMoreApps(){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didCloseMoreApps")
		public void didCloseMoreApps(){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("didClickMoreApps")
		public void didClickMoreApps(){
			throw new UnsupportedOperationException();
		}
		
		@NotImplemented("shouldRequestInterstitialsInFirstSession")
		public boolean shouldRequestInterstitialsInFirstSession(){
			throw new UnsupportedOperationException();
		}
    }

    static class Callbacks {
		@Callback
        @BindSelector("shouldRequestInterstitial:")
        public static boolean shouldRequestInterstitial(ChartboostDelegate __self__, Selector __cmd__, String location) {
        	return __self__.shouldRequestInterstitial(location);
        }
		
		@Callback
        @BindSelector("shouldDisplayInterstitial:")
        public static boolean shouldDisplayInterstitial(ChartboostDelegate __self__, Selector __cmd__, String location) {
        	return __self__.shouldDisplayInterstitial(location);
        }
		
		@Callback
        @BindSelector("didCacheInterstitial:")
        public static void didCacheInterstitial(ChartboostDelegate __self__, Selector __cmd__, String location) {
        	__self__.didCacheInterstitial(location);
        }
		
		@Callback
        @BindSelector("didFailToLoadInterstitial:")
        public static void didFailToLoadInterstitial(ChartboostDelegate __self__, Selector __cmd__, String location) {
        	__self__.didFailToLoadInterstitial(location);
        }
		
		@Callback
        @BindSelector("didDismissInterstitial:")
        public static void didDismissInterstitial(ChartboostDelegate __self__, Selector __cmd__, String location) {
        	__self__.didDismissInterstitial(location);
        }
		
		@Callback
        @BindSelector("didCloseInterstitial:")
        public static void didCloseInterstitial(ChartboostDelegate __self__, Selector __cmd__, String location) {
        	__self__.didDismissInterstitial(location);
        }
		
		@Callback
        @BindSelector("didClickInterstitial:")
        public static void didClickInterstitial(ChartboostDelegate __self__, Selector __cmd__, String location) {
        	__self__.didClickInterstitial(location);
        }
		
		@Callback
        @BindSelector("shouldDisplayLoadingViewForMoreApps")
        public static boolean shouldDisplayLoadingViewForMoreApps(ChartboostDelegate __self__, Selector __cmd__) {
        	return __self__.shouldDisplayLoadingViewForMoreApps();
        }
		
		@Callback
        @BindSelector("shouldDisplayMoreApps")
        public static boolean shouldDisplayMoreApps(ChartboostDelegate __self__, Selector __cmd__) {
        	return __self__.shouldDisplayMoreApps();
        }
		
		@Callback
        @BindSelector("didCacheMoreApps")
        public static void didCacheMoreApps(ChartboostDelegate __self__, Selector __cmd__) {
        	__self__.didCacheMoreApps();
        }
		
		@Callback
        @BindSelector("didFailToLoadMoreApps")
        public static void didFailToLoadMoreApps(ChartboostDelegate __self__, Selector __cmd__) {
        	__self__.didFailToLoadMoreApps();
        }
		
		@Callback
        @BindSelector("didDismissMoreApps")
        public static void didDismissMoreApps(ChartboostDelegate __self__, Selector __cmd__) {
        	__self__.didDismissMoreApps();
        }
		
		@Callback
        @BindSelector("didCloseMoreApps")
        public static void didCloseMoreApps(ChartboostDelegate __self__, Selector __cmd__) {
        	__self__.didCloseMoreApps();
        }
		
		@Callback
        @BindSelector("didClickMoreApps")
        public static void didClickMoreApps(ChartboostDelegate __self__, Selector __cmd__) {
        	__self__.didClickMoreApps();
        }
		
		@Callback
        @BindSelector("shouldRequestInterstitialsInFirstSession")
        public static boolean shouldRequestInterstitialsInFirstSession(ChartboostDelegate __self__, Selector __cmd__) {
        	return __self__.shouldRequestInterstitialsInFirstSession();
        }
    }

}
