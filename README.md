# MiNISpace-powiadomienia
Module for MiNISpace application - MiNISpace-powiadomienia that is responsible for sending notifications

# Usage and requirements
## Non-dockerized version
1. JDK of Java version 21
2. RabbitMQ - https://github.com/rabbitmq/rabbitmq-server/releases/tag/v3.12.14
3. Erlang - https://www.erlang.org/downloads
4. Setup environment variable ERLANG_HOME -> C:\Location of erlang
5. Add %ERLANG_HOME%\bin to the PATH environmental variable
6. Locate folder of downloaded RabbitMQ server and head into sbin folder
7. Inside sbin folder run command: ./rabbitmq-server start
8. Now with working rabbitmq server run application

## Dockerized version
Work in progress

# Utils
## RabbitMQ 
The default port for web console of RabbitMQ is 15672.
In order to access the web console of the RabbitMQ go to URL_TO_RABBITMQ_BROKER:15672 
and login using credentials. 