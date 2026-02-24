// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract AirlineTicketing {
    address public airline;
    uint public ticketCount = 0;

    struct Ticket {
        uint id;
        string flight;
        uint price;
        address buyer;
        bool isSold;
    }

    mapping(uint => Ticket) public tickets;

    event TicketListed(uint id, string flight, uint price);
    event TicketPurchased(uint id, address buyer);

    modifier onlyAirline() {
        require(msg.sender == airline, "Only airline can perform this action");
        _;
    }

    constructor() {
        airline = msg.sender;
    }

    function listTicket(string memory _flight, uint _price) public onlyAirline {
        ticketCount++;
        tickets[ticketCount] = Ticket(
            ticketCount,
            _flight,
            _price,
            address(0),
            false
        );
        emit TicketListed(ticketCount, _flight, _price);
    }

    function buyTicket(uint _id) public payable {
        require(_id > 0 && _id <= ticketCount, "Invalid ticket ID");
        Ticket storage ticket = tickets[_id];
        require(!ticket.isSold, "Ticket already sold");
        // require(msg.value >= ticket.price, "Insufficient funds");

        ticket.buyer = msg.sender;
        ticket.isSold = true;
        payable(airline).transfer(msg.value);

        emit TicketPurchased(_id, msg.sender);
    }
}
