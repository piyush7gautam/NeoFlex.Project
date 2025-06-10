# NeoFlex.Project
A movie recommendation System
# 🎬 NeoFlex - Movie Recommendation System

NeoFlex is a simple and elegant web-based movie recommendation system built using **JSP, Servlets**, and **JDBC**. It allows users to register, log in, and get personalized movie recommendations based on their selected genre.

---

## 🚀 Features

- ✅ User Registration and Login
- 🎞️ Genre-based Movie Recommendations (Action, Horror, Sci-Fi, etc.)
- 🖼️ Movie posters with ratings
- 📦 MVC architecture using Java Servlets and JSP
- 🔐 Basic input validation and session handling
- 🗃️ MySQL database connectivity using JDBC

---

## 🧰 Tech Stack

| Technology   | Role                    |
|--------------|-------------------------|
| Java (Servlets, JSP) | Backend logic         |
| HTML/CSS     | Frontend UI              |
| JDBC + MySQL | Database connection      |
| Apache Tomcat | Web server deployment   |
| Maven        | Project build management |

---

## 🛠️ Setup Instructions

### 1. 📂 Clone the Project
```bash
git clone https://github.com/your-username/NeoFlex.Project.git
NeoFlex/
│
├── src/main/java/com/neoflex/
│   ├── model/         # Movie and User model classes
│   ├── servlet/       # Login, Register, and Recommend servlets
│   └── dao/           # DBConnection class
│
├── src/main/webapp/
│   ├── index.jsp      # Welcome screen
│   ├── login.jsp      # Login page
│   ├── register.jsp   # Register page
│   ├── home.jsp       # Home after login
│   └── recommend.jsp  # Movie recommendations
│
├── create_tables.sql  # SQL script to create DB
└── pom.xml            # Maven dependencies
Details of the Project:
### 🔍 How the NeoFlex Movie Recommendation System Works

NeoFlex is a full-stack web application developed using Java EE technologies like JSP, Servlets, and JDBC, aimed at recommending movies based on user-selected genres. The project follows the MVC (Model-View-Controller) design pattern, separating the presentation, business logic, and data access layers to ensure clean, maintainable code.

#### 🔐 User Registration & Authentication

The application begins with a landing page (`index.jsp`) that links to both the **Register** and **Login** interfaces. When a new user registers via `register.jsp`, their input (username, email, password) is collected and sent via an HTTP POST request to the `RegisterServlet`. Here, the data is validated to ensure no fields are empty and the email is in a valid format. The servlet then establishes a JDBC connection to a MySQL database and inserts the user details into the `users` table. If the username or email already exists, an error message is shown.

During login (`login.jsp`), the user submits their credentials, which are passed to the `LoginServlet`. This servlet checks the entered credentials against those stored in the `users` table. If the match is successful, the servlet stores the username in an HTTP session and redirects the user to `home.jsp`. Otherwise, an appropriate error message is shown on the login page.

#### 🧠 Session Handling & Access Control

NeoFlex uses session management to secure private pages. Every protected JSP page (like `home.jsp` and `recommend.jsp`) includes logic to check if the session contains an active user. If not, the user is redirected back to the login page, thus preventing unauthorized access and session hijacking.

#### 🎞️ Genre Selection & Movie Recommendations

On the home page (`home.jsp`), the logged-in user is welcomed with a greeting and a genre selection interface. When a genre is selected (such as Action, Horror, or Sci-Fi), a POST request is sent to the `RecommendServlet`. This servlet is preloaded (during `init()`) with a hardcoded list of `Movie` objects mapped by genre. Alternatively, this can be extended to dynamically fetch movie data from a `movies` table in the database using JDBC.

The selected genre is used to fetch the corresponding movie list, which is stored in a request attribute and forwarded to `recommend.jsp`. This JSP then loops through the list using JSTL or scriptlets to display each movie's poster, title, genre, and rating in a styled card format.

#### 🗃️ Database Design

The MySQL database contains two main tables:

* `users`: Stores registered user data (username, email, password).
* `movies`: Optionally stores movies with fields like title, genre, rating, and image URL (used if dynamic loading is implemented).

A JDBC utility class `DBConnection` handles the connection logic, using MySQL’s JDBC driver with proper exception handling and logging. All SQL queries use `PreparedStatement` to prevent SQL injection.

#### 🎨 Frontend & UI

All frontend pages use HTML and CSS embedded in JSP for consistent design. Background images, modern fonts, and flexbox layouts are used for aesthetic appeal. Each page is responsive and visually aligned with streaming platforms like Netflix. CSS styling is kept in-line for simplicity but can be modularized.

#### 🛡️ Validation & Error Handling

Both client-side (via HTML `required` attributes) and server-side validation are implemented to ensure robust data entry. For instance, empty fields are rejected on the server, and informative error messages are displayed if login fails or registration data is invalid. Session-based access control enhances security.

---

### ✅ Summary

In short, NeoFlex offers a structured and interactive movie recommendation experience where:

* Users register and log in securely.
* Sessions protect restricted content.
* Recommendations are personalized based on genre.
* Data is handled safely with validation and JDBC integration.
* The application delivers a visually appealing and functional movie portal.

---

Images of the Work:
Index Page
![Screenshot 2025-06-10 100804](https://github.com/user-attachments/assets/73d55232-12fa-4ba4-945e-6eb472f52b30)
Login Page
![Screenshot 2025-06-10 100829](https://github.com/user-attachments/assets/bd53334a-4bf4-4596-a150-8ec4c60d8f05)
Home Page
![Screenshot 2025-06-10 100841](https://github.com/user-attachments/assets/06df6634-4fe7-4fbb-a22f-56da14d11b27)
Recommendation Page
![Screenshot 2025-06-10 100858](https://github.com/user-attachments/assets/4c829549-47bc-480a-94d2-c302a610e81b)



Future Improvements
Add movie rating and bookmarking feature

Implement password encryption (e.g., BCrypt)

Store movie data dynamically in DB instead of hardcoded lists

Mobile responsive design


---

### ✅ Ready to Use

You can copy and save this file as `README.md` in your project root. Let me know if you’d like me to embed screenshots or generate an HTML version for hosting on GitHub Pages.
