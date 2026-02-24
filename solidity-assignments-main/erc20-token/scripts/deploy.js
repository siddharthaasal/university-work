// scripts/deploy.js
// require('dotenv').config();
const {Web3} = require('web3');
const HDWalletProvider = require('@truffle/hdwallet-provider');

// Use the mnemonic from the .env file
const mnemonic =
  "concert inspire window ancient iron chuckle fury axis illegal dutch habit burst";
const provider = new HDWalletProvider(mnemonic, 'http://127.0.0.1:7545');

const web3 = new Web3(provider);

// Replace with the copied ABI and Bytecode from Remix
const abi = [
  {
    inputs: [
      {
        internalType: "uint256",
        name: "initialSupply",
        type: "uint256",
      },
    ],
    stateMutability: "nonpayable",
    type: "constructor",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "spender",
        type: "address",
      },
      {
        internalType: "uint256",
        name: "allowance",
        type: "uint256",
      },
      {
        internalType: "uint256",
        name: "needed",
        type: "uint256",
      },
    ],
    name: "ERC20InsufficientAllowance",
    type: "error",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "sender",
        type: "address",
      },
      {
        internalType: "uint256",
        name: "balance",
        type: "uint256",
      },
      {
        internalType: "uint256",
        name: "needed",
        type: "uint256",
      },
    ],
    name: "ERC20InsufficientBalance",
    type: "error",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "approver",
        type: "address",
      },
    ],
    name: "ERC20InvalidApprover",
    type: "error",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "receiver",
        type: "address",
      },
    ],
    name: "ERC20InvalidReceiver",
    type: "error",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "sender",
        type: "address",
      },
    ],
    name: "ERC20InvalidSender",
    type: "error",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "spender",
        type: "address",
      },
    ],
    name: "ERC20InvalidSpender",
    type: "error",
  },
  {
    anonymous: false,
    inputs: [
      {
        indexed: true,
        internalType: "address",
        name: "owner",
        type: "address",
      },
      {
        indexed: true,
        internalType: "address",
        name: "spender",
        type: "address",
      },
      {
        indexed: false,
        internalType: "uint256",
        name: "value",
        type: "uint256",
      },
    ],
    name: "Approval",
    type: "event",
  },
  {
    anonymous: false,
    inputs: [
      {
        indexed: true,
        internalType: "address",
        name: "from",
        type: "address",
      },
      {
        indexed: true,
        internalType: "address",
        name: "to",
        type: "address",
      },
      {
        indexed: false,
        internalType: "uint256",
        name: "value",
        type: "uint256",
      },
    ],
    name: "Transfer",
    type: "event",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "owner",
        type: "address",
      },
      {
        internalType: "address",
        name: "spender",
        type: "address",
      },
    ],
    name: "allowance",
    outputs: [
      {
        internalType: "uint256",
        name: "",
        type: "uint256",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "spender",
        type: "address",
      },
      {
        internalType: "uint256",
        name: "value",
        type: "uint256",
      },
    ],
    name: "approve",
    outputs: [
      {
        internalType: "bool",
        name: "",
        type: "bool",
      },
    ],
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "account",
        type: "address",
      },
    ],
    name: "balanceOf",
    outputs: [
      {
        internalType: "uint256",
        name: "",
        type: "uint256",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "account",
        type: "address",
      },
    ],
    name: "checkBalance",
    outputs: [
      {
        internalType: "uint256",
        name: "",
        type: "uint256",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [],
    name: "decimals",
    outputs: [
      {
        internalType: "uint8",
        name: "",
        type: "uint8",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [],
    name: "name",
    outputs: [
      {
        internalType: "string",
        name: "",
        type: "string",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [],
    name: "symbol",
    outputs: [
      {
        internalType: "string",
        name: "",
        type: "string",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [],
    name: "totalSupply",
    outputs: [
      {
        internalType: "uint256",
        name: "",
        type: "uint256",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "to",
        type: "address",
      },
      {
        internalType: "uint256",
        name: "value",
        type: "uint256",
      },
    ],
    name: "transfer",
    outputs: [
      {
        internalType: "bool",
        name: "",
        type: "bool",
      },
    ],
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "from",
        type: "address",
      },
      {
        internalType: "address",
        name: "to",
        type: "address",
      },
      {
        internalType: "uint256",
        name: "value",
        type: "uint256",
      },
    ],
    name: "transferFrom",
    outputs: [
      {
        internalType: "bool",
        name: "",
        type: "bool",
      },
    ],
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "to",
        type: "address",
      },
      {
        internalType: "uint256",
        name: "amount",
        type: "uint256",
      },
    ],
    name: "transferTokens",
    outputs: [
      {
        internalType: "bool",
        name: "",
        type: "bool",
      },
    ],
    stateMutability: "nonpayable",
    type: "function",
  },
];

const bytecode =
  "608060405234801561000f575f80fd5b50604051611672380380611672833981810160405281019061003191906103aa565b6040518060400160405280600781526020017f4d79546f6b656e000000000000000000000000000000000000000000000000008152506040518060400160405280600381526020017f4d544b000000000000000000000000000000000000000000000000000000000081525081600390816100ac9190610606565b5080600490816100bc9190610606565b5050506100cf33826100d560201b60201c565b506107ea565b5f73ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603610145575f6040517fec442f0500000000000000000000000000000000000000000000000000000000815260040161013c9190610714565b60405180910390fd5b6101565f838361015a60201b60201c565b5050565b5f73ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16036101aa578060025f82825461019e919061075a565b92505081905550610278565b5f805f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2054905081811015610233578381836040517fe450d38c00000000000000000000000000000000000000000000000000000000815260040161022a9392919061079c565b60405180910390fd5b8181035f808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2081905550505b5f73ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16036102bf578060025f8282540392505081905550610309565b805f808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f82825401925050819055505b8173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef8360405161036691906107d1565b60405180910390a3505050565b5f80fd5b5f819050919050565b61038981610377565b8114610393575f80fd5b50565b5f815190506103a481610380565b92915050565b5f602082840312156103bf576103be610373565b5b5f6103cc84828501610396565b91505092915050565b5f81519050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f600282049050600182168061045057607f821691505b6020821081036104635761046261040c565b5b50919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026104c57fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8261048a565b6104cf868361048a565b95508019841693508086168417925050509392505050565b5f819050919050565b5f61050a61050561050084610377565b6104e7565b610377565b9050919050565b5f819050919050565b610523836104f0565b61053761052f82610511565b848454610496565b825550505050565b5f90565b61054b61053f565b61055681848461051a565b505050565b5b818110156105795761056e5f82610543565b60018101905061055c565b5050565b601f8211156105be5761058f81610469565b6105988461047b565b810160208510156105a7578190505b6105bb6105b38561047b565b83018261055b565b50505b505050565b5f82821c905092915050565b5f6105de5f19846008026105c3565b1980831691505092915050565b5f6105f683836105cf565b9150826002028217905092915050565b61060f826103d5565b67ffffffffffffffff811115610628576106276103df565b5b6106328254610439565b61063d82828561057d565b5f60209050601f83116001811461066e575f841561065c578287015190505b61066685826105eb565b8655506106cd565b601f19841661067c86610469565b5f5b828110156106a35784890151825560018201915060208501945060208101905061067e565b868310156106c057848901516106bc601f8916826105cf565b8355505b6001600288020188555050505b505050505050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6106fe826106d5565b9050919050565b61070e816106f4565b82525050565b5f6020820190506107275f830184610705565b92915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f61076482610377565b915061076f83610377565b92508282019050808211156107875761078661072d565b5b92915050565b61079681610377565b82525050565b5f6060820190506107af5f830186610705565b6107bc602083018561078d565b6107c9604083018461078d565b949350505050565b5f6020820190506107e45f83018461078d565b92915050565b610e7b806107f75f395ff3fe608060405234801561000f575f80fd5b50600436106100a7575f3560e01c80635f5152261161006f5780635f5152261461016557806370a082311461019557806395d89b41146101c5578063a9059cbb146101e3578063bec3fa1714610213578063dd62ed3e14610243576100a7565b806306fdde03146100ab578063095ea7b3146100c957806318160ddd146100f957806323b872dd14610117578063313ce56714610147575b5f80fd5b6100b3610273565b6040516100c09190610af4565b60405180910390f35b6100e360048036038101906100de9190610ba5565b610303565b6040516100f09190610bfd565b60405180910390f35b610101610325565b60405161010e9190610c25565b60405180910390f35b610131600480360381019061012c9190610c3e565b61032e565b60405161013e9190610bfd565b60405180910390f35b61014f61035c565b60405161015c9190610ca9565b60405180910390f35b61017f600480360381019061017a9190610cc2565b610364565b60405161018c9190610c25565b60405180910390f35b6101af60048036038101906101aa9190610cc2565b610375565b6040516101bc9190610c25565b60405180910390f35b6101cd6103ba565b6040516101da9190610af4565b60405180910390f35b6101fd60048036038101906101f89190610ba5565b61044a565b60405161020a9190610bfd565b60405180910390f35b61022d60048036038101906102289190610ba5565b61046c565b60405161023a9190610bfd565b60405180910390f35b61025d60048036038101906102589190610ced565b61047f565b60405161026a9190610c25565b60405180910390f35b60606003805461028290610d58565b80601f01602080910402602001604051908101604052809291908181526020018280546102ae90610d58565b80156102f95780601f106102d0576101008083540402835291602001916102f9565b820191905f5260205f20905b8154815290600101906020018083116102dc57829003601f168201915b5050505050905090565b5f8061030d610501565b905061031a818585610508565b600191505092915050565b5f600254905090565b5f80610338610501565b905061034585828561051a565b6103508585856105ac565b60019150509392505050565b5f6012905090565b5f61036e82610375565b9050919050565b5f805f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20549050919050565b6060600480546103c990610d58565b80601f01602080910402602001604051908101604052809291908181526020018280546103f590610d58565b80156104405780601f1061041757610100808354040283529160200191610440565b820191905f5260205f20905b81548152906001019060200180831161042357829003601f168201915b5050505050905090565b5f80610454610501565b90506104618185856105ac565b600191505092915050565b5f610477838361044a565b905092915050565b5f60015f8473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2054905092915050565b5f33905090565b610515838383600161069c565b505050565b5f610525848461047f565b90507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff81146105a65781811015610597578281836040517ffb8f41b200000000000000000000000000000000000000000000000000000000815260040161058e93929190610d97565b60405180910390fd5b6105a584848484035f61069c565b5b50505050565b5f73ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff160361061c575f6040517f96c6fd1e0000000000000000000000000000000000000000000000000000000081526004016106139190610dcc565b60405180910390fd5b5f73ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff160361068c575f6040517fec442f050000000000000000000000000000000000000000000000000000000081526004016106839190610dcc565b60405180910390fd5b61069783838361086b565b505050565b5f73ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff160361070c575f6040517fe602df050000000000000000000000000000000000000000000000000000000081526004016107039190610dcc565b60405180910390fd5b5f73ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff160361077c575f6040517f94280d620000000000000000000000000000000000000000000000000000000081526004016107739190610dcc565b60405180910390fd5b8160015f8673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20819055508015610865578273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9258460405161085c9190610c25565b60405180910390a35b50505050565b5f73ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16036108bb578060025f8282546108af9190610e12565b92505081905550610989565b5f805f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2054905081811015610944578381836040517fe450d38c00000000000000000000000000000000000000000000000000000000815260040161093b93929190610d97565b60405180910390fd5b8181035f808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2081905550505b5f73ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16036109d0578060025f8282540392505081905550610a1a565b805f808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f82825401925050819055505b8173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef83604051610a779190610c25565b60405180910390a3505050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f601f19601f8301169050919050565b5f610ac682610a84565b610ad08185610a8e565b9350610ae0818560208601610a9e565b610ae981610aac565b840191505092915050565b5f6020820190508181035f830152610b0c8184610abc565b905092915050565b5f80fd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f610b4182610b18565b9050919050565b610b5181610b37565b8114610b5b575f80fd5b50565b5f81359050610b6c81610b48565b92915050565b5f819050919050565b610b8481610b72565b8114610b8e575f80fd5b50565b5f81359050610b9f81610b7b565b92915050565b5f8060408385031215610bbb57610bba610b14565b5b5f610bc885828601610b5e565b9250506020610bd985828601610b91565b9150509250929050565b5f8115159050919050565b610bf781610be3565b82525050565b5f602082019050610c105f830184610bee565b92915050565b610c1f81610b72565b82525050565b5f602082019050610c385f830184610c16565b92915050565b5f805f60608486031215610c5557610c54610b14565b5b5f610c6286828701610b5e565b9350506020610c7386828701610b5e565b9250506040610c8486828701610b91565b9150509250925092565b5f60ff82169050919050565b610ca381610c8e565b82525050565b5f602082019050610cbc5f830184610c9a565b92915050565b5f60208284031215610cd757610cd6610b14565b5b5f610ce484828501610b5e565b91505092915050565b5f8060408385031215610d0357610d02610b14565b5b5f610d1085828601610b5e565b9250506020610d2185828601610b5e565b9150509250929050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f6002820490506001821680610d6f57607f821691505b602082108103610d8257610d81610d2b565b5b50919050565b610d9181610b37565b82525050565b5f606082019050610daa5f830186610d88565b610db76020830185610c16565b610dc46040830184610c16565b949350505050565b5f602082019050610ddf5f830184610d88565b92915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f610e1c82610b72565b9150610e2783610b72565b9250828201905080821115610e3f57610e3e610de5565b5b9291505056fea264697066735822122074971bfd0e057281fafd9db471760f48eb3a416d632a0a1ba328f192acbc813964736f6c634300081a0033";

const deploy = async () => {
  try {
    const accounts = await web3.eth.getAccounts();
    console.log("Deploying from account", accounts[0]);

    const contract = new web3.eth.Contract(abi);
    const result = await contract
      .deploy({ data: bytecode, arguments: [1000000] }) // Initial supply
      .send({ from: accounts[0], gas: "2000000" });

    console.log("Contract deployed to", result.options.address);
  } catch (error) {
    console.error("An error occurred during deployment:", error);
  } finally {
    provider.engine.stop();
  }
};

deploy();
