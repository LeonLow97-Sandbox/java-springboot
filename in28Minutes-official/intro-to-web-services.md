# Web Services

# What is a Web Service?

- **W3C Definition**: Software system designed to support interoperable machine-to-machine interaction over a network
- 3 Keys
  - Designed for machine-to-machine (or application-application) interaction.
  - Should be interoperable - Not platform dependent
  - Should allow communication over a network

# How?

## How does data exchange between applications take place?

- Request: From Application to Web Service
- Response: From Web Service to Application

## How can we make web services platform independent?

- Request and Response must be platform independent.
- Popular data exchange formats:
  - **XML** (Extensible Markup Language)
  - **JSON** (JavaScript Object Notation)

## How does the Application know the format of the Request and Response?

- **Service definition** of Web Service which specifies:
  - Request / Response Format: XML? JSON?
  - Request Structure
  - Response Structure
  - Endpoint: How to call the service? What is the endpoint? What URL is this service providing at?

# Key Terminologies of Web Services

## Request and Response

- Request is input to the Web Service
- Response is output of the Web Service

## Message Exchange Format

- Format of the request and the response.
- XML or JSON

## Service Provider or Server

- Web Service is called the service provider.
  - Service provider is the one which hosts the web service.

## Service Consumer or Client

- Application is called the service consumer.
  - Service consumer is the one which is consuming the web service.

## Service Definition

- Contract between the service provider and the service consumer.
  - Request / Response Format
  - Request Structure
  - Response Structure
  - Endpoint

## Transport

- Transport defines how a service is called.
  - Is the service exposed over the internet? Is the service exposed over the Queue?
- HTTP and Message Queue (MQ)

# Wev Service Groups

- SOAP-based
- REST-styled
- SOAP and REST are not really comparable.
  - REST defines an architectural approach.
  - SOAP poses restrictions on the format of XML which is exchanged between service provider and service consumer.

## SOAP (Simple Object Access Protocol)

- Specific way of building web services
- Uses XML as the request exchange format.
- SOAP defines a specific XML request and response structure:
  - SOAP-ENV: Envelope
    - SOAP-ENV: Header
    - SOAP-ENV: Body

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getCourseDetailsResponsexmlns:ns2="http://in28minutes.com/courses">
            <ns2:course>
                <ns2:id>Course1</ns2:id>
                <ns2:name>Spring</ns2:name>
                <ns2:description>10 Steps</ns2:description>
            </ns2:course>
        </ns2:getCourseDetailsResponsexmlns:ns2>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

- Format
  - SOAP XML Request
  - SOAP XML Response
- Transport
  - SOAP over MQ
  - SOAP over HTTP
- Service Definition
  - Web Service Definition Language (WSDL)
    - Endpoint
    - All operations (GET, POST, DELETE, UPDATE)
    - Request Structure
    - Response Structure

## REST (Representational State Transfer)

- Requests and response are in a format defined by HTTP (HyperText Transfer Protocol)
- In the response and request, there are headers, methods (GET, PUT, POST, ...), status code (200, 404, ...) and the body.

## Key Abstraction - Resource

- A resource has an URI (Uniform Resource Identifier)
  - /user/Ranga/todos/1
  - /user/Ranga/todos
  - /user/Ranga
- A resource can have different representations:
  - XML
  - HTML
  - JSON
- Data Exchange Format
  - No restriction
  - JSON is popular
- Transport
  - Only HTTP
- Service Definition
  - No Standard. WADL/Swagger/...

# SOAP vs RESTful Services

|                                        |                    SOAP                     |                  REST                   |
| :------------------------------------: | :-----------------------------------------: | :-------------------------------------: |
| Restrictions vs Architectural Approach |                Format of XML                |           Architectural Style           |
|          Data Exchange Format          | SOAP XML with SOAP envelope header and body | No strict exchange format (XML or JSON) |
|           Service Definition           |                    WSDL                     |               No standard               |
|               Transport                |    No restrictions (can use HTTP or MQ)     |                uses HTTP                |
|         East of Implementation         |                  Difficult                  |                  Easy                   |

# Terminology in Spring Framework

- Tight Coupling adn Loose Coupling
- IOC Container
- Application Context
- Component Scan
- Dependency Injection
- Spring Beans
- Auto Wiring
