package com.codeforall.online.webserver;

import com.codeforall.online.webserver.utils.Header;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.codeforall.online.webserver.WebServer.DOC_ROOT;
import static com.codeforall.online.webserver.WebServer.FILE_404;

/**
 * Handles a single client connection: reads a simple HTTP GET
 * and serves a static file from {@link WebServer#DOC_ROOT}.
 */
public class ClientHandler implements Runnable {

    private final Logger logger;
    private final Socket client;
    private BufferedReader reader;
    private DataOutputStream output;
    private static final int BUF_SIZE = 1024;

    /**
     * @param client client socket connected to the server
     * @param logger shared logger to record events
     */
    public ClientHandler(Socket client, Logger logger) {
        this.client = client;
        this.logger = logger;
    }

    /** Entry point for the worker thread. Closes the socket on exit. */
    @Override
    public void run() {
        logger.log(Level.INFO, "new connection from " + getAddress(client));
        try (Socket s = client) {
            setUpStreams(s);
            dispatch();
        } catch (IOException e) {
            logger.log(Level.WARNING, "client disconnected " + getAddress(client));
        }
    }

    /** Parses the HTTP request and sends either the file or a 404 page. */
    private void dispatch() throws IOException {
        String httpRequest = readHttpRequest();
        if (httpRequest == null || !httpRequest.toUpperCase().startsWith("GET")) {
            return;
        }

        String fileName = extractFileRequested(httpRequest);
        File file = new File(DOC_ROOT, fileName);

        logger.log(Level.INFO, "Request received: " + getFirstLine(httpRequest));

        if (file.exists() && file.isFile()) {
            sendHeader(file);
            sendFile(file);
        } else {
            file = FILE_404;
            logger.log(Level.WARNING, "page not found");
            sendHeader(file);
            sendFile(file);
        }
    }

    /** Reads request headers until the blank line. */
    private String readHttpRequest() throws IOException {
        return reader.lines()
                .takeWhile(line -> !line.isEmpty())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    /** Extracts the path from the request line (e.g., "GET /index.html HTTP/1.1"). */
    private String extractFileRequested(String httpRequest) {
        String firstLine = getFirstLine(httpRequest);
        int first = firstLine.indexOf(' ');
        int second = firstLine.indexOf(' ', first + 1);

        String fileRequested = firstLine.substring(first + 1, second);
        if (fileRequested.equals("/")) fileRequested = "/index.html";
        if (fileRequested.startsWith("/")) fileRequested = fileRequested.substring(1);
        return fileRequested;
    }

    /** Returns the first line of the HTTP request. */
    private String getFirstLine(String httpRequest) {
        return httpRequest.lines().findFirst().orElse("");
    }

    /** Writes the HTTP header (200 or 404) for the given file. */
    private void sendHeader(File file) throws IOException {
        Header header = new Header(file);
        output.writeBytes(file == FILE_404 ? header.getHeader404() : header.getHeader200());
        output.flush();
    }

    /** Streams the file bytes to the client. */
    private void sendFile(File file) throws IOException {
        byte[] buf = new byte[BUF_SIZE];
        try (FileInputStream input = new FileInputStream(file)) {
            int n;
            while ((n = input.read(buf)) != -1) {
                output.write(buf, 0, n);
            }
            output.flush();
        }
    }

    /** Prepares buffered input/output streams for this connection. */
    private void setUpStreams(Socket s) throws IOException {
        reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        output = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
    }

    /** Formats remote address as "ip:port". */
    private String getAddress(Socket client) {
        return client.getInetAddress().getHostAddress() + ": " + client.getPort();
    }
}
