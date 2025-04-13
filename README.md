# **Runnerz**

**Runnerz – A Spring Boot 3 web application for tracking and saving user runs.** Implements full **CRUD operations** with **REST APIs**, using **HikariCP** and an **in-memory database** for development, and **PostgreSQL via Docker** in production.

---

**Key Features:**

• **Record Runs:** Users can save details such as distance, time, and date for each run.  
• **View Past Runs:** A history of all the runs recorded is available for users to track progress.  
• **Modify Runs:** Edit previously recorded runs to update details or add notes.  
• **Delete Runs:** Remove unwanted or incorrect records from the database.  

---

**Technologies Used:**

• **Backend:** Java, Spring Boot 3  
• **Database:** PostgreSQL (Production) with HikariCP connection pooling  
• **API:** RESTful API for CRUD operations  
• **Containerization:** Docker for easy deployment and scalability  
• **Development Database:** In-memory database for fast iteration during development  

---

**How It Works:**

The application uses **Spring Boot** to create a backend server with endpoints that allow users to interact with their running data.  
Data is stored in **PostgreSQL**, ensuring reliable persistence.  
**Docker** is used to containerize the entire application, including the database, for seamless deployment.

---

**API Endpoints:**

• **POST /runs:** Create a new run record.  
• **GET /runs:** Retrieve all run records.  
• **PUT /runs/{id}:** Update an existing run record.  
• **DELETE /runs/{id}:** Delete a specific run record.  
