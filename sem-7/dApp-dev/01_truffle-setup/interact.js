const { Web3 } = require('web3');
const HelloWorld = require('./build/contracts/HelloWorld.json');

const web3 = new Web3('http://127.0.0.1:7545');

//deployed contract address
const contractAddress = "0x0CFD00B5028E17f041AA68ce57C21085278d9199";
// You can copy one from 
const account = "0xd4E71400ecdceb21837f307A1f85a160bd5a3a33";
const helloWorld = new web3.eth.Contract(HelloWorld.abi, contractAddress);

async function interact() {
    let message = await helloWorld.methods.getMessage().call();
    console.log("Initial Message:", message);

    await helloWorld.methods.setMessage("Hello, Web3!").send({ from: account });

    message = await helloWorld.methods.getMessage().call();
    console.log("Updated Message:", message);
}

interact();
