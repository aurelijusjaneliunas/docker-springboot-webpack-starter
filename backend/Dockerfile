FROM java:openjdk-8u91-jdk

RUN mkdir -p /app/static /tmp/logs/app

# Install Gradle
ENV GRADLE_VERSION 2.13

RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
    unzip gradle-${GRADLE_VERSION}-bin.zip && \
    mv gradle-${GRADLE_VERSION} /opt/ && \
    rm gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME /opt/gradle-${GRADLE_VERSION}
ENV PATH $PATH:$GRADLE_HOME/bin

VOLUME /app
VOLUME /static

WORKDIR /app
EXPOSE 8080
