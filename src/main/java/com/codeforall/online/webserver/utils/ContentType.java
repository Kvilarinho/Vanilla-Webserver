package com.codeforall.online.webserver.utils;

public enum ContentType {

    HTML("text/html; charset=UTF-8"),
    PNG("image/png"),
    ICO("image/x-icon"),
    CSS("text/css; charset=UTF-8");


    private String content;

    ContentType(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
