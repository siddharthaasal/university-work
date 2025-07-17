import './App.css';
import { useState, useEffect } from "react";
import { Web3 } from "web3";
import axios from "axios";

const contractAddress = "0x5FbDB2315678afecb367f032d93F642f64180aa3";
const contractABI = [
  {
    "inputs": [
      {
        "internalType": "string[]",
        "name": "_initialUrls",
        "type": "string[]"
      }
    ],
    "stateMutability": "nonpayable",
    "type": "constructor"
  },
  {
    "anonymous": false,
    "inputs": [
      {
        "indexed": false,
        "internalType": "string",
        "name": "url",
        "type": "string"
      }
    ],
    "name": "UrlAdded",
    "type": "event"
  },
  {
    "inputs": [
      {
        "internalType": "string",
        "name": "_url",
        "type": "string"
      }
    ],
    "name": "addUrl",
    "outputs": [],
    "stateMutability": "nonpayable",
    "type": "function"
  },
  {
    "inputs": [
      {
        "internalType": "uint256",
        "name": "index",
        "type": "uint256"
      }
    ],
    "name": "getUrl",
    "outputs": [
      {
        "internalType": "string",
        "name": "",
        "type": "string"
      }
    ],
    "stateMutability": "view",
    "type": "function"
  },
  {
    "inputs": [],
    "name": "getUrlCount",
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
    "name": "urls",
    "outputs": [
      {
        "internalType": "string",
        "name": "",
        "type": "string"
      }
    ],
    "stateMutability": "view",
    "type": "function"
  }
];

const pinataApiUrl = "https://app.pinata.cloud/ipfs/files";
const pinataApiKey = "1d6f7e28ec6f7d3a9aae";
const pinataApiSecret = "a093d53f8a93a4c3672d7c64db938ca371fc0bead954eb9ba27911a82662d393";

function App() {
  const [web3, setWeb3] = useState(null);
  const [imageVault, setImageVault] = useState(null);
  const [urls, setUrls] = useState([]);
  const [images, setImages] = useState([]);

  useEffect(() => {
    // Initialize Web3 and connect to the local Hardhat node
    const web3Instance = new Web3("http://localhost:8545"); // Connect to local Hardhat node
    setWeb3(web3Instance);

    const contract = new web3Instance.eth.Contract(contractABI, contractAddress);
    setImageVault(contract);
    console.log("image vault: ", imageVault);
  }, []);


  useEffect(() => {
    if (imageVault) {
      fetchUrls();
    }
  }, [imageVault]);

  const fetchUrls = async () => {
    try {
      console.log(imageVault.methods);
      const count = await imageVault.methods.getUrlCount().call();
      const urls = [];
      for (let i = 0; i < count; i++) {
        const url = await imageVault.methods.getUrl(i).call();
        urls.push(url);
      }
      setUrls(urls);
      fetchImages(urls);
    } catch (error) {
      console.error("Error fetching URLs:", error);
    }
  };

  const fetchImages = (urls) => {
    const imagesData = urls.map(url => `https://gateway.pinata.cloud/ipfs/${url}`);
    setImages(imagesData);
  };

  // const addUrlToContract = async (url) => {
  //   try {
  //     const accounts = await web3.eth.getAccounts();
  //     await imageVault.methods.addUrl(url).send({ from: accounts[0] });
  //     fetchUrls(); // Refresh the URL list after adding a new URL
  //   } catch (error) {
  //     console.error("Error adding URL to contract:", error);
  //   }
  // };

  return (
    <div className="App">
      <h1>ImageVault</h1>

      {/* <h2>Add Image URL</h2>
      <input
        type="text"
        id="urlInput"
        placeholder="Enter IPFS URL"
        onChange={(e) => setNewUrl(e.target.value)}
      />
      <button onClick={() => addUrlToContract(newUrl)}>Add URL</button> */}

      <h2>Stored Image URLs</h2>
      <ul>
        {urls.map((url, index) => (
          <li key={index}>
            <a href={`https://gateway.pinata.cloud/ipfs/${url}`} target="_blank" rel="noopener noreferrer">
              {url}
            </a>
          </li>
        ))}
      </ul>

      <h2>Images from Pinata</h2>
      <div className="image-gallery">
        {images.map((image, index) => (
          <img key={index} src={image} alt={`Image ${index}`} width="200" />
        ))}
      </div>
    </div>
  );
}

export default App;