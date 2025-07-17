# Setup for Hyperledger Fabric

## Pre-requisites
- Git
- Go
- Docker
- Jq
- Hyperledger Fabric


## Steps

cd fabric-samples/test-network

From inside the test-network directory, run the following command to remove any containers or artifacts from any previous runs:

./network.sh down

You can then bring up the network by issuing the following command. You will experience problems if you try to run the script from another directory:

./network.sh up

This command creates a Fabric network that consists of two peer nodes, one ordering node. No channel is created when you run ./network.sh up, though we will get there in a future step. 


./network.sh createChannel

./network.sh deployCC -ccn basic -ccp ../asset-transfer-basic/chaincode-go -ccl go

The deployCC subcommand will install the asset-transfer (basic) chaincode on peer0.org1.example.com and peer0.org2.example.com and then deploy the chaincode on the channel specified using the channel flag (or mychannel if no channel is specified). If you are deploying a chaincode for the first time, the script will install the chaincode dependencies. You can use the language flag, -ccl, to install the Go, typescript or javascript versions of the chaincode. You can find the asset-transfer (basic) chaincode in the asset-transfer-basic folder of the fabric-samples directory. This folder contains sample chaincode that are provided as examples and used by tutorials to highlight Fabric features.