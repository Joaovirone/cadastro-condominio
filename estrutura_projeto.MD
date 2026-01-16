src/main/java/com/condominio/sistema
│
├── SistemaCondominioApplication.java
│
├── domain                  <-- O CORAÇÃO DO SISTEMA (Puro Java, sem frameworks)
│   ├── model               <-- Entidades e Value Objects
│   │   ├── morador
│   │   │   ├── Morador.java
│   │   │   └── CPF.java    <-- Value Object
│   │   ├── unidade
│   │   │   ├── Unidade.java
│   │   │   └── Bloco.java
│   │   └── garagem
│   │       └── Vaga.java
│   ├── repository          <-- Interfaces dos Repositórios (Contratos)
│   │   ├── MoradorRepository.java
│   │   └── UnidadeRepository.java
│   ├── service             <-- Regras de Domínio puras (se houver)
│   └── exception           <-- Exceções de negócio (ex: VagaOcupadaException)
│
├── application             <-- CAMADA DE APLICAÇÃO (Casos de Uso)
│   ├── dtos                <-- Data Transfer Objects (entrada/saída da API)
│   │   ├── MoradorDTO.java
│   │   └── RegistroUnidadeDTO.java
│   └── service             <-- Orquestração (Chama repositório, envia email, etc)
│       ├── RegistrarMoradorService.java
│       └── AlocarVagaService.java
│
├── infrastructure          <-- CAMADA DE INFRAESTRUTURA (Onde o Spring brilha)
│   ├── configuration       <-- Configs do Spring (Beans, Swagger, Cors)
│   ├── persistence         <-- Implementação do banco de dados
│   │   ├── entities        <-- Entidades JPA (anotadas com @Entity)
│   │   ├── repositories    <-- Interfaces JpaRepository do Spring
│   │   └── mappers         <-- Converte Entidade JPA <-> Entidade de Domínio
│   └── security            <-- Configurações de Segurança
│       ├── SecurityConfig.java
│       ├── TokenService.java
│       └── UserDetailsServiceImpl.java
│
└── interfaces              <-- CAMADA DE INTERFACE (Entrada externa)
    └── controllers         <-- REST Controllers
        ├── MoradorController.java
        └── AuthController.java
