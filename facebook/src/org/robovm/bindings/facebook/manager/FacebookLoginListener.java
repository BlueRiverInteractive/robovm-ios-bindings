
package org.robovm.bindings.facebook.manager;

public interface FacebookLoginListener {
	public void onSuccess (GraphObject user);

	public void onCancel ();

	public void onError (String error);
}
