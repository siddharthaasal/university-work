const { buildModule } = require("@nomicfoundation/hardhat-ignition/modules");

module.exports = buildModule("PaymentModule", (m) => {
  const payment = m.contract("Payment", []);

  return { payment };
});
