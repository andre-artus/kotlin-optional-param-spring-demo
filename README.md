# Kotlin Optional-Param Spring Demo

**This application clears the database on start.** Make sure nothing in `application.properties` points to a production database.

This is not a demonstration of best practices, it's intention is to show a very specific thing: using Kotlin data classes with optional `id` fields using Spring Boot and MongoDB. 

Run the application and send snippets from [sample_data](sample_data) via `curl` or PostMan 

### List all the `Project`s

`GET /project/`

### Accept a list of projects and store them directly in the DB

`POST /project/batch` 

### Create a `Project` directly into MongoDB

`POST /project/`

Validates a `ProjectRequest` before attempting to store a `Project`  

`POST /project/valid`

E.g. from the `sample_data` directory:

```
curl -vX GET --header 'Accept: application/json' 'http://localhost:8080/project/'

curl -vX POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d @projects.json 'http://localhost:8080/project/batch'

curl -vX POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d @invalid.json 'http://localhost:8080/project/valid'
```
