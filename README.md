# groovy-thymeleaf-practice

https://github.com/josdem/vetlog-spring-boot/blob/master/build.gradle

http://www.baeldung.com/spring-boot-internationalization

https://github.com/thymeleaf/thymeleaf-extras-springsecurity

http://groovy-lang.org/syntax.html

http://www.thymeleaf.org/documentation.html

http://groovy-lang.org/syntax.html

https://memorynotfound.com/spring-security-remember-hashing-authentication-example/

https://www.concretepage.com/spring/spring-security/remember-me-in-spring-security-example

######################################################################

spring boot docker 참조 : https://github.com/spring-guides/gs-spring-boot-docker

1. docker image 생성
./gradlew build buildDocker

2. docker 실행
docker run -p 8888:8888 -t com.example/groovy-thymeleaf-practice:0.0.1-SNAPSHOT

3. docker 실행 시 프로파일 설정
docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8888:8888 -t com.example/groovy-thymeleaf-practice:0.0.1-SNAPSHOT

######################################################################
