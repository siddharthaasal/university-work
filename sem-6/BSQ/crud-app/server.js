const express = require("express");
const bodyParser = require("body-parser");
const employeeRoutes = require("./routes/employeeRoutes");
const sequelize = require("./config/db");
const Employee = require("./models/Employee");

const app = express();

app.use(express.json()); // Middleware to parse JSON body
app.use(express.urlencoded({ extended: true })); // Middleware to parse URL-encoded form data

app.set("view engine", "ejs");
app.use(bodyParser.urlencoded({ extended: true }));
app.use("/", employeeRoutes);

// Sync database (Creates table if not exists)
sequelize.sync()
    .then(() => console.log("✅ Database synced"))
    .catch(err => console.error("❌ Sync error:", err));

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`🚀 Server running on port ${PORT}`));
