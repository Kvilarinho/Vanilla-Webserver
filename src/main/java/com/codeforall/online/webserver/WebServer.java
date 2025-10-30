package com.codeforall.online.webserver;

import com.codeforall.online.webserver.utils.Header;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private ServerSocket server;
    private Socket client;
    private BufferedReader reader;
    private DataOutputStream output;
    private static final String DOC_ROOT = "src/main/www";
    public static final File FILE_404 = new File(DOC_ROOT, "404.html");
    private Header header;
    private final int BUF_SIZE = 1024;


    public void listen(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Listening at port " + server.getLocalPort());

            while (true) {
                client = server.accept();
                System.out.println("Accepted client: " + client);
                setUpStreams();
                serve();
                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serve() throws IOException {
        String httpRequest = readHttpRequest();

        if (httpRequest == null || !httpRequest.toUpperCase().startsWith("GET")) {
            return;
        }

        String fileName = extractFileRequested(httpRequest);
        File file = new File(DOC_ROOT, fileName);

        if (file.exists() && file.isFile()) {

            sendHeader(file);
            sendFile(file);

        } else {
            file = FILE_404;

            sendHeader(file);
            sendFile(file);
        }
    }

    private String readHttpRequest() throws IOException {

        StringBuilder request = new StringBuilder();
        String requestLine = "";

        while ((requestLine = reader.readLine()) != null && !requestLine.isEmpty()) {
            request.append(requestLine);
            request.append(System.lineSeparator());
        }

        return request.toString();
    }

    private String extractFileRequested(String httpRequest) {
        String[] lines = httpRequest.split(System.lineSeparator());
        String requestedLine = lines[0];

        int first = requestedLine.indexOf(" ");
        int second = requestedLine.indexOf(" ", first + 1);

        String fileRequested = requestedLine.substring(first + 1, second);

        if (fileRequested.equals("/")) {
            fileRequested = "/index.html";
        }

        if (fileRequested.startsWith("/")) {
            fileRequested = fileRequested.substring(1);
        }


        System.out.println(fileRequested);
        return fileRequested;
    }

    private void sendHeader(File file) throws IOException {

        header = new Header(file);
        output.writeBytes(file == FILE_404 ? header.getHeader404() : header.getHeader200());
        output.flush();
    }

    private void sendFile(File file) throws IOException {
        byte[] buf = new byte[BUF_SIZE];
        int bytesRead;
        long total = 0;

        FileInputStream input = new FileInputStream(file);
        while ((bytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, bytesRead);
            total += bytesRead;
        }

        output.flush();

    }

    private void setUpStreams() {
        try {
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
