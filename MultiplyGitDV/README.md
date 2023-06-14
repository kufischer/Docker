Simple Thrift example for a multiplication server and a client using it.

Docker images can be run by the commands:

docker build -t server .
docker build -t client .

in the folder  .\aitoc\Docker\MultiplyGitDV\client and  .\aitoc\Docker\MultiplyGitDV\server .

To run the example the server should be started first by using:

docker run -p 9090:9090 -it server

and when server is started by starting the client with:

docker run -it client

Tags for server and client can be of course consistently changed.

Only difference between MultiplyGitDC and MultiplyGitDV is in files:

.\aitoc\Docker\MultiplyGitDC\client\src\main\java\thriftexample\MultiplicationClient\MultiplicationClient.java line 17-19
where in MultiplyGitDC theserver name specified in file docker-compose.yml because Docker internal networking is used.
In MultiplyGitDV the host network is used for inter-container communication where "host.docker.internal" refers to the hosts' IP address.

Additionally the path names are different for obvious reasons in the files compiles.sh, Dockerfile, and run.sh in the client as well as in the server folder.
