const { sequelize } = require("../config/db");
const Item = require("./Item");

const syncDatabase = async () => {
    await sequelize.sync({ alter: true }); // Creates tables if they don't exist
    console.log("Database synced!");
};

module.exports = { Item, syncDatabase };
