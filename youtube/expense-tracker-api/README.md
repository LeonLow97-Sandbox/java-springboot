# Setup

1. Creating a docker image for the PostgreSQL database.
  - `docker container run --name postgresdb -e POSTGRES_PASSWORD=password -d -p 5433:5432 postgres`
  - `docker container ls`
2. Adding a postgresql script to the docker container.
  - `docker cp expensetracker_db.sql postgresdb:/`
  - `docker container exec -it postgresdb bash`
  - `ls`
3. Running the sql script in the docker container
  - `psql -U postgres --file expensetracker_db.sql`
4. To enter interactive mode in container to access PostgreSQL again
  - `docker container exec -it postgresdb psql -U postgres`
  - In the interactive CLI, enter `\connect expensetrackerdb`

