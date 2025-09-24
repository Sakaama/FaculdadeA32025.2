# Sistema de Gestão de Projetos Corporativos

## Descrição

Este projeto é um sistema que ajuda a gerenciar projetos de empresas, feito com Spring Boot no backend e Thymeleaf + Bootstrap no frontend.  

A ideia é facilitar o controle das demandas, aprovações, alocação de equipes, acompanhamento das tarefas e geração de relatórios.

## Funcionalidades principais

- Permite que o cliente envie novas demandas/projetos.  
- Gerentes podem aprovar ou rejeitar esses projetos.  
- Projetos aprovados são alocados para equipes específicas.  
- As equipes gerenciam as tarefas ligadas a cada projeto.  
- O sistema controla o status e as fases dos trabalhos.  
- Tem dashboards e relatórios pra ajudar a tomar decisões.  
- Segurança de acesso conforme o perfil do usuário: cliente, gerente ou funcionário.

## Como o grupo dividiu o trabalho

- **Aluno 1:** Montou o projeto, banco de dados, segurança, e criou as entidades principais.  
- **Aluno 2:** Trabalhou no módulo do cliente, envio e aprovação das demandas.  
- **Aluno 3:** Fez o módulo que aloca os projetos para as equipes e controla as fases.  
- **Aluno 4:** Criou o sistema das tarefas, para as equipes verem e atualizarem.  
- **Aluno 5:** Desenvolveu os relatórios e dashboards para análises e métricas.  
- **Interface:** Um integrante cuidou do layout e design para o sistema ficar mais usuário-amigável.

## Tecnologias usadas

- Java 17 com Spring Boot  
- Thymeleaf para as páginas HTML  
- Bootstrap 5 para o design responsivo  
- Banco de dados MySQL ou H2  
- Git/GitHub para controle das versões

## Como rodar o projeto

1. Clone o repositório.  
2. Configure o banco (no arquivo `application.properties`).  
3. Rode `mvn clean install` para compilar.  
4. Use `mvn spring-boot:run` para iniciar.  
5. Acesse `http://localhost:8080` no navegador.

## Integrantes

- Cindy — Clientes e início de projetos  
- Luan — Gestão de tarefas e execução  
- Edislan — Setup, segurança e entidades básicas  
- Lucas — Gestão e alocação de projetos  
- Jhousier — Relatórios e desempenho  
- Carlos — Frontend e interface gráfica
