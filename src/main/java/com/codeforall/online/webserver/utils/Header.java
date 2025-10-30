package com.codeforall.online.webserver.utils;

import java.io.File;

import static com.codeforall.online.webserver.WebServer.FILE_404;

public class Header {

    private String header200;
    private String header404;

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

    public String getHeader200() {
        return header200;
    }

    public String getHeader404() {
        return header404;
    }
}
