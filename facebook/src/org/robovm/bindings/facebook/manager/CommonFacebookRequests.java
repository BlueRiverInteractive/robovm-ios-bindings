
package org.robovm.bindings.facebook.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.robovm.bindings.facebook.HttpMethod;

/** Helper class to create most common Facebook requests. */
public final class CommonFacebookRequests {
	private CommonFacebookRequests () {
	}

	public static FacebookRequest getFriends (FacebookRequestListener listener) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("fields", "installed,name");

		return new FacebookRequest("me/friends", parameters, HttpMethod.GET, false, listener);
	}

	public static FacebookRequest getPendingAppRequest (FacebookRequestListener listener) {
		return new FacebookRequest("/me/apprequests", null, HttpMethod.GET, false, listener);
	}

	public static FacebookRequest publishFeed (String name, String caption, String description, String message, String pictureUrl,
		String link, boolean showDialog, FacebookRequestListener listener) {
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
			int max = Math.min(50, invitedIds.size());

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
