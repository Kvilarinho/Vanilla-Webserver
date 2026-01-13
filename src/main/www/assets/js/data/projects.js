const bullseye = {
    title: "Bullseye",
    images: {
        cover: "assets/img/projects/bullseye/bullseye.jpeg"
    },
    longDescription: {
        intro: "Developed collaboratively in a team of four, Bullseye is a 2D arcade-style game built in Java using the SimpleGraphics library. The player controls an archer, shooting arrows at a moving target while avoiding obstacles and maximizing score.",
        features: [
            "Player movement and shooting mechanics controlled by keyboard inputs",
            "Randomized arrow types with different speed and score variations",
            "Dynamic target and obstacle spawning",
            "Real-time score tracking and game-over logic",
            "Object-oriented architecture using inheritance, composition, and enums"
        ],
        architecture: "The game follows a clean object-oriented design, making extensive use of inheritance and composition to model game entities. Enums are used for configuration and state management, and factory patterns are applied to handle object creation and variation logic.",
        collaboration: "This project strengthened my teamwork, version control, and problem-solving skills. We collaborated using Git and GitHub, dividing responsibilities across gameplay logic, graphics, and scoring systems, closely simulating a real-world software development workflow."
    },
    technologies: [
        "Java",
        "SimpleGraphics Library",
        "Object-Oriented Programming (OOP)",
        "Design Patterns (Factory, Enum-based configuration)",
        "Git & GitHub",
        "IntelliJ IDEA"
    ],
    github: "https://github.com/AlienGamer29/Bullseye"
};

const vanilla = {
    title: "Vanilla HTTP Web Server",
    images: {
        cover: "assets/img/projects/vanilla-webserver/vanilla-webserver.jpeg"
    },
    longDescription: {
        intro: "I built a simple HTTP Web Server in Java from scratch to gain a deep understanding of low-level client-server communication and how the HTTP protocol works internally. The server processes incoming requests directly using Java sockets, without relying on external frameworks.",

        features: [
            "Manual processing of HTTP GET requests using Java Sockets",
            "Serving static files (HTML and CSS) directly from a local directory",
            "Support for common HTTP status codes such as 200 OK, 404 Not Found, and 500 Internal Server Error",
            "Sequential handling of multiple client requests with proper stream and resource management",
            "Minimal and clean architecture focused on readability and core networking concepts"
        ],

        architecture: "The server is built around Java’s low-level networking APIs, handling raw TCP connections and parsing HTTP requests manually. Input and output streams are carefully managed to read client requests and construct valid HTTP responses, reinforcing a strong understanding of request/response lifecycles and protocol structure.",

        learningOutcome: "This project provided a solid foundation in how web servers operate behind the scenes — from socket management and request parsing to response generation. It served as a stepping stone toward more advanced Java web technologies such as Servlets, Spring Boot, and the MVC architectural pattern."
    },

    technologies: [
        "Java",
        "TCP/IP & HTTP Protocols",
        "Java Sockets API",
        "I/O Streams",
        "Maven"
    ],

    github: "https://github.com/Kvilarinho/Vanilla-WebServer"
};

const concurrentTcp = {
    title: "Concurrent TCP Chat",
    images: {
        cover: "assets/img/projects/concurrent-tcp-chatserver/concurrent-tcp-chatserver.jpeg"
    },
    longDescription: {
        intro: "Concurrent TCP Chat is a multi-client chat system built entirely in Java, designed to explore low-level networking, concurrency, and clean architecture principles. The system consists of a TCP server capable of handling multiple simultaneous clients and a terminal-based client that supports real-time messaging and command-based interaction.",

        features: [
            "Concurrent TCP Chat Server supporting multiple clients simultaneously",
            "Thread pool-based concurrency model for efficient client handling",
            "Terminal-based client with real-time message input and output",
            "Private messaging between users via /whisper command",
            "Dynamic username management using /name command",
            "Admin authentication with restricted commands and secure server shutdown",
            "Command handling implemented using the Strategy Pattern",
            "Graceful client connection, disconnection, and error handling"
        ],

        architecture: "The server architecture is built around Java sockets and a thread pool executor, ensuring controlled concurrency and efficient resource usage. Client commands are handled using the Command Strategy Pattern, allowing for clean separation of concerns and easy extensibility. Each command is encapsulated as an independent strategy, improving maintainability and readability of the codebase.",

        testingAndDocs: "The project includes unit tests written with JUnit 4 and Mockito, focusing on command logic and core server behavior. Comprehensive Javadoc and detailed documentation were added to ensure clarity, maintainability, and ease of onboarding for future contributors.",

        learningOutcome: "This project significantly strengthened my understanding of socket programming, concurrent systems, thread management, and clean code practices. It also reinforced the importance of architectural decisions when building scalable, maintainable networked applications."
    },

    technologies: [
        "Java",
        "TCP/IP",
        "Java Sockets API",
        "Concurrency & Thread Pools",
        "Command Strategy Pattern",
        "JUnit 4",
        "Mockito",
        "Javadoc"
    ],

    github: "https://github.com/Kvilarinho/Concurrent-TCP-ChatServer"
};

