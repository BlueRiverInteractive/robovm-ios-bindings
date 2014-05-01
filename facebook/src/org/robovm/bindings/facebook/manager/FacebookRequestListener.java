
package org.robovm.bindings.facebook.manager;


public interface FacebookRequestListener {
	public void onSuccess (GraphObject result);

	public void onCancel ();

	public void onError (String error);
}
