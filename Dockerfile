## Use the Maven base image
#FROM maven:3.8.6-amazoncorretto-17
#
#ARG JAR_FILE=traget/*.jar
#
#COPY ./target/rest.api.remastered-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT ["java", "-jar", "/app.jar"]


#FROM maven:3.8.6-amazoncorretto-17 AS builder
#WORKDIR /app
#COPY pom.xml .
#RUN mvn dependency:go-offline
#COPY src ./src
#RUN mvn package
#FROM amazoncorretto:17
#WORKDIR /app
#COPY --from=builder /app/target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]

#
#FROM maven:3.8.6-amazoncorretto-17  AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
#FROM amazoncorretto:17
#COPY --from=build /home/app/target/rest.api.remastered-0.0.1-SNAPSHOT.jar /usr/local/lib/rest.api.remastered-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#USER 10014
#ENTRYPOINT ["java","-jar","/usr/local/lib/rest.api.remastered-0.0.1-SNAPSHOT.jar.jar"]


FROM maven:3.8.6-amazoncorretto-17
WORKDIR /build
COPY pom.xml /build
RUN mvn -B dependency:resolve dependency:resolve-plugins
COPY src /build/src
RUN mvn package -DskipTests=true
ENTRYPOINT ["java","-Dspring-profiles.active=docker","-jar","/build/target/rest.api.remastered-0.0.1-SNAPSHOT.jar"]





































