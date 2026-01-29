# Vanilla Web Server

A simple multithreaded **HTTP web server** built entirely in **Java**, designed to provide a clear understanding of low-level client-server communication and the HTTP protocol.

The server listens for incoming connections and serves static resources from the `src/main/www` directory, using a **fixed thread pool** to handle multiple clients concurrently.


---

## Features
- Handles multiple client connections concurrently using `ExecutorService`
- Parses basic HTTP `GET` requests
- Serves static resources (`.html`, `.css`, `.js`, `.png`, `.ico`)
- Supports **JavaScript ES modules** with correct MIME types
- Automatically determines `Content-Type` via a dedicated `ContentType` enum
- Ignores query strings when resolving filesystem paths
- Returns a custom **404.html** page when resources are not found
- Clean, well-documented codebase with **Javadoc** and clear separation of concerns

---

## Project Structure

```
Vanilla-Webserver/
├─ src/
│  └─ main/
│     ├─ java/
│     │  └─ com/codeforall/online/webserver/
│     │     ├─ WebServer.java
│     │     ├─ ClientHandler.java
│     │     └─ utils/
│     │        ├─ Header.java
│     │        └─ ContentType.java
│     └─ www/
│        ├─ assets/
│        │  ├─ css/
│        │  │  └─ styles.css
│        │  ├─ js/
│        │  │  ├─ script.js
│        │  │  ├─ project.js
│        │  │  └─ data/
│        │  │     └─ projects.js
│        │  └─ img/
│        │     ├─ avatar.png
│        │     ├─ avatar-logo.png
│        │     └─ projects/
│        │        ├─ bullseye/
│        │        │  └─ bullseye.jpeg
│        │        ├─ concurrent-tcp-chatserver/
│        │        │  └─ concurrent-tcp-chatserver.jpeg
│        │        ├─ portfolio-website/
│        │        │  └─ portfolio-website.png
│        │        ├─ task-manager/
│        │        │  └─ task-manager.jpeg
│        │        └─ vanilla-webserver/
│        │           └─ vanilla-webserver.jpeg
│        ├─ index.html
│        ├─ project.html
│        ├─ 404.html
│        └─ favicon.ico
├─ images/
│  └─ webserver_running.png
└─ README.md
```

---

## How to Run

1. **Compile** the project (e.g., in IntelliJ or using Maven).  
2. **Run** the `Main` class:
   ```bash
   java com.codeforall.online.webserver.Main
   ```
3. Open your browser and visit:  
   👉 [http://localhost:9001](http://localhost:9001)

---

## Example Console Output

```
INFO: Listening at port 9001
INFO: new connection from 127.0.0.1:54328
INFO: Request received: GET /index.html HTTP/1.1
```

---

## Screenshot
![WebServer Running](images/webserver_running.png)

---

## Technologies Used
- Java 17 
- Java Networking (Sockets)
- Concurrency (`ExecutorService`)  
- Java I/O  
- Stream API  
- Logging (`java.util.logging`)

---

## What I Learned

Building this project from scratch gave me a deeper understanding of how web
servers work at a low level, beyond using frameworks.

Through this project, I learned:

- How HTTP requests are structured and how to manually parse request lines
- The importance of separating URL paths from query strings when resolving files
- How browsers depend on correct MIME types, especially for JavaScript ES modules
- How to serve different types of static resources (`HTML`, `CSS`, `JS`, images)
- How to handle multiple client connections using a fixed thread pool
- How to structure a clean and maintainable backend without relying on frameworks
- Why higher-level frameworks abstract many of these concerns and when they become valuable

---

## Author
**Kátia Vilarinho**  
Developed as part of a Java Full-Stack Bootcamp (Code For All_).

---

*"Simple, clean, and built from scratch — a true vanilla web server."*
