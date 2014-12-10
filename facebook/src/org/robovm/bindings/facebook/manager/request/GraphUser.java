
package org.robovm.bindings.facebook.manager.request;

import java.util.List;
import java.util.Map;

import org.robovm.apple.foundation.NSObject;

public class GraphUser extends GraphObject {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String FIRST_NAME = "first_name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String LAST_NAME = "last_name";
    private static final String LINK = "link";
    private static final String USERNAME = "username";
    private static final String BIRTHDAY = "birthday";
    private static final String INSTALLED = "installed";

    public GraphUser () {
    }

    public GraphUser (GraphObject clone) {
        super(clone);
    }

    public GraphUser (List<GraphObject> children) {
        super(children);
    }

    public GraphUser (Map<String, String> parameters) {
        super(parameters);
    }

    public GraphUser (NSObject data) {
        super(data);
    }

    public String getId () {
        return getString(ID);
    }

    public String getName () {
        return getString(NAME);
    }

    public String getFirstName () {
        return getString(FIRST_NAME);
    }

    public String getMiddleName () {
        return getString(MIDDLE_NAME);
    }

    public String getLastName () {
        return getString(LAST_NAME);
    }

    public String getLink () {
        return getString(LINK);
    }

    public String getUsername () {
        return getString(USERNAME);
    }

    public String getBirthday () {
        return getString(BIRTHDAY);
    }

    public boolean hasInstalled () {
        return containsString(INSTALLED);
    }
}
