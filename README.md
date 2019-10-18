# Dockerize-the-SpringBoot-App
Running the Spring Boot App in Docker

There are two SPring Boot API - 
1) parent APi - business api
2) child API -  dummyinvokedapi


business api will be calling the child api while giving the {"id": 55,"name": "Naresh","age": 30,"salary": 30.44} data.

business api url - http://localhost:8080/echo-echo/
dummyinvokedapi api url - http://localhost:9099/echo-echo/

There are two api url - 
/hello  - Will give you greet message
/echo-echo/ - Will call the child api via REST Template and reponse comes all the way from child api to parent api.


trick comes here - where will you configure the child api invokcation url in parent api ?
  create one application.properties file in parent api and configure below details to configure the uri of child api.
  
        operations.restURL=http://localhost:9099/echo-echo/
        
  The child api is running on localhost but with 9099 port, and this url you get when you run your child api on tomcat server locally with   the mvn spring-boot:run cmd.
  
  
Steps for creating the app and dockerize it in local machine -

1. Create two spring boot app as discussed above and run it both individually via below command -

    mvn spring-boot:run
    
   
2. Now run the parent api while giving the below url and JSON payload to postman (Making sure that api is working end-to-end)-
    http://localhost:8080/echo-echo/
    
    {
    "id": 55,
    "name": "Naresh",
    "age": 30,
    "salary": 30.44
    }

3. Now install the docker for windows and check whether it is availabel locally or not.
    open command prompt, type docker and hit the enter, so you will find the all the docker arguments, its means docker is running in       your local machine.
    
 4. Once you have Docker in local, you can create docker file for both the api individually. docker file structure -
 
        # Start with a base image containing Java runtime
        FROM openjdk:8-jdk-alpine

        # Add Maintainer Info
        MAINTAINER Naresh Saini <naresh.saini@ikea.com>

        # Add a volume pointing to /tmp
        VOLUME /tmp

        # The application's jar file
        ARG JAR_FILE=target/businessapi-0.0.1-SNAPSHOT.jar

        # Add the application's jar to the container
        ADD ${JAR_FILE} businessapi.jar

        # Run the jar file 
        ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/businessapi.jar"]
        
        
5. As describe above, you will need the jar file of your api , suppose businessapi.jar, so you have to create jar for both api via below    commnad - 

    mvn package
    
6. Now we will build the dockerfile as we have jar file of our apis-

      docker build -t <name of image> <tag-name>
  
7. After build the docker file you will get the docker image, so you hit just docker images, ans you will be find all available images on you rlocal repository.

8 . Now run the docker image or shoul i say run you api in dockerize container - 

      docker run -p <port> <name of docker image>
      
 Note -  you have to give two ports here, one port (8090) for operating sytem and one port(8080) for inside the container like below -
 
        docker run -p 8090:8080 <name of docker image>
        
  So , when you access you api , it will be OS port iike 8090.
 
 
 9.  Test the api after dockezire it - 
 
    same as we hot before in step -2, but only differenc is port , now it will be 8090 as disciussed in step - 8.
    
    
Cheers :) 
      
    
  
 
 
 

