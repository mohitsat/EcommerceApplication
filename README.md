# EcommerceApplication
E-commerce Application

Used Java8, Spring Boot, Spring Data JPA, PostgreSQL, REST API, Swagger.

The application has the following endpoints:

http://localhost:8080/swagger-ui/#/ : To access swagger documentation of the endpoints

http://localhost:8080/order: GET Request - Shows all orders

http://localhost:8080/order/id: GET Request - Shows order with order number 'id'

http://localhost:8080/order: POST Request - Create an order

http://localhost:8080/order/id: PUT Request - Cancel order with order number 'id'

http://localhost:8080/shipping: GET Request - Shows shipping details of all orders

http://localhost:8080/shipping/id: GET Request - Shows shipping details of order with order number 'id'

http://localhost:8080/payments: GET Request - Shows payment details of all orders

http://localhost:8080/payments/id: GET Request - Shows payment details of order with order number 'id'

http://localhost:8080/pricing: GET Request - Shows pricing details of all orders

http://localhost:8080/pricing/id: GET Request - Shows pricing details of order with order number 'id'

http://localhost:8080/shutdown: GET Request - Initiate app shutdown(Required, otherwise process remains open at localhost port)

The application database initially only has some basic inventory data and customers data filled. You will need to create orders before testing the endpoints. 

I have provided some input JSON files(Input1.json, Input2.json, ... on this page), which will be needed as input to create orders through http://localhost:8080/order: POST Request. After that, different endpoints can be tried out completely.

Please configure database in postgresql/src/main/resources/application.properties file to run on local machine. I currently have my local db configured. 

I have also provided a Jar file which can be used to execute the application on this page named postgresql-0.0.1-SNAPSHOT on this page. 

I would love to explain everything about the application after you review it. This was a great exercise and much more functionality can be added to the application. 

Thanks!



