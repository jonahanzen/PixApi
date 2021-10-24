# "Projetinho" com integração de pagamentos!

O sistema conta com integração de pagamento pelo GerenciaNet, utilizando o Pix. o sistema pode criar uma cobrança, e também consultar todas as cobranças. 

### Ferramentas utilizadas e/ou dependências

- JAVA SE 16

- Spring / Spring Boot

- Postman

- Maven

- Ter uma conta e API Pix no GerenciaNet :smile:

### Endpoints :

- **GET**: api/pix   Mostra todas as cobranças feitas no período.

    - exemplo: https://localhost:8080/api/pix  

- **POST**: api/pix/nome/cpf/valor    Cria uma cobrança com os parametros passados para o endpoint (nome,cpf,valor)

    - exemplo: https://localhost:8080/api/pix/joao/01234567890/0.32

### Instruções : 

- Coloque as informações da sua aplicação no src/main/resources/credentials.json

- Coloque o certificado em src/main/resources, ou altere as informações com o caminho correto em src/main/resources/application.properties

- Em CriarCobranca.java, coloque a sua chave Pix ( a que ira receber os valores )


### Links e Informações adicionais : 

Exemplos em JAVA do próprio GerenciaNet: https://github.com/gerencianet/gn-api-sdk-java-examples

Documentação GerenciaNet: https://dev.gerencianet.com.br/docs

Collection do Postman da API do GerenciaNet: https://documenter.getpostman.com/view/13574984/TVzVgvBA

Em ConsultarCobranca você pode alterar a data de inicio e final, apenas lembre-se que, se houverem muitas cobranças, paginar os resultados, e tomar cuidado com o uso de memória. :smile: 

Em CriarCobranca, você pode alterar em quanto tempo a cobrança vai expirar, e também pode alterar o pattern que utilizei no regex para criar uma string de cobrança aleatória.