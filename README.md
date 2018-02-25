# Renee Grittner Individual Project

### Problem Statement
Many small ensembles do not have an effective way to store, search, and comment on available compositions. 
This leads to redundant file storage, difficulties sharing scores and parts amongst ensemble members, and no conveient place
to store relevant information about a composition, such as stage diagrams, dates & locations last performed, and who played which parts on previous concert programs.

In future versions the concert planner will also allow functionality to:
* Organize a concert program, displaying total concert length as pieces are added to the program
* Allow for tracking of instrumentation 
* Allow for tracking of required hardware (symbol stands, etc) based on pieces on the program.

## Project Technologies

* Security/Authentication
    * Tomcat's JDBC Realm Authentication
    * Admin role: create/read/update/delete of all data
    * Guest role: view sample application
* Database
    * MySQL
    * MySQL Workbench
    * Vertabelo
    * Stores users and roles
    * Stores Composers, Compositions, Instruments, Musicians, and Concert Program information
* ORM Framework
    * Hibernate 5
* Dependency Management
    * Maven
* Web Services consumed using Java
    * Google Drive REST API
* CSS
    * Bootstrap
* Data Validation
    * JavaScript for front end
    * Explore Hibernate's validation
* Logging
    * Configurable logging using Log4J2.
        * Production level - only error logging
        * Development - ability to turn on debug logging
* Hosting
    * AWS
* Unit Testing
    * JUnit tests to achieve 80% code coverage
* IDE: IntelliJ IDEA
* Design and Layout
    * Balsamiq Mockups 3
* Repository
    * Github
    

### Design
[Wire Frames](concertPlanner.pdf)
[ERD](concertPlannerDbDesign.pdf)

### [Project Plan](projectPlan.md)

### [Development Journal](timeLog.md)