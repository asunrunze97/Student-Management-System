# Student-Management-System
a web-based Student Management System using Java, JSP, JDBC, and MySQL.

# Project Setup Instructions

1. Unzip `Project3.zip` and place the `Project3` folder into the Tomcat directory `/webapps`.
2. Open a terminal and navigate to the Tomcat directory `/webapps/Project3`.
3. You should now be in the `Project3` root folder.
4. Run the following command to compile all Java files:
    ```sh
    javac -cp .\WEB-INF\lib\* -d .\WEB-INF\classes .\WEB-INF\src\*.java
    ```
    This will create `.class` files in the `WEB-INF\classes` folder.
5. Start the Tomcat server by running:
    ```sh
    path_to_tomcat\bin\startup.bat
    ```
6. Open a browser and go to `http://localhost:8080/Project3` (replace `8080` with your port number). The `index.jsp` page should be displayed.

## Assumptions and Design Decisions

- All servers are running on localhost.
- JDK version is above 16 (Java Text Blocks are used in the code).
- Tomcat version is 10.
- Browser has JavaScript enabled (viewStudent.jsp uses AJAX calls).
- `database.properties` file contains valid database credentials.
- All servlets are annotated with `@WebServlet`.
- Two JAR files are included in `Project3/WEB-INF/lib` (`mysql-connector-j-9.0.0.jar` and `servlet-api.jar`). These are needed to build and run the project.
- MySQL is running on port 3306.
  - It has a database named `student_db`.
  - It has a table named `students` with columns `id`, `name`, and `email`.
- Tomcat is running on port 8080.

## Challenges Faced and How They Were Overcome

- **From using an IDE to manually setting up the project on the Tomcat server.**
  - **Solution:** Followed the setup instructions and sought help from the professor.
  
- **Learning Maven as a build tool.**
  - **Solution:** Watched YouTube tutorials but eventually gave up on Maven and manually set up the project.

- **Issues caused by linking the IDE to the Tomcat server.**
  - **Solution:** The automatically generated project folder by the IDE conflicted with the manual setup, especially with the database connection. Reinstalled the Tomcat server and rebuilt the project without any IDE.

## Sample Execution

(To be filled with actual screenshots and detailed descriptions of sample runs)
