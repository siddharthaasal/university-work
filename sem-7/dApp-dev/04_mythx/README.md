Line 48: Missing zero address validation in the beneficiary address variable
Line 65: block.timestamp is being used for timestamp comparisons
Line 127: block.timestamp is being used for timestamp comparisons
solc v0.8.14 it is not recommended for production deployments

------


Zero address check for beneficiary.

Replaced block.timestamp with block numbers (safer alternative).

Marked beneficiary and auctionEndTime as immutable.

Upgraded compiler version to ^0.8.21 (latest as of Aug 2025), avoiding known Solidity bugs.

--------
