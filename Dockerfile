FROM amazoncorretto:17
WORKDIR /app

RUN mkdir -p /app/images
RUN chmod -R 755 /app/images

RUN mkdir -p /app/images/user/profile
RUN chmod -R 755 /app/images/user/profile

RUN mkdir -p /app/images/product
RUN chmod -R 755 /app/images/product

RUN mkdir -p /app/images/promotion
RUN chmod -R 755 /app/images/promotion

RUN mkdir -p /app/images/categories
RUN chmod -R 755 /app/images/categories

COPY assets/image/product/*.png /app/images/product/
COPY assets/image/categories/*.png /app/images/categories/
COPY assets/image/promotion/*.png /app/images/promotion/

COPY /target/*.jar /app/OnlineMarket.jar
ENTRYPOINT ["java", "-jar", "/app/OnlineMarket.jar"]