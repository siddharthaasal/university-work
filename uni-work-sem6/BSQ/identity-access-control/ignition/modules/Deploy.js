const { buildModule } = require("@nomicfoundation/hardhat-ignition/modules");

module.exports = buildModule("IdentityAccessControlModule", (m) => {
  const deployer = m.getAccount(0); // Get the first account as the initial admin
  const identityAccessControl = m.contract("IdentityAccessControl", [deployer]);

  return { identityAccessControl };
});
