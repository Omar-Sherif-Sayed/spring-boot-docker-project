# spring-boot-docker-project
spring-boot-docker-project
tHis is Trailer Project 

Will never Work if u use it's Dockerfile to create an Image 

Becase the postgresql Database run in another Image

docker build -f Dockerfile -t spring-boot-docker .

docker run -p 8085:8085  spring-boot-docker

In this project I used https://github.com/ghusta/docker-postgres-world-db as my locally postgresql Database 
