# proj-cadas-funcionarios

## Sistema simples para cadastro de funcionários


### Tela inicial

O sistema cadastra o nome completo do funcionário, cargo, sexo e data de nascimento. O ID e a data de cadastro são gerado automaticamente, sendo o ID, de forma sequencial.

Na página inicial, o sistema informa a quantidade de funcionários e exibi uma tabéla informando como esses funcionários estão distribuidos nos cargos cadastrados.

Ainda na tela inicial, logo após a tabela citada, também são gerados botões com os cargos cadastrados, e a clicar nesses botões, é gerado uma tabela contendo o nome e o ID de cada funcionário pertecente ao determinado cargo.

Após a consulta citada acima, é possivel localizar todos os dados do funcionário a partir do ID


### Tela de Cadastro

Tela onde será possível cadastrar o nome completo do funcionário, cargo, sexo e data de nascimento. Caso algum dos dados esteja em branco, o sistema não cadastrará o funcionário.


### Telas de atualização dos dados do funcionário e tela de exclusão de funcionário

Em ambas as telas, é possível encontrar o funcionário tanto através do nome completo quanto do ID, sendo que na tela de atualização, não é possível alterar nem o ID nem a data de cadastro. Quanto aos dados exibidos na tela de exclusão, não é possível alterar qualquer um dos campos, apenas sendo possível deletar todo o cadastro do funcionário através do botão Deletar.


### Acesso ao banco

Como informado no arquivo application.properties, o nome banco é "teste_hibernate", o usuário é "root" e a senha é "Root135135". Caso necessário fazer o projeto em algum outro banco, com outros dados, essas alterações devem ser feitas também no arquivo application.properties


### Tecnologias usadas

No projeto foi utilizado a linguagem de programação Java versão 11, na IDE Eclipse. O projeto segue o padrão MVC através do Spring Boot 2.3.8, projeto Marven.

As dependencias adicionadas no projeto ao ser criado foram a Spring Boot DevTools e a Spring Web. Logo após o download foram acrescentadas no arquivo porm.xml as dependencias spring-boot-starter-data-jpa, mysql-connector-java e spring-boot-starter-thymeleaf.

Para acesso a banco de dados, foi usado o jpa, através do hibernate, acessando o banco de dados mysql.

Na questão do Front-End, foi usado o html 5, css 3 e javascript. 

Para inciar a tela principal com os dados vindos do banco, foi usando a dependencia thymeleaf e para usar fazer as consultas Ajax, foi utilizado o Jquery.
