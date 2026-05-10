# 🌱 NutriConecta

Sistema web para gerenciamento de doações de alimentos, conectando doadores e instituições de forma transparente e organizada.

---

## 📋 Sobre o Projeto

O **NutriConecta** é uma aplicação desenvolvida com Spring Boot que facilita o processo de doação de alimentos. A plataforma permite que doadores cadastrem doações, instituições façam solicitações e todo o ciclo — desde a oferta até a retirada — seja acompanhado com controle de status.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Security + JWT | JJWT 0.11.5 |
| Spring Data JPA | — |
| Thymeleaf | — |
| MySQL | — |
| Lombok | — |
| Bootstrap | 5 (via static) |
| Maven | — |

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas padrão MVC:

```
src/main/java/br/com/nutriconecta/nutriconecta/
├── controller/       # Controladores MVC (rotas web)
├── dto/              # Data Transfer Objects
├── exception/        # Tratamento global de exceções
├── model/            # Entidades JPA
│   └── enums/        # Enumerações de status
├── repository/       # Repositórios Spring Data
├── security/         # Configuração JWT e Spring Security
└── service/          # Interfaces e implementações de serviço
    └── impl/
```

---

## 📦 Entidades do Domínio

- **Usuario** — Doadores, Instituições e Administradores (`DOADOR`, `INSTITUICAO`, `ADMIN`)
- **Doacao** — Oferta de alimentos com título, descrição, quantidade e data de expiração
- **ItemDoacao** — Itens específicos vinculados a uma doação
- **Alimento** — Cadastro de tipos de alimentos
- **Solicitacao** — Pedido de uma instituição para receber uma doação
- **Retirada** — Registro da retirada física dos alimentos
- **Endereco** — Endereço associado a usuários ou doações

### Status de Doação
`ABERTA` → `EM_ANDAMENTO` → `RESERVADA` → `CONCLUIDA` / `CANCELADA`

### Status de Solicitação
`PENDENTE` → `APROVADA` / `REJEITADA` / `CANCELADA`

---

## 🔐 Segurança

A autenticação utiliza **JWT (JSON Web Token)** com Spring Security:

- Sessão **stateless** (sem estado no servidor)
- Senhas criptografadas com **BCrypt**
- Filtro JWT aplicado antes do filtro de autenticação padrão
- Rotas públicas: `/`, `/css/**`, `/js/**`, `/images/**`, `/api/auth/**`

---

## ⚙️ Configuração e Execução

### Pré-requisitos

- Java 17+
- Maven 3.8+
- MySQL 8+

### 1. Banco de Dados

Crie o banco de dados no MySQL:

```sql
CREATE DATABASE dbnutriconecta;
```

### 2. Configuração

Edite o arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dbnutriconecta?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 3. Executar

```bash
# Com Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Ou no Windows
mvnw.cmd spring-boot:run
```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## 🌐 Rotas Principais

| Rota | Descrição |
|---|---|
| `GET /` | Página inicial |
| `GET /usuarios/listar` | Lista de usuários |
| `GET /doacoes/listar` | Lista de doações |
| `GET /alimentos/listar` | Catálogo de alimentos |
| `GET /solicitacoes/listar` | Lista de solicitações |
| `GET /retiradas/listar` | Lista de retiradas |
| `POST /api/auth/**` | Autenticação JWT |

---

## 📁 Estrutura de Templates (Thymeleaf)

```
templates/
├── index.html
├── fragments/
│   ├── header.html
│   └── footer.html
├── alimentos/
│   ├── lista.html
│   └── form.html
├── doacoes/
│   ├── lista.html
│   └── form.html
├── retiradas/
│   ├── lista.html
│   └── form.html
└── solicitacoes/
    ├── lista.html
    └── form.html
```

---

## 🤝 Como Contribuir

1. Faça um fork do projeto
2. Crie uma branch para sua feature: `git checkout -b feature/minha-feature`
3. Commit suas alterações: `git commit -m 'feat: adiciona minha feature'`
4. Push para a branch: `git push origin feature/minha-feature`
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está sob desenvolvimento. Consulte os responsáveis para informações sobre licenciamento.
