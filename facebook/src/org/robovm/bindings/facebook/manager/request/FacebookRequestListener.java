
package org.robovm.bindings.facebook.manager.request;

import org.robovm.bindings.facebook.manager.FacebookListener;

public interface FacebookRequestListener extends FacebookListener {
    void onSuccess (GraphObject result);
}
