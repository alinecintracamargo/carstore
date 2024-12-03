# Carstore - Gerenciamento de Veículos e Usuários

Bem-vindo ao **Carstore**, um projeto de aplicação web desenvolvido em Java para o gerenciamento de veículos e usuários. Este sistema inclui funcionalidades completas de CRUD (Create, Read, Update, Delete) e autenticação de usuários, proporcionando segurança e facilidade no uso.

## Funcionalidades Principais

- **Cadastro de Veículos**:
  - Criação de registros de veículos com informações detalhadas, como modelo, fabricante, ano, preço e outras características.
  - Atualização e exclusão de veículos existentes.
  - Listagem de veículos cadastrados.

- **Gerenciamento de Usuários**:
  - Registro e autenticação de usuários.
  - Sistema de login.
  - Controle de acesso baseado em roles (usuário padrão e administrador).

- **Integração com Banco de Dados**:
  - Utilização do banco de dados **H2** para armazenamento de dados.
  - Scripts para criação de tabelas e inicialização do banco incluídos no projeto.

## Tecnologias Utilizadas

- **Backend**:
  - Linguagem: **Java**
  - Servidor: **Apache Tomcat**
  - Frameworks: **Servlets e JSP**

- **Banco de Dados**:
  - **H2 Database** (em modo embedado para desenvolvimento e testes).

- **Frontend**:
  - **HTML5, CSS3 e JavaScript**
  - Design responsivo com foco em usabilidade.

- **Segurança**:
  - Hashing de senhas com algoritmos seguros.
  - Validação e sanitização de entradas para evitar ataques como SQL Injection.

## Estrutura do Projeto

A estrutura segue uma organização clara para facilitar a navegação e a manutenção:

- **/src**:
  - Contém as classes Java para a lógica de negócio, como `CreatePessoaServlet`, `LoginServlet`, e outras classes relacionadas ao CRUD e autenticação.

- **/webapp**:
  - Arquivos JSP para renderização do frontend.
  - Recursos estáticos como CSS e JavaScript.

- **/resources**:
  - Scripts SQL para inicialização do banco de dados.

## Requisitos do Sistema

- **Java JDK** 11 ou superior.
- **Apache Tomcat** 9 ou superior.
- Navegador moderno (Google Chrome, Mozilla Firefox, etc.).

## Como Executar o Projeto

1. **Clonar o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/carstore.git
   cd carstore
   ```

2. **Configurar o Ambiente**:
   - Certifique-se de ter o JDK instalado e configurado.
   - Configure o Apache Tomcat no seu IDE (ex.: Eclipse, IntelliJ IDEA).

3. **Inicializar o Banco de Dados**:
   - Execute os scripts SQL localizados em `/resources` para criar as tabelas necessárias no H2.

4. **Implantar a Aplicação**:
   - Compile o projeto e implante o arquivo `.war` no Tomcat.

5. **Acessar o Sistema**:
   - Abra o navegador e acesse `http://localhost:8080/carstore`.

## Melhorias Futuras

- Integração com bancos de dados mais robustos, como PostgreSQL ou MySQL.
- Implementação de APIs RESTful para facilitar integrações.
- Melhorias na interface gráfica com frameworks como Bootstrap ou Materialize.
- Testes automatizados para garantir a qualidade do código.

## Contribuições

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Fork o repositório.
2. Crie uma branch para a sua feature:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das suas alterações e envie um pull request.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE). Sinta-se à vontade para usar e modificar conforme necessário.

