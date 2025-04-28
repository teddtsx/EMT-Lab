# Docker Setup for EMT Shop Application

This guide explains how to set up and run the EMT Shop application using Docker.

## Prerequisites

- [Docker](https://www.docker.com/products/docker-desktop/) installed on your machine
- [Docker Compose](https://docs.docker.com/compose/install/) installed on your machine

## Running the Application

### Using Docker Compose (Recommended)

1. Navigate to the project root directory (where the `docker-compose.yml` file is located)
2. Run the following command to build and start the application:

```bash
docker-compose up -d
```

This will:
- Build the application image
- Start a PostgreSQL database
- Start the application connected to the database
- The `-d` flag runs the containers in detached mode (in the background)

3. To stop the application, run:

```bash
docker-compose down
```

4. To stop the application and remove volumes (this will delete the database data), run:

```bash
docker-compose down -v
```

### Using Docker Directly

If you prefer to run the containers separately:

1. Build the application image:

```bash
docker build -t emt-shop-app .
```

2. Create a network:

```bash
docker network create emt-network
```

3. Start PostgreSQL:

```bash
docker run -d --name postgres --network emt-network -p 2345:5432 \
  -e POSTGRES_DB=emt_shop \
  -e POSTGRES_USER=emt \
  -e POSTGRES_PASSWORD=emt \
  postgres:15
```

4. Start the application:

```bash
docker run -d --name emt-shop-app --network emt-network -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/emt_shop \
  -e SPRING_DATASOURCE_USERNAME=emt \
  -e SPRING_DATASOURCE_PASSWORD=emt \
  -e SPRING_JPA_HIBERNATE_DDL_AUTO=create-drop \
  emt-shop-app
```

## Accessing the Application

Once the application is running, you can access it at:

- Application: http://localhost:8080
- API Documentation (if enabled): http://localhost:8080/swagger-ui.html

## Troubleshooting

### Database Connection Issues

If the application cannot connect to the database:

1. Check if the PostgreSQL container is running:

```bash
docker ps
```

2. Check the logs of the application:

```bash
docker logs emt-shop-app
```

3. Make sure the network is properly set up:

```bash
docker network inspect emt-network
```

### Application Build Issues

If there are issues building the application:

1. Check the build logs:

```bash
docker-compose logs app
```

2. Try building with verbose output:

```bash
docker-compose build --no-cache app
```

## Notes

- The database data is persisted in a Docker volume named `postgres-data`
- The application runs on port 8080
- The PostgreSQL database runs on port 2345 (mapped to 5432 inside the container)