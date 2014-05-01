
package org.robovm.bindings.facebook.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphObject {
	private List<GraphObject> children = new ArrayList<GraphObject>();
	private Map<String, String> parameters = new HashMap<String, String>();
	private final Map<String, GraphObject> graphParameters = new HashMap<String, GraphObject>();

	public GraphObject () {
	}

	public GraphObject (List<GraphObject> children) {
		this.children = children;
	}

	public GraphObject (Map<String, String> parameters) {
		this.parameters = parameters;
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
