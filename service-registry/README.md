# Spring Eureka 🌱

Spring Eureka is a service registry and discovery server that is part of the Spring Cloud suite. It facilitates the development of cloud-native applications in Java, particularly those following the microservices architecture.

## Overview

Microservices architecture involves breaking down an application into smaller, independent services that can be developed, deployed, and scaled individually. However, managing communication between these services can be complex, especially as the number of services grows. Spring Eureka helps address this challenge by providing a dynamic service discovery mechanism.

## Features

- **Service Registration**: Microservices register themselves with the Eureka server during startup.
- **Service Discovery**: Eureka server keeps track of registered services and their network locations.
- **Dynamic Routing**: Services can query the Eureka server to discover the network location of desired services, enabling direct communication.

## How It Works

1. **Service Registration**: Microservices register with the Eureka server by providing their network location.
2. **Service Discovery**: When a service needs to communicate with another service, it queries the Eureka server for the network location of the desired service.
3. **Dynamic Routing**: With the network location obtained from Eureka, services can communicate directly with each other.

## Usage

To use Spring Eureka in your project, follow these steps:

1. Include the necessary Spring Cloud dependencies in your project's `pom.xml` or `build.gradle` file.
2. Configure your microservices to register with the Eureka server during startup.
3. Configure your microservices to use Eureka for service discovery.
4. Start the Eureka server.
5. Start your microservices.

## Example

Here's a simple example of how to configure a Spring Boot application to use Spring Eureka:

```java
@SpringBootApplication
@EnableEurekaClient
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```
**Note: We are running our service registry at port 1111**