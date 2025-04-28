# Docker Setup Overview

## Architecture

The Docker setup for this application consists of two main services:

1. **Application Service (app)**
   - Built from the project's source code using a multi-stage Docker build
   - Uses Java 21 (Eclipse Temurin distribution)
   - Exposes port 8080 for web access
   - Connects to the PostgreSQL database

2. **Database Service (postgres)**
   - Uses PostgreSQL 15 official image
   - Stores data in a persistent volume
   - Exposes port 2345 (mapped to internal port 5432)
   - Configured with database name, username, and password

## Files Overview

### Dockerfile

The `Dockerfile` uses a multi-stage build approach:
- First stage: Builds the application using Maven
- Second stage: Creates a minimal runtime image with just the JRE and the built JAR file

This approach results in a smaller final image that doesn't include build tools or source code.

### docker-compose.yml

The `docker-compose.yml` file:
- Defines both services (app and postgres)
- Sets up networking between them
- Configures environment variables
- Maps ports to the host
- Sets up volume for database persistence

### .dockerignore

The `.dockerignore` file excludes unnecessary files from the Docker build context, making builds faster and more efficient.

## Environment Configuration

The application's database connection is configured through environment variables:
- `SPRING_DATASOURCE_URL`: Points to the postgres service
- `SPRING_DATASOURCE_USERNAME` and `SPRING_DATASOURCE_PASSWORD`: Match the PostgreSQL credentials
- `SPRING_JPA_HIBERNATE_DDL_AUTO`: Set to create-drop for development

## Network Configuration

A custom bridge network (`emt-network`) is created to allow the services to communicate with each other. Within this network:
- The app service can reach the postgres service using the hostname "postgres"
- The postgres service listens on its default port (5432)

## Data Persistence

Database data is persisted using a named volume (`postgres-data`). This ensures that data survives container restarts or removals.

## How to Use

For detailed instructions on how to build and run the application using Docker, please refer to the README.md file.

## Best Practices Implemented

1. **Multi-stage builds**: Reduces final image size
2. **Environment variables**: Makes configuration flexible
3. **Volume for data persistence**: Prevents data loss
4. **Dedicated network**: Isolates services
5. **.dockerignore**: Optimizes build process
6. **Official base images**: Ensures security and reliability
7. **Exposed ports**: Makes services accessible as needed