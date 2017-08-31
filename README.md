# Requirements #
Using microservice architecture design and implement api for online survey application such like SurveyMonkey
Initial set of features is:  

 - add/edit/delete questions, answers
 - read a list of all questions
 - read a question with all answers
 - respond to a survey
 - read the result for a particular question showing the total number of responses and distribution among the 
   possible answers in percent.
 
# Architectual Decisions #
In order to be able to scale applicaton for high trafic volume I will use Microservice Arhitecture pattern.
With help of well known and adopted tools development, deployment and day to day running process should be smooth.
  
## #1 Microservices organization ##
From given requirements I identified three groups of usage types:

- AUTHORING-SERVICE: Survey authoring module that is going to be used by survey creators. 
Expected number of module users (request per sec) is in reasonable order of magnitude.
This module will also provide questions and anwers at survey beginning.
 
- RESULTCAPTURE-SERVICE: Survey result capture module that is going accept and store actual answers. 
Expected number of requests in this module is much higher than in the previous case.

- ANALYTICS-SERVICE: Analytics module will  provide different statistical aggregations based on actual answers. 
This module is going to be used by first group of users or/and survey owners. 
This group of users is also much smaller than second one.

From all above I can make assumption that each module will have different scaling needs so decided to design them as separate microservices.

## #2 Data persistence ##
Each service will have its own mongo database instance.
Exceptions from this is first iteration of ANALYTICS-SERVICE which is going to pull data from other two services on the fly.
In future iterations we can implement it in more robust and scalable way to be able to support big and fast data analytics in realtime.
(Spark, Kafka ...) 

## #3 Data exchange ##
JSON is data format used for communication between client and server as well as inter-service communication.

## #4 Client-service and service-service communication ##
Use synchronous service communication becuse of better cloud tools support at the moment
(spring streams  cloud or spring 5 reactive is still immature)

## #5 Service discovery, load balancing and circuit breakers ##
Use eureka for service discovery and ribbon for client side load balancing.

## #6 Scaling ##
For autoscaling, self healing I'll relly on cloud provider platform such is Kubernetes.

## #7 API versioning ##
To be able to support smoth API evolution api versioning is going to be in place from the start.
Versioning method of choice is usage of Accept header in each request (Accept=application/vnd.survey-1.0+json)

# Build & Run #
####Prerequisites: 
- git
- jdk8
- maven 3.2 +
- docker ce 17.0 or higher
- docker-compose version 1.14.0 or higher
- if you plan to open code in your IDE please install Lombok plugin.

####Build:

- `git clone ????`

- `cd survey-api`

- `./mvnw clean package`
 
####Run: 
 
 - `docker-compose up -d --build`
 
 or
 
 - `./rebuild.sh` - to rebuild and start all services 
 - `./rebuild.sh <service name>` - to rebuild and start single service
 - `./rebuild.sh <service name> debug` - to rebuild and start single service in remote debug mode. 
    See [docker-compose.debug.yml](docker-compose.debug.yml) for debug port mappings. 

After some time API should be accessible on localhost port 80.
Please note that due to service discovery it could take up to 3 hartbeat cycles before each service being discovered.
 
####Stop & clean:

`docker-compose down --rmi local`

# API Documentation #
Once you run application you can [go to swagger UI](http://localhost/swagger-ui.html)
for more details

# Logging & Monitoring #
TBD

# Testing #
TBD

