const { Sequelize } = require("sequelize");
require("dotenv").config();

const sequelize = new Sequelize("employeecrud", "postgres", "1234", {
    host: "localhost",
    dialect: "postgres"
});

sequelize.authenticate()
    .then(() => console.log("✅ Connected to PostgreSQL"))
    .catch(err => console.error("❌ Connection error:", err));

module.exports = sequelize;
