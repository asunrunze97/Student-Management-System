- Setup instructions
    unzip Project3.zip and put Project3 folder into tomcat directory /webapps
    open a terminal and navigate to tomcat directory /webapps/Project3
    now we are at Project3 root folder
    run "javac -cp .\WEB-INF\lib\* -d .\WEB-INF\classes .\WEB-INF\src\*.java" to compile all java files
    it will create .class files in WEB-INF\classes folder
    then run "path_to_tomcat\bin\startup.bat" to start tomcat server
    then open a browser and type http://localhost:8080/Project3  (replace 8080 with your port number)
    then the index.jsp page will be displayed

- Any assumptions or design decisions you made
    all server are running on localhost

    jdk version is above 16 (Java Text Blocks is used in the code)

    tomcat version is 10

    browser enabled javascript (viewStudent.jsp used for make the ajax call)

    database.properties file with valid database credentials

    all servlets are used with annotated with @WebServlet

    two jar files are included in Project3/WEB-INF/lib ("mysql-connector-j-9.0.0.jar" and "servlet-api.jar") those are needed to build the project and running

    mysql is running on port 3306
        it has a database named "student_db"
        it has a table named "students" with columns "id", "name" and "email"

    tomcat is running on port 8080

- Challenges faced and how you overcame them
    from using IDE to muanual set up project into tomcat server.
    answer: follow the setup instructions and prof's help.

    get to know maven,a build tool.
    answer: follow some youtube video tutorial, but ended given up on maven and muanual set up project.

    since i used IDE first, I linked IDE to tomcat server, whihch massed up tomcat server a bit.
    the automatic gerneated project folder by IDE had some conflicts with my latter muanual set up project.
    moreclosely, the database connection is not working, I have to reinstall the tomcat server again then rebuild project without any IDE.


- Sample Execution