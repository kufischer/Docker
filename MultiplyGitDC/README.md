Simple Thrift example for a multiplication server and a client using it.

Example can be created and run by using the command:

docker-compose up

in folder .\aitoc\Docker\MultiplyGitDC

Only difference between MultiplyGitDC and MultiplyGitDV is in files:

.\aitoc\Docker\MultiplyGitDC\client\src\main\java\thriftexample\MultiplicationClient\MultiplicationClient.java line 17-19
where in MultiplyGitDC theserver name specified in file docker-compose.yml because Docker internal networking is used.
In MultiplyGitDV the host network is used for inter-container communication where "host.docker.internal" refers to the hosts' IP address.

Additionally the path names are different for obvious reasons in the files compiles.sh, Dockerfile, and run.sh in the client as well as in the server folder.
