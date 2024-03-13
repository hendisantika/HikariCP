FROM bellsoft/liberica-runtime-container:jdk-21-stream-musl as builder
LABEL authors="hendisantika"
RUN mkdir /project
COPY . /project
WORKDIR /project

# You can read these files for the information in your application
RUN echo $GIT_VERSION_TAG > GIT_VERSION_TAG.txt
RUN echo $GIT_COMMIT_MESSAGE > GIT_COMMIT_MESSAGE.txt
RUN echo $GIT_VERSION_HASH > GIT_VERSION_HASH.txt
RUN cd /project/HikariCP && ./mvnw clean package
#ADD hikaricp /home/myapp/hikaricp
#RUN cd hikaricp &&  \
RUN ./mvnw clean package
FROM bellsoft/alpaquita-linux-base:stream-musl-230404
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp
WORKDIR /home/myapp
COPY --from=builder /project/HikariCP/target .
EXPOSE 9000
CMD ["java", "-jar", "HikariCP-0.0.1.jar"]
