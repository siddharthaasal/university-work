//SPDX-License-Identifier : MIT
pragma solidity ^0.8.19;

contract Payment {
    mapping(address => uint256) balances;

    event Deposited(address indexed user, uint256 amount);
    event Withdrawn(address indexed user, uint256 amount);
    event Transferred(
        address indexed sender,
        address indexed receiver,
        uint256 amount
    );

    function deposit() public payable {
        require(
            msg.value >= 0,
            "The amount to be deposited must be greater than 0"
        );
        balances[msg.sender] += msg.value;
        emit Deposited(msg.sender, msg.value);
    }

    function withdraw(uint256 _amount) public payable {
        require(balances[msg.sender] >= _amount, "Insufficient Balance");
        balances[msg.sender] -= _amount;
        payable(msg.sender).transfer(_amount);
        emit Withdrawn(msg.sender, _amount);
    }

    function transfer(address _receiver, uint256 _amount) public {
        require(balances[msg.sender] >= _amount, "Insufficient Funds");
        require(_receiver != address(0), "Invalid recipient");
        balances[msg.sender] -= _amount;
        balances[_receiver] += _amount;
        emit Transferred(msg.sender, _receiver, _amount);
    }

    function getContractBalance() public view returns (uint256) {
        return address(this).balance;
    }
}
