FROM ubuntu:latest
LABEL authors="miqueias"

ENTRYPOINT ["top", "-b"]