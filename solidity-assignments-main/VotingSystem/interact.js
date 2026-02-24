const {Web3} = require("web3");
const web3 = new Web3("HTTP://127.0.0.1:7545"); // Replace with your Infura project ID or local node URL

const contractAddress = "0x1E57e4fb58115e3bd698eaa34d893B4014Cb91bb"; // Replace with your deployed contract address
const contractABI = [
  {
    inputs: [],
    stateMutability: "nonpayable",
    type: "constructor",
  },
  {
    inputs: [],
    name: "admin",
    outputs: [
      {
        internalType: "address",
        name: "",
        type: "address",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "string",
        name: "description",
        type: "string",
      },
    ],
    name: "createProposal",
    outputs: [],
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    inputs: [],
    name: "getWinningProposal",
    outputs: [
      {
        internalType: "string",
        name: "description",
        type: "string",
      },
      {
        internalType: "uint256",
        name: "voteCount",
        type: "uint256",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "uint256",
        name: "",
        type: "uint256",
      },
    ],
    name: "proposals",
    outputs: [
      {
        internalType: "string",
        name: "description",
        type: "string",
      },
      {
        internalType: "uint256",
        name: "voteCount",
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
        name: "voter",
        type: "address",
      },
    ],
    name: "registerVoter",
    outputs: [],
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "uint256",
        name: "proposalIndex",
        type: "uint256",
      },
    ],
    name: "vote",
    outputs: [],
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "address",
        name: "",
        type: "address",
      },
    ],
    name: "voters",
    outputs: [
      {
        internalType: "bool",
        name: "hasVoted",
        type: "bool",
      },
      {
        internalType: "uint256",
        name: "proposalIndex",
        type: "uint256",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
];

const account = "0xE85232A79638f22D0FA64FE4a8ff56a8B90f9ad6"; // Replace with your Ethereum account address
const privateKey =  
  "0x443ff6a383348a9deaad909a6d42318d1c6f8d74ffbd492b998e093d445dc220"; // Replace with your Ethereum private key

const votingContract = new web3.eth.Contract(contractABI, contractAddress);

// Function to register a voter
async function registerVoter(voterAddress) {
  const data = votingContract.methods.registerVoter(voterAddress).encodeABI();

  const tx = {
    to: contractAddress,
    data: data,
    gas: 2000000,
    gasPrice: web3.utils.toWei("20", "gwei"),
    from: "0xE85232A79638f22D0FA64FE4a8ff56a8B90f9ad6", // Explicitly include the 'from' address
  };

  const signedTx = await web3.eth.accounts.signTransaction(tx, privateKey);
  const receipt = await web3.eth.sendSignedTransaction(signedTx.rawTransaction);
  console.log("Voter registered:", receipt);
}

// Function to create a proposal
async function createProposal(description) {
  const data = votingContract.methods.createProposal(description).encodeABI();

  const tx = {
    to: contractAddress,
    data: data,
    gas: 2000000,
    gasPrice: web3.utils.toWei("20", "gwei"),
    from: "0xE85232A79638f22D0FA64FE4a8ff56a8B90f9ad6", // Explicitly include the 'from' address
  };

  const signedTx = await web3.eth.accounts.signTransaction(tx, privateKey);
  const receipt = await web3.eth.sendSignedTransaction(signedTx.rawTransaction);
  console.log("Proposal created:", receipt);
}

// Function to cast a vote
async function vote(proposalIndex) {
  const data = votingContract.methods.vote(proposalIndex).encodeABI();

  const tx = {
    to: contractAddress,
    data: data,
    gas: 2000000,
    gasPrice: web3.utils.toWei("20", "gwei"),
    from: "0xE85232A79638f22D0FA64FE4a8ff56a8B90f9ad6", // Explicitly include the 'from' address
  };

  const signedTx = await web3.eth.accounts.signTransaction(tx, privateKey);
  const receipt = await web3.eth.sendSignedTransaction(signedTx.rawTransaction);
  console.log("Vote casted:", receipt);
}

// Example usage:
(async () => {
  await registerVoter("0xE85232A79638f22D0FA64FE4a8ff56a8B90f9ad6"); // Replace with the voter's address
  await createProposal("Proposal 1");
  // await createProposal("Proposal 2");
  // await createProposal("Proposal 3");
  await vote(0); // Voting on the first proposal
  // await vote(1); 
})();