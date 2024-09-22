
# API De clinica

API desenvolvida simulando o ambiente de uma clínica médica

## Entidades

<details>
  <summary>Paciente</summary>
  <br>
  A classe Paciente representa a entidade "customer" no sistema.

## Estrutura da Entidade

A tabela "customer" possui os seguintes campos:

| Campo           | Tipo de Dado | Descrição                      |
|-----------------|--------------|--------------------------------|
| id              | Long         | Identificador único do customer|
| nome            | String       | Nome do customer               |
| cpf             | String       | CPF do customer                |
| telefone        | String       | Telefone do customer           |
| email           | String       | Endereço de e-mail do customer |
| endereco        | String       | Endereço do customer           |
| cidade          | String       | Cidade do customer             |
| estado          | String       | Estado do customer             |
| data_nascimento | Date         | Data de nascimento do customer |
| data_cadastro   | Date         | Data de cadastro do customer   |

## Anotações

- A classe Paciente está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@ToString` gera automaticamente o método `toString()` para representação em formato de string da classe.
- A anotação `@Table(name = "customer")` define o nome da tabela no banco de dados como "customer".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- Os campos "nome" e "cpf" estão anotados com `@Column(nullable = false)` para indicar que são campos obrigatórios e não podem ser nulos.
- O campo "data_cadastro" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
</details>

<details>
  <summary>Médico</summary>
  <br>
  A classe Medico representa a entidade "medico" no sistema.

## Estrutura da Entidade

A tabela "medico" possui os seguintes campos:

| Campo          | Tipo de Dado | Descrição                      |
|----------------|--------------|--------------------------------|
| id             | Long         | Identificador único do médico  |
| nome           | String       | Nome do médico                 |
| telefone       | String       | Telefone do médico             |
| email          | String       | Endereço de e-mail do médico   |
| crm            | String       | CRM (Cadastro de Registro Médico) do médico |
| especialidade  | String       | Especialidade do médico        |
| data_cadastro  | Date         | Data de cadastro do médico     |

## Anotações

- A classe Medico está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@ToString` gera automaticamente o método `toString()` para representação em formato de string da classe.
- A anotação `@Table(name = "medico")` define o nome da tabela no banco de dados como "medico".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- O campo "nome" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- O campo "data_cadastro" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.

</details>

<details>
  <summary>Consulta</summary>
  <br>
  A classe Consulta representa a entidade "consulta" no sistema.

## Estrutura da Entidade

A tabela "consulta" possui os seguintes campos:

| Campo           | Tipo de Dado        | Descrição                            |
|-----------------|---------------------|--------------------------------------|
| id              | Long                | Identificador único da consulta       |
| data_consulta   | LocalDateTime      | Data e hora da consulta               |
| observacoes     | String              | Observações da consulta               |
| customer        | Paciente            | Referência ao customer associado      |
| medico          | Medico              | Referência ao médico responsável      |

## Anotações

- A classe Consulta está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@Table(name = "consulta")` define o nome da tabela no banco de dados como "consulta".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- O campo "data_consulta" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- A classe Consulta possui um relacionamento de muitos para um com a classe Paciente, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_paciente", nullable = false)`.
- A classe Consulta possui um relacionamento de muitos para um com a classe Medico, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_medico", nullable = false)`.

</details>

<details>
  <summary>Exame</summary>
  <br>
  A classe Exame representa a entidade "exame" no sistema.

## Estrutura da Entidade

A tabela "exame" possui os seguintes campos:

| Campo        | Tipo de Dado        | Descrição                            |
|--------------|---------------------|--------------------------------------|
| id           | Long                | Identificador único do exame         |
| data_exame   | LocalDateTime      | Data e hora do exame                 |
| tipo_exame   | String              | Tipo de exame realizado              |
| resultado    | String              | Resultado do exame                   |
| customer     | Paciente            | Referência ao customer associado     |
| medico       | Medico              | Referência ao médico responsável     |

## Anotações

