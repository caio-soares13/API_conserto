## 🐳 Docker

Esta aplicação usa Spring Boot + H2 com persistência em arquivo.

### 🚧 Pré-requisitos

- Docker instalado
- Pasta `DATA/` será criada automaticamente para armazenar o banco localmente.

### 🚀 Rodar com Docker

```bash
docker build -t auction-app .
docker run -p 8080:8080 -v $(pwd)/DATA:/app/DATA auction-app
