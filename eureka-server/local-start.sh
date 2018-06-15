#!/bin/sh


mvn clean install package spring-boot:repackage -DskipTests -Dfindbugs.skip=true -Dpmd.skip=true -Dmaven.javadoc.skip=true

./stop.sh

rm -f tpid

nohup java  -Xms64m -Xmx1g -XX:+UseG1GC -jar ./target/eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > /dev/null 2>&1 &

echo $! > tpid

echo Start  eureka-server Success!