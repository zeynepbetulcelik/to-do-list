# Todolist Spring-Boot Application


### Pullling from docker hub
```
docker run --name todolist -e DATABASE_SERVER=jdbc:h2:mem:todolist -dp 8082:8580 zeynep875421/todolist:0.0.1 
```
When you run this command on your terminal, it will be pulled first and then it will start running on port 8082 (If you want to debug source code it will be run on port 8580).

### API Documentation with Swagger2
I used swagger in the application. If you are wondering what kind of fields will be sent before sending a request to the APIs, you can get a request using GET at this link and review the documentation:
```
http://localhost:8082/v2/api-docs
```
### Database access
```
http://localhost:8082/h2-console
```
### Properties
* username: sa
* password: password
* db URI:jdbc:h2:mem:todolist

# Take a look at the API usages:
## Signup
#### Endpoint: 
```
http://localhost:8082/api/v1/auth/signup
```
Request Type: POST
Body fields with JSON format:
{
    "username":"example@gmail.com",
    "password":"password",
    "name":"exampleName",
    "surname":"exampleSurname"
}
## Login
#### Endpoint: 
```
http://localhost:8082/api/v1/auth/login
```
Request Type: POST
Body fields with JSON format:
{
    "username":"example@gmail.com",
    "password":"password"
}
## Create to do list
#### Endpoint: 
```
http://localhost:8082/api/v1/list/to-do-list
```
Request Type: POST
Bearer token required (You can get it using signup or login (from response body)).
Body fields with JSON format:
 {
     "category": "",
     "name":" ",
     "completed": false 
 }
## Lists of to do list (for authenticated user)
#### Endpoint: 
```
http://localhost:8082/api/v1/list/to-do-list
```
Request Type: GET
Body fields with JSON format:
no field
Bearer token required (You can get it using signup or login (from response body)).
## Update to do list
#### Endpoint: 
```
http://localhost:8082/api/v1/list/to-do-list
```
Request Type: PUT
Bearer token required (You can get it using signup or login (from response body)).
Body fields with form data:
| Key	| Value | 
| ----- | ---------- |
|   id  	| 9710da8a-b7b4-4b9a-8e6d-35cf85680532     |

id: list id you can take it using get lists of todolist from response body

## Delete to do list
#### Endpoint: 
```
http://localhost:8082/api/v1/list/to-do-list
```
Request Type: DELETE
Bearer token required (You can get it using signup or login (from response body)).
Body fields with form data:
| Key	| Value | 
| ----- | ---------- |
|   id  	| 9710da8a-b7b4-4b9a-8e6d-35cf85680532     |

id: list id you can take it using get lists of todolist from response body

# Sample requests with using postman

## Signup
<p align="center">
  <img src= "https://github.com/zeynepbetulcelik/todolist/blob/master/postman%20screenshots/signup.PNG">
</p>

 ## Login

<p align="center">
  <img src="https://github.com/zeynepbetulcelik/todolist/blob/master/postman%20screenshots/login.PNG">
</p>

## Create to do list

<p align="center">
  <img src="https://github.com/zeynepbetulcelik/todolist/blob/master/postman%20screenshots/create-list.PNG">
</p>

## Lists of to do list (for authenticated user)

<p align="center">
  <img src="https://github.com/zeynepbetulcelik/todolist/blob/master/postman%20screenshots/lists.PNG">
</p>

## Update to do list

<p align="center">
  <img src="https://github.com/zeynepbetulcelik/todolist/blob/master/postman%20screenshots/update-list.PNG">
</p>

## Delete to do list

<p align="center">
  <img src="https://github.com/zeynepbetulcelik/todolist/blob/master/postman%20screenshots/delete-list.PNG">
</p>

