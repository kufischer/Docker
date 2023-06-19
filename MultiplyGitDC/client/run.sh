#!/bin/sh

echo "Waiting for 5 seconds for server to come up."

sleep 5

echo "Starting multiplication client ..."

cd /root/Docker/MultiplyGitDC/client ; java -cp target/MultiplicationClient-1.0.jar:target/dependency/* MultiplicationClient
