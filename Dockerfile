# Maven build container 

FROM maven:3.6.3-openjdk-11 AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

#pull base image

FROM openjdk

#maintainer 
MAINTAINER marciogreison81@gmail.com
#expose port 8080
#EXPOSE 8080

#default command
CMD java -jar /data/PrjTesteMyBatis-0.0.1-SNAPSHOT.jar

#copy hello world to docker image from builder image

COPY --from=maven_build /tmp/target/PrjTesteMyBatis-0.0.1-SNAPSHOT.jar /data/PrjTesteMyBatis-0.0.1-SNAPSHOT.jar
