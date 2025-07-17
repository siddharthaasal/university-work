const express = require("express");
const router = express.Router();
const employeeController = require("../controllers/employeeController");

router.get("/", employeeController.getEmployees); //w
router.post("/add", employeeController.createEmployee); //w
router.post("/update/:id", employeeController.updateEmployee);
router.get("/delete/:id", employeeController.deleteEmployee); //w
router.get("/search", employeeController.searchEmployee);

module.exports = router;
