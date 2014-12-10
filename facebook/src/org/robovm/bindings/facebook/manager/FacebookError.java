
package org.robovm.bindings.facebook.manager;

public class FacebookError {
    private final String message;
    private boolean shouldNotify;

    public FacebookError (String message) {
        this.message = message;
    }

    public FacebookError (String message, boolean shouldNotify) {
        this.message = message;
        this.shouldNotify = shouldNotify;
    }

    /** @return an error message suitable for display to the user. */
    public String getMessage () {
        return message;
    }

    /** @return {@code true} if Facebook recommends displaying the error message to the user, else {@code false}. */
    public boolean shouldNotify () {
        return shouldNotify;
    }
}
