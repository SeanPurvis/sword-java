# Sword

How to start the Sword application
---

1. Run `mvn clean install` to build
1. Start application with `java -jar target/sword-0.0.1-SNAPSHOT.jar server config.yml`
1. To check that sword is running enter url: `http://localhost:8080`

Health Check
---

To see health enter url: `http://localhost:8081/healthcheck`

Notes
---

- Currently, the only committed code that has been added to the Dropwizard archetype are POJO Database Table Representations. 11/9/2017
- Naming conventions of MySQL tables have to remain the same until a large scale database migration can take place. At this time, that is not possible. 11/9/2017