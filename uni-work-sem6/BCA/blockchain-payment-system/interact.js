const hre = require("hardhat");

async function main() {
    const contractAddress = "0x5FbDB2315678afecb367f032d93F642f64180aa3"; // Replace with your deployed contract address
    const Payment = await hre.ethers.getContractFactory("Payment");
    const payment = await Payment.attach(contractAddress);

    const [owner, addr1, addr2] = await hre.ethers.getSigners();

    console.log(`Interacting with contract at: ${contractAddress}`);

    // Deposit 1 ETH from addr1
    const depositAmount = hre.ethers.parseEther("1");
    let tx = await payment.connect(addr1).deposit({ value: depositAmount });
    await tx.wait();
    console.log(`✅ ${addr1.address} deposited 1 ETH`);

    // Check contract balance
    const contractBalance = await payment.getContractBalance();
    console.log(`💰 Contract Balance: ${hre.ethers.formatEther(contractBalance)} ETH`);

    // Transfer 0.5 ETH from addr1 to addr2
    const transferAmount = hre.ethers.parseEther("0.5");
    tx = await payment.connect(addr1).transfer(addr2.address, transferAmount);
    await tx.wait();
    console.log(`✅ ${addr1.address} transferred 0.5 ETH to ${addr2.address}`);

    // Withdraw 0.5 ETH from addr1
    tx = await payment.connect(addr1).withdraw(transferAmount);
    await tx.wait();
    console.log(`✅ ${addr1.address} withdrew 0.5 ETH`);

    // Final Contract Balance
    const finalBalance = await payment.getContractBalance();
    console.log(`💰 Final Contract Balance: ${hre.ethers.formatEther(finalBalance)} ETH`);
}

main()
    .then(() => process.exit(0))
    .catch((error) => {
        console.error(error);
        process.exit(1);
    });
