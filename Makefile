services-up:
	@echo "Running Service = ${SERVICE}"
	docker-compose -f docker-compose.yaml up --build ${SERVICE}
services-stop:
	docker compose stop
services-down:
	docker compose docker-compose.yaml down
app-build:
	/bin/sh ./gradlew assemble
