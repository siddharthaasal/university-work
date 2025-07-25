cd fabric-samples/test-network
./network.sh down

./network.sh up createChannel 
This does:

    Create mychannel

    Org1 and Org2 join the channel

    Anchor peers are updated


    peer channel list

 Define and Apply Endorsement Policies
What is it?

Endorsement policies define which peers must approve a transaction before it's accepted.
✅ Apply a Custom Policy When Deploying Chaincode:

./network.sh deployCC -ccn advanced -ccp ../asset-transfer-basic/chaincode-go -ccl go \
-ccep "OR('Org1MSP.peer','Org2MSP.peer')"


export ORDERER_CA=${PWD}/organizations/ordererOrganizations/example.com/orderers/orderer.example.com/msp/tlscacerts/tlsca.example.com-cert.pem

# Fetch current channel config block
peer channel fetch config config_block.pb -o localhost:7050 \
--tls --cafile "$ORDERER_CA" -c mychannel


# Decode the config block to JSON
configtxlator proto_decode --input config_block.pb --type common.Block \
| jq .data.data[0].payload.data.config > config.json

# Make changes manually in config.json or using a script
cp config.json modified_config.json
nano modified_config.json

"Capabilities": {
            "mod_policy": "Admins",
            "value": {
              "capabilities": {
                "V2_5": {},
                "MyTestCapability": {}
              }
            },
            "version": "0"
          }
# Save the modified file as modified_config.json

# Re-encode original and modified configs to protobuf
configtxlator proto_encode --input config.json --type common.Config > config.pb
configtxlator proto_encode --input modified_config.json --type common.Config > modified_config.pb

# Compute the update (delta)
configtxlator compute_update --channel_id mychannel --original config.pb \
--updated modified_config.pb > config_update.pb

# Decode the config update and wrap in envelope
configtxlator proto_decode --input config_update.pb --type common.ConfigUpdate \
| jq '{"payload":{"header":{"channel_header":{"channel_id":"mychannel", "type":2}},"data":{"config_update":.}}}' \
> config_update_envelope.json

# Encode the envelope to protobuf
configtxlator proto_encode --input config_update_envelope.json --type common.Envelope \
> config_update_envelope.pb

# Submit the config update to the orderer
peer channel update -f config_update_envelope.pb -c mychannel -o localhost:7050 \
--tls --cafile "$ORDERER_CA"
