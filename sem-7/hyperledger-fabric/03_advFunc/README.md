# Advanced functionalites like error handling and data validation mechanisms

cd ~/go/src/github.com/siddharthaasal/fabric-samples/
cd test-network/
./network.sh down  
./network.sh up createChannel -c mychannel

./network.sh deployCC -ccn basic -ccp ../asset-transfer-basic/chaincode-go -ccl go


export PATH=${PWD}/../bin:$PATH
export FABRIC_CFG_PATH=$PWD/../config/

export CORE_PEER_TLS_ENABLED=true
export CORE_PEER_LOCALMSPID="Org1MSP"
export CORE_PEER_TLS_ROOTCERT_FILE=$PWD/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/ca.crt
export CORE_PEER_MSPCONFIGPATH=$PWD/organizations/peerOrganizations/org1.example.com/users/Admin@org1.example.com/msp
export CORE_PEER_ADDRESS=localhost:7051

peer chaincode invoke -o localhost:7050 --ordererTLSHostnameOverride orderer.example.com --tls --cafile "${PWD}/organizations/ordererOrganizations/example.com/orderers/orderer.example.com/msp/tlscacerts/tlsca.example.com-cert.pem" -C mychannel -n basic --peerAddresses localhost:7051 --tlsRootCertFiles "${PWD}/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/ca.crt" --peerAddresses localhost:9051 --tlsRootCertFiles "${PWD}/organizations/peerOrganizations/org2.example.com/peers/peer0.org2.example.com/tls/ca.crt" -c '{"function":"InitLedger","Args":[]}'

peer chaincode query -C mychannel -n basic -c '{"Args":["GetAllAssets"]}'

<!-- deleting an invalid acc -->
peer chaincode invoke -C mychannel -n basic -c '{"function":"DeleteAsset","Args":["asset100"]}' -o localhost:7050 --ordererTLSHostnameOverride orderer.example.com --tls --cafile "$PWD/organizations/ordererOrganizations/example.com/orderers/orderer.example.com/msp/tlscacerts/tlsca.example.com-cert.pem" --peerAddresses localhost:7051 --tlsRootCertFiles "$PWD/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/ca.crt" | jqpeer chaincode query -C mychannel -n basic -c '{"Args":["GetAllAssets"]}'peer chaincode query -C mychannel -n basic -c '{"Args":["GetAllAssets"]}'

<!-- updating an asset -->
peer chaincode invoke -C mychannel -n basic \
-c '{"function":"UpdateAsset","Args":["asset2", "gold", "8", "updatedAsset", "999"]}' \
-o localhost:7050 \
--ordererTLSHostnameOverride orderer.example.com \
--tls --cafile "$PWD/organizations/ordererOrganizations/example.com/orderers/orderer.example.com/msp/tlscacerts/tlsca.example.com-cert.pem" \
--peerAddresses localhost:7051 \
--tlsRootCertFiles "$PWD/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/ca.crt"
