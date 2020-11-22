# The stage I: generating the .jar file
FROM alpine as jarBuilder
LABEL stage=complimentGeneratorBuilder
RUN apk update \
        && apk upgrade \
        && apk add openjdk11
RUN export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
WORKDIR /app
COPY . .
RUN ./gradlew build

# The stage II: running the .jar file
FROM alpine
RUN apk update \
        && apk upgrade \
        && apk add openjdk11
RUN export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
COPY --from=jarBuilder ./app/build/libs/compliment-generator.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-server", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-XX:InitialRAMPercentage=50.0", "-XX:MinRAMPercentage=50.0", "-XX:MaxRAMPercentage=50.0", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:+UseStringDeduplication", "-jar", "compliment-generator.jar"]