- A classe Exame está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@Table(name = "exame")` define o nome da tabela no banco de dados como "exame".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- O campo "data_exame" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- O campo "tipo_exame" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- A classe Exame possui um relacionamento de muitos para um com a classe Paciente, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_paciente", nullable = false)`.
- A classe Exame possui um relacionamento de muitos para um com a classe Medico, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_medico", nullable = false)`.

</details>

## API Endpoints
<details>
  <summary>Paciente</summary>
  <br>
  
O `PacienteController` é responsável por lidar com as requisições relacionadas aos customers.

## Métodos

- `getAll()`: Retorna todos os customers cadastrados.
  - Método HTTP: GET
  - Path: `/customer/all`
  - Parâmetros: Nenhum.

- `getById(id)`: Retorna um customer pelo ID.
  - Método HTTP: GET
  - Path: `/customer/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do customer a ser retornado.

- `add(customer)`: Adiciona um novo customer.
  - Método HTTP: POST
  - Path: `/customer/add`
  - Parâmetros: `customer` (corpo da requisição) - Objeto Paciente a ser adicionado.

- `update(customer)`: Atualiza um customer existente.
  - Método HTTP: PUT
  - Path: `/customer/edit`
  - Parâmetros: `customer` (corpo da requisição) - Objeto Paciente atualizado.

- `delete(id)`: Deleta um customer pelo ID.
  - Método HTTP: DELETE
  - Path: `/customer/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do customer a ser deletado.

- `getConsultas(id)`: Retorna todas as consultas associadas a um customer pelo ID.
  - Método HTTP: GET
  - Path: `/customer/{id}/consultas`
  - Parâmetros: `id` (caminho da requisição) - ID do customer.

- `getExames(id)`: Retorna todos os exames associados a um customer pelo ID.
  - Método HTTP: GET
  - Path: `/customer/{id}/exames`
  - Parâmetros: `id` (caminho da requisição) - ID do customer.
</details>

<details>
  <summary>Médico</summary>
  <br>
  O `MedicoController` é responsável por lidar com as requisições relacionadas aos médicos.

## Métodos

- `getAll()`: Retorna todos os médicos cadastrados.
  - Método HTTP: GET
  - Path: `/medico/all`
  - Parâmetros: Nenhum.

- `add(medico)`: Adiciona um novo médico.
  - Método HTTP: POST
  - Path: `/medico/add`
  - Parâmetros: `medico` (corpo da requisição) - Objeto Medico a ser adicionado.

- `update(medico)`: Atualiza um médico existente.
  - Método HTTP: PUT
  - Path: `/medico/edit`
  - Parâmetros: `medico` (corpo da requisição) - Objeto Medico atualizado.

- `delete(id)`: Deleta um médico pelo ID.
  - Método HTTP: DELETE
  - Path: `/medico/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do médico a ser deletado.

- `getById(id)`: Retorna um médico pelo ID.
  - Método HTTP: GET
  - Path: `/medico/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do médico a ser retornado.

- `getExames(id)`: Retorna os exames associados a um médico pelo ID.
  - Método HTTP: GET
  - Path: `/medico/{id}/exames`
  - Parâmetros: `id` (caminho da requisição) - ID do médico.

- `getConsultas(id)`: Retorna as consultas associadas a um médico pelo ID.
  - Método HTTP: GET
  - Path: `/medico/{id}/consultas`
  - Parâmetros: `id` (caminho da requisição) - ID do médico.

</details>

<details>
  <summary>Consulta</summary>
  <br>
  
O `ConsultaController` é responsável por lidar com as requisições relacionadas às consultas.

## Métodos

- `getAll()`: Retorna todas as consultas cadastradas.
  - Método HTTP: GET
  - Path: `/consulta/all`
  - Parâmetros: Nenhum.

- `add(consulta)`: Adiciona uma nova consulta.
  - Método HTTP: POST
  - Path: `/consulta/add`
  - Parâmetros: `consulta` (corpo da requisição) - Objeto Consulta a ser adicionado.

- `update(consulta)`: Atualiza uma consulta existente.
  - Método HTTP: PUT
  - Path: `/consulta/edit`
  - Parâmetros: `consulta` (corpo da requisição) - Objeto Consulta atualizado.

