const { DataTypes } = require("sequelize");
const sequelize = require("../config/db"); // Import database connection

const Employee = sequelize.define("Employee", {
    name: DataTypes.STRING,
    email: DataTypes.STRING,
    position: DataTypes.STRING,
    salary: DataTypes.INTEGER
}, {
    tableName: "employees",
    timestamps: false // Disable automatic timestamp columns
});

module.exports = Employee;
