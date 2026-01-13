package com.codeforall.online.webserver.utils;

/**
 * Enumeration of supported MIME content types for HTTP responses.
 * <p>
 * Each enum constant stores the corresponding MIME type string.
 */
public enum ContentType {

    /** HTML document type. */
    HTML("text/html; charset=UTF-8"),

    /** PNG image type. */
    PNG("image/png"),

    /** ICO (favicon) image type. */
    ICO("image/x-icon"),

    /** CSS stylesheet type. */
    CSS("text/css; charset=UTF-8"),

    /** Javascript document type **/
    JS("application/javascript; charset=UTF-8");

    private final String content;

    /**
     * Creates a new ContentType with its MIME string.
     *
     * @param content the MIME type string
     */
    ContentType(String content) {
        this.content = content;
    }

    /**
     * Returns the MIME type string of this content type.
     *
     * @return the MIME type as a String
     */
    public String getContent() {
        return content;
    }
}
