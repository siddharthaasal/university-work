// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract IdentityAccessControl {
    // Mapping for user identities
    mapping(address => bool) private users;
    mapping(address => bool) private admins;

    // Event to log identity registration
    event UserRegistered(address user);
    event AdminAssigned(address admin);

    // Modifier to restrict access to only admin
    modifier onlyAdmin() {
        require(admins[msg.sender], "You are not an admin");
        _;
    }

    // Constructor to set the initial admin
    constructor(address initialAdmin) {
        admins[initialAdmin] = true; // Assign the first admin
    }

    // Function to register a new user
    function registerUser(address user) public onlyAdmin {
        require(user != address(0), "Invalid address");
        require(!users[user], "User already registered");

        users[user] = true;
        emit UserRegistered(user);
    }

    // Function to assign an admin role
    function assignAdmin(address admin) public onlyAdmin {
        require(admin != address(0), "Invalid address");
        admins[admin] = true;
        emit AdminAssigned(admin);
    }

    // Function to check if an address is registered as a user
    function isUser(address user) public view returns (bool) {
        return users[user];
    }

    // Function to check if an address is an admin
    function isAdmin(address admin) public view returns (bool) {
        return admins[admin];
    }
}
