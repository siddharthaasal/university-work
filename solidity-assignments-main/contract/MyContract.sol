// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

abstract contract MyToken is ERC20, Ownable {
    constructor(uint256 initialSupply) ERC20("MyToken", "MTK") {
        _mint(msg.sender, initialSupply);
    }

    // Function to mint new tokens
     function mint(address to, uint256 amount) public {
        require(msg.sender == owner(), "You are not the owner");
        _mint(to, amount);
    }

    // Function to transfer tokens
    function transferTokens(address to, uint256 amount) public returns (bool) {
        return transfer(to, amount);
    }

    // Function to check balance of an account
    function checkBalance(address account) public view returns (uint256) {
        return balanceOf(account);
    }
}
