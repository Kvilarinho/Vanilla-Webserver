package com.codeforall.online.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple multithreaded HTTP web server.
 * <p>
 * Listens for client connections on a given port and handles basic HTTP GET
 * requests, serving static resources from {@link #DOC_ROOT}. Requested paths
 * are resolved against the document root, query strings are ignored for
 * file resolution, and appropriate Content-Type headers and HTTP status
 * codes are returned.
 *
 * Each client connection is processed by a {@link ClientHandler} running
 * in a separate thread from a thread pool.
 */

public class WebServer {

    /** Server socket that listens for incoming connections. */
    private ServerSocket server;

    /** Root directory containing files to serve. */
    public static final String DOC_ROOT = "src/main/www";

    /** File returned when a requested resource is not found. */
    public static final File FILE_404 = new File(DOC_ROOT, "404.html");

    private static final Logger LOGGER = Logger.getLogger(WebServer.class.getName());

    /** Maximum number of concurrent clients allowed. */
    private static final int MAXIMUM_CLIENTS = 306;

    /** Thread pool for handling multiple client connections simultaneously. */
    private final ExecutorService threadPool = Executors.newFixedThreadPool(MAXIMUM_CLIENTS);

    /**
     * Starts the server and begins listening for incoming client connections.
     *
     * @param port TCP port number on which the server will listen
     */
    public void listen(int port) {

        try {

            server = new ServerSocket(port);
            LOGGER.log(Level.INFO,"Listening at port " + port);

            serve(server);

        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, "could not bind to port: " + port);
            LOGGER.log(Level.SEVERE, e.getMessage());
            System.exit(1);

        } finally {
            threadPool.shutdown();
        }
    }

    /**
     * Accepts client connections and assigns each to a worker thread.
     *
     * @param server the server socket accepting incoming connections
     * @throws IOException if an error occurs while accepting connections
     */
    private void serve(ServerSocket server) throws IOException {

        while (true) {
            Socket client = server.accept();
            threadPool.submit(new ClientHandler(client, LOGGER));
        }
    }
}
