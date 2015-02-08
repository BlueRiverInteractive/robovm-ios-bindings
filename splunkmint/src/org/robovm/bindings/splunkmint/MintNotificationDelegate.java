
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/** A protocol to conform and be notified when certain actions occur. */
public interface MintNotificationDelegate extends NSObjectProtocol {
    /** Notifies you when cached requests are sent to the server.
     *
     * @param args A LoggedRequestEventArgs instance with information about the request. */
    @Method(selector = "loggedRequestHandled:")
    public void loggedRequestHandled (LoggedRequestEventArgs args);

    /** Notifies you when the network interceptor caches network data.
     *
     * @param networkData The NetworkDataFixture instance. */
    @Method(selector = "networkDataLogged:")
    public void networkDataLogged (NetworkDataFixture networkData);
}
