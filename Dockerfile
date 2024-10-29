FROM maven:3.8.5-openjdk-17 AS builder

ENV APP_HOME=/root/dev/app/
RUN mkdir -p $APP_HOME/src/main
WORKDIR $APP_HOME
COPY pom.xml .

COPY src/main/* src/main/
RUN mvn package && cp target/lab2-1.0-SNAPSHOT.war /tmp/app.war

FROM quay.io/wildfly/wildfly:28.0.0.Final-jdk17
COPY --from=builder /tmp/app.war /opt/jboss/wildfly/standalone/deployments/app.war

#FROM quay.io/wildfly/wildfly:28.0.0.Final-jdk17
#COPY target/lab2-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/app.war