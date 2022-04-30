FROM maven:3-openjdk-11

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn -f pom.xml clean package

COPY product/target/product-1.0-SNAPSHOT.jar product.jar
ENTRYPOINT ["java","-jar","product.jar"]