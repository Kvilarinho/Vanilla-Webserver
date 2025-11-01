package com.codeforall.online.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServer {

    private ServerSocket server;
    public static final String DOC_ROOT = "src/main/www";
    public static final File FILE_404 = new File(DOC_ROOT, "404.html");
    private static final Logger LOGGER = Logger.getLogger(WebServer.class.getName());
    private static final int MAXIMUM_CLIENTS = 306;
    private final ExecutorService threadPool = Executors.newFixedThreadPool(MAXIMUM_CLIENTS);

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

    private void serve(ServerSocket server) throws IOException {

        while (true) {
            Socket client = server.accept();
            threadPool.submit(new ClientHandler(client, LOGGER));
        }
    }
}