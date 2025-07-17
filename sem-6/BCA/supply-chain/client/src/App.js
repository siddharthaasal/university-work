import './App.css';
import { useState, useEffect } from 'react';
import { Web3 } from "web3";

const contractAddress = "0x5FbDB2315678afecb367f032d93F642f64180aa3";
const contractABI = [
  {
    "anonymous": false,
    "inputs": [
      {
        "indexed": false,
        "internalType": "uint256",
        "name": "id",
        "type": "uint256"
      },
      {
        "indexed": false,
        "internalType": "string",
        "name": "name",
        "type": "string"
      },
      {
        "indexed": false,
        "internalType": "address",
        "name": "owner",
        "type": "address"
      }
    ],
    "name": "ProductRegistered",
    "type": "event"
  },
  {
    "anonymous": false,
    "inputs": [
      {
        "indexed": false,
        "internalType": "uint256",
        "name": "id",
        "type": "uint256"
      },
      {
        "indexed": false,
        "internalType": "string",
        "name": "status",
        "type": "string"
      }
    ],
    "name": "StatusUpdated",
    "type": "event"
  },
  {
    "inputs": [
      {
        "internalType": "uint256",
        "name": "_id",
        "type": "uint256"
      }
    ],
    "name": "getProduct",
    "outputs": [
      {
        "internalType": "string",
        "name": "name",
        "type": "string"
      },
      {
        "internalType": "string",
        "name": "status",
        "type": "string"
      },
      {
        "internalType": "address",
        "name": "owner",
        "type": "address"
      }
    ],
    "stateMutability": "view",
    "type": "function"
  },
  {
    "inputs": [],
    "name": "productCount",
    "outputs": [
      {
        "internalType": "uint256",
        "name": "",
        "type": "uint256"
      }
    ],
    "stateMutability": "view",
    "type": "function"
  },
  {
    "inputs": [
      {
        "internalType": "uint256",
        "name": "",
        "type": "uint256"
      }
    ],
    "name": "products",
    "outputs": [
      {
        "internalType": "uint256",
        "name": "id",
        "type": "uint256"
      },
      {
        "internalType": "string",
        "name": "name",
        "type": "string"
      },
      {
        "internalType": "string",
        "name": "status",
        "type": "string"
      },
      {
        "internalType": "address",
        "name": "owner",
        "type": "address"
      }
    ],
    "stateMutability": "view",
    "type": "function"
  },
  {
    "inputs": [
      {
        "internalType": "string",
        "name": "_name",
        "type": "string"
      }
    ],
    "name": "registerProduct",
    "outputs": [],
    "stateMutability": "nonpayable",
    "type": "function"
  },
  {
    "inputs": [
      {
        "internalType": "uint256",
        "name": "_id",
        "type": "uint256"
      },
      {
        "internalType": "string",
        "name": "_status",
        "type": "string"
      }
    ],
    "name": "updateStatus",
    "outputs": [],
    "stateMutability": "nonpayable",
    "type": "function"
  }
];

function App() {
  const [web3, setWeb3] = useState(null);
  const [supplyChain, setSupplyChain] = useState(null);
  const [name, setName] = useState('');
  const [status, setStatus] = useState('');
  const [productId, setProductId] = useState('');
  const [product, setProduct] = useState(null);

  useEffect(() => {
    const initWeb3 = async () => {
      const web3Instance = new Web3("http://localhost:8545");
      setWeb3(web3Instance);

      const contract = new web3Instance.eth.Contract(contractABI, contractAddress);
      setSupplyChain(contract);
    };
    initWeb3();
  }, []);

  const registerProduct = async () => {
    const accounts = await web3.eth.getAccounts();
    await supplyChain.methods.registerProduct(name).send({ from: accounts[0] });
    setName('');
  };

  const updateProductStatus = async () => {
    const accounts = await web3.eth.getAccounts();
    await supplyChain.methods.updateStatus(productId, status).send({ from: accounts[0] });
    setStatus('');
    setProductId('');
  };

  const getProduct = async () => {
    const result = await supplyChain.methods.getProduct(productId).call();
    setProduct({ name: result[0], status: result[1], owner: result[2] });
  };

  return (
    <div className='mainDiv'>
      <h1>Supply Chain Tracking System</h1>
      <h2>Register Product</h2>
      <input
        type="text"
        value={name}
        placeholder="Product Name"
        onChange={(e) => setName(e.target.value)}
      />
      <button onClick={registerProduct}>Register</button>

      <h2>Update Product Status</h2>
      <input
        type="number"
        value={productId}
        placeholder="Product ID"
        onChange={(e) => setProductId(e.target.value)}
      />
      <input
        type="text"
        value={status}
        placeholder="New Status"
        onChange={(e) => setStatus(e.target.value)}
      />
      <button onClick={updateProductStatus}>Update Status</button>

      <h2>Get Product Details</h2>
      <input
        type="number"
        value={productId}
        placeholder="Product ID"
        onChange={(e) => setProductId(e.target.value)}
      />
      <button onClick={getProduct}>Get Product</button>
      {product && (
        <div>
          <p>Name: {product.name}</p>
          <p>Status: {product.status}</p>
          <p>Owner: {product.owner}</p>
        </div>
      )}
    </div>
  );
}

export default App;
