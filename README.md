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
I.e. currently in schema is as follows:

```
{
 "openapi": "3.0.3",
 "paths": {
  "/hello": {
   "get": {
    "tags": ["Greeting Resource"],
    "responses": {
     "200": {
      "description": "OK",
      "content": {
       "application/json": {
        "schema": {
         "type": "array",
         "items": {
          "$ref": "#/components/schemas/Reference"
 }}}}}}}}},
 "components": {
  "schemas": {
   "Reference": {
    "type": "object",
    "properties": {
     "entity": {
      "type": "string"
     },
     "ref": {
      "type": "string"
 }}}}}
}
```

I expect it be either: 
```
{
 "openapi": "3.0.3",
 "paths": {
  "/hello": {
   "get": {
    "tags": ["Greeting Resource"],
    "responses": {
     "200": {
      "description": "OK",
      "content": {
       "application/json": {
        "schema": {
         "type": "array",
         "items": {
          "$ref": "string"
 }}}}}}}}}
}
```

or

```
{
 "openapi": "3.0.3",
 "paths": {
  "/hello": {
   "get": {
    "tags": ["Greeting Resource"],
    "responses": {
     "200": {
      "description": "OK",
      "content": {
       "application/json": {
        "schema": {
         "type": "array",
         "items": {
          "$ref": "#/components/schemas/Reference"
 }}}}}}}}},
 "components": {
  "schemas": {
   "Reference": {
    "type": "string",
 }}}
}
```