- `delete(id)`: Deleta uma consulta pelo ID.
  - Método HTTP: DELETE
  - Path: `/consulta/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID da consulta a ser deletada.

- `getById(id)`: Retorna uma consulta pelo ID.
  - Método HTTP: GET
  - Path: `/consulta/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID da consulta a ser retornada.


</details>

<details>
  <summary>Exame</summary>
  <br>
  O `ExameController` é responsável por lidar com as requisições relacionadas aos exames.

## Métodos

- `add(exame)`: Adiciona um novo exame.
  - Método HTTP: POST
  - Path: `/exame/add`
  - Parâmetros: `exame` (corpo da requisição) - Objeto Exame a ser adicionado.

- `update(exame)`: Atualiza um exame existente.
  - Método HTTP: PUT
  - Path: `/exame/edit`
  - Parâmetros: `exame` (corpo da requisição) - Objeto Exame atualizado.

- `delete(id)`: Deleta um exame pelo ID.
  - Método HTTP: DELETE
  - Path: `/exame/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do exame a ser deletado.

- `getById(id)`: Retorna um exame pelo ID.
  - Método HTTP: GET
  - Path: `/exame/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do exame a ser retornado.

- `getAll()`: Retorna todos os exames cadastrados.
  - Método HTTP: GET
  - Path: `/exame/all`
  - Parâmetros: Nenhum.
</details>

## Tecnologias utilizadas e orientações.
<br>
A aplicação `clinica_api` utiliza as seguintes tecnologias:

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Biblioteca que facilita o acesso e manipulação de dados em bancos de dados relacionais.
- **Spring Data REST**: Biblioteca que simplifica a criação de APIs RESTful a partir de repositórios Spring Data.
- **Jasypt**: Biblioteca para criptografia e descriptografia de dados sensíveis.
- **Spring JDBC**: Biblioteca para acesso a bancos de dados utilizando JDBC.
- **Spring Web**: Biblioteca para desenvolvimento de aplicativos web no Spring.
- **Spring Boot DevTools**: Conjunto de ferramentas de desenvolvimento para agilizar o desenvolvimento de aplicativos Spring Boot.
- **MariaDB Java Client**: Driver JDBC para conexão com bancos de dados MariaDB.
- **Lombok**: Biblioteca que facilita a geração automática de código repetitivo, como getters, setters e construtores.
- **JUnit**: Framework de testes unitários para Java.

### Dependências do Spring Boot

- **spring-boot-starter-data-jpa**
- **spring-boot-starter-data-rest**
- **jasypt-spring-boot-starter** (versão 3.0.5)
- **spring-boot-starter-jdbc**
- **spring-boot-starter-web**
- **spring-boot-devtools**
- **mariadb-java-client**
- **lombok**
- **spring-boot-starter-test** (escopo: test)

Certifique-se de verificar se as versões das dependências no arquivo `pom.xml` estão corretas e atualizadas.

## Configuração do Banco de Dados

O banco de dados utilizado pela aplicação é o MariaDB. Certifique-se de ter o MariaDB instalado e configurado corretamente antes de executar a aplicação.

As configurações de conexão com o banco de dados são definidas no arquivo `application.properties` ou `application.yml`.

Exemplo de configuração no arquivo `application.properties` **SEM** o Jasypt:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# Configurações do Hibernate
spring.jpa.hibernate.ddl-auto=update
```

Exemplo de configuração no arquivo `application.properties` **COM** o Jasypt:

```properties
jasypt.encryptor.iv-generator-classname=org.jasypt.iv.NoIvGenerator
jasypt.encryptor.algorithm=PBEWithMD5AndTripleDES

# Caso tenha criptografado com alguma chave, insira ela abaixo e descomente a linha.
# jasypt.encryptor.password=<sua chave de criptografia>

spring.datasource.url=jdbc:mariadb://localhost:3306/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=ENC(NzDSBMwCbrR2JFmM7B7gzA==)
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
```
