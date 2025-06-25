Проект -Pet Store Application-

Tech Stack:
-Java version 17
-Spring Boot version 3.5.3
-Maven version 3.9.10
-H2 database

Треба да го извршите java фајлот PetStoreApplication.java

Default gateway: http://localhost:8080/

Тестирање со Postman
-http://localhost:8080/api/... 

Endpoints:
-/api/create-users Генерира 10 објекти за класата User
-/api/create-pets Генерира 20 миленичиња од класата Pet
-/api/list-users Враќа листа од сите креирани објекти од класата User
-/api/list-pets Враќа листа од сите креирани објекти од класата Pet
-/api/buy Изминува низ сите објекти User и според зададени услови прави релација помеѓу објект Pet и објект User
-/api/history-log Враќа објект кој содржи атрибути: LocalDateTime, int, int
