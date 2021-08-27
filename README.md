# Description

API backend for the AniRec application.

Supported entities:

- [x] Users
- [x] Anime
- [x] Genres
- [x] Characters
- [ ] Favorites (Anime and Genre)
- [x] Reviews
- [x] Snippets
- [ ] Upvotes

Supported features:

- searching using keywords

# Requirements

1. IDE (Eclipse or IntelliJ)
2. JDK 11+
3. MySql database (**AniRec** schema)
4. (Optional) **Postman** or **Curl** (CLI) for testing the API

# Running

## IDE

- Make sure you have the build plugins installed and configured
  (spring-boot-maven-plugin)

- `Run` in IDE

## Terminal

- Build and run project with maven

```shell
./mvnw spring-boot:run
```

- for Windows, run the `cmd` script instead

```shell
./mvnw.cmd spring-boot:run
```

# Usage

Once the server is up, it will be accessible at `localhost:8080`.

# Testing

- Configure the connection to your local MySQL database (or a remote one if you have access)

- Start up the server

- After the server comes up, you can test individual endpoints through "Postman" or
  "curl".

- for example, running a `GET` request on `localhost:8080/api/anime` will
  retrieve a list of all anime in the database
