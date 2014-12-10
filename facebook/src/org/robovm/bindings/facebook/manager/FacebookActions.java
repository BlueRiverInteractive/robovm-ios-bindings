
package org.robovm.bindings.facebook.manager;

import org.robovm.bindings.facebook.manager.request.FacebookRequest;
import org.robovm.bindings.facebook.manager.request.FacebookRequestListener;

public interface FacebookActions {
    /** Signs-in the user and requests the specified read permissions.
     * @param permissions The read permissions to request during sign-in.
     * @param allowLoginUI If {@code false} the user will never be prompted to login, instead sign-in will fail.
     * @param listener */
    void login (FacebookPermission[] permissions, boolean allowLoginUI, FacebookLoginListener listener);

    /** Completely signs-out the user. */
    void logout ();

    /** @return {@code true} when the user is signed in, else {@code false}. */
    boolean isLoggedIn ();

    /** Requests the specified publish permissions. Generally you should only request read permissions during sign-in and publish
     * permissions when you need them. For example, request "publish_actions" when you are about to show the feed dialog.
     * @param permissions
     * @param listener */
    void requestPublishPermissions (FacebookPermission[] permissions, FacebookRequestListener listener);

    /** Makes the specified request(s) on the Facebook api. If multiple requests are specified, a batch request will be made (only
     * works for requests without dialog ui).
     * @param requests */
    void request (FacebookRequest... requests);
}
