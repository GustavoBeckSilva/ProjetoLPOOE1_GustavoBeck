# Projeto de Sistema para Nutricionistas

Este é um projeto Java desenvolvido para a disciplina de Linguagem de Programação Orientada a Objetos, com o objetivo de criar um sistema para nutricionistas gerenciarem pacientes, calcularem o percentual de gordura corporal, criarem refeições e montarem dietas personalizadas. O projeto utiliza JPA para persistência de dados em um banco de dados PostgreSQL, gerenciado com Maven no NetBeans.

## Funcionalidades

O sistema oferece funcionalidades para:

- **Cadastrar pacientes e nutricionistas**: Cadastro de informações básicas e específicas.
- **Realizar exame de dobras cutâneas**: Cálculo de percentual de gordura corporal usando a técnica de Jackson e Pollock (7 dobras cutâneas).
- **Criar refeições e alimentos**: Registro de alimentos com informações nutricionais e agrupamento em refeições.
- **Montar dietas**: Estruturação de dietas com refeições diárias, incluindo calorias e macronutrientes.

## Estrutura das Classes

O sistema é estruturado em classes que representam as entidades principais e seus relacionamentos. Entre as principais classes estão:

- `Pessoa` (abstrata): Classe base para `Nutricionista` e `Paciente`.
- `Nutricionista`: Extende `Pessoa`, adicionando informações específicas do profissional.
- `Paciente`: Extende `Pessoa`, adicionando informações de percentual de gordura, massa magra, peso e altura.
- `Dieta`: Representa a dieta do paciente, composta por várias refeições.
- `Refeição`: Contém uma lista de alimentos com detalhes nutricionais.
- `Alimento`: Armazena dados nutricionais de cada alimento.

## Tecnologias e Dependências

O projeto utiliza as seguintes tecnologias e dependências:

- **Java 8+**: Linguagem principal.
- **NetBeans**: IDE para desenvolvimento.
- **Maven**: Gerenciador de dependências e build.
- **PostgreSQL**: Banco de dados relacional.
- **JDBC e JPA**: Conexão e persistência de dados.
- **JUnit**: Framework para testes unitários.

- ![Diagrama sem nome drawio (1)](https://github.com/user-attachments/assets/b76c659a-ffe3-4fb3-a122-a9cac74935d3)

- # Sistema de Gerenciamento Nutricional

Este projeto é um sistema de gerenciamento nutricional voltado para nutricionistas, permitindo o cadastro de pacientes, cálculo do percentual de gordura corporal, criação de refeições e montagem de dietas personalizadas. O sistema usa Java com JPA e PostgreSQL para gerenciar e persistir dados.

## Diagrama de Classes do Sistema

O diagrama de classes representa a estrutura principal do sistema, com as principais entidades e seus relacionamentos. Abaixo está a descrição detalhada de cada classe e seus relacionamentos.

### 1. Classes Principais

#### `Pessoa` (Classe Abstrata)
- A classe `Pessoa` serve como superclasse para `Nutricionista` e `Paciente`, agrupando atributos comuns a ambas as entidades.
- **Atributos**:
  - `id`: Identificador único de cada pessoa (gerado automaticamente).
  - `nome`: Nome completo da pessoa.
  - `dataNascimento`: Data de nascimento da pessoa.
  - `sexo`: Sexo da pessoa, armazenado como String.
- **Relação**:
  - Relacionamento de herança com as classes `Nutricionista` e `Paciente`.

#### `Nutricionista`
- Representa o nutricionista responsável por realizar exames e montar dietas.
- **Atributos**:
  - `registroProfissional`: Número de registro do profissional.
- **Relações**:
  - Herda de `Pessoa`.
  - Pode ter vários pacientes e criar dietas para eles.

#### `Paciente`
- Representa o paciente com dados necessários para avaliação nutricional.
- **Atributos**:
  - `percentualGordura`: Percentual de gordura corporal do paciente.
  - `percentualMassaMagra`: Percentual de massa magra do paciente.
  - `peso`: Peso do paciente em quilogramas.
  - `altura`: Altura do paciente em metros.
- **Relações**:
  - Herda de `Pessoa`.
  - Associa-se a um exame de dobras cutâneas e a uma dieta.

### 2. Exames e Cálculos

#### `ExameDobrasCutaneas`
- Representa um exame físico realizado pelo nutricionista para medir as dobras cutâneas do paciente e calcular o percentual de gordura.
- **Atributos**:
  - `dataExame`: Data de realização do exame.
  - `triceps`, `peito`, `subAxilar`, `subEscapular`, `abdominal`, `supraIliaca`, `coxa`: Medidas de dobras cutâneas (em milímetros).
- **Método**:
  - Cálculo do percentual de gordura corporal com base nas medidas de dobras cutâneas.
- **Relações**:
  - `Paciente` (associação): Um exame é realizado para um único paciente.

### 3. Dieta e Refeição

#### `Dieta`
- Representa o plano alimentar criado para um paciente específico.
- **Atributos**:
  - `dataInicio`: Data de início da dieta.
  - `dataFim`: Data de término da dieta.
- **Relações**:
  - `Paciente` (associação): Cada dieta pertence a um único paciente.
  - `Refeicao` (composição): Uma dieta possui uma lista de várias refeições, criando uma estrutura de alimentação completa.

#### `Refeicao`
- Representa uma refeição específica dentro de uma dieta, como café da manhã, almoço, etc.
- **Atributos**:
  - `tipoRefeicao`: Enum que define o tipo de refeição (`CAFÉ_DA_MANHÃ`, `ALMOÇO`, `JANTAR`, etc.).
- **Relações**:
  - `Dieta` (agregação): Pertence a uma dieta específica.
  - `Alimento` (composição): Uma refeição contém vários alimentos.

#### `Alimento`
- Representa um alimento específico, com valores nutricionais.
- **Atributos**:
  - `nome`: Nome do alimento.
  - `calorias`, `fibras`, `proteinas`, `gorduras`, `porcao`: Valores nutricionais do alimento.
- **Relações**:
  - `Refeicao`: Vários alimentos podem compor uma refeição específica.

## Banco de Dados e Configuração
- O sistema utiliza PostgreSQL para persistência de dados e JPA para o mapeamento objeto-relacional.
- O arquivo `persistence.xml` está configurado para realizar a criação e exclusão automática das tabelas no banco de dados durante o desenvolvimento.

## Requisitos
- **Java** 11 ou superior.
- **PostgreSQL**.
- **Maven** para gerenciamento de dependências.

## Executando o Projeto
1. Clone o repositório.
2. Configure o banco de dados PostgreSQL com as credenciais corretas no `persistence.xml`.
3. Compile e execute o projeto pelo Maven.
4. Os dados e as operações do sistema serão persistidos e visualizados diretamente no console.

## Testes
O sistema inclui testes JUnit para verificar a persistência das classes principais e seus relacionamentos no banco de dados, cobrindo:
- Cadastro de um paciente.
- Realização de um exame de dobras cutâneas.
- Registro de uma refeição.
- Montagem de uma dieta com refeições.

---
