// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract SupplyChain {
    struct Product {
        uint256 id;
        string name;
        string status;
        address owner;
    }

    mapping(uint256 => Product) public products;
    uint256 public productCount;

    event ProductRegistered(uint256 id, string name, address owner);
    event StatusUpdated(uint256 id, string status);

    function registerProduct(string memory _name) public {
        productCount++;
        products[productCount] = Product(
            productCount,
            _name,
            "Registered",
            msg.sender
        );
        emit ProductRegistered(productCount, _name, msg.sender);
    }

    function updateStatus(uint256 _id, string memory _status) public {
        require(_id > 0 && _id <= productCount, "Product does not exist");
        require(
            msg.sender == products[_id].owner,
            "Only the owner can update the status"
        );

        products[_id].status = _status;
        emit StatusUpdated(_id, _status);
    }

    function getProduct(
        uint256 _id
    )
        public
        view
        returns (string memory name, string memory status, address owner)
    {
        require(_id > 0 && _id <= productCount, "Product does not exist");
        Product memory product = products[_id];
        return (product.name, product.status, product.owner);
    }
}
