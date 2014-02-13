package org.robovm.bindings.appirater;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
public interface AppiraterDelegate extends NSObjectProtocol {
	//-(void)appiraterDidDisplayAlert:(Appirater *)appirater;
	void appiraterDidDisplayAlert(Appirater appirater);
	
	//-(void)appiraterDidDeclineToRate:(Appirater *)appirater;
	void appiraterDidDeclineToRate(Appirater appirater);
	
	//-(void)appiraterDidOptToRate:(Appirater *)appirater;
	void appiraterDidOptToRate(Appirater appirater);
	
	//-(void)appiraterDidOptToRemindLater:(Appirater *)appirater;
	void appiraterDidOptToRemindLater(Appirater appirater);
	
	//-(void)appiraterWillPresentModalView:(Appirater *)appirater animated:(BOOL)animated;
	void appiraterWillPresentModalView(Appirater appirater, boolean animated);
	
	//-(void)appiraterDidDismissModalView:(Appirater *)appirater animated:(BOOL)animated;
	void appiraterDidDismissModalView(Appirater appirater, boolean animated);
	
	public static class Adapter extends NSObject implements AppiraterDelegate{
		
		@Override
		public void appiraterDidDisplayAlert(Appirater appirater){
		}

		@Override
		public void appiraterDidDeclineToRate(Appirater appirater){
		}
		
		@Override
		public void appiraterDidOptToRate(Appirater appirater){
		}
		
		@Override
		public void appiraterDidOptToRemindLater(Appirater appirater){
		}
		
		@Override
		public void appiraterWillPresentModalView(Appirater appirater, boolean animated){
		}
		
		@Override
		public void appiraterDidDismissModalView(Appirater appirater, boolean animated){
		}
	}
	
	static class Callbacks{
		@Callback
		@BindSelector("appiraterDidDisplayAlert:")
		public static void appiraterDidDisplayAlert(AppiraterDelegate __self__, Selector __cmd__, Appirater appirater){
			__self__.appiraterDidDisplayAlert(appirater);
		}
		
		@Callback
		@BindSelector("appiraterDidDeclineToRate:")
		public static void appiraterDidDeclineToRate(AppiraterDelegate __self__, Selector __cmd__, Appirater appirater){
			__self__.appiraterDidDeclineToRate(appirater);
		}
		
		@Callback
		@BindSelector("appiraterDidOptToRate:")
		public static void appiraterDidOptToRate(AppiraterDelegate __self__, Selector __cmd__, Appirater appirater){
			__self__.appiraterDidOptToRate(appirater);
		}
		
		@Callback
		@BindSelector("appiraterDidOptToRemindLater:")
		public static void appiraterDidOptToRemindLater(AppiraterDelegate __self__, Selector __cmd__, Appirater appirater){
			__self__.appiraterDidOptToRemindLater(appirater);
		}
		
		@Callback
		@BindSelector("appiraterWillPresentModalView:animated:")
		public static void appiraterWillPresentModalView(AppiraterDelegate __self__, Selector __cmd__, Appirater appirater, boolean animated){
			__self__.appiraterWillPresentModalView(appirater, animated);
		}
		
		@Callback
		@BindSelector("appiraterDidDismissModalView:animated:")
		public static void appiraterDidDismissModalView(AppiraterDelegate __self__, Selector __cmd__, Appirater appirater, boolean animated){
			__self__.appiraterDidDismissModalView(appirater, animated);
		}
	}
}
