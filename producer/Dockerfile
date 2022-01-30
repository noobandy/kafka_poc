FROM amazoncorretto:11
ENV STORAGE_DIR /images
COPY target/*.jar app.jar
CMD java -jar app.jar --KAFKA_SERVERS=${KAFKA_SERVERS}