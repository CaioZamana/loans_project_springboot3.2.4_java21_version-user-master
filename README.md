# Aplicação API RESTFul de um sistema de empréstimos
## Loans Project with Clean Architecture

### Clean Architecture
Este projeto adota os princípios da Arquitetura Limpa (Clean Architecture) para garantir uma estrutura modular e altamente testável utilizando o Spring Framework.

## Documentation of API Rest with Swagger UI
[Swagger UI](http://loans2024java20.sa-east-1.elasticbeanstalk.com/swagger-ui/index.html)

## Fluxo de requisições da Arquitetura RESTful

A imagem ilustra o fluxo de requisições em uma aplicação web API Rest com Spring Framework, detalhando as etapas envolvidas no processamento de uma requisição HTTP.
![request-flow-api-rest.jpg](src%2Fmain%2Fresources%2Fstatic%2Frequest-flow-api-rest.jpg)

Abaixo está uma visão geral do fluxo de requisições na arquitetura:

1. **Cliente**:
    - O cliente envia requisições HTTP (POST, GET, PUT, PATCH, DELETE) para a API RESTful.

2. **Camada de requisições (Controller)**:
    - Os controladores (Controllers) recebem as requisições HTTP do cliente e as direcionam para os respectivos métodos de manipulação de recursos.
    - Cada controlador define os endpoints da API e mapeia as requisições para métodos específicos.

3. **Camada de transferência/conversão (DTO)**:
    - Antes de processar as requisições, os dados recebidos do cliente são convertidos para objetos de transferência de dados (DTOs).
    - Os DTOs são utilizados para transferir dados entre a camada dos controladores (Controllers) e a camada de serviço, encapsulando apenas as informações relevantes.

4. **Camada Lógica de Negócio (Service)**:
    - A camada de serviço implementa a lógica de negócio da aplicação e processa as requisições, realizando as operações desejadas.
    - Ela inclui validações, cálculos, acesso a serviços externos, entre outras operações específicas do domínio da aplicação.

5. **Camada de Entidade(Entity)**:
   - A camada de entidade define os objetos de dados que representam as entidades do domínio da aplicação.
   - As entidades mapeiam diretamente para as tabelas do banco de dados em sistemas de persistência relacionais.
   - Elas encapsulam o estado e o comportamento dos objetos de negócio da aplicação.

6. **Camada de Persistência (Repository)**:
    - Após a lógica de negócio processar a requisição, ela pode interagir com a camada de persistência para armazenar ou recuperar dados no banco de dados.
    - Os repositórios fornecem acesso aos dados armazenados e utilizam tecnologias como ORM (Object-Relational Mapping) ou JPA (Java Persistence API).

7. **Resposta (Response)**:
    - Após a conclusão da operação, a camada de serviço retorna uma resposta para o controlador, que constrói uma resposta HTTP apropriada e a envia de volta para o cliente.

## Diagrama de Classes da Aplicação de Empréstimos (UML Class Diagram Loan Application)
![uml-diagram-class.jpg](src%2Fmain%2Fresources%2Fstatic%2Fuml-diagram-class.jpg)

### Estrutura de Pacotes
A seguir, descrevemos a estrutura de pacotes:

- **controller**: Este pacote contém as classes que atuam como controladores, responsáveis por manipular as requisições HTTP e direcioná-las para o serviço apropriado.
- **documentation**: Aqui estão arquivos relacionados às especificações de API do sistema, neste caso utilizando o Swagger.
- **dto**: As classes DTO (Data Transfer Object) residem neste pacote. Elas são utilizadas para transferir dados entre o cliente e o servidor, fornecendo uma abstração dos detalhes de implementação interna.
- **Enum**: Enumerações importantes para o funcionamento do sistema são definidas neste pacote.
- **exception**: Classes de exceção personalizadas são colocadas aqui. Elas são usadas para lidar com exceções específicas do domínio ou da aplicação.
- **model**: Este pacote contém as classes de modelo, que representam as entidades principais do domínio da aplicação.
- **repository**: Aqui são definidas as interfaces de repositório, que fornecem métodos para acessar e manipular os dados no banco de dados.
- **security**: Contém as configurações de segurança, como autenticação e autorização.
- **service**: As classes de serviço residem neste pacote. Elas encapsulam a lógica de negócios da aplicação e são responsáveis por coordenar as operações entre os controladores e os repositórios.

#
### Contato:
<a href="https://www.linkedin.com/in/caiozamana/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank">
<a href="https://api.whatsapp.com/send?phone=55048991477921" target="_blank"><img src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white">
<a href = "mailto:caiobzm@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
<a href = "https://www.youtube.com/@CodeTechIntelligence"><img src="https://img.shields.io/badge/YouTube-red?style=for-the-badge&logo=youtube&logoColor=white" target="_blank"></a>

<table>
  <tr>
    <td>
      <img width="80px" align="center" src="https://avatars.githubusercontent.com/caiobello"/>
    </td>
    <td align="left">
      <a href="https://github.com/caiobello">
        <span><b>Caio B. Zamana</b></span>
      </a>
      <br>
      <span>Software Engineer</span>
    </td>
  </tr>
</table>