const hre = require("hardhat");

async function main() {
    // Get the contract factory for SupplyChain
    const SupplyChain = await hre.ethers.getContractFactory("SupplyChain");

    // Get the deployed contract address (replace with your actual deployed address)
    const supplyChainAddress = "0x5FbDB2315678afecb367f032d93F642f64180aa3"; // Update this line
    const supplyChain = SupplyChain.attach(supplyChainAddress);

    // Register a new product
    console.log("Registering a new product...");
    const productName = "Product A";
    const registerTx = await supplyChain.registerProduct(productName);
    await registerTx.wait(); // Wait for the transaction to be mined
    console.log(`Product registered: ${productName}`);

    // Update the product status
    const productId = 1; // Assuming this is the first product
    console.log("Updating product status...");
    const newStatus = "Shipped";
    const updateTx = await supplyChain.updateStatus(productId, newStatus);
    await updateTx.wait(); // Wait for the transaction to be mined
    console.log(`Status updated for Product ID ${productId}: ${newStatus}`);

    // Retrieve product details
    console.log("Retrieving product details...");
    const product = await supplyChain.getProduct(productId);
    console.log(`Product ID: ${productId}`);
    console.log(`Name: ${product[0]}`);
    console.log(`Status: ${product[1]}`);
    console.log(`Owner: ${product[2]}`);
}

// Run the main function and handle errors
main()
    .then(() => process.exit(0))
    .catch((error) => {
        console.error(error);
        process.exit(1);
    });
