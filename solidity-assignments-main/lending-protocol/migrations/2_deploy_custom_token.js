const CustomToken = artifacts.require("CustomToken");

module.exports = function(deployer){
    const tokenName = "Custom Token";
    const tokenSymbol = "CTK";

    deployer.deploy(CustomToken, tokenName, tokenSymbol);
}