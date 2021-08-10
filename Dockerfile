FROM adoptopenjdk/openjdk11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


#docker build --build-arg JAR_FILE=build/libs/*.jar -t springio/lets-coding-mysql-crm-batch-service.
#docker run -p 8080:8080 springio/lets-coding-mysql-crm-batch-service


#RUN curl -o /deployments/${APP_NAME}.jar ${ARTIFACT_URL} --insecure
#USER 1000
#RUN chown letscoding:letscoding /deployments/${APP_NAME}.jar
#COPY --chown=letscoding:letscoding ./application.sh /deployments/application.sh
#CMD ["sh", "/deployments/application.sh"]
