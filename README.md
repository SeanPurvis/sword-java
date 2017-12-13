# Sword

How to start the Sword application
---

1. Run `mvn clean install` to build
1. Start application with `java -jar target/sword-0.0.1-SNAPSHOT.jar server config.yml`
1. To check that sword is running enter url: `http://localhost:8080`

Health Check
---

To see health enter url: `http://localhost:8081/healthcheck`

Packages
---
src/main/java/ 
1. sword - Contains application entry point and configuration file parsing. 
2. sword.api - contains POJO representations of database tables. 
3. sword.db - contains DAO interfaces for database tables 
4. sword.mappers - contains mapper classes that map SQL query results back to POJOs. 
5. sword.resources - contains resource classes that describe a REST API endpoint for a table. 

Notes
---

- Currently, the only committed code that has been added to the Dropwizard archetype are POJO Database Table Representations. 11/9/2017
- Naming conventions of MySQL tables have to remain the same until a large scale database migration can take place. At this time, that is not possible. 11/9/2017
