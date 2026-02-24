const { expect } = require("chai");
const { ethers } = require("hardhat");

describe("Payment Contract", function () {
    let Payment, payment, owner, addr1, addr2;

    beforeEach(async function () {
        [owner, addr1, addr2] = await ethers.getSigners();
        Payment = await ethers.getContractFactory("Payment");
        payment = await Payment.deploy();
        await payment.deployed();
    });

    it("Should allow users to deposit funds", async function () {
        const depositAmount = ethers.parseEther("1");

        await expect(await payment.connect(addr1).deposit({ value: depositAmount }))
            .to.emit(payment, "Deposited")
            .withArgs(addr1.address, depositAmount);

        expect(await payment.getContractBalance()).to.equal(depositAmount);
    });

    it("Should allow users to withdraw funds", async function () {
        const depositAmount = ethers.parseEther("1");
        await payment.connect(addr1).deposit({ value: depositAmount });

        await expect(payment.connect(addr1).withdraw(depositAmount))
            .to.emit(payment, "Withdrawn")
            .withArgs(addr1.address, depositAmount);

        expect(await payment.getContractBalance()).to.equal(0);
    });

    it("Should allow users to transfer funds", async function () {
        const depositAmount = ethers.parseEther("1");
        await payment.connect(addr1).deposit({ value: depositAmount });

        await expect(payment.connect(addr1).transfer(addr2.address, depositAmount))
            .to.emit(payment, "Transferred")
            .withArgs(addr1.address, addr2.address, depositAmount);

        expect(await payment.getContractBalance()).to.equal(depositAmount);
    });

    it("Should fail if withdraw amount exceeds balance", async function () {
        await expect(payment.connect(addr1).withdraw(ethers.parseEther("1")))
            .to.be.revertedWith("Insufficient Balance");
    });

    it("Should fail if transfer amount exceeds balance", async function () {
        await expect(payment.connect(addr1).transfer(addr2.address, ethers.parseEther("1")))
            .to.be.revertedWith("Insufficient Funds");
    });

    it("Should fail if transferring to zero address", async function () {
        const depositAmount = ethers.parseEther("1");
        await payment.connect(addr1).deposit({ value: depositAmount });

        await expect(payment.connect(addr1).transfer("0x0000000000000000000000000000000000000000", depositAmount))
            .to.be.revertedWith("Invalid recipient");
    });
});
