// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract ImageVault {
    string[] public urls;

    event UrlAdded(string url);

    constructor(string[] memory _initialUrls) {
        for (uint i = 0; i < _initialUrls.length; i++) {
            urls.push(_initialUrls[i]);
        }
    }

    function addUrl(string calldata _url) external {
        urls.push(_url);
        emit UrlAdded(_url);
    }

    function getUrl(uint256 index) external view returns (string memory) {
        require(index < urls.length, "Index out of bounds");
        return urls[index];
    }

    function getUrlCount() external view returns (uint256) {
        return urls.length;
    }
}
