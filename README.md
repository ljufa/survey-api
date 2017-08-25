# Requirements #

 - add/edit/delete questions, answers
 - read a list of all questions
 - read a question with all answers
 - respond to a survey
 - read the result for a particular question showing the total number of responses and distribution among the 
   possible answers in percent.
   
# Architectual Decisions #

From required functionalities I identified three groups of usage types:

- Poll definition module that is going to be used by survey creators. 
Expected number of module users (request per sec) is in reasonable order of magnitude. 
- Poll execution module that is going to provide questions, accept and store actual answers. 
Expected number of module users is much higher than in previous case.
- Poll statistic module is going to provide different statistical aggregations based on actual answers. 
This module is going to be used by first group of users or/and survey owners. 
This group of users is also much smaller than second one.

## Decision #1 ##
Create 3 microservice one for each use case: poll definition, poll exectuion and poll statistics.
## Decision #2 ##
Each service will have its own mongo database instance. 
In the case that service needs data from the other service db it will be fetched from data owning service.
I.E. When execution service needs poll definition it will invoke definition service to fetch data.
## Decision #3 ##
If data can't be fetched from other service mongodb replication will be used. 
In that case data copy must be used in readonly mode.
## Decision #4 ##
Use synchronous service communication becuse of better cloud tools support (spring streams  cloud or spring 5 reactive is still immature)
## Decision #5 ##
Use eureka for service discovery and ribbon for client side load balancing
## Decision #6 ##
Implement load balancing, service discovery, circuit breaker and other MS deployment patterns in application itself by use of spring-cloud.
Alternative approach would be container orchestration platform
  