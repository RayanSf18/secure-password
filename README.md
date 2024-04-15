# Secure Password Validation Java Application
This project is a simple Java application that validates passwords based on a set of predefined criteria. The application accepts HTTP requests using the Spring Boot framework and uses regular expressions to validate the criteria.

## Routes
The application offers a single route to validate passwords:

`POST http://localhost:8080/validate-password`: This route accepts HTTP POST requests with a JSON body containing the password to be validated.

### Example Request:
Here is an example of a JSON request to validate a password:
```
{
    "password": "vYQIYxO&p$yfI^r"
}
```

## Validation Criteria
The application validates passwords based on the following criteria:

- The password must have at least 8 characters.
- The password must have at least one uppercase letter.
- The password must have at least one lowercase letter.
- The password must have at least one numeric digit.
- The password must have at least one special character (e.g., !@#$%).

## Responses
If the password meets all security criteria, the application will return an empty response with status HTTP/1.1 204 NoContent. 
Otherwise, if one or more criteria are not met, the application will return a list of messages indicating which criteria were not met. 
The list will be in JSON format and will contain a message for each unmet criterion.


### Example Failed Response
Here is an example of a JSON response for an invalid password:
```
{
    "failures": [
        "The password must have at least 8 characters.",
        "The password must have at least one capital letter.",
        "The password must have at least one lowercase letter.",
        "The password must have at least one numeric digit.",
        "The password must have at least one special character (e.g., !@#$%)."
    ]
}
```

## Installation
To install and run the application, follow the steps below:

1 - Clone the project repository to your local machine.
2 - Open the terminal and navigate to the root directory of the project.
3 - Run the command ./mvnw spring-boot:run to start the application.
4 - Use an HTTP testing tool, such as Postman, to send requests to the application.

## Conclusion
This project is a simple Java application that can be used to validate passwords based on predefined criteria. The application can easily be extended to include additional validation criteria or to integrate with other systems.
