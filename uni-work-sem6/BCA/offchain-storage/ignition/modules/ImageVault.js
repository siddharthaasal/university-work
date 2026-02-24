const { buildModule } = require("@nomicfoundation/hardhat-ignition/modules");

module.exports = buildModule("ImageVaultModule", (m) => {
  const initialUrls = [
    "QmdoZpyt6tTnZspoBau1pnvvMM8BzVqrytv8vkJPv14eQ7",
    "QmfPuUmEK2GygMJEeXG6KdY6JGVcrvchB9HpCvtsBZ2Bxq",
    "QmSurn71QdFJ4j79E15L9ySBjbTj1EJ6bNXSGNrZy8xX5P"
  ];

  const imageVault = m.contract("ImageVault", [initialUrls]);

  return { imageVault };
});
