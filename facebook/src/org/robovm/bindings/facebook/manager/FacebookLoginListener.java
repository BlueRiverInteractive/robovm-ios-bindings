
package org.robovm.bindings.facebook.manager;

import org.robovm.bindings.facebook.manager.request.GraphUser;

public interface FacebookLoginListener extends FacebookListener {
    public void onSuccess (GraphUser result);
}
