package com.codeforall.online.webserver;

/**
 * Entry point for starting the WebServer.
 * <p>
 * Launches the server and listens for incoming connections on port 9001.
 */
public class Main {

    /**
     * Starts the WebServer on port 9001.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new WebServer().listen(9001);
    }
}
