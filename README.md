# flightRestApi
This Spring Boot REST API is to handle Passenger details, Flight details and Booking details 

RequestMethod.GET => 
Get all flight details for a specific passenger
http://localhost:8080/passengers/567

RequestMethod.GET =>
Get all Passenger details for a specific flight after departure time
http://localhost:8080/passengers?flightNumber=456&departureDate=2019-12-20

In this application basic authentication and autherization is enabled.
Below are the username and password for basic authentication. "/passengers" route is available for both user and admin.
'user' -> 'user123'
'admin' -> 'admin123'

--------------------
Here the inmemmory H2 data base is used as the data base to keep the flight api information. 

To login to H2 DB console  -> http://localhost:8080/h2-console
JDBC URL -> jdbc:h2:mem:flightapi

----------------------
To run the flightRestApi Spring Boot application -> mvn spring-boot:run

