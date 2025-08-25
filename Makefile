default: docker-rebuild

docker-rebuild:
	docker compose up -d --no-deps --build
	docker compose up

migrations:
    docker-compose --profile migrations up migrations

docker-clean-win:
	docker stop $(docker ps -qa) | ForEach-Object { docker rm $_ } ; docker volume rm $(docker volume ls -q) ; docker network rm $(docker network ls -q | Where-Object { $_ -ne 'nat' -and $_ -ne 'none' -and $_ -ne 'bridge' })

docker-clean:
	docker stop $(docker ps -qa) && docker rm $(docker ps -qa) && docker volume rm $(docker volume ls -q) && docker network rm $(docker network ls -q)