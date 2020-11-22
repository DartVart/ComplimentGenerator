# Compliment generator
Here you can start a website that gives you a little of happiness! 😁
## Launch
Firstly, you need to build a docker image and remove intermediate build items.
```bash
docker build -t compliment-generator .
docker image prune --filter label=stage=complimentGeneratorBuilder
```
Secondly, you should start the container.
```bash
docker run -d -p 8080:8080 --rm compliment-generator
```
Thirdly, enjoy!