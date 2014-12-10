
package org.robovm.bindings.facebook.manager;

public interface FacebookListener {
    void onCancel ();

    void onError (FacebookError error);
}
