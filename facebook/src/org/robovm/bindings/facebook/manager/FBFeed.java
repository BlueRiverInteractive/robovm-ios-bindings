
package org.robovm.bindings.facebook.manager;

import java.util.HashMap;

import org.robovm.bindings.facebook.manager.FBFeed.Builder.Parameters;

public class FBFeed {
	private final HashMap<String, String> data;

	private FBFeed (Builder builder) {
		this.data = builder.data;
	}

	public HashMap<String, String> getData () {
		return data;
	}

	public String getMessage () {
		return data.get(Parameters.MESSAGE);
	}

	public String getLink () {
		return data.get(Parameters.LINK);
	}

	public String getPicture () {
		return data.get(Parameters.PICTURE);
	}

	public String getName () {
		return data.get(Parameters.NAME);
	}

	public String getCaption () {
		return data.get(Parameters.CAPTION);
	}

	public String getDescription () {
		return data.get(Parameters.DESCRIPTION);
	}

	public static class Builder {
		private final HashMap<String, String> data;

		protected static class Parameters {
			public static final String MESSAGE = "message";
			public static final String LINK = "link";
			public static final String PICTURE = "picture";
			public static final String NAME = "name";
			public static final String CAPTION = "caption";
			public static final String DESCRIPTION = "description";
		}

		public Builder () {
			data = new HashMap<String, String>();
		}

		public Builder setName (String name) {
			data.put(Parameters.NAME, name);
			return this;
		}

		public Builder setMessage (String message) {
			data.put(Parameters.MESSAGE, message);
			return this;
		}

		public Builder setLink (String link) {
			data.put(Parameters.LINK, link);
			return this;
		}

		public Builder setPicture (String picture) {
			data.put(Parameters.PICTURE, picture);
			return this;
		}

		public Builder setCaption (String caption) {
			data.put(Parameters.CAPTION, caption);
			return this;
		}

		public Builder setDescription (String description) {
			data.put(Parameters.DESCRIPTION, description);
			return this;
		}

		public FBFeed build () {
			return new FBFeed(this);
		}
	}
}
