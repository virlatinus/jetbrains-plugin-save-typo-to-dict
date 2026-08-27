
.PHONY: build

build:
	docker run --rm \
  -v "$(PWD)":/home/gradle/project \
  -w /home/gradle/project \
  gradle:8-jdk21 \
  gradle buildPlugin --no-daemon
