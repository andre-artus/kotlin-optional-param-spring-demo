# Usage

To test one can send data to the server using `curl`, for example:
 
 * Listing all projects
```
curl -vX GET --header 'Accept: application/json' 'http://localhost:8080/project/'
```
* Adding a batch of projects from a single file
```
curl -vX POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d @projects.json 'http://localhost:8080/project/batch'
```
* Adding a project if valida
```
curl -vX POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d @invalid.json 'http://localhost:8080/project/valid'
```
