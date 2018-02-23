FROM ubuntu:xenial

RUN apt update && apt install -y maven openjdk-8-jdk

ADD . /sword
WORKDIR /sword
RUN mvn clean install

ENTRYPOINT ["java", "-jar", "/sword/target/sword-0.0.1-SNAPSHOT.jar", "server", "/sword/config.yml"]
