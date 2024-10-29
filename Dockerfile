FROM quay.io/wildfly/wildfly:28.0.0.Final-jdk17
COPY target/lab2-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/app.war