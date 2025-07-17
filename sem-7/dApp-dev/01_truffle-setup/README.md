
### Pre-requisites
- Node.js **(nvm use 20)**
- npm
- Truffle
- Ganache
- Metamask Extension




### Steps to create this from scratch!

1. Configure MetaMask for Local Blockchain in the Browser
    Import test accounts using private keys from Ganache<br/>
    Add a custom network in MetaMask with:
    - **RPC URL**: `http://127.0.0.1:7545`
    - **Chain ID**: `1337`
    - **Currency Symbol**: `ETH`

2. Create dir for your project.

3. Initilize a new truffle project:
    ```bash
    truffle init
    ```

4.Configure 'truffle-config.js' to sync with your Ganache network and solc compiler.

5. Create Smart Contracts
    ```bash
    truffle create contract <ContractName>
    ```

6. Write your contract, write migration script.

7. Migrate your contract to blockchain.
    ```bash
    truffle migrate --network development
    ```

8. Write your interaction script (interact.js), use the generated contract_address, abi, and ganache's account address in this script.

9. Run the interaction script via
    ```bash
    node interact.js
    ```
