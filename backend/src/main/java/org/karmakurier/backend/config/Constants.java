package org.karmakurier.backend.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String DEFAULT_LANGUAGE = "de";
    public static final String ANONYMOUS_USER = "anonymoususer";

    private Constants() {
    }
}
