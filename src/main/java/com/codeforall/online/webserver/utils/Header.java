package com.codeforall.online.webserver.utils;

import java.io.File;

import static com.codeforall.online.webserver.WebServer.FILE_404;

/**
 * Builds basic HTTP headers for successful (200) and not found (404) responses.
 */
public class Header {

    private String header200;
    private String header404;

    /**
     * Creates headers for a given file based on its MIME type and size.
     *
     * @param file the file to generate headers for
     */
    public Header(File file) {
        String mime = fromFilename(file.getName()).getContent();
        this.header200 = "HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: " + mime + "\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n";
        this.header404 = "HTTP/1.0 404 Not Found\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + FILE_404.length() + "\r\n" +
                "\r\n";
    }

    /**
     * Determines the content type based on a file’s extension.
     *
     * @param fileName name of the file
     * @return the corresponding {@link ContentType}
     */
    private ContentType fromFilename(String fileName) {
        String extension = "";
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot >= 0) {
            extension = fileName.substring(lastDot + 1).toLowerCase();
        }

        switch (extension) {
            case "html":
                return ContentType.HTML;
            case "png":
                return ContentType.PNG;
            case "ico":
                return ContentType.ICO;
            case "css":
                return ContentType.CSS;
            default:
                return ContentType.HTML;
        }
    }

    /** @return HTTP 200 OK header string. */
    public String getHeader200() {
        return header200;
    }

    /** @return HTTP 404 Not Found header string. */
    public String getHeader404() {
        return header404;
    }
}
