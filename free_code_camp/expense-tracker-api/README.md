# Setup

1. Creating a docker image for the PostgreSQL database.
  - 
2. Adding a postgresql script to the docker container.
  - `docker cp expensetracker_db.sql postgresdb:/`
  - `docker container exec -it postgresdb bash`
  - `ls`
3. Running the sql script in the docker container
  - `psql -U postgres --file expensetracker_db.sql`