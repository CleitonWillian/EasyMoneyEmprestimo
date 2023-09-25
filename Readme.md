# README

## Easy Money Empréstimo

### 1. Sobre o Projeto
Easy Money Emprestimo é uma aplicação de empréstimo que permite aos usuários fazer emprestimos com as 
condições ideais de acordo com o perfil do usuario.
Utilizamos uma arquitetura robusta de casos de uso (**UseCase**) com métodos de validação 
avançados para fornecer resultados otimizados e confiáveis.

### 2. Tecnologias Utilizadas
- **Java 17**: Linguagem de programação que oferece um forte sistema de tipos e um excelente
 gerenciamento de memória.
- **Spring Boot**: Usado para simplificar o processo de configuração e desenvolvimento.
- **Swagger**: Para documentação da api.
- **Maven**: Para gerenciamento de dependências.
- **JUnit 5**: Para testes unitários.
- **H2 database**: Facil usabilidade e flexibilidade

Cada tecnologia foi escolhida com o objetivo de tornar a aplicação mais eficiente, 
fácil de testar e manter.

### 3. Arquitetura e Padrões
A aplicação segue a arquitetura **UseCase**, que facilita a separação de responsabilidades 
e torna o sistema mais testável. 
Além disso, usamos padrões de projeto como **Strategy** para facilitar a escrita do caso 
de uso de validação do tipo de Pessoa.
O projeto é divido com responsabilidades/tenologia onde **receive** é a camada de entrada 
de dados da nossa API no caso temos **receive/rest**, já a camada send temos as tecnologias 
database e rest, no caso da send/database é onde temos tudo que precisamos para consumir 
um banco de dados ja na camada send/rest é onde temos separada a estrutura passa consumir um 
serviço rest com Feign.
Temos o pacote *core* que é onde retem toda regra de negócio que esta fica devidademente
no pacote **bussineslogic** onde tem apenas as implementações de seus usecases. 



### 4. Instalação e Execução
Para instalar e executar este projeto, siga os seguintes passos:


##### Use o Maven para compilar e rodar
mvn clean install
mvn spring-boot:run
\```

### 5. Console H2
Colocar no seu browser o endereço http://localhost:8090/h2-console/
-url: jdbc:h2:file:./data/EasyMoneyEmprestimo  
-driverClassName: org.h2.Driver
-username: sa
-password: 

### 6. Swagger
Colocar no seu browser o endereço http://localhost:8090/swagger-ui/index.html
