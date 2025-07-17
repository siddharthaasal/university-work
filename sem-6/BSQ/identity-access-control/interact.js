const { ethers } = require("hardhat");

async function main() {
    // Replace with your deployed contract address
    const contractAddress = "0x9fE46736679d2D9a65F0992F2272dE9f3c7fa6e0";

    // Get signers
    const [deployer, user1, user2, admin1] = await ethers.getSigners();

    // Attach to the deployed contract
    const IdentityAccessControl = await ethers.getContractFactory("IdentityAccessControl");
    const contract = IdentityAccessControl.attach(contractAddress);

    console.log(`Interacting with contract at: ${contractAddress}`);

    // Register a new user (user1) as an admin
    console.log(`Registering user: ${user1.address}`);
    let tx = await contract.connect(deployer).registerUser(user1.address);
    await tx.wait();
    console.log(`User ${user1.address} registered! ✅`);

    // Check if user1 is registered
    const isUser1Registered = await contract.isUser(user1.address);
    console.log(`Is user1 registered? ${isUser1Registered}`);

    // Assign user1 as an admin
    console.log(`Assigning admin role to: ${user1.address}`);
    tx = await contract.connect(deployer).assignAdmin(user1.address);
    await tx.wait();
    console.log(`User ${user1.address} is now an admin! ✅`);

    // Check if user1 is an admin
    const isUser1Admin = await contract.isAdmin(user1.address);
    console.log(`Is user1 an admin? ${isUser1Admin}`);

    // Register another user (user2) using the new admin
    console.log(`Registering user2: ${user2.address}`);
    tx = await contract.connect(user1).registerUser(user2.address);
    await tx.wait();
    console.log(`User ${user2.address} registered by admin ${user1.address}! ✅`);

    // Check if user2 is registered
    const isUser2Registered = await contract.isUser(user2.address);
    console.log(`Is user2 registered? ${isUser2Registered}`);
}

// Run the script
main().catch((error) => {
    console.error(error);
    process.exitCode = 1;
});
