# Spring Boot Task Management API
This is a Spring Boot application for managing a Task Management API system where a person can add their task with title, description, dueDate and status where admin user have access of all the task.
This project integrated with test cases.




## Installation 

 - [Clone the repository to your local machine](https://github.com/Verma35Shubham/Task_Management_Api.git)
 - [Open a terminal and navigate to the project directory]()
 - [Run mvn clean install to build the project]()
 - [Run mvn spring-boot:run to start the application]()
 
## Requirements
Before you begin, ensure that you have met the following requirements:

 - [You have installed the latest version of Java]()
 - [You have installed the latest version of Maven]()
 - [You have installed the latest version of Spring Boot]()
 - [You have installed the latest version of Spring Security]()


## API Reference

#### This project provides the following APIs:

#### Post item

```http
  POST /api/user/add
```

```http
  POST /api/task/add
```

```http
  POST /api/admin/add
```


#### PUT item

```http
  PUT /api/user/login
```
```http
  PUT /api/user/logout
```

```http
  PUT /api/task/update/user_task
```

#### DELETE item

```http
  DELETE /api/task/delete/user_task
```


#### Get item

```http
  GET /api/user/all/tasks
```
```http
  GET /api/admin/find/all/task
```

```http
  GET /api/get/product
```

```http
  GET /api/admin/get/category/{taskStatus}
```
## Contributing

Contributions are always welcome!


 - [Fork the repository]()
 - [Create a new branch (git checkout -b feature/feature-name)]()
 - [Make the changes]()
- [Commit your changes (git commit -am 'Add some feature')]()
 - [Push to the branch (git push origin feature/feature-name)]()
 - [Create a new Pull Request]()


