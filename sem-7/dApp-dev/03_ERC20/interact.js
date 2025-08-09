require("dotenv").config();
const { ethers } = require("ethers");

const abi = [
    "function transfer(address to, uint amount) public returns (bool)",
    "function mint(address to, uint256 amount) public",
    "function balanceOf(address account) external view returns (uint256)"
];

const provider = new ethers.JsonRpcProvider(process.env.RPC_URL);
const wallet = new ethers.Wallet(process.env.PRIVATE_KEY, provider);
const token = new ethers.Contract(process.env.TOKEN_ADDRESS, abi, wallet);

async function main() {
    const to = "0xD9C2BE1793A6F75999B0e4Bd3Fc36c9A47db608d"; // RECEIVER'S ADDRESS
    const amount = ethers.parseUnits("10", 18); // 10 tokens

    const tx = await token.transfer(to, amount);
    await tx.wait();
    console.log(`Transferred 10 tokens to ${to}`);
}

main().catch(console.error);
