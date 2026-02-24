package Java;

// Define the Discountable interface for products with discounts
interface Discountable {
    double calculateDiscount();
}

// Define the Shippable interface for products with shipping options
interface Shippable {
    double calculateShippingCost();
}

// Define the base class Product
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
    }
}

// Implement the Electronics class as a subclass of Product with discounts
class Electronics extends Product implements Discountable {
    private double discountRate;

    public Electronics(String name, double price, double discountRate) {
        super(name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: $" + calculateDiscount());
    }
}

// Implement the Clothing class as a subclass of Product with discounts and shipping
class Clothing extends Product implements Discountable, Shippable {
    private double discountRate;
    private double shippingCost;

    public Clothing(String name, double price, double discountRate, double shippingCost) {
        super(name, price);
        this.discountRate = discountRate;
        this.shippingCost = shippingCost;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateShippingCost() {
        return shippingCost;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: $" + calculateDiscount());
        System.out.println("Shipping Cost: $" + calculateShippingCost());
    }
}

// Implement the Books class as a subclass of Product with discounts and shipping
class Books extends Product implements Discountable, Shippable {
    private double discountRate;
    private double shippingCost;

    public Books(String name, double price, double discountRate, double shippingCost) {
        super(name, price);
        this.discountRate = discountRate;
        this.shippingCost = shippingCost;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateShippingCost() {
        return shippingCost;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: $" + calculateDiscount());
        System.out.println("Shipping Cost: $" + calculateShippingCost());
    }
}

public class Ass1Q5 {
    public static void main(String[] args) {
        // Create sample products
        Electronics laptop = new Electronics("Laptop", 800.0, 0.1);
        Clothing shirt = new Clothing("Shirt", 25.0, 0.2, 5.0);
        Books novel = new Books("Novel", 15.0, 0.15, 3.0);

        // Display product details and calculate final costs
        System.out.println("Product Details:");
        laptop.displayDetails();
        System.out.println();

        shirt.displayDetails();
        System.out.println();

        novel.displayDetails();
        System.out.println();
    }
}

