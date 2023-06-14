FROM openjdk:8u111-jdk-alpine

MAINTAINER Klaus Fischer <Klaus.Fischer@dfki.de>

RUN apk add --no-cache git

RUN apk add --no-cache openssh

COPY mosim-test /root/.ssh/id_rsa
RUN chmod go-rwx /root/.ssh/id_rsa

COPY config-ssh /root/.ssh/config

RUN cd /root \
        && git clone git@git.hb.dfki.de:kfischer/aitoc.git

ENV MAVEN_VERSION 3.6.3
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH

RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  mv apache-maven-$MAVEN_VERSION /usr/lib/mvn

RUN /root/aitoc/Docker/MultiplyGitDV/client/compile.sh

CMD [ "/root/aitoc/Docker/MultiplyGitDV/client/run.sh" ]
