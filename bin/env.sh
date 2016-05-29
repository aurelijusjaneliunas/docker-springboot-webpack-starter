export DOCKER_CONFIG_PROD=${DOCKER_CONFIG_PROD:-docker-compose.production.yml}
export DOCKER_CONFIG_DEV=${DOCKER_CONFIG_DEV:-docker-compose.override.yml}

export DB_USER=${DB_USER:-postgres}
export DB_NAME=${DB_NAME:-postgres}

export SPRING_SETTINGS_DEV=${SPRING_SETTINGS_DEV:-dev}
export SPRING_SETTINGS_PROD=${SPRING_SETTINGS_MODULE:-prod}

dcdev() {
    docker-compose -f docker-compose.yml -f $DOCKER_CONFIG_DEV "$@"
}

dcprod() {
    docker-compose -f docker-compose.yml -f $DOCKER_CONFIG_PROD "$@"
}
