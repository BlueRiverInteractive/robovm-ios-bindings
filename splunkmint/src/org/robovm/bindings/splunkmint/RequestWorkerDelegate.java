
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface RequestWorkerDelegate extends NSObjectProtocol {
    @Method(selector = "loggedRequestHandledWithEventArgs:")
    public void loggedRequestHandled (LoggedRequestEventArgs args);

    @Method(selector = "pingEventCompletedWithResponse:")
    public void pingEventCompleted (MintResponseResult splunkResponseResult);

    @Method(selector = "networkDataLogged:")
    public void networkDataLogged (NetworkDataFixture networkData);
}
