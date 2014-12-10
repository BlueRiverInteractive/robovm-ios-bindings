
package org.robovm.bindings.facebook.manager.request;

import java.util.Map;

public class FacebookRequest {
    private String api;
    private Map<String, String> parameters;
    private String httpMethod;
    private boolean useDialog;
    private FacebookRequestListener listener;

    public FacebookRequest () {
    }

    /** Construct a new Facebook request.
     * @param api The Facebook graph api to use. For example: "apprequests", "me/friends"
     * @param parameters Additional parameters for the request.
     * @param httpMethod Either "GET", "POST" or "PUT".
     * @param useDialog Whether to prompt the user or not.
     * @param listener The listener will be invoked onSuccess(GraphObject), onError(String), onCancel(). */
    public FacebookRequest (String api, Map<String, String> parameters, String httpMethod, boolean useDialog,
        FacebookRequestListener listener) {
        this.api = api;
        this.parameters = parameters;
        this.httpMethod = httpMethod;
        this.useDialog = useDialog;
        this.listener = listener;
    }

    public String getApi () {
        return api;
    }

    public Map<String, String> getParameters () {
        return parameters;
    }

    public String getHttpMethod () {
        return httpMethod;
    }

    public boolean isUseDialog () {
        return useDialog;
    }

    public FacebookRequestListener getListener () {
        return listener;
    }

    public void setListener (FacebookRequestListener listener) {
        this.listener = listener;
    }

    @Override
    public String toString () {
        return "FacebookRequest: " + api + " (" + httpMethod + ")";
    }
}
