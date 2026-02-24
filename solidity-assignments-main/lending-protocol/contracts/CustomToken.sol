// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract CustomToken is ERC20 {
    address private _owner;
    constructor (string memory name, string memory symbol) ERC20(name, symbol){_owner = msg.sender;}

    function mint(address to, uint256 amount) public {
        require(msg.sender == _owner);
        _mint(to, amount);
    }
}

