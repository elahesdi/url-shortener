# URL Shortener Application

A Spring Boot application that shortens URLs using an external API and caches the results in Redis. The application is designed to be deployed on Kubernetes.

## Table of Contents

- [URL Shortener Application](#url-shortener-application)
  - [Description](#description)
  - [Features](#features)
  - [Prerequisites](#prerequisites)
  - [Configuration](#configuration)

## Description

The URL Shortener Application is a Spring Boot project that shortens URLs by interacting with an external API. If a shortened URL is not found in the Redis cache, the application queries the external API, stores the result in Redis, and returns the shortened URL.

## Features

- URL shortening using an external API
- Caching in Redis for improved performance
- Kubernetes deployment-ready

## Prerequisites

Ensure you have the following installed before running the application:

- Java 17 or higher
- Maven
- Docker (for local development)
- Kubernetes (for deployment)


## Configuration

Update the application configuration in `src/main/resources/application.properties` according to your needs. You can use the following sample configuration as a starting point:

```properties
# src/main/resources/application.properties

redis.host=redis
spring.redis.port=6379
redis.duration=5
server.port=8085
api.URLShortener=https://api.apilayer.com/short_url/hash
api.key=sRwXp6WU8R7K7XPsOWDYo1sXaezh2n2p

