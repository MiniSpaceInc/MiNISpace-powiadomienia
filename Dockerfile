FROM --platform=linux/amd64 maven:3.9.6-amazoncorretto-21-debian

WORKDIR /app

COPY . .
RUN chmod +x entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]
