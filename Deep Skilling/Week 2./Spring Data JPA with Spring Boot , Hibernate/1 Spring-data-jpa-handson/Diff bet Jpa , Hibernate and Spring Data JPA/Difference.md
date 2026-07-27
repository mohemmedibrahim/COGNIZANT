# JPA, Hibernate and Spring Data JPA

## Introduction

JPA, Hibernate, and Spring Data JPA are widely used technologies for database persistence in Java applications. They work together to simplify database operations and object-relational mapping (ORM).

## What is JPA?

JPA (Java Persistence API) is a **specification** that defines the standard rules for mapping Java objects to database tables. It provides annotations such as `@Entity`, `@Table`, and `@Id` but requires an implementation like Hibernate.



## What is Hibernate?

Hibernate is an **implementation of JPA**. It provides the actual ORM functionality, manages database operations, and offers additional features like caching, HQL, and lazy loading.


## What is Spring Data JPA?

Spring Data JPA is a **Spring Framework module** built on top of JPA. It reduces boilerplate code by providing repository interfaces such as `JpaRepository` for CRUD operations.


## Difference between JPA, Hibernate and Spring Data JPA

| **JPA** | **Hibernate** | **Spring Data JPA** |
|---------|---------------|---------------------|
| Specification | JPA Implementation | Spring Module |
| Defines persistence rules | Implements JPA | Simplifies JPA development |
| Uses `EntityManager` | Uses `Session` | Uses `JpaRepository` |
| Cannot work alone | Can work independently | Works with Spring Boot |


## Conclusion

- **JPA** defines the persistence specification.
- **Hibernate** implements the JPA specification.
- **Spring Data JPA** makes database operations easier by reducing coding effort.