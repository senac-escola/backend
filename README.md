# Backend ⚙️

> O backend é contruído em [Java](https://www.oracle.com/java/technologies/downloads/) com [Spring](https://spring.io/), e implantado na [DigitalOcean](https://www.digitalocean.com/).

## 🔎 Como utilizar

- Clone o repositório com o comando abaixo:

```console
git clone https://github.com/senac-escola/backend.git
```

- Verifique se a URL do banco de dados na connection-string do arquivo `application-local.properties` está correta, assim como os credenciais, no arquivo abaixo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/escola
spring.datasource.username=admin
spring.datasource.password=123
```

- Dentro da pasta clonada em sua máquina, execute o comando abaixo:

```console
./mvnw spring-boot:run
```

_Para mais informações, consulte a nossa [documentação](https://senac-escola-docs.vercel.app/)._

## 📋 Issues

Fique à vontade para abrir uma issue caso encontre algum bug ou tenha alguma sugestão, assim podemos discutir o melhor caminho para melhorá-la ou corrigi-lá.

## 👋 Contribuição

Por se tratar de um projeto acadêmico, não estamos aceitando contribuições externas, mas o projeto pode ser utilizado para fins de estudo e ou desenvolvimento de aplicações similares.

## 📜 Licença

Este projeto é feito sobre a licença GPL-3.0, para mais informações sobre a sua possível utilização, modificação e compartilhamento, [clique aqui](LICENSE).
