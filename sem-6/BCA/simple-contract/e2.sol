//SPDX-License-Identifier:Unlicensed
pragma solidity ^0.8.0;

contract MyContract {
    uint256 private num;

    function setNumber(uint256 _num) public {
        num = _num;
    }

    function getNumber() public view returns (uint256) {
        return num;
    }
}
