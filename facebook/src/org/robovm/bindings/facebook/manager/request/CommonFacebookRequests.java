
package org.robovm.bindings.facebook.manager.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.robovm.bindings.facebook.HttpMethod;
import org.robovm.bindings.facebook.manager.FacebookError;
import org.robovm.bindings.facebook.manager.FacebookListener;
import org.robovm.bindings.facebook.manager.FacebookPermission;

/** Helper class to create most common Facebook requests. */
public final class CommonFacebookRequests {
    private CommonFacebookRequests () {
    }

    public interface FacebookGrantedPermissionsRequestListener extends FacebookListener {
        void onSuccess (List<FacebookPermission> result);
    }

    public static FacebookRequest requestGrantedPermissions (final FacebookGrantedPermissionsRequestListener listener) {
        if (listener == null) throw new NullPointerException("listener");
        return new FacebookRequest("me/permissions", null, HttpMethod.GET, false, new FacebookRequestListener() {
            @Override
            public void onSuccess (org.robovm.bindings.facebook.manager.request.GraphObject result) {
                List<FacebookPermission> list = new ArrayList<>();
                List<GraphObject> permissions = result.getChildren();
                for (GraphObject permission : permissions) {
                    if (permission.getString("status").equals("granted")) {
                        list.add(FacebookPermission.fromName(permission.getString("permission")));
                    }
                }

                listener.onSuccess(list);
            }

            @Override
            public void onCancel () {
                listener.onCancel();
            }

            @Override
            public void onError (FacebookError error) {
                listener.onError(error);
            }
        });
    }

    public interface FacebookFriendsRequestListener extends FacebookListener {
        void onSuccess (List<GraphUser> friends);
    }

    public static FacebookRequest requestFriends (FacebookFriendsRequestListener listener) {
        return requestFriends("me", new String[] {"installed", "name"}, listener);
    }

    public static FacebookRequest requestFriends (String id, String[] fields, final FacebookFriendsRequestListener listener) {
        if (id == null) throw new NullPointerException("id");
        if (listener == null) throw new NullPointerException("listener");
        Map<String, String> parameters = new HashMap<String, String>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i < fields.length - 1) sb.append(',');
        }
        parameters.put("fields", sb.toString());

        return new FacebookRequest(id + "/friends", parameters, HttpMethod.GET, false, new FacebookRequestListener() {
            @Override
            public void onSuccess (GraphObject result) {
                List<GraphUser> list = new ArrayList<>();
                List<GraphObject> friends = result.getChildren();

                for (GraphObject friend : friends) {
                    list.add(new GraphUser(friend));
                }
                listener.onSuccess(list);
            }

            @Override
            public void onError (FacebookError error) {
                listener.onError(error);
            }

            @Override
            public void onCancel () {
                listener.onCancel();
            }

        });
    }

// TODO listeners
    public static FacebookRequest requestAppRequests (FacebookRequestListener listener) {
        return new FacebookRequest("/me/apprequests", null, HttpMethod.GET, false, listener);
    }

    public static FacebookRequest publishFeed (String name, String caption, String description, String message,
        String pictureUrl, String link, boolean showDialog, FacebookRequestListener listener) {
        HashMap<String, String> parameters = new HashMap<String, String>();
        if (name != null) parameters.put("name", name);
        if (caption != null) parameters.put("caption", caption);
        if (description != null) parameters.put("description", description);
        if (message != null) parameters.put("message", message);
        if (pictureUrl != null) parameters.put("picture", pictureUrl);
        if (link != null) parameters.put("link", link);

        return new FacebookRequest("me/feed", parameters, HttpMethod.POST, showDialog, listener);
    }

    public static FacebookRequest invite (String title, String message, List<String> invitedIds, FacebookRequestListener listener) {
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("title", title);
        parameters.put("message", message);
        parameters.put("frictionless", "1");

        if (invitedIds.size() > 1) {
            StringBuilder sb = new StringBuilder();
            int max = Math.min(50, invitedIds.size()); // The maximum allowed invites are 50.

            for (int i = 0; i < max; i++) {
                sb.append(invitedIds.get(i));
                if (i < max - 1) sb.append(",");
            }
            parameters.put("suggestions", sb.toString());
        } else if (invitedIds.size() == 1) {
            parameters.put("to", invitedIds.get(0));
        }
        return new FacebookRequest("apprequests", parameters, HttpMethod.POST, true, listener);
    }
}
