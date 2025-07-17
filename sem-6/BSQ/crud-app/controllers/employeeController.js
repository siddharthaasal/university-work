const Employee = require("../models/Employee");

// ✅ Get All Employees
exports.getEmployees = async (req, res) => {
    try {
        const employees = await Employee.findAll();
        res.json(employees);
    } catch (error) {
        res.status(500).json({ error: "❌ Error fetching employees" });
    }
};

// ✅ Add a New Employee
exports.createEmployee = async (req, res) => {
    try {
        const { name, email, position, salary } = req.body;
        const employee = await Employee.create({ name, email, position, salary });
        res.json({ message: "✅ Employee added", employee });
    } catch (error) {
        res.status(500).json({ error: "❌ Error adding employee" });
    }
};

// ✅ Update an Employee
exports.updateEmployee = async (req, res) => {
    try {
        const { name, email, position, salary } = req.body;
        const { id } = req.params;

        const employee = await Employee.findByPk(id);
        if (!employee) {
            return res.status(404).json({ error: "❌ Employee not found" });
        }

        await employee.update({ name, email, position, salary });
        res.json({ message: "✅ Employee updated", employee });
    } catch (error) {
        res.status(500).json({ error: "❌ Error updating employee" });
    }
};

// ✅ Delete an Employee
exports.deleteEmployee = async (req, res) => {
    try {
        const { id } = req.params;
        const employee = await Employee.findByPk(id);

        if (!employee) {
            return res.status(404).json({ error: "❌ Employee not found" });
        }

        await employee.destroy();
        res.json({ message: "✅ Employee deleted" });
    } catch (error) {
        res.status(500).json({ error: "❌ Error deleting employee" });
    }
};

// ✅ Search Employees by Name
exports.searchEmployee = async (req, res) => {
    try {
        const { name } = req.query;
        const employees = await Employee.findAll({
            where: { name }
        });

        res.json(employees);
    } catch (error) {
        res.status(500).json({ error: "❌ Error searching employees" });
    }
};
