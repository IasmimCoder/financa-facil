# Ficha Técnica

## FinancaFacil - Organize suas Finanças Pessoais

Este documento fornece uma visão geral técnica do projeto FinancaFacil, destacando as tecnologias utilizadas, a escolha de ferramentas específicas e as razões por trás dessas decisões.

## Tecnologias Utilizadas

### Spring Boot

O FinancaFacil utiliza o Spring Boot como o framework principal para o desenvolvimento Java. O Spring Boot simplifica a configuração e o desenvolvimento de aplicativos Spring, oferecendo convenções sensatas, facilitando a criação de aplicativos robustos e prontos para produção.

### Spring Data JPA (Hibernate)

O Spring Data JPA é uma extensão do Spring que simplifica ainda mais o acesso a dados em aplicativos Java baseados em Spring. No FinancaFacil, utilizamos o Hibernate como a implementação JPA. O Hibernate é uma escolha comum para mapeamento objeto-relacional (ORM) devido à sua ampla adoção, flexibilidade e funcionalidades avançadas.

#### JPA (Java Persistence API):
1. Definição: JPA é uma especificação Java que descreve uma interface padrão para o mapeamento objeto-relacional e operações de persistência em Java. Foi introduzida como parte da Java EE (Enterprise Edition) 5.

2. Objetivo: Fornecer uma maneira padronizada de persistir objetos Java em bancos de dados relacionais, simplificando o código e facilitando a interoperabilidade entre diferentes implementações de ORM.

3. Características:

    - Mapeamento Objeto-Relacional (ORM): Permite que objetos Java sejam mapeados diretamente para tabelas de banco de dados relacionais.
    - API Padrão: Define uma API comum para realizar operações de persistência, consultas e transações.
    - Anotações: Utiliza anotações Java para configurar o mapeamento entre entidades e tabelas, relacionamentos, etc.
    - Consulta JPQL (Java Persistence Query Language): Uma linguagem de consulta orientada a objetos similar ao SQL, mas específica para entidades Java.

#### Hibernate:
1. Definição: Hibernate é uma implementação da especificação JPA e também um framework ORM de código aberto para Java.

2. Objetivo: Facilitar o mapeamento objeto-relacional e fornecer uma implementação robusta para operações de persistência, consultas e transações.

3. Características:

    - Mapeamento Objeto-Relacional: Permite o mapeamento de entidades Java para tabelas de banco de dados.
    - Cache: Oferece suporte a diferentes tipos de cache para melhorar o desempenho.
    - Linguagem de Consulta HQL (Hibernate Query Language): Similar à JPQL, mas específica do Hibernate.
    - Eventos e Interceptadores: Permite que você defina eventos e interceptadores para personalizar o comportamento do Hibernate.

#### Como eles funcionam juntos:
 - JPA fornece uma especificação padrão para mapeamento objeto-relacional, enquanto Hibernate é uma implementação dessa especificação. Outras implementações de JPA também existem, como EclipseLink e Apache OpenJPA.

 - Na prática, muitas aplicações Java usam o Hibernate como a implementação de referência JPA devido à sua rica funcionalidade e ampla adoção na comunidade.

- Quando você desenvolve uma aplicação JPA usando Hibernate, você escreve código de entidade, utiliza anotações para configurar o mapeamento e realiza operações de persistência usando APIs padrão JPA, mas o Hibernate é a implementação concreta que executa essas operações.

- Em resumo, JPA define a interface padrão, e Hibernate (ou outra implementação) fornece a implementação específica que lida com as operações de persistência nos bastidores. Isso permite que você troque facilmente de uma implementação JPA para outra, se necessário, mantendo o mesmo código de aplicação.

#### Mapeamento Objeto-Relacional (ORM)

O Hibernate facilita o mapeamento entre entidades Java e tabelas de banco de dados relacionais. Isso permite que as transações financeiras sejam representadas como objetos Java, simplificando o código e melhorando a manutenção do sistema.

### PostgreSQL

O PostgreSQL foi escolhido como o banco de dados para o FinancaFacil devido à sua robustez, conformidade com padrões SQL e suporte a recursos avançados. A integração com o Spring Boot é direta, proporcionando uma experiência de desenvolvimento tranquila.

## Jakarta Persistence API (JPA)

O projeto faz uso da Jakarta Persistence API (JPA), uma especificação Java que descreve uma interface padrão para o mapeamento objeto-relacional. A escolha da JPA permite que o FinancaFacil seja independente de uma implementação específica (como Hibernate, EclipseLink, etc.), facilitando a portabilidade do código entre diferentes provedores JPA.

### Motivação para Jakarta Persistence API (JPA)

A transição de Java EE para Jakarta EE impulsionou a mudança do JPA para o Jakarta Persistence API. A adoção da JPA oferece uma solução padronizada e moderna para o mapeamento objeto-relacional, mantendo a interoperabilidade com diversas implementações.

## Estrutura do Projeto

O projeto segue uma estrutura organizada, com diretórios distintos para controladores, modelos, repositórios, serviços e recursos estáticos. Essa organização facilita a manutenção do código, permitindo uma visão clara das responsabilidades de cada componente.

