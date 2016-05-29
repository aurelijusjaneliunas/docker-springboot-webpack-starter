# docker-springboot-webpack-starter

This is a starter project for a spring boot app with webpack built frontend that uses docker for dev enironment.  
Docker and docker-compose is all you need to develop, build & deploy, run development or production mode with a single command.

## stack
Java 1.8  
node 5.10  
Postgres 9.5  
SpringBoot 1.3.3  
Webpack  
Stylus   
Nginx  
Gunicorn


## get started

Get latest docker & docker-compose:  
https://www.docker.com/  
https://docs.docker.com/compose/

Start dev server:
```sh
./bin/develop.sh
```
Wait for docker to set up container, then open [http://localhost:8080](http://localhost:8080)

## production mode

```sh
# build production images, create db backup & start
./bin/deploy.sh

# stop server
./bin/stop_production.sh

# start srever
./bin/start_production.sh
```

In prod mode sources are added to docker image rather than mounted from host. Nginx serves static files, proxy pass to gunicorn for spring boot app. Logs in `logs` dir.

#### enable ssl
Copy your .key and .crt files to `nginx/ssl` and run `./bin/deploy.sh`.

## install dependencies
```sh
# frontend
./bin/npm.sh install [package] --save-dev

# backend
./bin/pipinstall.sh [pacakge] #will also add entry to backend/requirements.txt
```

## backup & restore database

```sh
# create a backup in backups dir
./bin/backup.sh

# restore from a backup in backups dir (server must be stopped)
./bin/restore.sh backups/somebackup.bak
```

## layout

```
bin/                          - various utility scripts

docker-compose.yml            - base docker compose config
docker-compose.overrides.yml  - development docker compose config
docker-compose.production.yml - production docker compose config

frontend/                     - frontend stuff
frontend/package.json         - npm package file with frotnend dependencies
frontend/src/js/              - javascript code
frontend/src/js/index.js      - js entry point. include other js deps here
frontend/src/style/           - stylesheets       
frontend/src/style/index.styl - stylesheet entry point. include other styl files here

backend/                      - backend stuff
backend/src/                  - spring boot apps

logs/                         - in prod mode app, gunicorn, nginx, postgres logs go here
nginx/                        - nginx stuff for prod mode
nginx/ssl/                    - put key & cert here if you use ssl
nginx/nginx_nossl.conf        - nginx conf if no ssl is used
nginx/nginx_ssl.conf          - nginx conf for deploy with ssl
```
