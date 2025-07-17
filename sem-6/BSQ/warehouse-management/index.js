let inventory = JSON.parse(localStorage.getItem("inventory")) || [];

function renderInventory() {
    const table = document.getElementById("inventoryTable");
    table.innerHTML = "";
    inventory.forEach((item, index) => {
        const row = document.createElement("tr");
        if (item.quantity < item.limit) row.classList.add("low-stock");
        row.innerHTML = `
    <td>${item.name}</td>
    <td>${item.quantity}</td>
    <td>${item.limit}</td>
    <td>
        <button onclick="updateQuantity(${index}, 1)">+</button>
        <button onclick="updateQuantity(${index}, -1)">-</button>
        <button onclick="deleteItem(${index})">Delete</button>
    </td>
    `;
        table.appendChild(row);
    });
    localStorage.setItem("inventory", JSON.stringify(inventory));
}

function addItem() {
    const name = document.getElementById("itemName").value;
    const quantity = parseInt(document.getElementById("itemQuantity").value);
    const limit = parseInt(document.getElementById("itemLimit").value);

    if (name && quantity > 0 && limit > 0) {
        inventory.push({ name, quantity, limit });
        renderInventory();
        document.getElementById("itemName").value = "";
        document.getElementById("itemQuantity").value = "";
        document.getElementById("itemLimit").value = "";
    } else {
        alert("Please enter valid values.");
    }
}

function updateQuantity(index, change) {
    inventory[index].quantity += change;
    if (inventory[index].quantity < 0) inventory[index].quantity = 0;
    renderInventory();
}

function deleteItem(index) {
    inventory.splice(index, 1);
    renderInventory();
}

renderInventory();
