
package org.robovm.bindings.facebook.manager.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;

public class GraphObject {
    private List<GraphObject> children = new ArrayList<>();
    private Map<String, String> parameters = new HashMap<>();
    private Map<String, GraphObject> graphParameters = new HashMap<>();

    public GraphObject () {
    }

    public GraphObject (GraphObject clone) {
        this.children = clone.children;
        this.parameters = clone.parameters;
        this.graphParameters = clone.graphParameters;
    }

    public GraphObject (List<GraphObject> children) {
        this.children = children;
    }

    public GraphObject (Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @SuppressWarnings("unchecked")
    public GraphObject (NSObject data) {
        if (data instanceof NSArray) {
            NSArray<NSObject> arrayData = (NSArray<NSObject>)data;
            List<GraphObject> children = new ArrayList<GraphObject>();
            for (NSObject entryData : arrayData) {
                children.add(new GraphObject(entryData));
            }
            addChildren(children);
        } else {
            Map<String, String> convertedParams = new HashMap<String, String>();
            NSDictionary<NSObject, NSObject> parameters = (NSDictionary<NSObject, NSObject>)data;
            for (Entry<NSObject, NSObject> entry : parameters.entrySet()) {
                String key = String.valueOf(entry.getKey());
                if (entry.getValue() instanceof NSArray || entry.getValue() instanceof NSDictionary
                    || entry.getValue() instanceof NSMutableDictionary) {
                    addGraphParameter(key, new GraphObject(entry.getValue()));
                } else if (entry.getValue() instanceof NSString && entry.getValue().toString().contains("{")) {
                    String v = entry.getValue().toString();
                    v = v.substring(1, v.length() - 1);
                    String[] values = v.split(",");

                    Map<String, String> p = new HashMap<String, String>();
                    for (String value : values) {
                        value = value.trim();
                        String[] kv = value.split(":");
                        kv[0] = kv[0].replace("\"", "");
                        kv[1] = kv[1].replace("\"", "");
                        p.put(kv[0], kv[1]);
                    }
                    addGraphParameter(key, new GraphObject(p));
                } else {
                    convertedParams.put(key, String.valueOf(entry.getValue()));
                }
            }
            addParameters(convertedParams);
        }
    }

    public void addParameter (String key, String value) {
        parameters.put(key, value);
    }

    public void addParameters (Map<String, String> parameters) {
        this.parameters.putAll(parameters);
    }

    public void addChild (GraphObject child) {
        children.add(child);
    }

    public void addChildren (List<GraphObject> children) {
        this.children.addAll(children);
    }

    public void addGraphParameter (String key, GraphObject value) {
        graphParameters.put(key, value);
    }

    public void addGraphParameters (Map<String, GraphObject> parameters) {
        graphParameters.putAll(parameters);
    }

    public String getString (String key) {
        if (!parameters.containsKey(key)) return null;
        return parameters.get(key);
    }

    public GraphObject getGraph (String key) {
        if (!graphParameters.containsKey(key)) return null;
        return graphParameters.get(key);
    }

    public boolean containsString (String key) {
        return parameters.containsKey(key);
    }

    public boolean containsGraph (String key) {
        return graphParameters.containsKey(key);
    }

    public List<GraphObject> getChildren () {
        return children;
    }

    @Override
    public String toString () {
        if (parameters.size() > 0) {
            if (graphParameters.size() > 0) return "{" + parameters.toString() + "," + graphParameters.toString() + "}";
            return parameters.toString();
        }
        return children.toString();
    }
}
