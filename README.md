# API RESTful-Propiedades Paises
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Mucumbe/RestAPI1/blob/main/LICENSE)

# Sobre o projeto


API RESTful-Propiedades Paises é uma aplicação BackEnd  construída para a candidatora para vaga de Back-End Engineer capaz de executar as actividades listadas abacho.
- criar um novo país a partir da API criada com todas as suas propriedades;
- listar todos os países anteriorimente criados;
- modificar os dados de um país anteriormente criado;
- eliminar um país anteriormente criado;
- ordenar a lista dos países por qualquer uma das suas propriedades.

## A aplicação consiste em disponibilizar  Endpoits com as funcionalidades listadas acima
Exemplos:
### pedido HTTP correspondente à listagem de todos paises:
	GET https://apipais.herokuapp.com/paises HTTP/1.1
	Accept: application/json
	Resposta a este pedido
	
	HTTP/1.1 200 OK
	Content-Type: application/json
	(...)
	[
    {
        "id": 1,
        "nome": "Moçambique",
        "capital": "Maputo",
        "regiao": {
            "id": 2,
            "nome": "Sul"
        },
        "subRegiao": {
            "id": 1,
            "nome": "SubRegiao1"
        },
        "area": 801590.00
    },
    {
    	(...)
    }
]

### pedido HTTP correspondente à Criação de um pais na Base de dados:
	Post https://apipais.herokuapp.com/paises HTTP/1.1
	Accept: application/json
	{
    "nome": "Moçambique",
    "capital": "Maputo",
    "regiao": {
        "id": 1
    },
    "subRegiao": {
        "id": 1
    },
    "area": 801590.00
}
	
	Resposta a este pedido
	HTTP/1.1 201 CREATED
	Content-Type: application/json
		{
	    "id": 7,
	    "nome": "Moçambique",
	    "capital": "Maputo",
	    "regiao": {
	        "id": 1,
	        "nome": "Norte"
	    },
	    "subRegiao": {
	        "id": 1,
	        "nome": "SubRegiao1"
	    },
	    "area": 801590.00
	}
	
### pedido HTTP Retorna dados de um pais por ID correspondente:
	GET https://apipais.herokuapp.com/paises/1 HTTP/1.1
	Accept: application/json
	
	Resposta a este pedido
	HTTP/1.1 200 OK
	Content-Type: application/json
		{
    "id": 1,
    "nome": "Moçambique",
    "capital": "Maputo",
    "regiao": {
        (.....)
    },
    "subRegiao": {
        (....)
    },
    "area": 801590.00
}

### pedido HTTP correspondente à eliminacao de pais por ID:
	DELETE https://apipais.herokuapp.com/paises/2 HTTP/1.1
	Accept: application/json
	
	Resposta a este pedido
	HTTP/1.1 204 No Content
	Content-Type: application/json
	
### pedido HTTP correspondente à edicao de pais por ID(So actualiza as variaveis colocadas no Endpoit):
	DELETE /paises/2 HTTP/1.1
	Accept: application/json
	{
    "capital": "Moeda"
    
	}
	
	Resposta a este pedido
	HTTP/1.1 200 Ok
	Content-Type: application/json
	{
    "id": 1,
    "nome": "Moçambique",
    "capital": "Moeda",
    "regiao": {
        (...)
    },
    "subRegiao": {
        (...)
    },
    "area": 801590.00
}

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- lombok

## Base de dados
-Mysql - Local
-PostgreSQL - local(heroku) hospedado

## Implantação em produção
- Back end: Heroku
- Banco de dados: mysql

# Como executar o projeto

## Backend
- Pré-requisitos: Java 8


# Autor

Blandino Júnior Sibone Mucumbe



