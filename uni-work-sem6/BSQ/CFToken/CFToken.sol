// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

// // import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
// // import "@openzeppelin/contracts/access/Ownable.sol";

// contract CFToken is ERC20 {
//     uint256 public rate = 1000; // 1 Ether = 1000 CFT
//     address public airline;

//     constructor() ERC20("CFToken", "CFT") {
//         _mint(msg.sender, 100000 * 10 ** decimals()); // Initial supply
//     }

//     function setRate(uint256 newRate) external {
//         rate = newRate;
//     }

//     // Change visibility from `external` to `public`
//     function buyTokens() public payable {
//         require(msg.value > 0, "Send Ether to get CFT");
//         uint256 tokensToMint = msg.value * rate;
//         _mint(msg.sender, tokensToMint);
//     }

//     function setAirline(address _airline) external {
//         airline = _airline;
//     }

//     function payForFlight(uint256 amount) external {
//         require(balanceOf(msg.sender) >= amount, "Not enough CFT");
//         require(airline != address(0), "Airline not set");
//         _transfer(msg.sender, airline, amount);
//     }

//     function withdraw() external {
//         payable(msg.sender).transfer(address(this).balance);
//     }

//     // Explicitly define the receive function
//     receive() external payable {
//         buyTokens(); // Now this will work because `buyTokens` is `public`
//     }
// }