const taskManager = {
    title: "Task Manager (CLI)",
    images: {
        cover: "assets/img/projects/task-manager/task-manager.jpeg"
    },
    longDescription: {
        intro: "Task Manager is a command-line application developed entirely in Java, designed to manage daily tasks directly from the terminal with automatic file-based persistence. The application focuses on clean object-oriented design and practical backend concepts rather than graphical interfaces.",

        features: [
            "Add, list, complete, and delete tasks via terminal commands",
            "Persistent storage using text files (tasks.dat) to retain data between sessions",
            "Automatic save mechanism to ensure task data is never lost",
            "Command-based architecture implemented using the Strategy Pattern (Map<Command, Function>)",
            "Robust error handling for invalid inputs, missing tasks, and edge cases"
        ],

        architecture: "The application follows core object-oriented design principles such as modularity, separation of concerns, and single responsibility. Each command is encapsulated as an independent strategy, enabling clean command execution flow and easy extensibility. Collections and Java Streams are used to efficiently manage and process task data.",

        learningOutcome: "This project strengthened my understanding of file I/O, class design, and architectural patterns in Java. It also served as a foundation for more advanced backend development, including MVC-based applications and database-backed systems."
    },

    technologies: [
        "Java",
        "Object-Oriented Programming (Encapsulation, Inheritance, Composition)",
        "Collections (Map, List)",
        "Streams API",
        "File I/O",
        "Maven"
    ],

    github: "https://github.com/Kvilarinho/Task-Manager"
};

const portfolioWebsite = {
    title: "Personal Portfolio Website",
    images: {
        cover: "assets/img/projects/portfolio-website/portfolio-website.png"
    },
    longDescription: {
        intro: "This personal portfolio website was designed and developed from scratch to showcase my projects, skills, and technical journey as a software developer. The site focuses on clean structure, maintainability, and scalability, rather than relying on heavy frameworks.",

        features: [
            "Project listing page with short descriptions and navigation to detailed project pages",
            "Dynamic project details rendered from structured JavaScript data",
            "Reusable project template shared across all detailed pages",
            "Clean and modular JavaScript architecture separating data, rendering logic, and page control",
            "Responsive layout optimized for desktop and mobile devices"
        ],

        architecture: "The website follows a modular, data-driven approach. All project information is centralized in a single data file, while rendering logic is handled by reusable functions. URL parameters are used to dynamically load project details, avoiding content duplication and improving maintainability. This structure allows new projects to be added with minimal changes to the codebase.",

        learningOutcome: "Building this website strengthened my understanding of frontend fundamentals, DOM manipulation, modular JavaScript architecture, and clean separation of concerns. It also provided hands-on experience in designing scalable project structures suitable for long-term portfolio growth."
    },
    technologies: [
        "HTML5",
        "CSS3",
        "JavaScript",
        "Responsive Design",
        "Git & GitHub",
        "GitHub Pages"
    ],
    github: "https://github.com/Kvilarinho/kvilarinho.github.io"
};


export const projects = {
    bullseye,
    vanilla,
    concurrentTcp,
    taskManager,
    portfolioWebsite
};

