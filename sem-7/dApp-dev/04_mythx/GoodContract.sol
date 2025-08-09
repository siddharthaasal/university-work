// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.21;

contract SimpleAuction {
    address payable public immutable beneficiary;
    uint public immutable auctionEndBlock;

    address public highestBidder;
    uint public highestBid;

    mapping(address => uint) pendingReturns;

    bool ended;

    event HighestBidIncreased(address bidder, uint amount);
    event AuctionEnded(address winner, uint amount);

    error AuctionAlreadyEnded();
    error BidNotHighEnough(uint highestBid);
    error AuctionNotYetEnded();
    error AuctionEndAlreadyCalled();
    error ZeroAddressNotAllowed();

    constructor(uint biddingBlockCount, address payable beneficiaryAddress) {
        if (beneficiaryAddress == address(0)) revert ZeroAddressNotAllowed();
        beneficiary = beneficiaryAddress;
        auctionEndBlock = block.number + biddingBlockCount;
    }

    function bid() external payable {
        if (block.number > auctionEndBlock) revert AuctionAlreadyEnded();
        if (msg.value <= highestBid) revert BidNotHighEnough(highestBid);

        if (highestBid != 0) {
            pendingReturns[highestBidder] += highestBid;
        }

        highestBidder = msg.sender;
        highestBid = msg.value;
        emit HighestBidIncreased(msg.sender, msg.value);
    }

    function withdraw() external returns (bool) {
        uint amount = pendingReturns[msg.sender];
        if (amount > 0) {
            pendingReturns[msg.sender] = 0;
            if (!payable(msg.sender).send(amount)) {
                pendingReturns[msg.sender] = amount;
                return false;
            }
        }
        return true;
    }

    function auctionEnd() external {
        if (block.number < auctionEndBlock) revert AuctionNotYetEnded();
        if (ended) revert AuctionEndAlreadyCalled();

        ended = true;
        emit AuctionEnded(highestBidder, highestBid);
        beneficiary.transfer(highestBid);
    }
}
