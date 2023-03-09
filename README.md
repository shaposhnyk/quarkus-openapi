# quarkus-openapi

What this project does?
It exposes a REST service, http://localhost:8080/hello which returns an array of *strings*

What works:
- service returns correct JSON: ["Hello/from", "RestEasy/to"]

What does not work: 
- QuarkusTest does *not* pass, it expects an object not a string
-- I expect the test pass
- OpenApi schema http://localhost:8080/q/openapi states than return type of method is a list of object
-- I expect that
--- either the return type is array of string
--- either the return type is array of objects of type string
I.e. in components we have:
```
       "Reference": {
        "type": "string"
      }, 
```
