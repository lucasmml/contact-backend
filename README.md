# Contacts

Este projeto contém um controller chamado `RestApiController` que possui as funcionalidades do seu crud.

## Getting Started

Aqui seguem as configuraçãoo para execução local do projeto.

### Prerequisites

``Maven``

``Java 8``

### Installing

Realizar o maven clean install e em seguida maven update project.

## Running the tests

Não foi realizado testes unitários, devido a baixa complexidade de negócio.


## Deployment

Teste local:
Suba o backend através da classe ContactsApp (método main).
E acesse a url http://localhost:9001/api/persons

Deve retornar a lista de pessoas em formato json.
A criação, alteração e exclusão podem ser feitas através dos métodos PUT, POST e DELETE.

Endpoints:

* ``http://localhost:9001/api/person/{id} - GET``
* ``http://localhost:9001/api/person - POST``
* ``http://localhost:9001/api/person/{id} - PUT`` 
* ``http://localhost:9001/api/person/{id} - DELETE``
* ``http://localhost:9001/api/persons - GET``
 

## Authors

* **Lucas**

