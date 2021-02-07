# Maven build container 

FROM maven:3.6.3-openjdk-11 AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/ 
WORKDIR /tmp/
RUN mvn clean package

FROM openjdk
MAINTAINER marciogreison81@gmail.com
COPY --from=maven_build /tmp/target/PrjTesteMyBatis-0.0.1-SNAPSHOT.jar /data/PrjTesteMyBatis-0.0.1-SNAPSHOT.jar
COPY --from=maven_build /tmp/target/lib /data/
WORKDIR /data/
CMD java -jar PrjTesteMyBatis-0.0.1-SNAPSHOT.jar