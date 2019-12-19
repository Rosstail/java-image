package org.groupe3;

/**
 * Class that create FilterException
 */
public class FilterException extends Exception {
    public FilterException() {
    }

    /**
     * Method to show message for FilterException
     * @param message
     */
    public FilterException(String message) {
        super(message);
    }

    /**
     * Method to show message and cause for FilterException
     * @param message
     * @param cause
     */
    public FilterException(String message, Throwable cause) {
        super(message, cause);
    }
}

