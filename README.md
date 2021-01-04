# EcommerceApplication
E-commerce Application

Used Java8, Spring Boot, Spring Data JPA, PostgreSQL, Swagger.

The application has the following endpoints:

http://localhost:8080/swagger-ui/#/ : To access swagger documentation of the endpoints

http://localhost:8080/order: GET Request - Shows all orders

http://localhost:8080/order/id: GET Request - Shows order with order number 'id'

http://localhost:8080/order: POST Request - Create an order

http://localhost:8080/order/id: PUT Request - Cancel order with order number 'id'

http://localhost:8080/shipping: GET Request - Shows shipping details of all orders

http://localhost:8080/shipping/id: GET Request - Shows shipping details of order with order number 'id'

http://localhost:8080/payment: GET Request - Shows payment details of all orders

http://localhost:8080/payment/id: GET Request - Shows payment details of order with order number 'id'

http://localhost:8080/pricing: GET Request - Shows pricing details of all orders

http://localhost:8080/pricing/id: GET Request - Shows pricing details of order with order number 'id'

http://localhost:8080/shutdown: GET Request - Initiate app shutdown(Required, otherwise process remains open at localhost port)

The application initially only has some basic inventory data and customers data filled. You will need to create orders before testing the endpoints. 

I hae provided some input JSON files, which will create orders through http://localhost:8080/order: POST Request. After that, different endpoints can be tried out completely.

Please configure database in postgresql/src/main/resources/application.properties file to run on local machine. I currently have my local db configured. 

I have also provided a Jar file which can be used to execute the application. This can be found in JAR folder. 

Thanks!



